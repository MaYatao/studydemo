package com.company.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leedcode16：
 * <p>
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
 * 使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *  
 * 提示：
 * <p>
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 *
 * @Description 描述
 * @author: yatao.ma
 * @date: 2020/7/13 9:41 上午
 */
public class leedcode16 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2};
        System.out.println(threeSumClosest(nums, 0));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        //前三个数作为第一个组合
        int ans = nums[0] + nums[1] + nums[2];

        for(int i=0;i<nums.length;i++) {
            //双指针，第二个，最后一个
            int start = i+1, end = nums.length - 1;
            while(start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if(Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                //如果排列的数字比target大，就把后一个指针往前移动一位
                if(sum > target) {
                    end--;
                    //如果排列的数字比target小，就把前一个指针往后移动一位
                } else if(sum < target) {
                    start++;
                } else {
                    return ans;
                }
            }
        }
        return ans;

    }
}
