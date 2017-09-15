/**
 * Вспомним нашего старого знакомого робота из этой задачи. 
 * Теперь мы будем давать роботу команды удаленно, подключаясь к нему по беспроводному каналу связи.
 * 
 * Подключение к роботу представляется в программе интерфейсом RobotConnection:
 * 
 * public interface RobotConnection extends AutoCloseable {
 *     void moveRobotTo(int x, int y);
 *     @Override
 *    void close();
 * }
 * 
 * Да, робот с тех пор поумнел и стал понимать команду на перемещение в заданную точку (метод moveRobotTo). 
 * Ему больше не нужны пошаговые инструкции.
 * 
 * RobotConnection — это временно устанавливаемое соединение, которое надо закрывать, когда оно больше не нужно. 
 * Для закрытия соединения в интерфейсе есть метод close().
 * 
 * За установку соединения отвечает RobotConnectionManager:
 * 
 * public interface RobotConnectionManager {
 *     RobotConnection getConnection();
 * }
 * 
 * Метод getConnection() делает попытку соединиться с роботом и возвращает установленное соединение, 
 * через которое можно отдавать роботу команды.
 * 
 * Установка соединения может завершиться неуспешно, а также уже установленное соединение может внезапно разорваться. 
 * Всякое бывает. Поэтому любой метод RobotConnectionManager и RobotConnection может бросить непроверяемое исключение 
 * RobotConnectionException:
 * 
 * public class RobotConnectionException extends RuntimeException {
 * 
 *     public RobotConnectionException(String message) {
 *         super(message);
 * 
 *     }
 * 
 *     public RobotConnectionException(String message, Throwable cause) {
 *         super(message, cause);
 *     }
 * }
 * 
 * Ваша задача — реализовать метод который устанавливает соединение с роботом, отдает ему команду на перемещение 
 * в заданную точку и затем закрывает соединение, выполняя при необходимости повтор этой последовательности до трех раз.
 * 
 * При этом:
 *    Попытка отдать команду роботу считается успешной, если удалось установить соединение и выполнить метод 
 *    RobotConnection.moveRobotTo() без исключений. Ошибка закрытия соединения не важна и должна игнорироваться.
 *    Если первая попытка подключиться и отдать команду оказалась неуспешной, то закрываем соединение и выполняем вторую попытку. 
 *	  Если вторая тоже не удалась, то выполняется третья. 
 *	  После третьей неудачи метод должен бросить исключение RobotConnectionException.
 *    Метод отвечает за открытие и закрытие соединения. Если соединение удалось установить, 
 *    то оно обязательно должно быть закрыто несмотря на возможные исключения, случившиеся в дальнейшем во время работы метода.
 *    Если во время работы метода случилось исключение любого типа, отличного от RobotConnectionException, 
 *    метод должен завершиться и выбросить это исключение, не выполняя повторных попыток пообщаться с роботом. 
 *    Единственное, что метод должен сделать перед выбросом этого исключения — закрыть открытое соединение RobotConnection.
 */
 public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
    boolean connect = false;
    int i = 0;
    while (!connect && (i < 3)) {
        try (RobotConnection robotConnection = robotConnectionManager.getConnection()) {
            robotConnection.moveRobotTo(toX, toY);
            connect = true;
        } catch (RobotConnectionException e) {
            i++;
        }
    }
    if (!connect) {
        throw new RobotConnectionException("Fail");
    }
}
