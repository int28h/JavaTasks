/*
There is a LogEntry class for monitoring user activity on your site. The class has three fields:

    created: Date - the date of creating log entry
    login: String - a user login
    url: String - a url that the user clicked

The class have getters for all fields with the corresponding names (getCreated(), getLogin(), getUrl()).

Write a collector that calculates how many times was clicked each url by users. The collector will be applied to a stream of log entries for creating a map: url -> click count.

The class LogEntry will be available during testing. You can create your own classes for local testing.

Important. You should write only the collector in any valid formats but without ; on the end.
It will be passed as an argument to the collect() method of a stream as shown below.

List<LogEntry> logs = ...
Map<String, Long> clickCount = 
        logs.stream()
            .collect(...your_collector_will_be_passed_here...);
*/
Collectors.groupingBy(LogEntry::getUrl, Collectors.summingLong(s -> 1))