import solver.ComplexNumber;
import solver.Matrix;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParseInput {

    private static String readFromFile(String pathToFile) throws FileNotFoundException {

        StringBuilder result= new StringBuilder();

        File file = new File(pathToFile);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()){
            result.append(scanner.nextLine()).append(" ");
        }

        return result.toString();

    }
    public static Matrix parsingInput(String input) throws FileNotFoundException {
        String s = readFromFile(input);

        List<ComplexNumber> list = new ArrayList<>();
        String[] num = s.split(" ");

        int columns = Integer.parseInt(num[0]) + 1;
        int rows = Integer.parseInt(num[1]);

        for (int i = 2; i < num.length ; i++) {
            list.add(ComplexNumber.parseToComplexNumber(num[i]));
        }


        ComplexNumber [] B = list.toArray(new ComplexNumber[0])  ;

        int k = 0;

        ComplexNumber [][] A = new ComplexNumber[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                A[i][j] = B[k];
                k++;
            }
        }

        return new Matrix(A);
    }

}
