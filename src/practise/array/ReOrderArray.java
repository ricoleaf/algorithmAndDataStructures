package practise.array;

import java.util.Arrays;

/**
 * @author: wangkangnian
 * @since: v1.0.0
 */
public class ReOrderArray {
    public static void main(String[] args) {

        int[] arr = new int[]{2,4,6,5,7};
        System.out.println(Arrays.toString(reOrderArray(arr)));
    }
    public static int[] reOrderArray (int[] array) {
        // write code here
        int[] arr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                arr[i] = array[i];
            } else {
                int j = i-1;
                int p = i;

                arr[i] = array[i];
                while (arr[p]%2 == 1 && arr[j]%2 == 0 && j >= 0) {
                    int tmp = arr[p];
                    arr[p] = arr[j];
                    arr[j] = tmp;
                    p = j;
                    j = p - 1;
                }
            }
        }
        return arr;
    }
}
