package xformation_Food;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;


/**
 * 
 * This application enables users to choose different cuisines and after choosing you can have:
 * lunch/drink/lunch with drink
 * 
 * only command line interface with protection of wiriting false data
 * 
 * additional feature - printing order with each ordered meal and sum to pay
 * 
 * @author Micha³ Wojtaszek
 * @version 1.0
 * @since 2017-10-23
 *
 */


public class WhatToEat {
	
	public static int [] choose_main_course(ArrayList<HashSet<ItemFromMenu>> cuisine, Scanner scanner_in_method) {
		//this method returns information about preffered main course and dessert in given cuisine
		
		
		int i=0;
		
		System.out.println("Choose your main course:");
		
		for(ItemFromMenu x : cuisine.get(0)) {
			System.out.println("Press "+(++i)+" to choose - "+x.toString());
		}
		
		String line=scanner_in_method.nextLine();
		int main_course=0;
		
		while(true) {			
			try {
				main_course=Integer.parseInt(line);
				
				while(main_course<1 || main_course>cuisine.get(0).size()) {
					System.out.println("Enter correct integer number, try again.");
					main_course=Integer.parseInt(scanner_in_method.nextLine());
				}
				break;
			}
			catch (Exception E) {
				System.out.println("You must enter an integer number, try again.");
			}
			line=scanner_in_method.nextLine();
		}
		
		// teraz deser
		
		System.out.println("Choose your dessert:");
		i=0;
		for(ItemFromMenu x : cuisine.get(2)) {
			System.out.println("Press "+(++i)+" to choose - "+x.toString());
		}
		
		line=scanner_in_method.nextLine();
		int dessert=0;
		while(true) {			
			try {
				dessert=Integer.parseInt(line);
				
				while(dessert<1 || dessert>cuisine.get(2).size()) {
					System.out.println("Enter correct integer number, try again.");
					dessert=Integer.parseInt(scanner_in_method.nextLine());
				}
				break;
			}
			catch (Exception E) {
				System.out.println("You must enter an integer number, try again.");
			}
			line=scanner_in_method.nextLine();
		}
		
		int tab[]= {main_course, dessert};
		
		return tab;
	}
/************************************************************************************************************/
	
	public static int [] choose_drink(ArrayList<HashSet<ItemFromMenu>> cuisine, Scanner scanner_in_method) {
		//this method return information about chosen drink from given cuisine
		// also asks about glass/lemon
		
		System.out.println("Choose your drink:");
		int i=0, drink=0;
		for(ItemFromMenu x : cuisine.get(1)) {
			System.out.println("Press "+(++i)+" to choose - "+x.toString());
		}
		
		String line=scanner_in_method.nextLine();
			
		while(true) {			
			try {
				drink=Integer.parseInt(line);
				
				while(drink<1 || drink>cuisine.get(1).size()) {
					System.out.println("Enter correct integer number, try again.");
					drink=Integer.parseInt(scanner_in_method.nextLine());
				}
				break;
			}
			catch (Exception E) {
				System.out.println("You must enter an integer number, try again.");
			}
			line=scanner_in_method.nextLine();
		}
		
		System.out.println("Would you like glass or lemon?");
		System.out.println("Press 0 for none");
		System.out.println("Press 1 for glass");
		System.out.println("Press 2 for lemon");
		System.out.println("Press 3 for both");
		
		int gratis=0;
		
		line=scanner_in_method.nextLine();
		
		while(true) {			
			try {
				gratis=Integer.parseInt(line);
				
				while(gratis<0 || gratis>3) {
					System.out.println("Enter correct integer number, try again.");
					gratis=Integer.parseInt(scanner_in_method.nextLine());
				}
				break;
			}
			catch (Exception E) {
				System.out.println("You must enter an integer number, try again.");
			}
			line=scanner_in_method.nextLine();
		}
	
		int tab[]= {drink, gratis};
		
		return tab;
	}
	
/*******************************************************************************************************/
	
