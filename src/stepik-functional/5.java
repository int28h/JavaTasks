/**
 * Write a lambda expression that accepts a list of strings and returns new list of distinct strings (without repeating). 
 * The order of elements in the result list may be any (elements will be sorted by the testing system).
 *
 * If the input list doesn't contain any strings then the result list should be empty.
 *
 * Sample Input 1:
 * java scala java clojure clojure
 * Sample Output 1:
 * clojure java scala
 * 
 * Sample Input 2:
 * the three the three the three an an a
 * Sample Output 2:
 * a an the three
 */
(list) -> {
	 return list.stream().distinct().collect(Collectors.toList());
	};