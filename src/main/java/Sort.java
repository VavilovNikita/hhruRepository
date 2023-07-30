package main.java;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 4, 6, 1, 3, 2, 6};
        Sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void Sort(int[] arr, int low, int high) {
        if (low < high) {
            int middle = ((low + high) / 2);
            Sort(arr, low, middle);
            Sort(arr, middle + 1, high);
            Merge(arr, low, middle, high);
        }


    }

    public static void Merge(int[] arr, int low, int middle, int high) {
        int leftLength = middle - low + 1;
        int rightLength = high - middle;

        int[] left = Arrays.copyOfRange(arr, low, middle+1);
        int[] right = Arrays.copyOfRange(arr, middle+1, high+1);


        int leftIndex = 0;
        int rightIndex = 0;
        int arrIndex = low;

        while (leftIndex < leftLength && rightIndex < rightLength) {
            if (left[leftIndex] <= right[rightIndex]) {
                arr[arrIndex] = left[leftIndex];
                leftIndex++;
            } else {
                arr[arrIndex] = right[rightIndex];
                rightIndex++;
            }
            arrIndex++;
        }

        while (leftIndex < leftLength) {
            arr[arrIndex] = left[leftIndex];
            leftIndex++;
            arrIndex++;
        }
        while (rightIndex < rightLength) {
            arr[arrIndex] = right[rightIndex];
            rightIndex++;
            arrIndex++;
        }
    }
}


