/*
Write a method for calculating the sum of odd numbers in the given interval (inclusively) using Stream API.
*/
public static long sumOfOddNumbersInRange(long start, long end) {
    return LongStream.rangeClosed(start, end).filter(s -> s % 2 != 0).sum();
}