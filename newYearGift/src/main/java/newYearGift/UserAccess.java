package newYearGift;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import giftitems.GiftItems;

public class UserAccess {
  static BufferedReader inputReader=new BufferedReader(new InputStreamReader(System.in));
  static ArrayList<GiftItems> gift=new ArrayList<GiftItems>();
  static int totalWeight=0;
 
	public static void main(String[] args) throws NumberFormatException, IOException {
		int choice;
		
		do {System.out.println("Hey User Select the below options to prepare your Gift\n1.Chocaltes\n2.Sweets");
		     choice=Integer.parseInt(inputReader.readLine());
			if(choice==1) {
				int chocalatechoice;
				
				do {
					System.out.println("select the chocalate which you want\n1.Cadbury\n2.Kitkat\n3.Gummies");
					chocalatechoice=Integer.parseInt(inputReader.readLine());
					switch(chocalatechoice) {
					case 1:selectChocalateCost("Chocalate","Cadbury");
					break;
					case 2:selectChocalateCost("Chocalate","Kitkat");
					break;
					case 3:selectChocalateCost("Chocalate","Gummies");
					break;
					
					}
				}while(chocalatechoice!=4);
			}else if(choice==2) {
				int sweetChoice;
				
				do {
					System.out.println("select the sweet which you want\n1.ladoo\n2.gulabJamun\n3.kalakand");
					sweetChoice=Integer.parseInt(inputReader.readLine());
					switch(sweetChoice) {
					case 1:selectSweetCost("sweet","ladoo");
					break;
					case 2:selectSweetCost("sweet","GulabJamn");
					break;
					case 3:selectSweetCost("Sweet","Kalakand");
					break;
					
				}
				
			}while(sweetChoice!=4);
		}
		}while(choice!=3);
		Comparator<GiftItems> compare=new Comparator<GiftItems>() {
			public int compare(GiftItems item1,GiftItems item2) {
				if(item1.getCost()>item2.getCost()&&item1.getWeight()>item2.getWeight())
					return 1;
				else
					return -1;
			}
       };
		Collections.sort(gift,compare);
		System.out.println("Chocalates in the order");
		for(GiftItems g:gift) {
			if(g.getType().equals("Chocalate"))
				System.out.println(g);
			//System.out.println(g.getType()+"  "+g.getChocalate()+" "+g.getCost()+" "+g.getWeight());
		}
		
		System.out.println("Total weight of all gifts"+totalWeight);
		
		
		System.out.println("Candies Which are in the predermined Range");
		for(GiftItems g:gift) {
			if(g.getType().equals("Chocalate")&&g.getCost()>0&&g.getCost()<50&& g.getWeight()>10&& g.getWeight()<=200)
				System.out.println(g);
			
		}
		
		
	}
	public static void selectChocalateCost(String type,String chocalate) throws NumberFormatException, IOException {
		System.out.println("select the cost of chocalate that you want\n1 5Rs\n2. 10Rs\n3. 50Rs");
		
		int cost=Integer.parseInt(inputReader.readLine());
		System.out.println("How Many chocaltes you want");
		int chocalateCount;
		
		if(cost==1) {
			 chocalateCount=Integer.parseInt(inputReader.readLine());
			totalWeight+=chocalateCount;
			gift.add(new GiftItems(type,chocalate,5,10,chocalateCount));
		}else if(cost==2) {
			
			chocalateCount=Integer.parseInt(inputReader.readLine());
			totalWeight+=chocalateCount;
			gift.add(new GiftItems(type,chocalate,10,30,chocalateCount));
		}else if(cost==3) {
			chocalateCount=Integer.parseInt(inputReader.readLine());
			totalWeight+=chocalateCount;
			gift.add(new GiftItems(type,chocalate,50,100,chocalateCount));
		}
		
		
	}
	public static void selectSweetCost(String type,String sweet) throws NumberFormatException, IOException {
		System.out.println("select the cost of sweets that you want\n1 20Rs\n2. 50Rs\n3. 100Rs");
		int cost=Integer.parseInt(inputReader.readLine());
		System.out.println("How Many Sweets you want");
		int sweetCount;
		if(cost==1) {
			sweetCount=Integer.parseInt(inputReader.readLine());
			totalWeight+=sweetCount;
			gift.add(new GiftItems(type,sweet,20,100,sweetCount));
		}else if(cost==2) {
			sweetCount=Integer.parseInt(inputReader.readLine());
			totalWeight+=sweetCount;
			gift.add(new GiftItems(type,sweet,50,200,sweetCount));
		}else if(cost==3) {
			sweetCount=Integer.parseInt(inputReader.readLine());
			totalWeight+=sweetCount;
			gift.add(new GiftItems(type,sweet,100,500,sweetCount));
		}
		
		
	}
	

}
