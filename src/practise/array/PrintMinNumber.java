package practise.array;


import java.util.Arrays;

/**
 *  JZ37 把数组排成最小的数
 *  332
 *  323
 */
public class PrintMinNumber {

    public static void main(String[] args) {

        System.out.println(printMin(new int[]{3,32,321}));
    }

    public static String printMin(int[] numbers) {
        String[] input = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            input[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(input, (o1, o2) -> {
            String s1 = o1 + o2;
            String s2 = o2 + o1;
            return s1.compareTo(s2);
        });
        StringBuilder sb = new StringBuilder();
        Arrays.stream(input).forEach(sb::append);
        return sb.toString();
    }
}
