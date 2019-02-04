# Stacks

- Stacks are data structure that follow **Last In First Out** principle.
- They are also called LIFO.

## Stack operations
1. `push(item)` Pushes an item into the stack
2. `pop(): item` Pops an item off the stack

## Stack implementations

### Linked List inplementation
```
top -> 3 -> 6 -> 2 -> 9 -> x
```
**Push**
Insert an item after the top sentinel.

**Pop**
Remove the item after the sentinel.

### Array implementation
Use a variable `top` to keep track of next unused position in the array.

**Push**
Insert the item at index given by top and increment the top index.

**Pop**
Return the last item in array (`top-1`) and decrement the top index. If items to be stored are objects it is better to free memory by pointing popped items to null.
