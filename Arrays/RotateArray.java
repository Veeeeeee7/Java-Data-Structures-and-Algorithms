package Arrays;

public class RotateArray {
    public static void rotateArray(int arr[], int d) {
        int size = arr.length;
        int gcd = gcd(size, d);

        // makes sure d < size
        d = d % size;

        for (int i = 0; i < gcd; i++) {
            int temp = arr[i];
            int j = i;
            while (true) {
                int k = j + d;
                if (k >= size) {
                    k = k - size;
                }
                if (k == i) {
                    break;
                }
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }

    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
