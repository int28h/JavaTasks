/**
 * Write a lambda expression that accepts a long value and returns a next even number.
 * It is guaranteed an input number is non-negative.
 */
x -> {if (x%2 == 0) return x+2; return x+1;};