package account.controller;

import java.util.List;

import account.model.Account;
import account.model.AccountDao;
import account.view.AccountView;

public class AccountController {
	public AccountDao dao;
	public AccountView view;

	public AccountController(AccountDao dao, AccountView view) {
		this.dao = dao;
		this.view = view;
	}

	public void run() {
		while (true) {
			int choice = view.showMenu();
			switch (choice) {
			case 1:{
				String na = view.getName();
				double dl =view.getBalanc();
				Account ac = new Account(na,dl);
				dao.insert(ac);
				}
				break;

			case 2:{
				int id = view.getdebit();
				int i = view.getCredeit();
				double dl =view.getBalanc();;
				Account ss = new Account(id,i,dl);
				dao.update(ss);
			}
				
				break;
			case 3:
			{
				int id = view.getID();
				Account ac = new Account(id);
				dao.delete(ac);
			}
				break;
			case 4:
			{
				List<Account> ac = dao.showdata();
				for( Account ar: ac) {
					System.out.println("id : "+ar.getId());
					System.out.println("Name : "+ar.getName());
					System.out.println("balance :"+ar.getBalance());
				}
			}
				break;
			case 5:{
				List<Account> ac = dao.showdata();
				ac.sort((a,b)->b.getName().compareTo(a.getName()));
				for(Account am :ac ) {
					System.out.println("id : "+am.getId());
					System.out.println("Name : "+am.getName());
					System.out.println("balance :"+am.getBalance());
				}
			}
				break;
			case 6:{
				List<Account>ac= dao.showdata();
				ac.sort((a,b)->(int) (b.getBalance()-(a.getBalance())));
			}
				break;
			case 7:{
				int id = view.getID();
				List<Account> ac = dao.showdata();
				ac.stream().filter(s-> s.getId()==id).forEach(s->{
					s.display();
					System.out.println("---------------------");
				});
			}
				break;
			case 8:
				return;
			default:
				System.out.println("invalid choice.....!");
			}
		}
	}

}
