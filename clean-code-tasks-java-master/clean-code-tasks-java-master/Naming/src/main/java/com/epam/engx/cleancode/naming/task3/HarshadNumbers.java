package com.epam.engx.cleancode.naming.task3;

public class HarshadNumbers {

	
	public static void main(String[] args) {
		long limit = 1000; 
		for (int count = 1; count <= limit; count++) {
			if (count % loop(count) == 0) {
				System.out.println(count);
			}
		}
	}

	private static int loop(int harshNumber) {
		int sequence = 0;
		while (harshNumber != 0) {
            sequence += harshNumber % 10;
            harshNumber = harshNumber / 10;
        }
		return sequence;
	}

}
