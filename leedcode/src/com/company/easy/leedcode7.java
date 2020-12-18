package com.company.easy;

/**
 * leedcode7：
 *给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2的31次方,  2的31次方 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0
 *
 * @Description 描述
 * @author: yatao.ma
 * @date: 2020/6/29 10:20 上午
 */
public class leedcode7 {
    public static void main(String[] args) {
        System.out.println(reverse(1230));
    }

  /*  public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return (int) res == res ? (int) res : 0;

    }*/
    public static int reverse(int x) {
        String s=String.valueOf(x);
        StringBuilder sb=new StringBuilder();
        if(x>=0){
            for (int i = s.length()-1; i >=0 ; i--) {
             sb.append(s.charAt(i));
            }
        } else{
            for (int i = s.length()-1; i >0 ; i--) {
                sb.append(s.charAt(i));
            }
           sb.insert(0,"-");
        }
        int result=0;
        try {
            result=Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            return  result;
        }

        return  result;
    }
}
