package rowoperations;

import solver.ComplexNumber;
import solver.Matrix;

public class RowAddition implements RowOperations {

    private Matrix matrix;
    int row1, row2;
    ComplexNumber multiple;

    public RowAddition(Matrix matrix, int row1, int row2, ComplexNumber multiple) {
        this.matrix = matrix;
        this.row1 = row1;
        this.row2 = row2;
        this.multiple = multiple;
    }


    @Override
    public void execute() {
        matrix.rowAddition(row2,row1,multiple);
    }
}
