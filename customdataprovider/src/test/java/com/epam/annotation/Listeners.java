package com.epam.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.junit.runner.Description;
import org.junit.runner.notification.RunListener;

public class Listeners extends RunListener {
	String msg1 = "";
	String msg = "";

	@Override
	public void testStarted(Description description) throws java.lang.Exception {
		try {

			
			Method m5 = TestClassA.class.getMethod(description.getMethodName());
			msg = m5.getAnnotation(Testing.class).dataprovider();
			Class<?> clazz = TestClassA.class;
			Method[] m = clazz.getDeclaredMethods();
			
			for (Method m1 : m) {

				if (m1.isAnnotationPresent(JavaFileInfo.class)) {

					JavaFileInfo ta = m1.getAnnotation(JavaFileInfo.class);

					msg1 = ta.name();

					if (msg1.equals(msg)) {
						Dataexchanger.data=(Object[][]) m1.invoke(new TestClassA());
						//new Dataexchanger().dataSetting((Object[][]) m1.invoke(new TestClassA()));
						// new TestClassA().checking(d[0][1]);
						

					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
