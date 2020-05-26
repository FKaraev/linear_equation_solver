package solver;

import java.util.ArrayList;

import java.util.List;

public class Row {

    private List<ComplexNumber> row;

    public Row(int length){
        row = new ArrayList<>(length);
    }


    public Row(){
        row = new ArrayList<>(5);
    }

    public List<ComplexNumber> getRow() {
        return row;
    }

    public int getLength() {
        return row.size();
    }

    public ComplexNumber getElement(int index){
        return row.get(index-1);
    }

    public void add(int column, ComplexNumber data){
        row.add(column-1,data);
    }

    public void set(int index, ComplexNumber data){
        row.set(index-1,data);
    }

    @Override
    public String toString() {
        return row.toString();
    }
}
