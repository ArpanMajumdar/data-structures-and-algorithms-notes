# Singly linked lists

Linked lists consist of nodes. A typical node contains following information:
1. **Data** (This can be any object we want to store)
2. **Link** (This is generally a memory pointer or object reference to the next node of linked list)

Typical structure of a node
```java
public class LinkedListNode {
    public int data;
    public LinkedListNode next;
}
```

## Linked list operations

- Iterate through the list
- Insert an item
  - At the beginning
  - At middle or end of list
- Remove an item
  - From the beginning
  - From middle or end of list

### Iterate through a list
```
current = top

while(current != null) 
    // Do something with the current node

    // Move to next node
    current = current.next
end

```

### Insert at top
1. Point the new node's next pointer to top.
2. Point top to the new node
> Note that order is important here. If we first point top to the new node, then we lose the entire list.

```
newNode.next = top
top = newNode
```

### Insert in the middle
1. Find the node before where we want to insert new node.
2. Point new node's next pointer to before node's next.
3. Point before node's next pointer to new node.

```
// Find the node before
newNode.next = before.next
before.next = newNode
```

### Insert at end
1. Iterate till the end of the list while checking if next node is null.
2. Point the new node's next to null.
3. Point current node(last node)'s next to new node.
```
before = top

while(before.next != null)
    before=before.next

newNode.next = before.next
before.next = newNode
```

### Remove from beginning
1. Point the top pointer to top's next node.
2. Depending on the programming language, we may have to free memory of the first node if language doesn't support garbage collection.
```
top = top.next
```

### Remove from middle
1. Find the node before the node you want to delete.
2. Point before's next pointer to next node's next.
```
// Find the node before
before.next = before.next.next
```

## Using sentinels
Since there is no node at the beginning of the Linked List, we have to cover many special cases for beginning. These problems can be solved by placing a sentinel node at the beginning of the Linked List which contains no data but points to the first element of list. In that case, we are always inserting at the middle. An empty list is denoted by sentinel pointing to null.

## Sorting linked lists
1. Start with an empty list.
2. Add items one by one such that list is always sorted.
3. Traverse the list once all items are finished to get tehm in sorted order.

Here is the pseudocode for adding items:



