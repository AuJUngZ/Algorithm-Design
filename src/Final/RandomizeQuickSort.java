package Final;

public class RandomizeQuickSort {

    public static void randomizeQuickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = randomizePartition(arr, left, right);
            randomizeQuickSort(arr, left, pivot - 1);
            randomizeQuickSort(arr, pivot + 1, right);
        }
    }

    public static int randomizePartition(int[] arr, int left, int right) {
        int i = (int) (Math.random() * (right - left + 1)) + left; //random pivot from left to right
        swap(arr, i, right);
        return partition(arr, left, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int x = arr[right]; //pivot
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] <= x) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
