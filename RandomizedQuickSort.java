// Randomized Quick Sort Implementation in Java
// This implementation of Quick Sort selects a pivot randomly
// to enhance performance on average compared to the standard Quick Sort.
// The time complexity is O(n log n) on average and O(n^2) in the worst case.
// Space complexity is O(log n) due to recursion depth.

import java.util.Random;

public class RandomizedQuickSort {
    // Method to perform randomized quick sort
    public static void randomizedQuickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = randomizedPartition(array, low, high);
            randomizedQuickSort(array, low, pivotIndex - 1);
            randomizedQuickSort(array, pivotIndex + 1, high);
        }
    }

    // Method to partition the array around the pivot
    private static int randomizedPartition(int[] array, int low, int high) {
        Random rand = new Random();
        int pivotIndex = low + rand.nextInt(high - low + 1);
        int pivotValue = array[pivotIndex];

        // Move pivot to the end
        swap(array, pivotIndex, high);
        int storeIndex = low;

        for (int i = low; i < high; i++) {
            if (array[i] < pivotValue) {
                swap(array, storeIndex, i);
                storeIndex++;
            }
        }

        // Move pivot to its final place
        swap(array, storeIndex, high);
        return storeIndex;
    }

    // Swap method to swap two elements in the array
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Main method to test the sorted algorithm
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        randomizedQuickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}