public class FibonacciRecursion {
    public static void main(String[] args) {
        int num = 10;

        for (int i = 0; i < num; i++) {
            System.out.print(fib(i) + " ");
        }
    }

    private static int fib(int num) {
        if (num <= 1)
            return num;
        return fib(num - 2) + fib(num - 1);
    }
}
