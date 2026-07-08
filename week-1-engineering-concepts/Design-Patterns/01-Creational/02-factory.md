# Factory Design Pattern

## Definition

The **Factory Design Pattern** is a **Creational Design Pattern** that
encapsulates object creation in one place.

Instead of creating objects using the `new` keyword throughout the
application, the client asks a **Factory** to create the required
object.

This promotes **loose coupling**, improves maintainability, and makes
the application easier to extend.

------------------------------------------------------------------------

## Why do we need the Factory Pattern?

Without a factory:

``` java
Shape shape = new Circle();
Shape shape = new Rectangle();
Shape shape = new Square();
```

Problems: - Tight coupling - Repeated object creation logic - Hard to
maintain - Hard to extend

A Factory centralizes object creation.

------------------------------------------------------------------------

## Real-World Analogy

Ordering pizza from a restaurant.

You tell the restaurant which pizza you want. The restaurant prepares it
and gives you the finished product.

Client → Factory → Product

------------------------------------------------------------------------

## Components

### Product

``` java
public interface Shape {
    void draw();
    void computeArea();
}
```

### Concrete Products

``` java
public class Circle implements Shape {
    public void draw(){ System.out.println("Circle"); }
    public void computeArea(){ System.out.println("Area"); }
}
```

``` java
public class Rectangle implements Shape {
    public void draw(){ System.out.println("Rectangle"); }
    public void computeArea(){ System.out.println("Area"); }
}
```

``` java
public class Square implements Shape {
    public void draw(){ System.out.println("Square"); }
    public void computeArea(){ System.out.println("Area"); }
}
```

------------------------------------------------------------------------

# Simple Factory

``` java
public enum ShapeType{
    CIRCLE,RECTANGLE,SQUARE
}
```

``` java
public class ShapeFactory{

    public static Shape createShape(ShapeType type){

        if(type==null) return null;

        return switch(type){
            case CIRCLE -> new Circle();
            case RECTANGLE -> new Rectangle();
            case SQUARE -> new Square();
        };
    }
}
```

Client:

``` java
Shape shape = ShapeFactory.createShape(ShapeType.CIRCLE);
shape.draw();
shape.computeArea();
```

### Advantages

-   Simple
-   Centralized creation

### Disadvantages

-   Violates Open/Closed Principle
-   Modify factory for every new product

------------------------------------------------------------------------

# Factory Method

Abstract Creator

``` java
public abstract class ShapeFactory{
    public abstract Shape createShape();
}
```

Concrete Creators

``` java
class CircleCreator extends ShapeFactory{
    public Shape createShape(){
        return new Circle();
    }
}
```

``` java
class RectangleCreator extends ShapeFactory{
    public Shape createShape(){
        return new Rectangle();
    }
}
```

``` java
class SquareCreator extends ShapeFactory{
    public Shape createShape(){
        return new Square();
    }
}
```

Client

``` java
ShapeFactory factory = new CircleCreator();
Shape shape = factory.createShape();
shape.draw();
shape.computeArea();
```

------------------------------------------------------------------------

## How it Works

1.  Client requests a product.
2.  Factory creates the object.
3.  Client uses only the Product interface.
4.  Client never directly calls `new`.

------------------------------------------------------------------------

# Simple Factory vs Factory Method

  Feature       Simple Factory   Factory Method
  ------------- ---------------- ----------------
  Factory       One              Multiple
  Inheritance   No               Yes
  OCP           Violates         Follows
  Flexibility   Medium           High
  Usage         Small apps       Large apps

------------------------------------------------------------------------

# Advantages

-   Loose Coupling
-   Easy Maintenance
-   Better Scalability
-   Supports OCP
-   Easy Testing

------------------------------------------------------------------------

# Disadvantages

-   More classes
-   Slightly complex

------------------------------------------------------------------------

# Interview Questions

### Why use Factory?

To separate object creation from business logic.

### Which SOLID principle is supported?

Open/Closed Principle.

### Difference between Simple Factory and Factory Method?

Simple Factory uses one factory with conditions. Factory Method
delegates creation to subclasses.

------------------------------------------------------------------------

# One-Line Revision

> Factory Pattern encapsulates object creation so clients depend on
> abstractions instead of concrete classes.
