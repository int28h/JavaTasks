/**
 * Реализуйте работу очереди. Для каждой операции изъятия элемента выведите ее результат.
 * 
 * На вход программе подаются строки, содержащие команды. Каждая строка содержит одну команду. Команда — это либо «+ N», либо «−».
 * Команда «+ N» означает добавление в очередь числа N, по модулю не превышающего 10^9.
 * Команда «−» означает изъятие элемента из очереди. Гарантируется, что размер очереди в процессе выполнения команд не превысит 10^6 элементов.
 * 
 * Формат входного файла
 * В первой строке входного файла содержится M (1 <= M <= 10^6) - число команд. Каждая последующая строка исходного файла содержит ровно одну команду.
 * 
 * Формат выходного файла
 * Выведите числа, которые удаляются из очереди с помощью команды «−», по одному в каждой строке.
 * Числа нужно выводить в том порядке, в котором они были извлечены из очереди. Гарантируется, что извлечения из пустой очереди не производится.
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    private static int[] array = new int[1000000];
    private static int head = 1;
    private static int tail = 1;

    private static void add(int[] array, int number) {
        array[tail] = number;
        if (tail == array.length) {
            tail = 1;
        } else {
            tail++;
        }
    }

    private static void remove(int[] array, PrintStream out) {
        out.println(array[head]);
        if (head == array.length) {
            head = 1;
        } else {
            head++;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("input.txt"));
        FileOutputStream fos = new FileOutputStream("output.txt");
        PrintStream out = new PrintStream(fos);

        int commandsCount = in.nextInt();

        for (int i = 0; i <= commandsCount; i++) {
            String command = new String();
            command = in.nextLine();
            if (command.startsWith("+")) {
                command = command.substring(2, command.length());
                int number = Integer.parseInt(command);
                add(array, number);
            } else if (command.startsWith("-")) {
                remove(array, out);
            }
        }
        in.close();
        out.close();
    }
}

