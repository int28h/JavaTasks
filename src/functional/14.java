/*
Many java developers wrote methods to calculate a factorial value using a recursive or iterative algorithm. 
It's time to do it with streams.

The factorial of n is calculated by the product of integer number from 1 to n (inclusive). The factorial of 0 is equal to 1.

Important. Use the given template for your factorial method. Pay attention to type of an argument and the returned value. 
Please, don't use cycles or recursion.
*/
public static long factorial(long n) {
    if(n == 0) return 1;
    return LongStream.rangeClosed(1, n).reduce(1, (long a, long b) -> a * b);
}