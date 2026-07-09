# Command Design Pattern

## Definition

The **Command Design Pattern** is a **Behavioral Design Pattern** that **encapsulates a request as an object**, allowing requests to be parameterized, queued, logged, and undone/redone.

Instead of calling methods on an object directly, the client creates a **Command Object** that represents the request.

> **One-Line Definition:** Command Pattern converts a request into an object, decoupling the sender from the receiver while supporting features like undo, redo, logging, and queuing.

---

# Why do we need Command Pattern?

Consider an **AC Remote**.

Without the Command Pattern:

```
Remote

↓

AirConditioner.turnOn()

↓

AirConditioner.setTemperature()

↓

AirConditioner.turnOff()
```

The Remote directly controls the Air Conditioner.

Problems:

- Tight Coupling
- Difficult to add new devices (Bulb, Fan, TV)
- No Undo/Redo support
- Difficult to maintain
- Violates Open/Closed Principle

Command Pattern solves this by introducing a **Command object** between the Remote and the Device. 

---

# Real-World Examples

- TV Remote
- AC Remote
- Undo / Redo in Text Editors
- Calculator Operations
- IDE Undo Feature
- Queueing Print Jobs
- Macro Recording
- Home Automation Systems

---

# Components

## 1. Receiver

The object that performs the actual work.

Example:

```java
AirConditioner
```

Responsibilities:

- Turn ON
- Turn OFF
- Set Temperature

The Receiver contains the business logic.

---

## 2. Command Interface

Defines a common contract for all commands.

Example:

```java
public interface ICommand {

    void execute();

    void undo();

}
```

Every command must implement:

- execute()
- undo()

---

## 3. Concrete Commands

Each command performs one specific operation.

Examples:

```
TurnOnCommand

TurnOffCommand

SetTemperatureCommand
```

Each command stores:

- Receiver
- Required parameters
- Previous state (for undo)

---

## 4. Invoker

Stores and executes commands.

Example:

```
RemoteController
```

Responsibilities:

- Store current command
- Execute command
- Maintain command history
- Perform Undo

The Invoker **does not know how the Receiver works**.

---

## 5. Client

Creates:

- Receiver
- Commands
- Invoker

Connects everything together.

---

# Structure

```
             Client
                |
                ▼
            Invoker
                |
          HAS-A Command
                |
        ----------------
        |              |
        ▼              ▼
 Command Interface  Concrete Command
                          |
                     HAS-A Receiver
                          |
                          ▼
                     AirConditioner
```

---

# How It Works

1. Client creates the Receiver.
2. Client creates Command objects.
3. Client gives the command to the Invoker.
4. Invoker executes the command.
5. Command delegates the request to the Receiver.
6. Invoker stores command history for Undo/Redo.

---

# Example: AC Remote

Receiver:

```
AirConditioner
```

Commands:

```
TurnOnCommand

TurnOffCommand

SetTemperatureCommand
```

Invoker:

```
RemoteController
```

Flow:

```
Client

↓

RemoteController

↓

TurnOnCommand

↓

AirConditioner.turnOn()
```

The Remote doesn't know how the AC works internally—it simply executes the command. :contentReference[oaicite:2]{index=2}

---

# Undo Functionality

One major advantage of Command Pattern is **Undo/Redo**.

Example:

```
Turn ON AC

↓

Set Temperature = 25°C

↓

Set Temperature = 18°C

↓

Turn OFF AC

↓

Undo

↓

AC Turns ON

↓

Undo

↓

Temperature becomes 25°C

↓

Undo

↓

Temperature becomes 0°C

↓

Undo

↓

AC Turns OFF
```

Each Command stores its previous state, making Undo easy to implement. :contentReference[oaicite:3]{index=3}

---

# Relationships

## IS-A Relationship

```
TurnOnCommand

IS-A

ICommand
```

```
TurnOffCommand

IS-A

ICommand
```

```
SetTemperatureCommand

IS-A

ICommand
```

---

## HAS-A Relationship

```
RemoteController

HAS-A

ICommand
```

```
TurnOnCommand

HAS-A

AirConditioner
```

Concrete Commands hold a reference to the Receiver.

---

# Advantages

- Decouples sender and receiver.
- Supports Undo/Redo.
- Supports Command Queueing.
- Supports Logging.
- Easy to add new commands.
- Follows Open/Closed Principle.
- Improves code maintainability.
- Supports Macro Commands (multiple commands together).

---

# Disadvantages

- Increases the number of classes.
- Slightly more complex for simple applications.
- Every operation requires its own Command class.

---

# When Should We Use It?

Use Command Pattern when:

- Undo/Redo is required.
- Operations need to be queued.
- Requests need to be logged.
- Multiple operations should be executed as one (Macro).
- Sender and Receiver should be loosely coupled.
- Different receivers perform different actions.

---

# Command vs Strategy

| Command | Strategy |
|----------|----------|
| Encapsulates a request | Encapsulates an algorithm |
| Focuses on executing operations | Focuses on selecting behavior |
| Supports Undo/Redo | Doesn't support Undo inherently |
| Invoker executes commands | Context uses strategies |

---

# Command vs Observer

| Command | Observer |
|----------|----------|
| One request → One receiver | One subject → Many observers |
| Explicit execution | Automatic notification |
| Used for actions | Used for event notification |

---

# Command vs Proxy

| Command | Proxy |
|----------|-------|
| Encapsulates requests | Controls access |
| Supports Undo/Redo | Supports lazy loading/security |
| Focuses on operations | Focuses on access control |

---

# Interview Questions

## Why do we need Command Pattern?

To encapsulate requests as objects, reducing coupling between the sender and receiver while supporting features like Undo, Redo, Queueing, and Logging.

---

## Which SOLID Principle does Command support?

- **Open/Closed Principle (OCP)** → New commands can be added without modifying existing code.
- **Single Responsibility Principle (SRP)** → Each command performs only one operation.

---

## Which relationship is used?

**HAS-A (Composition)**

- Invoker has a Command.
- Command has a Receiver.

---

## What is the Receiver?

The object that performs the actual business logic.

Example:

```
AirConditioner
```

---

## What is the Invoker?

The object responsible for executing Commands.

Example:

```
RemoteController
```

---

## Why is Undo easy?

Each Command stores the previous state before execution, allowing it to restore that state when `undo()` is called.

---

# Real-World Examples

- AC Remote
- TV Remote
- Smart Home Controllers
- Text Editor Undo/Redo
- IDE Undo History
- Print Queue
- Database Transactions
- Macro Recording in Office Applications

---

# Key Points

- Behavioral Design Pattern
- Request is encapsulated as an object.
- Sender and Receiver are decoupled.
- Invoker executes commands.
- Receiver performs actual work.
- Supports Undo/Redo.
- Supports Queueing.
- Uses Composition.
- Easy to extend with new commands.

---

# Revision

- Behavioral Pattern
- Request becomes an object.
- Command Interface
- Concrete Commands
- Receiver performs work.
- Invoker executes commands.
- Client configures everything.
- Supports Undo/Redo.
- Loose Coupling.

---

# One-Line Revision

> **Command Pattern encapsulates a request as an object, decoupling the sender from the receiver while enabling features like undo, redo, logging, and command queueing.**