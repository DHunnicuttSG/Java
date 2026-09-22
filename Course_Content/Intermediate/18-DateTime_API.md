# Java Date-Time API (java.time) Lesson
### Lesson Overview

The Java Date-Time API (java.time) was introduced in Java 8 to replace the older and problematic date/time classes such as Date and Calendar. The API is immutable, thread-safe, easier to read, and based on international standards.

## Learning Outcomes

By the end of this lesson, learners will be able to:

1. Use the correct ISO calendar standard.
2. Differentiate between human time and machine time.
3. Differentiate between local and zone classes.
4. Differentiate between periods and durations.
5. Create LocalDate objects.
6. Calculate dates in the future and the past.
7. Calculate the time between two dates.
8. Format dates.
9. Convert the legacy Date object.

## 1. Using the Correct ISO Calendar Standard

The Java Date-Time API uses the ISO-8601 calendar system by default.

ISO-8601 is the international standard for representing dates and times:

* Date: 2026-05-15
* Time: 14:30:00
* DateTime: 2026-05-15T14:30:00

The primary calendar class is:
```java
LocalDate date = LocalDate.now();

System.out.println(date);
```

Output:
```java
2026-09-21
```
## Why ISO-8601?

Benefits:

* Internationally recognized
* Unambiguous formatting
* Standardized across systems
* Used throughout the Java Date-Time API

The API also supports alternative calendar systems through the java.time.chrono package, but ISO is the default and most commonly used.

### 2. Human Time vs Machine Time

One of the most important concepts in the Date-Time API is understanding the difference between human time and machine time.

### Human Time

Human time represents how people think about dates and times.

Examples:

* Birthday
* Meeting at 2:00 PM
* Christmas Day
* Store opening hours

Classes:
```java
LocalDate
LocalTime
LocalDateTime
ZonedDateTime
```

Example:
```java
LocalDate birthday = LocalDate.of(1995, 7, 14);
```
### Machine Time

Machine time represents a single point on the timeline.

Class:
```java
Instant
```

Example:
```java
Instant now = Instant.now();

System.out.println(now);
```

Output:
```java
2026-09-21T18:45:30.123Z
```

Notice:

* Uses UTC
* Represents nanosecond precision
* Ideal for logging, persistence, and distributed systems

### Rule of Thumb

Use:

* LocalDate, LocalTime, LocalDateTime for business requirements
* Instant for storage, auditing, and system timestamps

## 3. Local Classes vs Zoned Classes
### Local Classes

Local classes have **no time zone information**.

### LocalDate
```java
LocalDate date = LocalDate.now();
```

Represents:
```java
2026-09-21
```
### LocalTime
```java
LocalTime time = LocalTime.now();
```

Represents:
```java
14:30:00
```
### LocalDateTime
```java
LocalDateTime dt = LocalDateTime.now();
```

Represents:
```java
2026-09-21T14:30:00
```

Not tied to any timezone.

## Zoned Classes

A zoned class includes a timezone.

### ZonedDateTime
```java
ZonedDateTime meeting =
    ZonedDateTime.now(ZoneId.of("America/New_York"));

System.out.println(meeting);
```

Output:
```java
2026-09-21T14:30:00-04:00[America/New_York]
```
### Comparison
| Local Classes	| Zoned Classes |
|---|---|
|No timezone 	|Includes timezone |
|Human-focused	|Global time-aware |
|LocalDate	|ZonedDateTime |
|LocalTime	|OffsetTime |
|LocalDateTime	|OffsetDateTime |

### Example Problem
```java
LocalDateTime meeting = LocalDateTime.of(
        2026, 10, 1, 9, 0);

System.out.println(meeting);
```

Question:

>Is this 9:00 AM in New York, London, or Tokyo?

Answer:

You do not know.

A ZonedDateTime removes this ambiguity.

## 4. Periods vs Durations

Another common area of confusion is the difference between Period and Duration.

### Period

A Period measures time in:

* Years
* Months
* Days

Used with dates.
```java
Period period = Period.ofMonths(3);

System.out.println(period);
```

Output:
```java
P3M
```

Example:
```java
LocalDate today = LocalDate.now();

LocalDate future = today.plus(
        Period.ofMonths(3));
```

### Duration

A Duration measures time in:

* Hours
* Minutes
* Seconds
* Nanoseconds

Used with times and instants.
```java
Duration duration =
        Duration.ofHours(5);

System.out.println(duration);
```

Output:
```java
PT5H
```

Example:
```java
LocalDateTime now = LocalDateTime.now();

LocalDateTime later =
        now.plus(Duration.ofHours(5));
```

### Summary
|Period	|Duration |
|---|---|
|Date-based	|Time-based |
|Years, Months, Days	|Hours, Minutes, Seconds |
|Works with LocalDate	|Works with LocalTime and Instant |
|Human calendar concepts	|Measured elapsed time |

## 5. Creating LocalDates
### Current Date
```java
LocalDate today = LocalDate.now();
```

### Specific Date
```java
LocalDate independenceDay =
        LocalDate.of(1776, 7, 4);
```

### Parse ISO Date
```java
LocalDate date =
        LocalDate.parse("2026-12-25");
```

