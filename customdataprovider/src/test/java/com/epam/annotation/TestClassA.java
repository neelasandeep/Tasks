package com.epam.annotation;

import java.lang.reflect.Method;

import org.junit.Test;

public class TestClassA {
	
	@Testing(dataprovider="sumData")
	@Test
	public void checking() {
		//Object[][] t=new Dataexchanger().getdata();
		//System.out.println(t[0][1]);
		System.out.println(Dataexchanger.data[0][1]);
	}
	@Testing(dataprovider="smData")
	@Test
	public void checkingg() {
		System.out.println(Dataexchanger.data[0][1]);
	}
	
	 @JavaFileInfo(name = "smData")
	   public static Object[][] smData() 
		{
			return new Object[][] {
				{2, 10 }, 
				{6, -1 }, 
				{-1, -2}, 
				{22, 55}, 
				{-5,  0},
				{1,  4},
				{ -6, 12},
				{-3,  1},
				{3,  12},
				{0,  1}};
		}
	
	 @JavaFileInfo(name = "sumData")
	   public static Object[][] sumData() 
		{
			return new Object[][] {
				{2, 4 }, 
				{6, -1 }, 
				{-1, -2}, 
				{22, 55}, 
				{-5,  0},
				{1,  4},
				{ -6, 12},
				{-3,  1},
				{3,  12},
				{0,  1}};
		}
	   
	
	   
	   
	   
}
//Class<TestClassA> clazz = TestClassA.class;
//Method m = TestClassA.class.getMethod(description.getMethodName());
//System.out.println("a"+m);
//Testing testing = (Testing) m.getAnnotation(Testing.class);
//String dp = testing.dataprovider();