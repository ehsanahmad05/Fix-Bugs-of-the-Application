package com.SimpleLearn;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		/*System.out.println("Hello World!");*/
		System.out.println("\n**************************************\n");
		System.out.println("\tWelcome to TheDesk \n");
		System.out.println("**************************************");
		optionsSelection();

	}
	private static void optionsSelection() {
		String[] arr = {"1. I wish to review my expenditure",
				"2. I wish to add my expenditure",
				"3. I wish to delete my expenditure",
				"4. I wish to sort the expenditures",
				"5. I wish to search for a particular expenditure",
				"6. Close the application"
		};
		int[] arr1 = {1,2,3,4,5,6};
		int  slen = arr1.length;
		for(int i=0; i<slen;i++){
			System.out.println(arr[i]);
			// display the all the Strings mentioned in the String array
		}
		ArrayList<Integer> arrlist = new ArrayList<Integer>();
		ArrayList<Integer> expenses = new ArrayList<Integer>();
		expenses.add(1000);
		expenses.add(2300);
		expenses.add(45000);
		expenses.add(32000);
		expenses.add(110);
		expenses.addAll(arrlist);

		System.out.println("\nEnter your choice:\t");
		Scanner sc = new Scanner(System.in);
		int  options =  sc.nextInt();
		for(int j=1;j<=slen;j++){
			if(options==j){
				switch (options){
				case 1:
					System.out.println("Your saved expenses are listed below: \n");
					System.out.println(expenses+"\n");
					optionsSelection();
					break;
				case 2:
					System.out.println("Enter the value to add your Expense: \n");
					int value = sc.nextInt();
					arrlist.add(value);
					System.out.println("Your value is updated\n");
					expenses.addAll(arrlist);
					System.out.println(expenses+"\n");
					optionsSelection();

					break;
				case 3:
					System.out.println("You are about the delete all your expenses! \nConfirm again by selecting the same option...\n");
					int con_choice = sc.nextInt();
					if(con_choice==options){
						expenses.clear();
						System.out.println(expenses+"\n");
						System.out.println("All your expenses are erased!\n");
					} else {
						System.out.println("Oops... try again!");
					}
					optionsSelection();
					break;
				case 4:
					System.out.println("Your expenses are sorted here :");

					int[] a = expenses.stream().mapToInt(i -> i).toArray();


					int min; int temp=0;
					for(int i=0; i<a.length; i++) {
						min=i;
						for(int j1=i+1; j1<a.length; j1++) {

							if(a[j1]<a[min]) {
								min=j1;
							}
						}
						temp=a[i];
						a[i]=a[min];
						a[min]=temp;
					}

					for (int i = 0; i < a.length; i++) {
						System.out.println(a[i]+" ");
					}
					optionsSelection();
					break;
				case 5:
					int[] leng = expenses.stream().mapToInt(i -> i).toArray();
					System.out.println("Enter the expense you need to search:\t");
					int s=sc.nextInt();
					int temp1=0;
					for(int i=0; i<leng.length; i++) {
						if(leng[i]==s) {
							System.out.println("**********Your Expense "+s+" is Available**********");
							System.out.println();
							System.out.println();
							temp1=temp1+1;
						}
					}
					if(temp1==0)
					System.out.println("Item expense is not Found");
					optionsSelection();
					break;
				case 6:
					closeApp();
					break;
				default:
					System.out.println("You have made an invalid choice!");
					break;
				}
				sc.close();}
		}

	}
	private static void closeApp() {
		System.out.println("Closing your application... \nThank you!");
	}
	
	
}
