# Exercise 4 - AAA Pattern, Setup and Teardown

## AAA Pattern

- Arrange - Prepare the required objects and test data.
- Act - Execute the method being tested.
- Assert - Verify the expected result.

## Test Fixtures

- Test fixtures are the objects and data required before running a test.

## Setup and Teardown

- @Before - Runs before every test method.
- @After - Runs after every test method.

## Conclusion

- AAA pattern makes tests clean and easy to read.
- @Before avoids duplicate initialization code.
- @After is used for cleanup after each test.