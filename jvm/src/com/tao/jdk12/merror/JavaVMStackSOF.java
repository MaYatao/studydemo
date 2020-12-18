package com.tao.jdk12.merror;

/**
 * VM Args:-Xss160k
 *
 * 使用-Xss参数减少栈内存容量
 *  线 程 请 求 的 栈 深 度 大 于 虚 拟 机 所 允 许 的 最 大 深 度
 */
public class JavaVMStackSOF {
	private int stackLength = 1;

	public void stackLeak() {
		stackLength++;
		stackLeak();
	}

	public static void main(String[] args) throws Throwable {
		JavaVMStackSOF oom = new JavaVMStackSOF();
		try {
			oom.stackLeak();
		} catch (Throwable e) {
			System.out.println("stack length:" + oom.stackLength);
			throw e;
		}
	}
}
