# Doubly linked lists

```
x <- sentinel <-> 52 <-> 4 <-> 13 <-> sentinel -> x
```

### Adding a node after a given node
1. Find the node before where we want to insert new node.
2. Point new node's prev and next pointers to the before node and after node.
3. Update after node's prev pointer to point to new node.
4. Update before node's next pointer to point to new node.
```
// Find the node before
newNode.next = before.next
newNode.prev = before

before.next.prev = newNode
before.next = newNode
```

### Removing items
1. Find the node to be deleted.
2. Update prev pointer of next node of to-be-deleted node to point to prev node of the same.
3. Update next pointer of prev node of to-be-deleted node to point to next node of the same.
```
// Find the node to be deleted (targetNode)
targetNode.next.prev = targetNode.prev
targetNode.prev.next = targetNode.next
```

