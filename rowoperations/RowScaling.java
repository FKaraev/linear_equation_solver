package rowoperations;

import solver.ComplexNumber;
import solver.Matrix;

public class RowScaling implements RowOperations {

    private Matrix matrix;
    int row1;
    ComplexNumber scaleFactor;

    public RowScaling(Matrix matrix, int row1, ComplexNumber scaleFactor) {
        this.matrix = matrix;
        this.row1 = row1;
        this.scaleFactor = scaleFactor;
    }


    @Override
    public void execute() {
        matrix.rowScaling(row1,scaleFactor);
    }
}
