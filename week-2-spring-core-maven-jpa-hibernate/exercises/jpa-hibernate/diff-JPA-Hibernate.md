# JPA vs Hibernate vs Spring Data JPA

## JPA (Java Persistence API)
- JPA is a specification (JSR 338).
- It defines standard APIs for object-relational mapping (ORM).
- It is not an implementation.
- Requires an implementation like Hibernate.

## Hibernate
- Hibernate is an implementation of JPA.
- It is an ORM framework.
- Maps Java objects to database tables.
- Provides features like caching, lazy loading, and HQL.
- Requires more configuration and boilerplate code than Spring Data JPA.

## Spring Data JPA
- Spring Data JPA is built on top of JPA.
- It commonly uses Hibernate as the JPA implementation.
- Reduces boilerplate code by generating repository implementations automatically.
- Provides methods like `findAll()`, `findById()`, `save()`, and `delete()` without writing SQL.

## Relationship

Spring Data JPA
        ↓
       JPA
        ↓
   Hibernate
        ↓
    Database

## Difference

| JPA | Hibernate | Spring Data JPA |
|-----|-----------|-----------------|
| Specification | JPA Implementation | Abstraction over JPA |
| No implementation | ORM Framework | Simplifies database operations |
| Defines standards | Implements JPA | Generates repository code automatically |

## Conclusion
- JPA defines **what** should be done.
- Hibernate defines **how** it is done.
- Spring Data JPA makes using Hibernate much easier by removing boilerplate code.