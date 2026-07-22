# Exercise 7 

## Recursion
- Recursion is a technique where a method calls itself.
- Every recursive method must have a base case to stop recursion.

## Forecasting Logic
- Future Value = Current Value × (1 + Growth Rate)
- The recursive method repeats this calculation until all years are processed.

## Time Complexity
- Recursive Solution: O(n)
- Space Complexity: O(n) (recursive call stack)

## Optimization
- Use iteration instead of recursion to avoid stack usage.
- Memoization can be used when recursive subproblems repeat.
- Since this problem has no overlapping subproblems, iteration is the best optimization.

## Conclusion
- Recursion makes the code simple and easy to understand.
- For large inputs, an iterative approach is more efficient.