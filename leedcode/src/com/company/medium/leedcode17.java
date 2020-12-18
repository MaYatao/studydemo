package com.company.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leedcode17：
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序
 *
 * @Description 描述
 * @author: yatao.ma
 * @date: 2020/7/14 10:04 上午
 */
public class leedcode17 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("322"));

    }
    static  Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    static  List<String> output = new ArrayList<String>();

    public static void backtrack(String combination, String next_digits) {
        // 如果字符串为空
        if (next_digits.length() == 0) {
            // 添加原先的字符串
            output.add(combination);
        }

        else {

            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);

                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }

    public static List<String> letterCombinations(String digits) {
        // 如果字符串为空
        if (digits.length() != 0) {
            backtrack("", digits);
        }
        return output;
    }
}
