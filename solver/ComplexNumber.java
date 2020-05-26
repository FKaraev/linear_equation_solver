package solver;

public class ComplexNumber {

    private double real;
    private double imaginary;

    public static final ComplexNumber ONE = new ComplexNumber(1,0);
    public static final ComplexNumber MINUS_ONE = new ComplexNumber(-1,0);
    public static final ComplexNumber ZERO = new ComplexNumber(0,0);

    public ComplexNumber(double real, double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }


    public static ComplexNumber difference(ComplexNumber num1, ComplexNumber num2){
        double real = num1.real - num2.real;
        double img = num1.imaginary - num2.imaginary;
        return new ComplexNumber(real,img);
    }

    public static ComplexNumber sum(ComplexNumber num1, ComplexNumber num2){
        double real = num1.real + num2.real;
        double img = num1.imaginary + num2.imaginary;
        return new ComplexNumber(real,img);
    }

    public static ComplexNumber product(ComplexNumber num1, ComplexNumber num2){
        double real = (num1.real * num2.real) - (num1.imaginary * num2.imaginary) ;
        double img = (num1.imaginary * num2.real) + (num1.real * num2.imaginary);
        return new ComplexNumber(real,img);
    }

    public static ComplexNumber quotient(ComplexNumber num1, ComplexNumber num2){
        double real = product(num1,conjugate(num2)).real / magnitude(num2);
        double img = product(num1,conjugate(num2)).imaginary / magnitude(num2);

        return new ComplexNumber(real,img);
    }

    public static ComplexNumber conjugate(ComplexNumber number){
        return new ComplexNumber(number.real, -number.imaginary);
    }

    public static double magnitude(ComplexNumber number){
        return Math.pow(number.real,2) + Math.pow(number.imaginary,2);
    }

    public boolean equals(ComplexNumber number){
        if(this.real == number.real &&
                this.imaginary == number.imaginary){
            return true;
        }

        else{
            return false;
        }
    }

    public static ComplexNumber parseToComplexNumber(String string){

        double real = 0;
        double img;

        if(!string.contains("i")){
            return new ComplexNumber(Double.parseDouble(string),0);
        }

        else {
            if(string.contains("+")){

                String[] parts = string.split("\\+");
                real = Double.parseDouble(parts[0]);
                img = parts[1].charAt(0) == 'i'? 1:Double.parseDouble(parts[1].substring(0,parts[1].length()-1));

                return new ComplexNumber(real,img);
            }

            else if(string.contains("-")){
                if(string.lastIndexOf('-') == 0) {
                    real = 0;
                    img = "-i".equals(string)? -1:Double.parseDouble(string.substring(0,string.length()-1));

                    return new ComplexNumber(0,img);
                }
                 real = Double.parseDouble(string.substring(0,string.lastIndexOf('-')));
                 img = "-i".equals(string)? -1:Double.parseDouble(string.substring(string.lastIndexOf('-'),string.length()-1));

                return new ComplexNumber(real,img);
            }

            else{
                img = "i".equals(string)? 1:Double.parseDouble(string.substring(string.lastIndexOf('-'),string.length()-1));

            }
        }

        return new ComplexNumber(real,img);
    }


    @Override
    public String toString() {

        if (imaginary != 0) {

            if(real == 0){

                if(imaginary == 1){
                    return String.format("+i", real);
                }
                else if(imaginary == -1){
                    return String.format("-i", real);
                }
            }

            if(imaginary == 1){
                return String.format("%f+i", real);
            }
            else if(imaginary == -1){
                return String.format("%f-i", real);
            }

            return imaginary > 0 ? String.format("%f+%f%s", real, imaginary, "i") : String.format("%f%f%s", real, imaginary, "i");
        }
        else {

            return String.format("%f",real);
        }

    }
}
