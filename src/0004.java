/**
 * Реализуйте метод, проверяющий, является ли заданное число по абсолютной величине степенью двойки.
 */

public static boolean isPowerOfTwo(int value) {
    value = Math.abs(value);
    return Integer.bitCount(value) == 1; //Returns the number of one-bits in the two's complement binary representation of the specified int value.
    }
