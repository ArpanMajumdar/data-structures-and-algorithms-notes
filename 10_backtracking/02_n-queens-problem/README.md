# N - Queens Problem

## Goal
Place N queens on an N X N chessboard so that none of them can attack any of the others.
![n queen](https://upload.wikimedia.org/wikipedia/commons/1/1f/Eight-queens-animation.gif)

## Possible solutions

### Brute force
Try every possible arrangement of queens.
64 * 63 * 62 * 60 * 59 * 58 * 57 * 56 = 178462987637760
which is more than 1 trillion possibilities for N = 8.

### Backtracking

Backtracking can trim out huge chunks of tree.

**Algorithm 1**
```
findSolution(board[][],numPositioned){
    if(board is illegal)
        return false

    if(numPositioned == N)
        return true
    
    for row = 0 to N
        for col = 0 to N
            // If you find an empty cell, place a queen there
            if(board[row][col] is empty)
                board[row][col] = taken

                if(findSolution(board,numPosition + 1))
                    return true

                // If position is invalid, backtrack
                board[row][col] = not taken // Backtrack

    return false
}
```

One problem with the above algorithm is there are 2 places where it loops over the board - 
1. While checking if board is illegal
2. Normal double for loops

#### Tracking attacks
To solve 1, we can build a numAttacks array where we can store the count of number of queens attacking any given position.

1. Create a `numAttacks` array of the same shape as chessboard.
2. When trying new positions, use only those positions where `numAttacks[row][col] = 0` i.e. 0 queens are attacking that position.
3. When you position a new queen, increment attack counts by 1 for all the squares it can attack.
4. When you remove a queen, decrement attack counts by 1 for all the squares it can attack.
5. This method ensures that board posiition is never illegal.

**Algorithm 2**
```
findSolution(board[][],numAttacks[][], numPositioned){
    if(numPositioned == N)
        return true
    
    for row = 0 to N
        for col = 0 to N
            // If you find an empty cell, place a queen there
            if(board[row][col] is empty and numAttacks[row][col] == 0)
                board[row][col] = taken
                increment attack counts for this position

                if(findSolution(board,numAttacks,numPosition + 1))
                    return true

                // If position is invalid, backtrack
                board[row][col] = not taken // Backtrack
                decrement attack counts for this position

    return false
}
```

The problem with above 2 approaches is the assumption that any queen can go to any position. However, if we check the correct arrangements we can notice that every row and column can have exactly one queen. Instead of thinking about the queens, we can think where in each row a queen should be.

Original approach assumed 64 possible positions for 1st queen, 63 for second and so on resulting in 64 * 63 * 62 * 60 * 59 * 58 * 57 * 56 = 178462987637760 possibilities.

New approach only considers 8 columns for a queen in the first row, 8 in second row and so on resulting in 8 * 8 * 8 * 8 * 8 * 8 * 8 * 8 = 16777216. So the number of possibilities are drastically reduced.

```
findSolution(board[][],numAttacks[][], numPositioned){
    if(numPositioned == N)
        return true
    
    for col = 0 to N
        // If you find an empty cell, place a queen there
        if(board[row][col] is empty and numAttacks[row][col] == 0)
            board[row][col] = taken
            increment attack counts for this position

            if(findSolution(board,numAttacks,numPosition + 1))
                return true

            // If position is invalid, backtrack
            board[row][col] = not taken // Backtrack
            decrement attack counts for this position

    return false
}
```



