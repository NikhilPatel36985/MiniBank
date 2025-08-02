package account.model;

public class Account {
	private int id;
	private int idi;
	public int getIdi() {
		return idi;
	}
	public void setIdi(int idi) {
		this.idi = idi;
	}

	private String name;
	private double balance;

	
	public void display() {
		System.out.println("id : "+ id);
		System.out.println("name : "+ name);
		System.out.println("balance : "+ balance);
		System.out.println("-----------------------------------------------");
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Account() {
	}

	public Account(int id, String name, double balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
	}

	public Account(int id,int i, double balance) {
		this.id = id;
		this.idi = i;
		this.balance = balance;
	}

	public Account(int id) {
		this.id = id;
	}

	public Account(String name, double balance) {
		this.name = name;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", balance=" + balance + "]";
	}

}
