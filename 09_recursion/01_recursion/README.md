# Recursion

Recursion is a techinique in programming in which a function calls itself. It is a powerful technique which allows us solve problems easily that otherwise can be very tricky to solve.

There can be multiple types of recursion:
- **Direct**: A method calls itself directly
- **Indirect**: Method A calls method B which in turn calls A
- **Multiple**: Method A calls itself multiple times

e.g.- Quicksort calls itself twice to recursively sort two halves of the array.

**Factorial example**
```
factorial(N)
    if(N==0)
        return 1
    return N * factorial(N-1)
```

**Execution**
```
factorial(4)                        12
    4 * factorial(3)                4 * 6 = 12
        3 * factorial(2)            3 * 2 = 6
            2 * factorial(1)        2 * 1 = 2
                1 * factorial(0)    1 * 1

```

### Runtime
- N recursive calls
- Constant number of steps per call
- Total O(N) runtime.

### Memory use
- Each resursive call may use memory. e.g.- Factorial method uses O(N) memory.
- If an algorithm calls itself many times, memory can add up quickly.

### Depth of recursion
- Programming languages generally use two data structures to allocate memory 
  - **Heap** - Used to create objects
  - **Stack** - Used for method calls
- Generally stack size is much less than that of heap and too many method calls due to deep recursion can exhaust the stack.

## Examples

### Fibonacci numbers

Fibinacci numbers are given by the following recurrence relation.
```
F(0) = 1
F(1) = 1
F(N) = F(N-1) + F(N-2)
```
Here are the first few fibonacci numbers.
1,1,2,3,5,8,13,21,34,55,89,...

Pseudocode for calculating fibonacci numbers using recursion.
```
fibonacci(n)
    if(n==0)
        return 1
    if(n==1)
        return 1
    return fibonacci(n-1) + fibonacci(n-2)
```
#### Time complexity
Let time taken is T(N)
```
T(N) = C + T(N-1) + T(N-2)
T(N) = T(N-1) + T(N-2)
We can see that the runtime of the function is fibonacci sequence itself.
T(N) = O(fibonacci(N))
```

#### Counting nodes in the recursion tree
Fibonacci recursion tree follows this property:
`# Leaf Nodes = # Internal nodes + 1`
Since all the leaf nodes are fibonacci(0) or fibonacci(1), all of them equal to 1. Therefore we can say that value of root node is sum of all leaf nodes(or count of all leaf nodes).

`# Leaf nodes = fibonacci(N)`
`# Internal nodes = # Leaf nodes -1`
`Total nodes = # Leaf nodes + # Internal nodes = 2 * fibonacci(N) - 1 = O(fibonacci(N))`

### Tower of hanoi
This is a famous puzzle. In this puzzle, we have 3 pegs and N discs of various sizes. The goal is to move all the discs from one peg to another. Here are the rules of the game:

1. A larger disc cannot be placed above a smaller disc.
2. We can only move one disc at a time.

