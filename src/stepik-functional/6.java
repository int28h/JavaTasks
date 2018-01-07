/**
 * Using closure write a lambda expression that calculates 
 * a * x^2 + b * x + c where a, b, c are context final variables. They will be available in the context during testing. 
 * Note, the result is double.
 */
(x) -> {
    return (double) a * (x * x) + b * x + c;    
};