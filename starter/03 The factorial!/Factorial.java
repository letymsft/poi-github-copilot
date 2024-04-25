//I need a java function for factorial
//Copilot response: Here is a non-public function in Java that calculates the factorial of a number:

public class Factorial {
    public static void main(String[] args) {
        long result = factorial(5);
        System.out.println("The factorial of 5 is: " + result);
    }

    public static long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}