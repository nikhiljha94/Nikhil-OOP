import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // This program implements the linear search algorithm
    public static int linearSearch(int[] arr, int target) {

        // Loop through each element in the array
        // The loop variable i represents the index of the current element
        for (int i = 0; i < arr.length; i++) {

            // If the target is found, return the index
            if (arr[i] == target) {
                return i;
            }
        }
        // If the target is not found, return -1
        return -1;
    }

    // This program implements the Binary search algorithm
    public static int binarySearch(int[] arr, int target) {

        // Initialize the left and right pointers to the first and last indices of the array
        int left = 0;
        int right = arr.length - 1;

        // Continue searching as long as the left pointer is less than or equal to the right pointer
        while (left <= right) {

            // Calculate the middle index to divide the array
            // Using (left + right) / 2 can cause overflow, so use left + (right - left) / 2
            int mid = left + (right - left) / 2;

            // Check if the target is at the middle
            // If the target is at the middle, return the middle index
            if (arr[mid] == target) {
                return mid;
            }

            // If the target is greater, ignore the left half
            if (arr[mid] < target) {
                left = mid + 1;
            }
            // If the target is smaller, ignore the right half
            else {
                right = mid - 1;
            }
        }

        // If the target is not present in the array
        return -1;
    }

    public static void main(String[] args) {
        // Step 1: Declare and initialize an array of integers
        int[] scores = {45, 78, 22, 89, 91, 60, 56, 88, 77, 72};

        // Step 2: Print the original array
        System.out.println("Original Array: " + Arrays.toString(scores));

        // Step 3: Sort the array in ascending order
        Arrays.sort(scores);
        System.out.println("Sorted Array: " + Arrays.toString(scores));

        // Step 4: Get input from the user for the score to search
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a score to search for: ");
        int yourScore = scanner.nextInt();

        // Step 5: Perform linear search
        int linearSearchResult = linearSearch(scores, yourScore);
        if (linearSearchResult != -1) {
            System.out.println("Linear Search: Score " + yourScore + " found at index " + linearSearchResult);
        } else {
            System.out.println("Linear Search: Score " + yourScore + " not found.");
        }

        // Step 6: Perform Binary search
        int BinarySearchResult = binarySearch(scores, yourScore);
        if (BinarySearchResult != -1) {
            System.out.println("Binary Search: Score " + yourScore + " found at index " + BinarySearchResult);
        } else {
            System.out.println("Binary Search: Score " + yourScore + " not found.");
        }
    }
}