package com.company.easy;


import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 */

public class Leedcode1 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, -2, -3, -4, -5,-6,-7,-8};
        int target = -8;
        twoSum(nums, target);
    }

    public static int[] twoSum(int[] nums, int target) {
   /*     int[] twoSum = new int[2];
        Arrays.sort(nums);
        loop: for (int i = 0; i < nums.length - 1; i++) {
            int num = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (num == nums[j]) {
                    twoSum[0] = i;
                    twoSum[1] = j;
                    break loop;
                }
            }
        }
        return twoSum;*/
        Map <Integer,Integer> result=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            int  m=target-nums[i];
            if(result.containsValue(m)){
                return new int[]{result.get(m),i};
            }
            result.put(i,nums[i]);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");

    }

}
