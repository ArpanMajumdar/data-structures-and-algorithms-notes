
public class TriangularArray {

    private int numRows;
    private String[] values;

    TriangularArray(int numRows) {
        this.numRows = numRows;
        this.values = new String[(numRows * (numRows - 1)) / 2];
    }

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

    public void setValue(String val, int row, int col) {
        values[this.mapRowAndColToStorageArrayIndex(row, col)] = val;
    }

    public String getValue(int row, int col) {
        return values[this.mapRowAndColToStorageArrayIndex(row, col)];
    }
}