![Tower of Hanoi](http://mathworld.wolfram.com/images/eps-gif/TowersofHanoiSolution_700.gif)

#### Recursive solution
1. To figure out the resursive solution, the biggest problem to solve is to move largest disc to the destination location.
2. To do that, we need to recursively move N-1 discs to temporary peg.
3. Move the largest disc to destination peg.
4. Recursively move all N-1 discs to destination peg.

#### Algorithm
```
moveDiscs(numDiscs, startPeg, destPeg, tempPeg)
    // If there are no discs to move, then return
    if(numDiscs == 0)
        return
    
    // Recursively move upper discs to temporary peg
    moveDiscs(numDiscs - 1, startPeg, tempPeg, destPeg)

    // Move the largest disc to its final destination
    moveDiscs(1, startPeg, destPeg, tempPeg)

    // Recursively move N-1 discs from temp peg to destination peg
    moveDiscs(numDiscs - 1, tempPeg, destPeg, startPeg)
```
#### Counting nodes in recursion tree
Since, every recursive step gives rise to to recursive calls each with size N-1. If we form a recursion tree, it would be a complete binary tree.

T(N) = # Nodes in the recursion tree = # Nodes in a complete binary tree = 2^N = O(2^N)

> According to a legend, there are 64 golden discs in a temple. If we move all discs from start peg to end peg, the world will end. However looking at the time complexity, 2^64 = 1.8 * 10^19 steps. Let moving 1 disc takes 1 sec and we don't make any mistake, it would take roughly 585 billion years.

## Koch curves
Koch curves is one of the first fractals described by mathematicians. Level of the curve deternimes how complex the curve will be.

#### Level 0
- Level 0 curve is a line segment.

#### Level 1
- Break the line segment into three pieces. 
- Replace the middle third with two line segments.

 and so on.
 ![Koch curves](https://home.iitm.ac.in/arunn/images/kochcurve1.PNG)

 ### Algorithm
 ```
 drawSegment(level, angle, length)
    if(level == 0)
        draw the line segment with given angle and length
    else
        // Draw the four parts of segment
        drawSegment(level-1, angle, distance/3)
        drawSegment(level-1, angle - 60, distance/3)
        drawSegment(level-1, angle + 60, distance/3)
        drawSegment(level-1, angle, distance/3)
 ```

 #### Time complexity
 Eevery function call gives rise to 4 new recursive calls with problem size N-1. If we form a recursion tree, it is a complete quaternary tree (tree with each node having 4 or 0 children). Sum of all the nodes of tree is 4^N.

 T(N) = O(4^N)
 Hence runtime is going to be pretty slow. However, we cannot go too many levels deep as after 6th or 7th level, length of line segment becomes so small that it is barely more than pixel size as shown in figure (f).

 #### Curve length
 After every recursive call, length of the curve increases by 1/3rd of its original size. Since we are replacing middle third with 2 new line segments,if initial length of curve is `L` then final length is `L + L/3 = 4/3 * L`.

## Removing recursion
Sometimes we may want to remove recursion as recursive call may go very deep which can exhaust the stack. Recursion can be modeled using stacks. So we can create our own stack to model recursion.

Here is a general algorithm for converting a recursive algorithm to a non-recursive one.
```
recursiveFn(paramneters)
    create stacks to hold parameters
    push initial parameters into stacks

    do until(stacks are empty)
        pop parameters off the stack(s)
        process parameters, possibly adding new parameters to the stacks
```

e.g.- 
### Recursive quicksort
```
quicksort(values[],beg,end)
    if beg>=end
        return
    
    divide them into 2 groups

    // Recursively sort the 2 groups

    quicksort(values,beg, mid - 1)
    quicksort(values,mid + 1, end)
```

### Non-recursive quicksort
```
quicksort(values[]){
    // Create stacks to hold the begin and end indices of subarrays
    begStack = new Stack()
    endStack = new Stack()

    // Push begin and end indices of array to stack
    begStack.push(0)
    endStack.push(values.length - 1)

    // Repeat until stacks are empty
    while(stacks are not empty)
        // Get begin and end indices for the current subarray
        beg = begStack.pop()
        end = endStack.pop()

        // Check if we need to do anything
        if(beg<end)
            // Divide the items into 2 groups
            // Sort the group beg to mid - 1
            begStack.push(beg)
            endStack.push(mid - 1)

            // Sort the group mid + 1 to end
            begStack.push(mid + 1)
            endStack.push(end)    
}
```

## Memoization
If we take a close look at the recursion tree of fibonacci function, we can see that a lot of nodes are duplicate. If we can store the intermediate results, then we don't need to calculate the intermediate results again and just look up them from cache. This technique is memoization.

```
cache = {1,1,0,0,0,...0}

fibonacci(N){
    if(cache[N]==0)
        cache[N] = fibonacci(N-1) + fibonacci(N-2)
    else
        return cache[N]
}
```

### Runtime
- Number of leaf nodes = N
- Number of inner nodes = N-1
- 2*N-1 number of nodes visited
- O(N) runtime
