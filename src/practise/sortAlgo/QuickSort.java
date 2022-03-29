package practise.sortAlgo;

import java.util.Arrays;

/**
 * @author: wangkangnian
 * @since: v1.0.0
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1,1};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        for (int j = arr.length ; j >= 0; j--) {

            adjustHeap(arr, j);

        }

    }

    public static void adjustHeap(int[] arr, int length) {
        for (int k = arr.length/2 - 1; k >=0; k--) {
            if (2*k+1 < length && arr[2*k + 1] > arr[k]) {
                swap(arr, k, 2*k+1);
            }
            if (2*k+2 < length && arr[2*k + 2] > arr[k]) {
                swap(arr, k, 2*k+2);
            }
        }
        swap(arr, 0, length - 1);
    }

    private static void sort(int[] arr, int left, int right) {
        if (right > left) {
            int index = getIndex(arr, left, right);
            sort(arr, left, index - 1);
            sort(arr, index + 1, right);
        }
    }

    private static int getIndex(int[] arr, int l, int r) {
        int mid = l + (r - l) / 2;
        int val = arr[mid];
        while (l < r) {
            while (l < r && arr[r] >= val) {
                r--;
            }
            while (l < r && arr[l] < val) {
                l++;
            }
            if (l != r) {
                swap(arr, l, r);
            }
        }
        return l;
    }

    private static void swap(int[] arr, int l, int r) {
        if (l <0 || r < 0) {
            return;
        }
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }


}
