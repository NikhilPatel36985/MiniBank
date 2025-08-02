package account.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDao {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/backend";
	private static final String UNAME = "root";
	private static final String PSWD = "root";

	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, UNAME, PSWD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public void insert(Account as) {
		try {
			Connection con = getConnection();
			PreparedStatement pps = con.prepareStatement("insert into account (name ,balance) values(?,?)");
			pps.setString(1, as.getName());
			pps.setDouble(2, as.getBalance());
			int i = pps.executeUpdate();
			if (i != 0) {
				System.out.println("successfully..insert..");
			} else {
				System.out.println("some error...");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Account am) {
		try {
			Connection con = getConnection();
			con.setAutoCommit(false);
			PreparedStatement pps = con.prepareStatement("update account set balance=balance-? where id=?");
			pps.setDouble(1, am.getBalance());
			pps.setInt(2, am.getId());
			PreparedStatement pp1 = con.prepareStatement("update account set balance=balance+? where id=?");
			pp1.setDouble(1, am.getBalance());
			pp1.setInt(2, am.getIdi());

			int i = pps.executeUpdate();
			int j = pp1.executeUpdate();

			if (i != 0 && j != 0) {
				con.commit();
				System.out.println("successfully update...");
			} else {
				System.out.println("some error....");
			}
		} catch (SQLException e) {
			e.printStackTrace();
//			try {
//				con.rollback();
//			} catch (SQLException l) {
//				l.printStackTrace();

//			}
		}
	}

	public void delete(Account ac) {
		try {
			Connection con = getConnection();
			PreparedStatement pps = con.prepareStatement("delete from account where id =? ");
			pps.setInt(1, ac.getId());
			int i = pps.executeUpdate();
			if (i != 0) {
				System.out.println("delete successfully...");
			} else {
				System.out.println("some error...");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Account> showdata() {
		List<Account> ac = new ArrayList<Account>();
		Connection con = getConnection();
		try {
			PreparedStatement pps = con.prepareStatement("select *from account");
			ResultSet rs = pps.executeQuery();
			while(rs.next()) {
				int ua = rs.getInt("id");
				String nam = rs.getString("name");
				double dl = rs.getDouble("balance");
//				ac.add(new Account(ua,nam,dl));
				System.out.println(ua+"\t"+nam+"\t"+dl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return ac;
	}
}
