# Exercise 2 - Implementing Dependency Injection

## Dependency Injection (DI)
- Dependency Injection is a design pattern where Spring injects required objects.
- It reduces tight coupling between classes.

## IoC
- Spring IoC Container creates and manages beans.

## Steps
1. Create beans in `applicationContext.xml`.
2. Inject `BookRepository` into `BookService`.
3. Load the Spring context and use the bean.

## Conclusion
- Spring automatically injects dependencies.
- Setter Injection is used in this exercise.