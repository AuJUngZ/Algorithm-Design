import Final.MaxOfPoint;
import Final.QuickSort;
import Final.RandomizeQuickSort;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 8, 7};
        QuickSort.quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        int[] arr2 = {10, 5, 2, 7, 8, 7};
        RandomizeQuickSort.randomizeQuickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
