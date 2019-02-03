# Triangular arrays

If all the elements in a matrix are different it is efficient to store then in a 2-D array. But what if the matrix is symmetric? In that case it is not efficient to store all elements of the matrix. In those cases we use triangular arrays.

e.g- Distance between different cities

| | Chicago | New york | Los Angeles | San Francisco
|--- |--- |--- |--- |---
| Chicago | 0 | 790 | 1745 | 1852
| New york | 790 | 0 | 2776 | 2564
| Los Angeles | 1745 | 2776 | 0 | 381
| San Francisco | 1852 | 2564 | 381 | 0

### How to store a triagular array?
We can store the triangular array in a 1-D array and create a mapping between 2-D array to the corresponding 1-D array.

1. **Calculate the number of elements in the 1-D array.**
0 + 1 + 2 + ... + N-1 = N(N-1)/2

2. **Create a mapping from 2-D array to 1-D storage array**
   - If row < col, switch row and column as we removed them from array.
   - Calculate the offset index after which a given row starts. This is given by 0 + 1 + 2 + .... + (row-1) = ((row-1)*row)/2.
   - Finally the index can be calculated by ((row-1)*row)/2 + col.

### Implementation of triangular array using java
```java
public class TriangularArray {

    private int numRows;
    private String[] values;

    TriangularArray(int numRows) {
        this.numRows = numRows;
        this.values = new String[(numRows * (numRows - 1)) / 2];
    }

    // Map a row and col to a storage array index
    private int mapRowAndColToStorageArrayIndex(int row, int col) {
        if (row < col) {
            // Swap row and col
            int temp;
            temp = row;
            row = col;
            col = temp;
        }
        return (row * (row - 1)) / 2 + col;
    }

    // Set value
    public void setValue(String val, int row, int col) {
        values[this.mapRowAndColToStorageArrayIndex(row, col)] = val;
    }

    // Get value
    public String getValue(int row, int col) {
        return values[this.mapRowAndColToStorageArrayIndex(row, col)];
    }
}
```