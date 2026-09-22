# Java BigDecimal
## Lesson Overview

Financial, scientific, and high-precision business applications often require exact decimal arithmetic. Java's primitive floating-point types (float and double) can introduce small rounding errors because they store numbers in binary format. The BigDecimal class provides arbitrary-precision decimal arithmetic, making it the preferred choice when accuracy is critical.

## Learning Outcome 1: Explain BigDecimal
### What is BigDecimal?

BigDecimal is a class in the java.math package that provides precise decimal arithmetic with virtually unlimited precision.

Unlike double and float, BigDecimal stores decimal values exactly, avoiding the rounding issues associated with binary floating-point representation.

### Why Use BigDecimal?

Common use cases include:

* Financial calculations
* Currency processing
* Tax calculations
* Scientific measurements
* Any application requiring precise decimal values

### Floating-Point Problem Example
```java
System.out.println(0.1 + 0.2);
```

Output:
```java
0.30000000000000004
```

This occurs because double cannot exactly represent many decimal values.

### BigDecimal Solution
```java
import java.math.BigDecimal;

BigDecimal a = new BigDecimal("0.1");
BigDecimal b = new BigDecimal("0.2");

BigDecimal result = a.add(b);

System.out.println(result);
```

Output:
```java
0.3
```

### Important Constructor Rule

Prefer using String values when creating BigDecimal objects.

✅ Recommended:
```java
BigDecimal amount = new BigDecimal("10.25");
```

❌ Avoid:
```java
BigDecimal amount = new BigDecimal(10.25);
```

The second example imports the floating-point approximation into the BigDecimal.

## Learning Outcome 2: Compare Precision and Scale

Understanding precision and scale is essential when working with BigDecimal.

### Precision

Precision is the total number of significant digits in a number.

Example:
```java
BigDecimal value = new BigDecimal("12345.67");
```

Precision:
```java
7
```

Digits counted:
```java
1234567
```
### Scale

Scale is the number of digits to the right of the decimal point.

Example:
```java
BigDecimal value = new BigDecimal("12345.67");
```

Scale:
```java
2
```

### Visual Comparison

Value:

12345.67

|Attribute|	Value|
|---|---|
|Precision|	7|
|Scale|	2|

Another example:

0.001230

|Attribute	|Value|
|---|---|
|Precision	|4|
|Scale	    |6|

### Explanation:

* Precision counts significant digits: 1230
* Scale counts digits right of the decimal: 001230

Inspecting Precision and Scale
```java
BigDecimal value = new BigDecimal("12345.67");

System.out.println(value.precision());
System.out.println(value.scale());
```

Output:
```java
7
2
```
### Key Difference
|Precision|	Scale|
|---|---|
|Total significant digits|	Digits after decimal point|
|Measures overall accuracy|	Measures decimal places|
|Example: 123.45 → 5|	Example: 123.45 → 2|

## Learning Outcome 3: Describe Scale as it Applies to BigDecimal
### What Is Scale?

Scale represents the number of digits to the right of the decimal point.

Examples:

|Value|	Scale|
|---|---|
|100|	0|
|100.0|	1|
|100.00|	2|
|100.125|	3|

Notice that trailing zeros affect scale.
```java
BigDecimal a = new BigDecimal("100");
BigDecimal b = new BigDecimal("100.00");

System.out.println(a.scale());
System.out.println(b.scale());
```

Output:
```java
0
2
```

Although the numerical values are equal, their scales differ.

### Changing Scale

The setScale() method can increase or decrease the scale.

### Increasing Scale
```java
BigDecimal amount = new BigDecimal("25.5");

amount = amount.setScale(4);

System.out.println(amount);
```

Output:
```java
25.5000
```

### Decreasing Scale
```java
BigDecimal amount = new BigDecimal("25.5678");

amount = amount.setScale(2, RoundingMode.HALF_UP);

System.out.println(amount);
```

Output:
```java
25.57
```

### Why Scale Matters

Scale is important because business rules often require a fixed number of decimal places.

Examples:

* Currency: 2 decimal places
* Tax calculations: 2–4 decimal places
* Scientific measurements: variable precision
* Interest calculations: often 4 or more decimal places

## Learning Outcome 4: Explain Considerations for Rounding Modes
### Why Rounding Is Necessary

Certain calculations produce more decimal places than required.

Example:
```java
BigDecimal result =
    new BigDecimal("10")
        .divide(new BigDecimal("3"));
```

This causes an exception because the result is a repeating decimal.

To perform the operation, you must specify a scale and rounding mode.
```java
BigDecimal result =
    new BigDecimal("10")
        .divide(
            new BigDecimal("3"),
            2,
            RoundingMode.HALF_UP
        );
```

Output:
```java
3.33
```

### Common Rounding Modes
**HALF_UP**

Rounds toward the nearest neighbor.

Values ending in 5 round up.

Examples:
```java
2.345 → 2.35
2.344 → 2.34
```

Most familiar to end users.
```java
value.setScale(2, RoundingMode.HALF_UP);
```

**HALF_DOWN**

Rounds toward the nearest neighbor.

Values ending in exactly 5 round down.

Examples:
```java
2.345 → 2.34
2.346 → 2.35
```

**HALF_EVEN** (Banker's Rounding)

Rounds to the nearest even digit when exactly halfway between two values.

Examples:
```java
2.345 → 2.34
2.355 → 2.36
```

Benefits:

* Reduces cumulative rounding bias
* Common in financial and statistical systems


**UP**

Always rounds away from zero.

Examples:
```java
2.341 → 2.35
-2.341 → -2.35
```

Useful when underestimation is unacceptable.

**DOWN**

Always rounds toward zero.

Examples:
```java
2.349 → 2.34
-2.349 → -2.34
```

Useful when truncation is desired.

**CEILING**

Always rounds toward positive infinity.

Examples:
```java
2.341 → 2.35
-2.341 → -2.34
```

**FLOOR**

Always rounds toward negative infinity.

Examples:
```java
2.341 → 2.34
-2.341 → -2.35
```

### Choosing a Rounding Mode

Consider the following questions:

* Is regulatory compliance involved?
* Will results be used for financial reporting?
* Is minimizing cumulative bias important?
* Must the result always favor the customer or organization?
* Is simple truncation acceptable?

### Typical Recommendations
|Scenario|	Suggested Rounding Mode|
|--|--|
|General business applications|	HALF_UP|
|Financial institutions|	HALF_EVEN|
|Statistical calculations|	HALF_EVEN|
|Tax calculations|	Follow regulatory requirements|
|Truncation required|	DOWN|
|Never underestimate value|	UP or CEILING|

## Summary

BigDecimal provides precise decimal arithmetic and should be used whenever exact numeric calculations are required. Precision represents the total number of significant digits, while scale represents the number of digits to the right of the decimal point. Scale directly affects how values are stored, displayed, and calculated. When reducing scale or performing operations that generate repeating decimals, developers must choose an appropriate rounding mode based on business requirements, regulatory rules, and potential rounding bias.

## Key Takeaways
* BigDecimal provides exact decimal arithmetic.
* Prefer string constructors when creating BigDecimal objects.
* Precision = total significant digits.
* Scale = digits to the right of the decimal point.
* Scale impacts storage, display, and calculations.
* Rounding modes determine how values are adjusted when precision must be reduced.
* HALF_UP and HALF_EVEN are the most commonly used rounding strategies.
* Financial and regulatory requirements should always guide rounding decisions.