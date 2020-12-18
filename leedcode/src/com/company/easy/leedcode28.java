package com.company.easy;

/**
 * leedcode28：
 *
 * @Description 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * @author: yatao.ma
 * @date: 2020/8/26 10:31 上午
 */
public class leedcode28 {
	public static void main(String[] args) {
		System.out.println(kmpMatch("aaaaa",
				"abaabcac"));
	}

	public static int strStr(String haystack, String needle) {
		if (needle.equals("")) {
			return 0;
		}
		int len = haystack.length();
		int l = needle.length();
		for (int i = 0; i < len - l + 1; i++) {
			;
			if (haystack.substring(i, i + l).equals(needle)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 求出一个字符数组的next数组
	 *
	 * 1.next[0]=-1, next[1]=0。
	 * 2.在求解next[j]时，令k=next[j-1]，
	 * 3.比较T[j-1]与T[k]的值，
	 *   a. 若T[j-1]等于T[k]，则next[j]=k+1。
	 *   b. 若T[j-1]不等于T[k]，令k=next[k]，若k等于-1，则next[j]=0，否则跳至3。
	 *
	 * @param t 字符数组
	 * @return next数组
	 */
	public static int[] getNextArray(char[] t) {
		int[] next = new int[t.length];
		next[0] = -1;
		next[1] = 0;
		int k;
		for (int j = 2; j < t.length; j++) {
			k = next[j - 1];
			while (k != -1) {
				if (t[j - 1] == t[k]) {
					next[j] = k + 1;
					break;
				} else {
					k = next[k];
				}
				//当k==-1而跳出循环时，next[j] = 0，否则next[j]会在break之前被赋值
				next[j] = 0;
			}
		}
		return next;
	}

	/**
	 * 对主串s和模式串t进行KMP模式匹配
	 *
	 * @param s 主串
	 * @param t 模式串
	 * @return 若匹配成功，返回t在s中的位置（第一个相同字符对应的位置），若匹配失败，返回-1
	 */
	public static int kmpMatch(String s, String t) {
		char[] s_arr = s.toCharArray();
		char[] t_arr = t.toCharArray();
		int[] next = getNextArray(t_arr);
		int i = 0, j = 0;
		while (i < s_arr.length && j < t_arr.length) {
			if (j == -1 || s_arr[i] == t_arr[j]) {
				i++;
				j++;
			} else {
				j = next[j];
			}
		}
		if (j == t_arr.length) {
			return i - j;
		} else {
			return -1;
		}
	}

}
