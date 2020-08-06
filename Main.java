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
}