Output:
```java
2026-12-25
```

### Using Month Enum
```java
LocalDate date =
        LocalDate.of(
                2026,
                Month.DECEMBER,
                25);
```

## 6. Calculating Dates in the Future and Past

The API is immutable.

Every calculation returns a new object.

### Future Dates
```java
LocalDate today = LocalDate.now();

LocalDate nextWeek =
        today.plusWeeks(1);

LocalDate nextMonth =
        today.plusMonths(1);

LocalDate nextYear =
        today.plusYears(1);
```

### Past Dates
```java
LocalDate yesterday =
        today.minusDays(1);

LocalDate lastMonth =
        today.minusMonths(1);

LocalDate lastYear =
        today.minusYears(1);
```

### Chaining Operations
```java
LocalDate result =
        LocalDate.now()
                 .plusMonths(2)
                 .minusWeeks(1)
                 .plusDays(5);
```

## 7. Calculating the Time Between Two Dates
### Using Period
```java
LocalDate start =
        LocalDate.of(2025, 1, 1);

LocalDate end =
        LocalDate.of(2026, 3, 15);

Period difference =
        Period.between(start, end);

System.out.println(difference);
```

Output:
```java
P1Y2M14D
```

### Using ChronoUnit

Calculate the number of days between dates.
```java
long days =
    ChronoUnit.DAYS.between(
            start,
            end);

System.out.println(days);
```

Example Output:
```java
438
```

### Time Between Instants
```java
Instant start = Instant.now();

// Some operation

Instant end = Instant.now();

Duration elapsed =
        Duration.between(start, end);

System.out.println(elapsed);
```

Output:
```java
PT0.120S
```

## 8. Formatting Dates

Formatting is performed using DateTimeFormatter.

### Default Format
```java
LocalDate date =
        LocalDate.of(2026, 7, 4);

System.out.println(date);
```

Output:
```java
2026-07-04
```

### Custom Format
```java
DateTimeFormatter formatter =
    DateTimeFormatter.ofPattern(
            "MM/dd/yyyy");

String formatted =
        date.format(formatter);

System.out.println(formatted);
```

Output:
```java
07/04/2026
```

### Another Format
```java
DateTimeFormatter formatter =
    DateTimeFormatter.ofPattern(
            "dd MMM yyyy");

System.out.println(
        date.format(formatter));
```

Output:
```java
04 Jul 2026
```

### Formatting DateTime
```java
LocalDateTime dt =
        LocalDateTime.now();

DateTimeFormatter formatter =
        DateTimeFormatter.ofPattern(
                "yyyy-MM-dd HH:mm:ss");

System.out.println(
        dt.format(formatter));
```

Sample Output:
```java
2026-09-21 14:30:45
```

## 9. Converting the Legacy Date Object

Before Java 8, developers used:
```java
java.util.Date
```

The Date-Time API provides easy conversion methods.

### Date to Instant
```java
Date legacyDate = new Date();

Instant instant =
        legacyDate.toInstant();
```

### Date to LocalDate
```java
Date legacyDate = new Date();

LocalDate localDate =
    legacyDate.toInstant()
              .atZone(
                  ZoneId.systemDefault())
              .toLocalDate();
```

### Date to LocalDateTime
```java
LocalDateTime dateTime =
    legacyDate.toInstant()
              .atZone(
                  ZoneId.systemDefault())
              .toLocalDateTime();
```

### LocalDateTime to Date
```java
LocalDateTime ldt =
        LocalDateTime.now();

Date legacyDate =
    Date.from(
        ldt.atZone(
            ZoneId.systemDefault())
           .toInstant());
```

## Common Interview Questions
### What problem did Java 8 Date-Time API solve?
* Mutability issues
* Poor API design
* Thread safety concerns
* Confusing date calculations

### When should you use Instant?

Use Instant when storing an exact moment on the timeline, such as:

* Audit records
* Logs
* Event timestamps

### When should you use LocalDate?

Use LocalDate when a timezone is irrelevant:

* Birthdays
* Holidays
* Due dates

### What is the difference between Period and Duration?
|Period	|Duration|
|---|---|
|Calendar-based|	Clock-based|
|Years, months, days|	Hours, minutes, seconds|
|Human time|	Machine time|

## Hands-On Lab
### Exercise 1

Create a LocalDate representing your birthday.

Display:

* Original date
* Date 30 days later
* Date 6 months earlier

### Exercise 2

Create two dates:
```java
LocalDate start = LocalDate.of(2025, 1, 1);
LocalDate end = LocalDate.of(2026, 1, 1);
```

Calculate:

* Years between
* Months between
* Days between

### Exercise 3

Format today's date as:
```java
September 21, 2026
```

## Key Takeaways
* Java uses the ISO-8601 calendar standard by default.
* Instant represents machine time.
* LocalDate, LocalTime, and LocalDateTime represent human time.
* Zoned classes include timezone information.
* Period measures years, months, and days.
* Duration measures elapsed time in hours, minutes, seconds, and nanoseconds.
* Date-time objects are immutable.
* Use DateTimeFormatter for presentation formatting.
* Convert legacy Date objects through Instant.
* Prefer the Java 8+ Date-Time API over Date and Calendar for all new development.