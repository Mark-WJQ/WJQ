package com.wjq.jvm;

/**
 * 字段不参与多态
 *
 * @author wangjianqiang24
 * @date 2021/1/18
 */
public class FieldHasNoPolymorphic {

	static class Father{

		public int money = 1;


		public Father() {
			this.money = 2;
			someMethod();
		}

		public void someMethod(){
			System.out.println("I'm father,the money is " + money);
		}

	}

	static class Son extends Father{
		public int money = 2;

		public Son() {
			this.money = 4;
			someMethod();
		}

		/**
		 * 动态绑定，根据实际类型调用
		 */
		@Override
		public void someMethod() {

			System.out.println("I'm son,the money is " + money);
		}
	}

	public static void main(String[] args) {
		Father f = new Son();
		System.out.println(f.money);
	}

}
