/**
 * Реализуйте метод, возвращающий ответ на вопрос: правда ли, что a + b = c?
 * Допустимая погрешность – 0.0001 (1E-4)
 */
 
 public static boolean doubleExpression(double a, double b, double c) {
    boolean x = Math.abs((a + b) - c) < 1E-4;
    return x;
  }