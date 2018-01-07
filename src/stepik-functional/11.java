/*
Write a method using Stream API to check the input number is prime or not. 
Let's agree that input value is always greater than 1 (i.e. 2, 3, 4, 5, ....). Use the provided template for your method.

A prime number is a value greater than 1 that has no positive divisors other than 1 and itself. 
See https://en.wikipedia.org/wiki/Prime_number
*/
public static boolean isPrime(final long number) {
     return LongStream.rangeClosed(2, number/2).noneMatch(i -> number%i == 0);
}