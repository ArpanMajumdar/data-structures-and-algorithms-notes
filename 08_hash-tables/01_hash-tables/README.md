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

|Method |Insertion | Search | Extra space
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

#### Assuming array is 50% filled
1. There is a 1/2 chance of failing after 1st try.
2. There is a 1/4 chance of failing after 2nd try.
3. There is a 1/8 chance of failing after 3rd try.
4. There is a 1/16 chance of failing after 4th try and so on.

The odds of failing multiple times is very small.

#### Assuming array is 90% filled
1. There is a 0.9 chance of failing after 1st try.
2. There is a 0.81 chance of failing after 2nd try.
3. There is a 0.729 chance of failing after 3rd try.
4. There is a 0.6561 chance of failing after 4th try and so on.

The odds of failing is reducing very slowly.

Thus when a hash table is full, its performance start deteriorating. Thus we have to resize the hash table before it reaches 80%.

### In-place rehashing
Many times array is full of removed objects in which case we don't need to resize the array. We can just rehash in the existing table. Algorithm for in-place rehashing is given below.

```
Mark every item as old
Empty all the removed spots

for each item in array
    if item is marked as updated
        ignore
    if item is marked as old
        rehash the item

        if you find an empty spot
            drop the item there and mark it as updated
        if you find a spot marked old
            drop the item there and mark it as updated
            rehash the old item it replaced
```

## Open addressing - Linear probing
1. In open addressing, we allocate an array to store the key-values and use a probe sequence to identify the location of key in array. One of the simple methods is linear probing.
2. In this method, we calculate the initial position of key using a simple function. e.g.- `K mod N`.
3. In case of collision, we simply add a constant to the probe sequence to get the next location. `P(i+1) = P(i) + C`

### Cons
1. Linear probing is simple but it causes clustering of values and clustering is bad. Larger the cluster, more times key has to follow the sequence.
2. As the cluster becomes larger, probability that a item will land after that cluster increases. This again increases the cluster.
3. As the clusters start forming, they merge to form even larger clusters.


## Open addressing - Quadratic probing
Quadratic probing helps to avoid primary clustering. 

#### Linear probing
P(i+1) = P(i) + C
Let the key be K, then probe sequence values are given by
- K
- K + 1
- K + 2
- K + 3

#### Quadratic probing
P(i+1) = P(i) + i^2
Let the key be K, then probe sequence values are given by
- K
- K + 1
- K + 4
- K + 9

We can see that there is more chance of addition of new keys adjacent to already existing keys in the array in case of linear probing. In quadratic probing, this chance is eliminated.

### Cons
1. Although quadratic probing helps to deal with primary clustering, it gives rise to secondary clustering.
2. Secondary clustering occurs when many keys map to the same initial location. As a result, it will follow the same probe sequence for those items and sequence will become long.
3. Secondary clustering is not as bad as primary clustering but is does increase the average probe length.

## Double hashing
1. As we have already seen that linear probing suffers with primary clustering and quadratic probing suffers with secondary clustering.
2. To solve this problem we need every value to generate a different probe sequence. One way to accomplish this is to use double hashing.
3. In double hashing we have 2 hash functions H1 and H2. We use H1 to generate the initial value. If it is occupied then we use H2 to generate subsequent values.

Let H1 and H2 are the two hash functions
```
K = H1(key)

if K is not occupied 
    done
else 
    C = H2(key)
    Then subsequent sequence is given by
    K + C
    K + 2C
    K + 3C
    ...
```

e.g- 
Let the array holds 10 entries.
```
H1(key) = key mod 10
H2(key) = (key mod 7) + 3
```

### Cons
1. One of the biggest cons of double hashing is that sometimes the sequence may get stuck in a loop and doesn't produce all possible indices in array.
2. If this happens, even if the array is empty we may not be able to find a place for a given key.
3. This issue can be solved by resizing the array.






