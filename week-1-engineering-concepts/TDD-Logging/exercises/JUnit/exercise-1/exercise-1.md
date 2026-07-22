# Exercise 1 - Setting Up JUnit

## Steps

1. Create a new java project.
2. Add JUnit dependency in `pom.xml`.
3. Create a test class inside `src/test/java`.
4. Write and run test cases using JUnit.

## Maven Dependency

```xml
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.13.2</version>
    <scope>test</scope>
</dependency>
```

## Project Structure

```
src
├── main
│   └── java
│       └── Calculator.java
└── test
    └── java
        └── CalculatorTest.java
```

## Conclusion

- JUnit is used for unit testing Java applications.
- Test classes are created under `src/test/java`.
- Maven automatically downloads the JUnit dependency.