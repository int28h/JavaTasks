/**
 * Write a lambda expression that accepts seven (!) string arguments and returns a string in upper case 
 * concatenated from all of them (in the order of arguments).
 *
 * Sample Input:
 * The lambda has too many string arguments.
 * Sample Output:
 * THELAMBDAHASTOOMANYSTRINGARGUMENTS.
 */
(first, second, third, fourth, fifth, sixth, seventh) -> {
    String result = (first + second + third + fourth + fifth + sixth + seventh).toUpperCase();
    return result;
};