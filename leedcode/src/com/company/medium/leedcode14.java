package com.company.medium;

/**
 * leedcode14：
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 *
 * @author: yatao.ma
 * @date: 2020/7/6 11:05 上午
 */
public class leedcode14 {
    public static void main(String[] args) {

    }

    /**
     * @description 方法描述
     *   横向扫描
     * @return
     * @author yatao.ma
     * @date 2020/7/7 11:28 上午
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            ans = ans.substring(0, j);
            if (ans.equals("")) {
                return ans;
            }

        }
        return ans;
    }
    /**
     * @description 方法描述
     *  纵向
     * @return
     * @author yatao.ma
     * @date 2020/7/7 11:28 上午
     */
    public static String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        //第一个字符串的长度
        int length = strs[0].length();
        //有几个字符串
        int count = strs.length;
        //不断循环第一个字符串的字符串
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            //循环比较其他字符串的相同位置
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }


}
