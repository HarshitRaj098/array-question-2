import java.util.ArrayList;
import java.util.Collections;

public class RotateArray {

    // Function to rotate the array by k positions to the right
    public static void rotateArray(ArrayList<Integer> arr, int k) {
        int n = arr.size();
        k = k % n; // In case k is larger than the array size

        // If k is 0 or the array has only one element, no rotation needed
        if (k == 0 || n == 1) {
            return;
        }

        // Step 1: Reverse the entire array
        Collections.reverse(arr);

        // Step 2: Reverse the first k elements
        ArrayList<Integer> firstPart = new ArrayList<>(arr.subList(0, k));
        Collections.reverse(firstPart);

        // Step 3: Reverse the remaining n-k elements
        ArrayList<Integer> secondPart = new ArrayList<>(arr.subList(k, n));
        Collections.reverse(secondPart);

        // Step 4: Merge the reversed parts back into the original array
        arr.clear();
        arr.addAll(firstPart);
        arr.addAll(secondPart);
    }

    // Main method to test the rotation
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        Collections.addAll(arr, 1, 2, 3, 4, 5, 6);

        System.out.println("Original Array: " + arr);

        int k = 2; // Rotate the array by 2 steps to the right
        rotateArray(arr, k);

        System.out.println("Array after " + k + " rotations: " + arr);
    }
}
