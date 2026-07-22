# Mockito Exercise 2 - Verifying Interactions

## Verifying Interactions
- `verify()` checks whether a method on a mock object was called.
- It can also verify how many times a method was invoked.

## Steps
1. Create a mock object.
2. Inject the mock into the service.
3. Call the service method.
4. Verify the interaction using `verify()`.

## Conclusion
- `verify()` ensures the expected method was invoked.
- Useful for testing interactions with external dependencies.