/**
 * Реализуйте метод, вычисляющий факториал заданного натурального числа.
 */
 
 public static BigInteger factorial(int value) { 
    BigInteger result = BigInteger.valueOf(1);
    for(int i = 1; i < value + 1; i++)
    {
        result = result.multiply(BigInteger.valueOf(i));
    }
    return result; 
}