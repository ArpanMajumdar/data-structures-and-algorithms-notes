# Queues

- Queues are data structures that follow First In First Out strategy.
- They are also called FIFO structures.

## Queue operations
1. `enqueue(item)` Add an item to the back of the queue
2. `dequeue() : item` Remove an item from front of queue
3. `peek(): item` Return an item from front of queue without removing it from queue

## Queue implementations

### Doubly linked list implementation
**enqueue**
To enqueue an item, simply add an item after the top sentinel in a doubly linked list.

**dequeue**
To dequeue an item, remove and return item before the bottom sentinel.

### Array implementation
Maintain a left and right index to keep track of begin and end of queue.

**enqueue**
To enqueue an item, increment the right index and add an item.

**dequeue**
To dequeue an item, return item at the left index and decrement.

### Circular queues
If queue implementation is done using an array and we keep on adding and removing items, items in the array slowly shift to the right. So, no matter how big an array we make we will run short.

To create a circular queue, we need 2 indexes:
- **top**: The next open position
- **bottom**: The oldest item in the queue

**dequeue**
To dequeue an item, return the bottom item and set `bottom` to `(bottom+1) mod N`.

**queue**
To enqueue an item, insert an item at the top index and set `top` to `(top+1) mod N`.

### Double ended queues
**Operations**
- Enqueue an item at either end
- Dequeue an item at either end
- Peek an item at either end

They are easy to implement with doubly linked lists with top and bottom sentinels.

