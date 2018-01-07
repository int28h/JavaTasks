/*
You have two classes:

    Account: number: String, balance: Long
    Transaction: uuid: String, sum: Long, account: Account

Both classes have getters for all fields with the corresponding names (getNumber(), getSum(), getAccount() and so on).

Write a collector that calculates the total sum of transactions (long type, not integer) by each account 
(i.e. by account number). The collector will be applied to a stream of transactions.

Classes Transaction and Account will be available during testing. You can create your own classes for local testing.

Important. You should write only the collector in any valid formats but without ; on the end.
It will be passed as an argument to the collect() method of a stream as shown below.

List<Transaction> transactions = ...
Map<String, Long> totalSumOfTransByEachAccount = 
        transactions.stream()
                    .collect(...your_collector_will_be_passed_here...);
*/
Collectors.groupingBy(s -> s.getAccount().getNumber(), summingLong(Transaction::getSum))