package com.company.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * leedcode20：
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 *
 * @Description 描述
 * @author: yatao.ma
 * @date: 2020/7/17 3:52 下午
 */
public class leedcode20 {

    public static void main(String[] args) {
        System.out.println(isValid("]"));
    }


    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if ( s.charAt(i) == '(') {
                stack.push(')');
            } else if ( s.charAt(i) == '[') {
                stack.push(']');
            } else if ( s.charAt(i) == '{') {
                stack.push('}');
            } else if (stack.isEmpty() ||  s.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();

     /*   Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (!stack.isEmpty() && stack.size() > s.length() / 2) {
                    char min = stack.pop();
                    if (map.get(min) != s.charAt(i)) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        } else {
            return true;
        }*/
    }
}
