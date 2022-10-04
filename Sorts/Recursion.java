public class Recursion {
    public static void main(String[] args) {
        System.out.println(recursiveFactorial(5));
        System.out.println(iterativeFactorial(5));
    }

    // recursive factorial
    // each time going through, the number is multiplied by the number - 1 until the number is 0
    public static int recursiveFactorial(int num) {
        if (num == 0) {
            return 1;
        }
        return num * recursiveFactorial(num-1);
    }

    // iterative factorial
    // uses a for loop to multiply the number by the number - 1 until the number is 0
    public static int iterativeFactorial(int num) {
        if (num == 0) {
            return 1;
        }

        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
