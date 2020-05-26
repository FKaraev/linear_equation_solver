import solver.ComplexNumber;
import solver.Matrix;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        String inputFile = "src/in.txt";
        String outputFile = "src/out.txt";

        Matrix matrix = ParseInput.parsingInput(inputFile);

        System.out.println(matrix);

        LinearEquationSolver solver = new LinearEquationSolver(matrix);
        solver.solve();
        System.out.println(matrix);
        writeToFile(solver.getSolutions(), outputFile);

        
    }


    public static void writeToFile(String solution, String out){
        File file = new File(out);
        try {
            FileWriter writer = new FileWriter(file);

            writer.write(solution);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    static  void demo(){

        ComplexNumber [][] A;
        ComplexNumber number1 = new ComplexNumber(1,1);
        ComplexNumber number2 = ComplexNumber.ONE;
        ComplexNumber number3 = new ComplexNumber(3,0);
        ComplexNumber number5 = ComplexNumber.ONE;
        ComplexNumber number4 = ComplexNumber.ZERO;
        ComplexNumber number6 = new ComplexNumber(4,0);

        A = new ComplexNumber[][]{{number1,number2,number3},{number4,number5,number6}};

        Matrix matrix = new Matrix(A);

        LinearEquationSolver solver = new LinearEquationSolver(matrix);
        solver.solve();

        //System.out.println(solver.getSolutions());
        System.out.println(matrix);


    }

}
