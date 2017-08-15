/**
 * Реализуйте метод flipBit, изменяющий значение одного бита заданного целого числа на противоположное.
 */

public static int flipBit(int value, int bitIndex) {
    return value ^ (1 << bitIndex-1); 
}