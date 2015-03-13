# PA 3

---
# Checklist
- BaseThread
- Philosopher
- Monitor
- DiningPhilosophers
- Makefile (ignore it)

---
# Yield vs Sleep
- `Thread.yield` to temporarily pause the running thread and allow other threads to execute

- `Thead.sleep` to suspend the running thread for the specified number of milliseconds

---
# Philosopher
- Read TODO in comments
- Implements eat, think, talk

---
# Monitor (Most important)
- `pickUp`
- `putDown`
- `requestTalk`
- `endTalk`

---
# Pickup
- Condition: Both the left & right chopsticks are available
- Waits until condition true, pick both and returns
- Using `wait` method of Java Monitor

---
# PutDown
- Returns a pair of holding chopstick
- `notifyAll` to all waiting philosophers
- P2 put down can trigger both P1 and P3

---
# Monitor Notes
- Calling `wait` and `notifyAll` must be inside `synchronized`

---
# requestTalk
- Condition: No one is talking
- Waits until condition true, mark as talking, return permit
- Using `wait`

---
# endTalk
- marks as no one is talking
- `notify` one is enough but carefully
- If requestTalk & endTalk are sharing Monitor with Pickup/Putdown. `notifyAll` is required

1. A waiting for chopsticks & B waiting for talk
2. C signals end talk but A is awaken up

---
# Sharing Monitor or not
- Eat and talk are independent task
- Separating monitors are better
- But you can use a shared monitor

---
# Application Arguments
```java
class Adder {
  public static void main (String[] args) {
    if (args.length == 2) {
      try {
        int first = Integer.parseInt(args[0]);
        int second = Integer.parseInt(args[1]);
        int sum = first + second;
        System.out.println("" + first + " + " + second + " = " + sum);
      } catch (NumberFormatException e) {
        System.err.println("Both must be integers: " + args[0] + ", " + args[1]);
      }
    }else{
      System.err.println("Usage: java Adder x y");
    } 
  }
}
```

---
# Command-Line Arguments
1. Launch application from command line
2. Configure program arguments in IDE

References:
[http://docs.oracle.com/javase/tutorial/essential/environment/cmdLineArgs.html](http://docs.oracle.com/javase/tutorial/essential/environment/cmdLineArgs.html)

---
