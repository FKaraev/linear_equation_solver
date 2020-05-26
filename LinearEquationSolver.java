import solver.ComplexNumber;
import solver.Matrix;
import solver.Row;

import java.util.List;

public class LinearEquationSolver {

    private Matrix matrix;
    private Row solutions;
    private GaussElimination gaussEliminator;
    private Solution solution;

    public LinearEquationSolver(Matrix matrix){
        this.matrix = matrix;
        gaussEliminator = new GaussElimination(matrix);
        solutions = new Row(matrix.getColumnNumbers()-1);
    }

    public void solve(){

        gaussEliminator.perform();

        List<Integer> freeRows = gaussEliminator.searchFreeRow(gaussEliminator.getPivotNumber());

        if(freeRows.size() != 0){
            for (Integer freeRow : freeRows) {
                if (!matrix.getEntry(freeRow, matrix.getColumnNumbers()).equals(ComplexNumber.ZERO)) {
                    solution = Solution.NONE;
                    System.out.println("No solutions");
                    return;
                }
            }
        }

        if(gaussEliminator.getPivotNumber() == matrix.getColumnNumbers()-1) {
            solution = Solution.ONE;
            JordanElimination jordanEliminator = new JordanElimination(matrix);
            jordanEliminator.perform();

            for (int i = 1; i < matrix.getColumnNumbers(); i++) {
               solutions.add(i, matrix.getEntry(i,matrix.getColumnNumbers()));
            }

            System.out.println(getSolutions());
        }

        else {
            solution = Solution.MANY;
            System.out.println("Infinitely many solutions");
        }


    }



    public String getSolutions(){
        StringBuilder  builder = new StringBuilder();
        if(solution != Solution.ONE){
         return solution.solution;
        }

        for (int i = 1; i <= solutions.getLength() ; i++) {
            builder.append(solutions.getElement(i)).append("\n");
        }
        return builder.toString();
    }
}
