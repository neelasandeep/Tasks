package com.epam.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

import org.junit.runner.JUnitCore;
 
public class ProcessAnnotationExample
{
   public static void main(String[] args) throws NoSuchMethodException, SecurityException
   { 
	   JUnitCore runner = new JUnitCore();
   runner.addListener(new Listeners());
   runner.run(TestClassA.class);
  
   }
}
