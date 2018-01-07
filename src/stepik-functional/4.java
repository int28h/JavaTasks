/**
 * Write a lambda expression that accepts two long arguments as a range borders and calculates (returns) 
 * production of all numbers in this range (inclusively). It's guaranteed that 0 <= left border <= right border. 
 * If left border == right border then the result is any border.
 */
(x,y) -> {
    long result = x;
    for(long i = x + 1; i <= y; i++){
        result *= i;
    }
    return result;
};