/*
Write a curried form of the function f(x,y,z)=x+y*y+z*z*z

using lambda expressions in Java 8 style. The result and x, y, z must be integer numbers.

Solution format. You may write the result in any valid formats but with ; on the end.

An example of a curried function: x -> y -> ...;
*/
x -> y -> z -> x + y*y + z*z*z;