/**
 * Using closure write a lambda expression that adds prefix (before) and suffix (after) to its single string argument; 
 * prefix and suffix are final variables and will be available in the context during testing.
 * All whitespaces on the both ends of the argument must be removed. 
 */
(str) -> {
    return prefix + str.trim() + suffix;
};