	public static void print_order(ArrayList<HashSet<ItemFromMenu>> cuisine, int tab[], int drink[]) {
		
		System.out.println("Your order:");
		Iterator<ItemFromMenu> iter=cuisine.get(0).iterator();
		ItemFromMenu order=new ItemFromMenu();
		float sum=0.0f;
		
		if(tab[0]>0) {
			while(tab[0]>0) {
				order=iter.next();
				tab[0]--;
			}
			System.out.println(order);
			sum+=order.getPrice();
		}
		
		if (tab[1]>0) {
			iter=cuisine.get(2).iterator();
			while(tab[1]>0) {
				order=iter.next();
				tab[1]--;
			}
			System.out.println(order);
			sum+=order.getPrice();
		}
		
		
		if (drink[0]>0) {
			iter=cuisine.get(1).iterator();
			while(drink[0]>0) {
				order=iter.next();
				drink[0]--;
			}
			System.out.println(order);
			sum+=order.getPrice();
		}
		
		switch(drink[1]) {
			case 0:
				break;
			case 1:
				System.out.println("Glass -- gratis");
				break;
			case 2:
				System.out.println("Lemon -- gratis");
				break;
			case 3:
				System.out.println("Glass, lemon -- gratis");
				break;
			default:
				break;
		}
		
		System.out.print("Sum to pay: "+sum+" $");
		
	}
/***********************************************************************************************************/
	
