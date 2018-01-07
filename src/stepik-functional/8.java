/*
You have a class Account (number: String, balance: Long, isLocked: boolean),
the list accounts of type List<Account> and the method filter(List<T> elems, Predicate<T> predicate) 
for filtering the given list of type T by the predicate.

The class Account has the next methods: getNumber(), getBalance(), isLocked() for getting the values 
of the corresponding fields.

Write a code for filtering the accounts list in two ways:

    get list with all non-empty accounts (balance > 0) and save it to the variable nonEmptyAccounts
    get all non-locked accounts with too much money (balance >= 100 000 000) and save it to the variable accountsWithTooMuchMoney

The class Account, the list accounts (List<Account>) and the method filter(...) will be available during testing.

Important. Use the given code template for your solution. Do not change it!

Example of use the filter method. The code below gets only even number from the list.

List<Integer> numbers = ...
List<Integer> evenNumbers = filter(numbers, number -> number % 2 == 0);
*/
List<Account> nonEmptyAccounts = filter(accounts, account -> account.balance > 0);

List<Account> accountsWithTooMuchMoney = filter(accounts, account -> !account.isLocked() && account.balance >= 100000000);