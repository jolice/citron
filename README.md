# Citron

Basic, proof-of-concept implementation of the testing framework. Provides fluent syntax for various assertions.

[![Build Status](https://travis-ci.org/riguron/Citron.svg?branch=master)](https://travis-ci.org/riguron/Citron)
[![codecov](https://codecov.io/gh/riguron/Citron/branch/master/graph/badge.svg)](https://codecov.io/gh/riguron/Citron)

# Basic usage

All assertions begin with ```assertThat()``` followed by an application of the matchers.

```java
int result = 2 + 2;
assertThat(result)
       .isNotNull()
       .and()
       .is(4)
       .and()
       .isIn(3, 4, 5);
```

Assertions are chained and separated by ```and()``` expression. 
All assertions are evaluated in the order they are specified in. It means that, for the specified example,
```result``` will be first checked for nulity, then whether it's equal to ```4``` and then whether it's in the ```[3, 4, 5]```
collection.

List of currently supported assertions:

| Method name | Parameter | Asserts that
| ------------- | ------------- | ------------- |
| matches  | Predicate | Actual Value matches a custom predicate |
| is | Expected value | Expected value equals actual value |
| isNot | Expected value | Expected value does not equal actual value |
| sameWith | Expected value | Expected and actual references point to the same instance |
| isNull | - | Actual value is null |
| isNotNull | - | Actual value is not null |
| isSubclassOf | Type | Class of the actual value is the subclass of the specified class |
| isInstanceOf | Type | Actual value is an instance of the specified class |
| isAnything | - | Always passes, regardless of the actual value
| isIn | Collection of elements | Whether the collection contains actual value |
| isNotIn | Collection of elements | Whether the collection does not contain actual value |
| equalToEveryOf | Collection of elements | Whether the collection completely consists of actual values |


# Method assertions

Method assertions allow for asserting whether an execution of some method (or multiple methods) was completed
without producing an exception.

For example, given the method:

```java
public void fail() {
    throw new UnsupportedOperationException();
}
```

The following assertion will pass:

```java
assertThat(this::fail)
        .doesThrow(UnsupportedOperationException.class);
```

To assert that method completes without throwing a runtime exception:

```java
String result = "abcde";
assertThat(() -> result.substring(1))
         .completesNormally();
```

# String assertions

There are some additional assertions for string provided, such as ```contains``` or whether string is equal
to another one ignoring the case.

```java
assertThat("abcde")
        .isNotNull()
        .and()
        .ignoringCase().is("AbCdE")
        .and()
        .contains("bcd");
```   

Full list of assertion methods for the strings:

| Method name | Asserts that |
| ------------- | ------------- |
| matches  | String matches a regular expression  |
| contains  | String contains another string  |
| endsWith | String ends with another string |
| startsWith | String starts with another string |
| ignoringCase | Equality ignoring the case |
| ignoringWhitespace | Equality ignoring the whitespace |  
