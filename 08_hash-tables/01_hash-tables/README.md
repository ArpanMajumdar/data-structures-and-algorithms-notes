# Hash tables
- A **hash table** is a data structure that allows us to quickly store and retrieve items.
- Since hash tables use a key to lookup values, they are also called **dictionaries**.
- A hash table converts a key to a corresponding position in a data structue.
- The process of this conversion is called **hashing**.
- They allow fast insertion and retrieval.
- They use extra space.

e.g- Phone numbers are stored in a table by looking at the last digit of the number.

| Index | Phone #
|--- |---
| 0 | 
| 1 | 982372992**1**
| 2 | 927972928**2**
| 3 | 
| 4 | 
| 5 | 927391378**5**
| 6 | 
| 7 | 863837997**7**
| 8 | 
| 9 | 

## Why hash tables are good?

Alternatives
|Method |Insertion | Search |Extra space
|--- |--- |--- |---
|Sorted list | O(N) | O(N) | Some
|Sorted array | O(N) | O(N log N) | Some
|Tree | O(N log N) | O(N log N) | Some
|Hash table | O(1) | O(1) | Much

## Hash table requirements
- Data structure to store items
- Hashing function
- Collision resolution policy

## Chaining
In chaining, each entry in the array is the top of linked list. Whenever, collision occurs new item is added to the linked list.
Some modifications can be made to the linked list to improve performance:
1. Use top and bottom sentinels to easily insert and remove items.
2. Keep the linked list in sorted order so that is easier to conclude if a key is there in the list.

### Adding items
1. Find the item's bucket number.
2. Add the item to that bucket's linked list.

### Finding items
1. Find the item's bucket number.
2. Search the bucket's list.

### Updating items
1. Find the item, inserting if it isn't present.
2. Set item's value.

### Removing items
1. Find the item in list.
2. If it is not present, we are done.
3. Else, remove the item from linked list.

### Performance
- Even distribution : O(1)
- Uneven distribution : O(N)

Performance depends on
- **Hashing function**. A good hash function distributes items evenly hence improves the performance. Pseudorandom number generators can be used to generate good hashes by using keys as seed.
- **Items to be hashed to hash table size ratio**. Bigger the ratio, worse the performance.

To improve performance if number of items is increasing, **resizing** of hash table can be done. We need to iterate through all buckets and rehash items. This takes **O(N)** time.

|Operation | Time complexity
|--- |---
|Adding | O(1)
|Finding | O(1)
|Updating | O(1)
|Deleting | O(1)
|Resizing | O(N)

## Open addressing
Open addressing defines a probe sequence for a key using which it decides in which position it will keep the item.
### Probe Sequence
A probe sequence is a sequence of array locations P0,P1,P2 ... where item can be placed. The algorithm first tries to place the item at position P0. If it is full it tries P2. If P2 is also full it tries P3 and so on till it finds empty position.

### Adding items
1. Follow the probe sequence until you find an empty spot or a spot marked as removed.
2. If spot is found, put the item there.
3. If you can't find an empty spot in N tries then give up.

The reasons that we can't find an empty spot can be:
1. Array may be full
2. It still may have some empty spaces but array may be so full that sequence is not able to find an empty space efficiently. 

### Finding items
1. Follow the probe sequence until you find the target key.
2. If you find a spot marked as removed, keep going.
3. If you find an empty spot first, the target isn't present.

### Removing items
1. Follow the probe sequence until you find the target key.
2. If you find an empty spot first, the target isn't present.
3. Otherwise mark the spot as removed.

### Performance
Performance of open addressing depends on the load factor or how much space is filled.

Suppose the array is 50% filled
- 