	public static void main(String[] args) {
		
		int tab[]= {0,0};  //variable containing iformation about preffered main course and dessert
		int drink[]= {0,0}; // variable containing iformation about prefferd drink and choice of lemon/glass
		int kuchnia=0; // variable containing information of chosen cuisine
		int meal=0;   // variable containing iformation - to eat or to drink?
		
		
		ArrayList<HashSet<ItemFromMenu>> polishCuisine=new ArrayList<HashSet<ItemFromMenu>>(3);
		for (int i=0; i<3; i++) {
			polishCuisine.add(new HashSet<ItemFromMenu>());
		}
		
		ArrayList<HashSet<ItemFromMenu>> mexicanCuisine=new ArrayList<HashSet<ItemFromMenu>>(3);		
		for (int i=0; i<3; i++) {
			mexicanCuisine.add(new HashSet<ItemFromMenu>());		
		}
		
		ArrayList<HashSet<ItemFromMenu>> italianCuisine=new ArrayList<HashSet<ItemFromMenu>>(3);		
		for (int i=0; i<3; i++) {
			italianCuisine.add(new HashSet<ItemFromMenu>());		
		}
		
		//sets of meals set0, drinks set1, desserts set2, 
				
		polishCuisine.get(0).add(new ItemFromMenu("Schabowy z ziemniakami", 15.0f));
		polishCuisine.get(0).add(new ItemFromMenu("Kurczak z frytkami", 17.0f));
		polishCuisine.get(0).add(new ItemFromMenu("Pierogi z miêsem", 12.0f));
		polishCuisine.get(0).add(new ItemFromMenu("Pierogi ruskie", 12.5f));
		polishCuisine.get(0).add(new ItemFromMenu("Pierogi z serem", 13.0f));
		
		polishCuisine.get(1).add(new ItemFromMenu("Wódka", 14.0f));
		polishCuisine.get(1).add(new ItemFromMenu("Bimber", 8.0f));
		polishCuisine.get(1).add(new ItemFromMenu("Woda gazowana", 4.5f));
		polishCuisine.get(1).add(new ItemFromMenu("Woda niegazowana", 3.5f));
		polishCuisine.get(1).add(new ItemFromMenu("Oran¿ada", 5.5f));
		polishCuisine.get(1).add(new ItemFromMenu("Kompot", 2.5f));
		
		polishCuisine.get(2).add(new ItemFromMenu("Galaretka", 5.0f));
		polishCuisine.get(2).add(new ItemFromMenu("Szarlotka", 7.0f));
		polishCuisine.get(2).add(new ItemFromMenu("Makowiec", 6.5f));
		
	
		mexicanCuisine.get(0).add(new ItemFromMenu("Burrito", 25.0f));
		mexicanCuisine.get(0).add(new ItemFromMenu("Nachos", 7.0f));
		mexicanCuisine.get(0).add(new ItemFromMenu("Paella", 22.0f));
		
		mexicanCuisine.get(1).add(new ItemFromMenu("Tequila", 10.0f));
		mexicanCuisine.get(1).add(new ItemFromMenu("Cerveza", 5.5f));
		mexicanCuisine.get(1).add(new ItemFromMenu("Agua", 8.5f));
		
		mexicanCuisine.get(2).add(new ItemFromMenu("Torrijas", 5.0f));
		mexicanCuisine.get(2).add(new ItemFromMenu("Magdalenas", 7.0f));
		mexicanCuisine.get(2).add(new ItemFromMenu("Ensaimadas", 6.5f));
		
		
		italianCuisine.get(0).add(new ItemFromMenu("Pizza", 25.0f));
		italianCuisine.get(0).add(new ItemFromMenu("Spaghetti", 27.0f));
		italianCuisine.get(0).add(new ItemFromMenu("Lazana", 13.0f));
		
		italianCuisine.get(1).add(new ItemFromMenu("Vino rosso", 12.0f));
		italianCuisine.get(1).add(new ItemFromMenu("Aqua", 8.0f));
		italianCuisine.get(1).add(new ItemFromMenu("S.Pellegrino", 14.5f));
		
		italianCuisine.get(2).add(new ItemFromMenu("Tiramisu", 6.0f));
		italianCuisine.get(2).add(new ItemFromMenu("Pana Cotta", 7.0f));
		italianCuisine.get(2).add(new ItemFromMenu("Cassata", 6.5f));
		
						
		System.out.println("Choose preferred cuisine:");
		
		System.out.println("polish - press 1 \nmexican - press 2 \nitalian - press 3");
		
		Scanner scanner = new Scanner(System.in);
		String line=scanner.nextLine();
		
		
		while(true) {			// getting information about preffered cuisine
			try {
				kuchnia=Integer.parseInt(line);
				
				while(kuchnia<1 || kuchnia>3) {
					System.out.println("Enter correct integer number, try again.");
					kuchnia=Integer.parseInt(scanner.nextLine());
				}
				break;
			}
			catch (Exception E) {
				System.out.println("You must enter an integer number, try again.");
			}
			line=scanner.nextLine();
		}
		
		System.out.println("Choose: \nlunch - press 1\ndrink - press 2\nlunch and drink - press 3");
		
		
		line=scanner.nextLine();
		
		
		while(true) {			//gettin information - eat or drink?
			try {
				meal=Integer.parseInt(line);
				
				while(meal<1 || meal>3) {
					System.out.println("Enter correct integer number, try again.");
					meal=Integer.parseInt(scanner.nextLine());
				}
				break;
			}
			catch (Exception E) {
				System.out.println("You must enter an integer number, try again.");
			}
			line=scanner.nextLine();
		}
		
		
				
		switch(kuchnia) {   //action performed when customer has already chosen both cuisine and eat or drink
			case 1:  //polish cuisine
				
				switch(meal) {
					case 1:							
						tab=choose_main_course(polishCuisine, scanner);									
						break;
											
					case 2:					
						drink=choose_drink(polishCuisine, scanner);						
						break;
						
					case 3:					
						tab=choose_main_course(polishCuisine, scanner);
						drink=choose_drink(polishCuisine, scanner);						
						break;
						
					default:
						break;
				}				
				
				print_order(polishCuisine, tab, drink);	
				
				break;
				
			case 2: //mexican cuisine
				
				switch(meal) {
				case 1:							
					tab=choose_main_course(mexicanCuisine, scanner);									
					break;
										
				case 2:					
					drink=choose_drink(mexicanCuisine, scanner);						
					break;
					
				case 3:					
					tab=choose_main_course(mexicanCuisine, scanner);	
					drink=choose_drink(mexicanCuisine, scanner);						
					break;
					
				default:
					break;
				}				
			
				print_order(mexicanCuisine, tab, drink);	
			
				break;
			case 3:  //italian cuisine
				switch(meal) {
				case 1:							
					tab=choose_main_course(italianCuisine, scanner);									
					break;
										
				case 2:					
					drink=choose_drink(italianCuisine, scanner);						
					break;
					
				case 3:					
					tab=choose_main_course(italianCuisine, scanner);	
					drink=choose_drink(italianCuisine, scanner);						
					break;
					
				default:
					break;
				}				
			
				print_order(italianCuisine, tab, drink);	
			
				break;
			default:
				System.out.println("No kitchen to choose");
				break;
		}
		
		scanner.close();
	}
}
