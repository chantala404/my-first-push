package org.cts.test.login;

public class Hdfc extends Sbi{

	public void current() {
		// TODO Auto-generated method stub
System.out.println("current Account");
	}

	@Override
	public void joint() {
		// TODO Auto-generated method stub
		System.out.println("Joint Account");
	}

	@Override
	public void savings() {
		// TODO Auto-generated method stub
		System.out.println("Savings Account");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hdfc h=new Hdfc();
		h.fixed();
		h.joint();
		h.savings();
		h.current();
	}
}
