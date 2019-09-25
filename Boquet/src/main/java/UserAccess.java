import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import flowers.Jasmine;
import flowers.Lilly;
import flowers.Rose;

public class UserAccess {
	static BufferedReader inputReader=new BufferedReader(new InputStreamReader(System.in));
	static int  totalCostOfFlowers=0;
	public static void main(String[] args) throws NumberFormatException, IOException{
		int userChoice;
		System.out.println("Hey user Selct which flower You want to prepare Your Boquet");
		System.out.println("1.Rose\n2.Jasmine\n3.Lilly\4.Lavender\n5.Exit");
		System.out.println("Enter your option");
		
		do {
			 userChoice=Integer.parseInt(inputReader.readLine());
			 switch(userChoice) {
			 case 1:    totalCostOfFlowers+=new Rose().roseCostCalculation(getFlowerCount("Rose")); break;
			 case 2:    totalCostOfFlowers+=new Jasmine().jasmineCostCalculation(getFlowerCount("Jasmine")); break;
		     case 3:     totalCostOfFlowers+=new Lilly().lillyCostCalculation(getFlowerCount("Lilly")); break;
//			 case 4:    new Rose(getFlowerCount("Lavender")); break;
			 default:  System.out.println("Enter correct input"); break;
			         
			 }
			 System.out.println("Do you want One more combination to prepare Your Boquet \nEnter your option ");
			
		}while(userChoice!=5);

		
		System.out.println("total Cost of Boquet is "+totalCostOfFlowers);

	}
	public static int getFlowerCount(String flower) throws NumberFormatException, IOException {
		int flowerCount;
		System.out.println("Enter how many"+ flower+ " you need");
        flowerCount=Integer.parseInt(inputReader.readLine());
		
        return flowerCount;
	}

}
