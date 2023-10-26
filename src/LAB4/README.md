# Stacks in Java
## Introduction
A stack is a data structure that stores items in an Last-In/First-Out (LIFO) or First-In/Last-Out (FILO) manner. In stack, a new element is added at one end and an element is removed from that end only. The insert and delete operations are often called push and pop.

## Implementation
In Java, Stack is a class that falls under the Collection framework that extends the Vector class. It is available in Java.util package and implements the List interface. It is used to represent a last-in-first-out (LIFO) stack of objects. It is used to insert and remove the elements from the top of the stack. It is based on the principle of last-in-first-out (LIFO). In Java, the stack is implemented using ArrayDeque or LinkedList. However, the ArrayDeque class is a more efficient and faster way to implement a stack.

In Addition, we can implement our own stack interface and class in Java.
For this code, we will be using the ArrayStack class to implement the stack.

## Methods
### push(e)
This method is used to push an element into the stack. This method is used to add an element at the top of the stack. This method returns the element that is pushed recently onto the stack.
### pop()
This method is used to pop an element from the stack. This method removes and returns the element that is at the top of the stack.
Null is returned if the stack is empty.
### top()
This method is used to return the element that is at the top of the stack without removing it.
Null is returned if the stack is empty.
### size()
This method is used to return the size of the stack.
### isEmpty()
This method is used to check whether the stack is empty or not. It returns true if the stack is empty, otherwise false.

### Examples
#### Calculators
#### Infix to Postfix
#### Function Calls
#### Delimiter Matching
#### Undo Operation in Text Editors
#### Reverse a String
#### Decimal to Binary Conversion


# Queues in Java
## Introduction
A Queue is a linear structure which follows a particular order in which the operations are performed. The order is First In First Out (FIFO). A good example of a queue is any queue of consumers for a resource where the consumer that came first is served first. The difference between stacks and queues is in removing. In a stack we remove the item the most recently added; in a queue, we remove the item the least recently added.
## Implementation
In Java, Queue is an interface available in java.util package and extends the Collection interface. It is used to insert elements at the end of the queue and removes from the beginning of the queue. It is an ordered list of objects with its use limited to insert elements at the end of the list and deleting elements from the start of the list, more like a FIFO (First In First Out) data structure. We can use LinkedList, ArrayDeque or PriorityQueue to implement Queue in Java.

In Addition, we can implement our own queue interface and class in Java.
For this code, we will be using the ArrayQueue class to implement the queue.

## Methods
### enqueue(e)
This method is used to insert an element into the queue. This method is used to add an element at the end of the queue. This method returns the element that is enqueued recently onto the queue.
### dequeue()
This method is used to remove an element from the queue. This method removes and returns the element that is at the front of the queue.
Null is returned if the queue is empty.
### first()
This method is used to return the element that is at the front of the queue without removing it.
Null is returned if the queue is empty.
### size()
This method is used to return the size of the queue.
### isEmpty()
This method is used to check whether the queue is empty or not. It returns true if the queue is empty, otherwise false.

### Examples
#### Printer Queue
#### Breadth First Search
#### Waiting Lines
#### Web Server Request Processing
#### CPU Scheduling


# Learning lessons from the experiment
# I have learned how to implement stacks and queues in Java.
# I have learned how to use stacks and queues in solving problems.
# Learnt implementation of stacks and queues using Array.
# Learnt various methods of stacks and queues.
# Learnt about the applications of stacks and queues.
# Practiced using stacks and queues in solving problems.
# Made interface and class for stacks and queues.

# Conclusion
# Stacks and queues are data structures that are used to store data in a particular order.
# Stacks and queues are used in solving various problems.
# Stacks and queues are used in various applications.
# Stacks and queues are implemented using arrays, linked lists, etc.
# Stacks and queues are implemented using various methods.
# Various supporting methods are used in implementing stacks and queues.
# Stacks have methods like push, pop, top, size, isEmpty.
# Queues have methods like enqueue, dequeue, first, size, isEmpty.
# Stacks and queues are used in various applications like calculators, undo operation in text editors, etc.
# We can use stacks when LIFO (Last In First Out) order is required.
# We can use queues when FIFO (First In First Out) order is required.

