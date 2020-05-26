package rowoperations;

import solver.Matrix;

public class RowPermutation implements RowOperations {
    private Matrix matrix;
    int row1, row2;

    public RowPermutation(Matrix matrix, int row1, int row2) {
        this.matrix = matrix;
        this.row1 = row1;
        this.row2 = row2;
    }

    @Override
    public void execute() {
        matrix.rowPermutation(row1, row2);
    }
}
