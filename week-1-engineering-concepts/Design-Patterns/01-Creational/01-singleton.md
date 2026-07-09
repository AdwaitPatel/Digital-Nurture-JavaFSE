# Singleton Design Pattern

## Definition

The **Singleton Design Pattern** ensures that **only one instance** of a
class is created throughout the application's lifecycle while providing
a global access point to that instance.

## Characteristics

-   Private constructor
-   Static instance variable
-   Public static `getInstance()` method
-   Only one object exists

## 1. Eager Initialization

-   Object created when class loads.
-   Thread-safe.
-   May create object unnecessarily.

``` java
public class DBConnectionEager {
    private static final DBConnectionEager instance = new DBConnectionEager();
    private DBConnectionEager() {}
    public static DBConnectionEager getInstance() {
        return instance;
    }
}
```

## 2. Lazy Initialization

-   Object created only on first request.
-   Not thread-safe.

``` java
public class DBConnectionLazy {
    private static DBConnectionLazy instance;
    private DBConnectionLazy() {}
    public static DBConnectionLazy getInstance() {
        if(instance == null)
            instance = new DBConnectionLazy();
        return instance;
    }
}
```

## 3. Thread-Safe Singleton

``` java
public class DBConnectionThreadSafe {
    private static DBConnectionThreadSafe instance;
    private DBConnectionThreadSafe() {}
    public static synchronized DBConnectionThreadSafe getInstance() {
        if(instance == null)
            instance = new DBConnectionThreadSafe();
        return instance;
    }
}
```

## 4. Double Checked Locking

``` java
public class DBConnectionDoubleLocking {
    private static volatile DBConnectionDoubleLocking instance;
    private DBConnectionDoubleLocking() {}
    public static DBConnectionDoubleLocking getInstance() {
        if(instance == null) {
            synchronized(DBConnectionDoubleLocking.class) {
                if(instance == null) {
                    instance = new DBConnectionDoubleLocking();
                }
            }
        }
        return instance;
    }
}
```

## Why `volatile`?

-   Prevents instruction reordering.
-   Ensures memory visibility across threads.

## Comparison

  Type                    | Lazy  | Thread Safe  | Performance
  ------------------------| ------|------------- | -------------
  Eager                   | ❌    | ✅            | High
  Lazy                    | ✅    | ❌            | High
  Synchronized            | ✅    | ✅            | Medium
  Double Checked Locking  | ✅    | ✅            | High

## Interview Points

-   Private constructor prevents object creation using `new`.
-   `getInstance()` is static because no object exists before calling
    it.
-   Instance variable is static because it belongs to the class.
-   `volatile` is required for Double Checked Locking.
-   Preferred implementation: Double Checked Locking with `volatile`.

## One-Line Revision

> Singleton ensures only one instance of a class exists and provides a
> global access point to it.
