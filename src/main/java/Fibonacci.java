public class Fibonacci {
    private static Integer fibonacci(int n) {
        int fib;
        int num = 0;
        int num2 = 1;
        for (int loop = 1; loop < n; loop++) {
            fib = num + num2;
            num = num2;
            num2 = fib;
        }
        return num;
    }

    public static Integer getFibonacci(int member) {
        return fibonacci(member);

    }
}
