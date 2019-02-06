# Backtracking

Backtracking is an approach of solving problems where the goal is to find the best arrangement of a number of possible options. The general idea is to recursively check each possible option and if a decision is found to be wrong, we backtrack to an earlier solution and try a different solution. Backtracking can be thought of as exploring a tree of possible solutions. Each node in a tree is a partial solution.

e.g.- 
Suppose you have to make an investment
- You can choose from any 4 of possible investments
- Each has an expected profit
- You want to make atleast Rs. 10000000.
- You have limited funds so you cannot make all 4 investments

### General idea for backtracking

```
findSolution(partialSolution){
    if(partial solution is a complete solution)
        return true
    if(partial solution cannot lead to any solution)
        return false

    for each possible extension to partial solution
        build test solution

        if(findSolution(testSolution))
            copy test solution to partial solution
            return true

    return false
}
```