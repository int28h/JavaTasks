/*
Create a parallel LongStream for filtering prime numbers in the given range (inclusively).

The static method NumberUtils.isPrime(...some long number...) will be available for you during testing. 
It returns true if the passed value is prime and false otherwise.

Be carefully with rangeClose(d), iterate and limit methods!

Important. You need return a prepared parallel stream from the template. After calling count() it should return 
the count of prime numbers in the given range. Pay attention to the method template. Do not change it.

PS: it's not a very efficient approach for generating prime numbers, it's just an example of parallel streams.
*/
public static LongStream createPrimesFilteringStream(long rangeBegin, long rangeEnd) {
    return LongStream.rangeClosed(rangeBegin, rangeEnd).parallel().filter(s -> NumberUtils.isPrime(s));
}
