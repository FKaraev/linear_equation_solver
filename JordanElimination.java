import solver.ComplexNumber;
import solver.Matrix;
import rowoperations.RowAddition;
import rowoperations.RowOperatorInvoker;

public class JordanElimination {
    private Matrix matrix;
    private RowOperatorInvoker invoker;
    private int pivotNumber;
    private GaussElimination gaussEliminator;

    public JordanElimination(Matrix matrix) {
        this.matrix = matrix;
        invoker = new RowOperatorInvoker();
    }

    public Matrix perform(){
        int rows = matrix.getColumnNumbers()-1;

        for (int i = rows; i > 0; i--) {

            for (int j = i - 1; j > 0; j--) {
                ComplexNumber sf = ComplexNumber.product(ComplexNumber.MINUS_ONE,matrix.getEntry(j,i));

                invoker.setRowOperation(new RowAddition(matrix, i, j,sf));
                invoker.invokeOperation();
            }
        }

        return matrix;
    }


}
