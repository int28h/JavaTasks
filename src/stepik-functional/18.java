/*
Write a collector that evaluates the product of squares of integer numbers in a Stream<Integer>.

Important. You should write only the collector in any valid formats but without ; on the end.
It will be passed as an argument to the collect() method of a stream as shown below.

List<Integer> numbers = ...
long val = numbers.stream().collect(...your_collector_will_be_passed_here...);

Examples of the valid solution formats: Collectors.reducing(...) or reducing(...).
*/
Collectors.reducing(1, (a, b) -> a * b * b)