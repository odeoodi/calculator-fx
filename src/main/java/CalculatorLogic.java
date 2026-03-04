
public class CalculatorLogic {

    public static String calculateMessage(String a, String b) {
        double num1 = Double.parseDouble(a);
        double num2 = Double.parseDouble(b);

        double sum = num1 + num2;
        double product = num1 * num2;
        double subtract = num1 - num2;
        double divisor = num1 / num2;

        return "Sum: " + sum + ", Product: " + product + ", Divisor: " + divisor + ", and subtract: " + subtract;
    }
}

