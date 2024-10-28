public class MathUtil {

    // Static Methods

    /**
     * Checks whether a given number n is prime.
     * 
     * @param n the number to check
     * @return true if n is prime, otherwise false
     */
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    /**
     * Calculates the greatest common divisor (GCD) of two integers using the Euclidean algorithm.
     * 
     * @param a the first integer
     * @param b the second integer
     * @return the GCD of a and b
     */
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**
     * Computes the least common multiple (LCM) of two numbers.
     * 
     * @param a the first integer
     * @param b the second integer
     * @return the LCM of a and b
     */
    public static int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b);
    }

    /**
     * Returns the nth Fibonacci number.
     * 
     * @param n the index of the Fibonacci number to return
     * @return the nth Fibonacci number
     */
    public static int fibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    /**
     * Calculates the factorial of a number n.
     * 
     * @param n the number to calculate the factorial of
     * @return the factorial of n
     */
    public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Negative numbers don't have factorials.");
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Non-Static Methods

    /**
     * Determines if the given number n is a perfect number.
     * 
     * @param n the number to check
     * @return true if n is a perfect number, otherwise false
     */
    public boolean isPerfectNumber(int n) {
        if (n < 1) return false;
        int sum = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum == n;
    }

    /**
     * Computes the sum of the digits of the given number n.
     * 
     * @param n the number to compute the sum of digits
     * @return the sum of the digits of n
     */
    public int sumOfDigits(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    /**
     * Reverses the digits of a number n.
     * 
     * @param n the number to reverse
     * @return the number formed by reversing the digits of n
     */
    public int reverseNumber(int n) {
        int reversed = 0;
        while (n != 0) {
            reversed = reversed * 10 + n % 10;
            n /= 10;
        }
        return reversed;
    }

    /**
     * Checks if a number is an Armstrong number.
     * 
     * @param n the number to check
     * @return true if n is an Armstrong number, otherwise false
     */
    public boolean isArmstrongNumber(int n) {
        int sum = 0, temp = n, digits = String.valueOf(n).length();
        while (temp != 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, digits);
            temp /= 10;
        }
        return sum == n;
    }

    /**
     * Finds the smallest prime number greater than n.
     * 
     * @param n the number to check from
     * @return the next prime number after n
     */
    public int nextPrime(int n) {
        int next = n + 1;
        while (!isPrime(next)) {
            next++;
        }
        return next;
    }

    public static void main(String[] args) {
        // Testing static methods
        System.out.println("Static Method Tests:");
        System.out.println("Is 7 prime? " + MathUtil.isPrime(7)); // true
        System.out.println("GCD of 48 and 18: " + MathUtil.gcd(48, 18)); // 6
        System.out.println("LCM of 4 and 5: " + MathUtil.lcm(4, 5)); // 20
        System.out.println("Fibonacci of 6: " + MathUtil.fibonacci(6)); // 8
        System.out.println("Factorial of 5: " + MathUtil.factorial(5)); // 120

        // Testing non-static methods
        MathUtil mathUtil = new MathUtil();
        System.out.println("\nNon-Static Method Tests:");
        System.out.println("Is 28 a perfect number? " + mathUtil.isPerfectNumber(28)); // true
        System.out.println("Sum of digits of 12345: " + mathUtil.sumOfDigits(12345)); // 15
        System.out.println("Reversed number of 1234: " + mathUtil.reverseNumber(1234)); // 4321
        System.out.println("Is 153 an Armstrong number? " + mathUtil.isArmstrongNumber(153)); // true
        System.out.println("Next prime after 10: " + mathUtil.nextPrime(10)); // 11
    }
}
