/**
 * Реализуйте метод, который возвращает букву, стоящую в таблице UNICODE после символа "\" (обратный слэш) на расстоянии a.
 */
 
 public static char charExpression(int a) {
    int ch = '\\';
    int x = ch + a;
    char unicode = (char)x;
    return unicode;
}