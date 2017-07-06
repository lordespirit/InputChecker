package test;

import org.junit.Test;

import input.Input;

public class TestInput {

	@Test
	public void testInputEmail(){
		
		Input checker = new Input();
		
		checker.scanEmail();
		
	}
}
