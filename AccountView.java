package account.view;

import java.util.Scanner;

public class AccountView {
	Scanner sc = new Scanner(System.in);

	public int showMenu() {
		System.out.println("Enter 1 for insert..");
		System.out.println("Enter 2 for update..");
		System.out.println("Enter 3 for delete..");
		System.out.println("Enter 4 for displayAlldata..");
		System.out.println("Enter 5 for sorting name..");
		System.out.println("Enter 6 for sorting balance..");
		System.out.println("Enter 7 for find the single data..");
		System.out.println("Enter 8 for exit....");
		return sc.nextInt();
	}

	public int getID() {
		System.out.println("Enter the ID..");
		return sc.nextInt();
	}

	public String getName() {
		System.out.println("Enter the Name ");
		sc.nextLine();
		return sc.nextLine();
	}

	public double getBalanc() {
		System.out.println("Enter the balance");
		return sc.nextDouble();
	}

	public int getdebit() {
		System.out.println("Enter the debitAccount");
		return sc.nextInt();
	}

	public int getCredeit() {
		System.out.println("Enter the creditAccount");
		return sc.nextInt();
	}

}
