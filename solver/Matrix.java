package solver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Matrix{
    private List<Row> rows;
    private int rowNumbers, columnNumbers;


    public Matrix(int n, int m){
        rowNumbers = n;
        columnNumbers = m;
        rows = new ArrayList<>(rowNumbers);

        for (int i = 0; i < rowNumbers; i++) {
            Row temp = new Row(columnNumbers);
            rows.add(temp);
        }
    }

    public Matrix(ComplexNumber[][] matrix){
        this(matrix.length, matrix[0].length);

        for (int i = 1; i <=rowNumbers ; i++) {
            for (int j = 1; j <=columnNumbers ; j++) {
                rows.get(i-1).add(j,matrix[i-1][j-1]);
            }
        }
    }

    public Row getARow(int row){
        return rows.get(row-1);
    }

    public int getColumnNumbers() {
        return columnNumbers;
    }

    public int getRowNumbers() {
        return rowNumbers;
    }

    public ComplexNumber getEntry(int row, int column){
        return this.getARow(row).getElement(column);
    }

    public void setEntry(int row, int column, ComplexNumber entry){
        this.getARow(row).set(column,entry);
    }

    public void rowScaling(int row, ComplexNumber scaleFactor){
        int rowLength = this.getARow(row).getLength();

        for (int i = 1; i <= rowLength; i++) {
           ComplexNumber entry = this.getEntry(row,i);
           this.setEntry(row,i, ComplexNumber.quotient(entry,scaleFactor));
        }
    }

    public void rowAddition(int row2, int row1, ComplexNumber multiple){

        for (int i = 1; i <= this.columnNumbers; i++) {
            ComplexNumber num1 = this.getEntry(row1,i);
            ComplexNumber num2 = this.getEntry(row2,i);
            ComplexNumber num3
                               = ComplexNumber.sum(ComplexNumber.product(multiple,num1),num2);

            this.setEntry(row2,i,num3);
        }
    }

    public void rowPermutation(int row1, int row2){
        Collections.swap(rows,row1-1,row2-1);
    }



    @Override
    public String toString() {
        return "entities.Matrix{" +
                "rows=" + rows.toString() +
                ", size=" + rowNumbers + "*" + columnNumbers+
                '}';
    }
}
