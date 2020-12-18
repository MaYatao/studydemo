package com.tao.jdk12.merror;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * VM Args:-Xmx20M -XX:MaxDirectMemorySize=10M
 */
public class DirectMemoryOOM {
	private static final int _1MB = 1024 * 1024;

	public static void main(String[] args) throws Exception {
		Field unsafeField = Unsafe.class.getDeclaredFields()[0];
		unsafeField.setAccessible(true);
		Unsafe unsafe = (Unsafe) unsafeField.get(null);
		while (true) {
			unsafe.allocateMemory(_1MB);
		}
	}

	public static class RuntimeConstantPoolOOM {
		public static void main(String[] args) {

			String str1 = new StringBuilder("计算机").append("软件").toString();
			System.out.println(str1.intern() == str1);
			String str2 = new StringBuilder("ja").append("va").toString();
			System.out.println(str2.intern() == str2);

		}
	}
}
