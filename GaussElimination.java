import solver.ComplexNumber;
import solver.Matrix;
import rowoperations.RowAddition;
import rowoperations.RowOperatorInvoker;
import rowoperations.RowPermutation;
import rowoperations.RowScaling;

import java.util.ArrayList;
import java.util.List;

public class GaussElimination {
    private Matrix matrix;
    private RowOperatorInvoker invoker;
    private int pivotNumber;
    private List<Integer> freeRows = new ArrayList<>();


    public GaussElimination(Matrix matrix) {
        this.matrix = matrix;
        invoker = new RowOperatorInvoker();
    }

    public void perform() {

        int rows = matrix.getRowNumbers();

        for (int i = 1; i <= rows; i++) {
            Pair<Integer, Integer> pair = this.pivotSearch(i);
            if(pair == null) break;

            ComplexNumber pivot = matrix.getEntry(pair.getFirst(), pair.getSecond());
            pivotNumber++;

            invoker.setRowOperation(new RowPermutation(matrix, pair.getFirst(), i));
            invoker.invokeOperation();

            invoker.setRowOperation(new RowScaling(matrix, i, pivot));
            invoker.invokeOperation();


            for (int j = i + 1; j <= rows; j++) {
                ComplexNumber sf = ComplexNumber.product(ComplexNumber.MINUS_ONE,matrix.getEntry(j,i));

                invoker.setRowOperation(new RowAddition(matrix, i, j,sf));
                invoker.invokeOperation();
            }

        }

    }

    public Pair<Integer, Integer> pivotSearch ( int startingRow){
            Pair<Integer, Integer> pair = new Pair<>();
            for (int i = 1; i <= matrix.getColumnNumbers(); i++) {
                for (int j = startingRow; j <= matrix.getRowNumbers(); j++) {
                    if (!matrix.getEntry(j, i).equals(ComplexNumber.ZERO)) {
                        pair.makePair(j, i);
                        return pair;
                    }
                }
            }
            return null;
    }

    public List searchFreeRow(int row){
        for (Integer i = row; i <= matrix.getRowNumbers(); i++) {
           freeRows.add(i);
            for (int j = 1; j < matrix.getColumnNumbers(); j++) {
                if(!matrix.getEntry(i,j).equals(ComplexNumber.ZERO)) {
                    freeRows.remove(i);
                    break;
                }
            }
        }
        return freeRows;
    }

    int getPivotNumber(){
        return pivotNumber;
    }

}

class Pair<T1,T2>{
    private T1 num1;
    private T2 num2;

    void makePair(T1 num1, T2 num2){
        this.num1 = num1;
        this.num2 = num2;
    }

    T1 getFirst(){
        return num1;
    }

    T2 getSecond(){
        return num2;
    }
}