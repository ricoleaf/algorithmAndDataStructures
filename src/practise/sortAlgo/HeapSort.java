package practise.sortAlgo;

import java.util.Arrays;

/**
 *  大/小顶堆
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] input = new int[]{3,1,4,2,5,8};
        heap(input);
        System.out.println(Arrays.toString(input));
    }

    private static void heap(int[] input) {
        int length = input.length;
        if (length == 0) {
            return;
        }
        for (int i = length; i >= 0; i--) {
            adjustHeap(input, i);
        }

    }
    public static void adjustHeap(int[] input, int length) {
        for (int i = length / 2 - 1; i >= 0; i--) {
            if ((2 * i + 1) < length && input[i] < input[2 * i + 1]) {
                swap(input, i, 2 * i + 1);
            }
            if ((2 * i + 2) < length && input[i] < input[2 * i + 2]) {
                swap(input, i, 2 * i + 2);
            }
        }
        swap(input, 0, length - 1);
    }

    public static void swap(int[] input, int i, int j) {
        if (i >= 0 && j >= 0) {
            int tmp = input[i];
            input[i] = input[j];
            input[j] = tmp;
        }
    }
}
