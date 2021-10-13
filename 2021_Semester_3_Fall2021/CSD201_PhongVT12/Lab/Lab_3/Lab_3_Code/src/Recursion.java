public class Recursion {

    public static int sum(int n) throws Exception {
        if (n < 1) {
            System.out.println("Input value must be postive");
        } else if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);
    }

    public static int findmin(int a[], int n) {
        if (n == 1) {
            return a[n - 1];
        }
        return Math.min(a[n - 1], findmin(a, n - 1));
    }

    public static int findsum(int a[], int n) {
        if (n == 1) {
            return a[n - 1];
        }
        return a[n - 1] + findsum(a, n - 1);
    }

    public static int ispalindrome(char a[], int n) {
        if (a.length == 1) {
            return 1;
        } else if (n < a.length / 2) {
            return 1;
        } else {
            if (a[a.length - n] == a[n - 1]) {
                return ispalindrome(a, n - 1);
            } else {
                return 0;
            }
        }
    }

    public static boolean binarysearch(int a[], int left, int right, int target) {
        if (left > right) {
            return false;
        }


        // Get middile value of the list
        int mid = (left + right) / 2;
        if (a[mid] == target) {
            return true;
        } else if (a[mid] < target) { // Move the left to position mid+1
            return binarysearch(a, mid + 1, right, target);
        } else if (a[mid] > target) { // Move the right to position mid-1
            return binarysearch(a, left, mid - 1, target);
        }
        return false;
    }

    public static int GCD(int a, int b) throws Exception {
        if (a >= 0 && b >= 0) {
            if (b == 0)
                return a;
            return GCD(b, a % b);
        } else {
            throw new Exception("Value must be non-negative");
        }
    }

    public static long power(int x, int n) throws Exception {
        if (n >= 0) {
            if (n == 0) {
                return 1;
            } else {
                return x * power(x, n - 1);
            }
        } else {
            throw new Exception("Value [n] must be non-negative");
        }

    }

    public static long fact(int x) throws Exception {
        if (x >= 0) {
            if (x == 0)
                return 1;
            else
                return x * fact(x - 1);
        } else {
            throw new Exception("Value [x] must be non-negative");
        }
    }

    public static long fib(int x) throws Exception {
        if (x >= 1) {
            if (x <= 2)
                return 1;
            else
                return fib(x - 1) + fib(x - 2);
        } else {
            throw new Exception("Value [x] >= 1");
        }
    }

    public static double addReciprocal(int n) throws Exception {
        if (n >= 1) {
            if (n == 1)
                return 1.0;
            else
                return 1.0 / n + addReciprocal(n - 1);
        } else {
            throw new Exception("Value [n] >= 1");
        }
    }

}
