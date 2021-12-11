package practise.backtracking;

import java.util.ArrayList;

/**
 * 返回给定不重复元素数组的所有子集
 *
 * @author wangkangnian
 */
public class SubsetsLeetcode46 {
    static ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {


        int[] nums = {1, 2, 3, 4};
        subsets(nums);
        System.out.println(result);
    }

    public static void subsets(int[] nums) {
        subsets1(nums, 0 , new ArrayList<Integer>());
    }

    /**
     * 回溯法
     * @param nums
     * @param index
     * @param list
     */
    public static void subsets1(int[] nums, int index, ArrayList<Integer> list) {
        result.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            subsets1(nums, i + 1, list);
            list.remove(list.size() - 1);

        }
    }



}
