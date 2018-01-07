/*
Write a curried function (using lambdas) that accepts four string arguments and concatenated all in one string 
following the rules:

    String cases: in the result string, first and second arguments must be in lower cases and third and fourth in upper cases.
    Order of arguments concatenation: first, third, second, fourth.

Solution format. You may write the result in any valid formats but with ; on the end.

An example of a curried function: x -> y -> ...;
*/
a -> b -> c -> d -> new String(a.toLowerCase() + c.toUpperCase() + b.toLowerCase() + d.toUpperCase());