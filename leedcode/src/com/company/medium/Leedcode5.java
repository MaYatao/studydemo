package com.company.medium;

/**
 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 示例 1：
 输入: "babad"
 输出: "bab"
 注意: "aba" 也是一个有效答案。
 示例 2：

 输入: "cbbd"
 输出: "bb"

 */
public class Leedcode5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));

    }
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        String res = s.substring(0, 1);
        // 中心位置枚举到 len - 2 即可
        for (int i = 0; i < len - 1; i++) {
            String oddStr = centerSpread(s, i, i);
            String evenStr = centerSpread(s, i, i + 1);
            String maxLenStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
            if (maxLenStr.length() > maxLen) {
                maxLen = maxLenStr.length();
                res = maxLenStr;
            }
        }
        return res;
    }

    private static String centerSpread(String s, int left, int right) {
        // left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
        // right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数
        int len = s.length();
        int i = left;
        int j = right;
        while (i >= 0 && j < len) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        // 这里要小心，跳出 while 循环时，恰好满足 s.charAt(i) != s.charAt(j)，因此不能取 i，不能取 j
        return s.substring(i + 1, j);
    }


    /*   动态规划
    public static String longestPalindrome(String s) {
        if(s.length()<2){
            return  s;
        }
        int  maxLen=1;
        int  begin=0;
        int len=s.length();
        boolean [][] dp=new boolean[len][len];
        for (int i = 0; i <len ; i++) {
            dp[i][i]=true;
        }
        char[] chars=s.toCharArray();
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <i ; j++) {
        *//*      if(s.charAt(i)!=s.charAt(j)){
                  dp[i][j]=false;
              }else  {
                  if(i-j<3){
                      dp[i][j]=true;
                  }else{
                      dp[i][j]=dp[i-1][j+1];
                  }
              }*//*
                dp[i][j]=chars[i]==chars[j]  &&(i-j<3  ||dp[i-1][j+1]);
                if (dp[i][j] && i - j + 1 > maxLen) {
                    maxLen = i - j + 1;
                    begin = j;
                }
            }
        }
        return   s.substring(begin,begin+maxLen);
    }*/
   /*   暴力破
   public static String longestPalindrome(String s) {
     if(s.length()<2){
         return  s;
     }
     int  maxLen=1;
     int  begin=0;
        for (int i = 0; i <s.length()-1 ; i++) {
            for (int j = i+1; j <s.length() ; j++) {
                if(j-i+1 > maxLen  && isPlaindrome(s,i,j)){
                    maxLen =j-i+1;
                    begin=i;
                }
            }
        }
        return   s.substring(begin,begin+maxLen);
    }

    public  static boolean  isPlaindrome (String s, int i,int j){
         while(j>i){
             if(s.charAt(i)!=s.charAt(j)){
                 return  false;
             }
             i++;
             j--;
         }
        return  true;
    }*/
}
