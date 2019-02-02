# Time complexity

## Big-oh notation

### Big-oh rules
1. If an algorithm performs $f(N)$ steps, then it is order of $f(N)$.
2. If an algorithm performs $f(N)$ steps followed by $g(N)$ steps, then it is $O(f(N)+g(N))$.
3. If $f(N)>g(N)$ for large N, then $O(f(N)+g(N))$=$O(f(N))$.
4. If an algorithm performs $g(N)$ steps for each of $f(N)$ steps, then it is of the order of $O(f(n)*(g(n)))$.
5. Ignore constant multiples: $O(c*f(N))$=$O(f(N))$, $O(f(c*N))$=$O(f(N))$.

## Typical runtime functions

### $O(1)$
Perform a fixed number of actions whatever may be the value of N.
e.g.- Accessing an element in array

### $O(N)$
Perform one action per input
e.g.- Looping through an array and performig some constant time action.
```
for i = 1 to N
    ...
```

### $O(N^2)$
For each input, loop through the inputs again.
e.g.- Finding duplicates in an array
```
for i = 1 to N
    for j = 1 to N
        ...
```

### $O(N^C)$
$O(N^2)$ can be generalized to C i.e. C nested for loops.
```
for i = 1 to N
    for j = 1 to N
        for k = 1 to N
            ... C times
```

### $O(log(N))$
Problems that divide the search space into 2 (or N) pieces at each step.
e.g.- Binary search discards half of the search space everytime.

### $O(2^N)$
Problems that deal with selection of items.

### $O(N!)$
Problems that deal with arrangement of items.

## P and NP

**P** - Deterministic Polynomial time
e.g.- Finding the largest number in the list is a polynomial function in N

**NP** - Non-deterministic polynomial time. This type of algorithm is allowed to make an inspired guess and check if the guess is correct.
e.g.- Given a set of N numbers, is there a subset whose sum adds up to 0.




