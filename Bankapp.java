package bankApplication2;
import java.util.Scanner;

class Bank{
	String adminUser,adminPassword,custUser,custPastword,custName;
	int accountNo;
	float balance,wAmount,dAmount;
	static int count;
	public Bank(){
		adminUser = "admin";
		adminPassword = "admin";
		balance = 10000f;
		
	}
	int adminLogin(String user,String pass){
		if(user.equals(adminUser) && pass.equals(adminPassword))
		{
			return 1;
		}
		return -1;
	}
	static void showAdminMenu(){
		
		System.out.println("1.....Creat Customer");
		System.out.println("2.....Display Customer");
		System.out.println("3.....exit");
	}
	void creatCustomer()
	{
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter the  Customer name");
		custName = obj.next();
		System.out.println("Enter the  User name");
		custUser = obj.next();
		System.out.println("Enter the  Password ");
		custPastword = obj.next();
		System.out.println("Enter the  Account no. ");
		accountNo = obj.nextInt();
	}
	void display()
	{
		System.out.println(accountNo+" "+custUser+" "+custPastword+" "+custName+" "+balance);
	}
	static void showCustomerMenu()
	{
		System.out.println("1.....withdraw");
		System.out.println("2.....deposite");
		System.out.println("3.....checkBalance");
		System.out.println("4.....exit");
	}
	
}
public class Bankapp
{
	
	public static void main(String[] args)
	{
		Bank objBank = new Bank();
		Bank objBank1[] = new Bank[2];
		Scanner obj = new Scanner(System.in);
		while(true)
		{
			System.out.println("1.....AdminLogin");
			System.out.println("2.....customerLogin");
			System.out.println("3.....exit");
			int choice = obj.nextInt();
			switch(choice)
			{
				case 1:System.out.println("Enter the user name and password ");
					String user = obj.next();
					String pass = obj.next();
					if(objBank.adminLogin(user,pass) == 1)
					{
						
						Bank.showAdminMenu();
						
						System.out.println("Enter the choice ");
						int choice1 = obj.nextInt();
						switch(choice1)
						{
							case 1:for(int i=0;i<2;i++)
								{
									objBank1[i] = new Bank();
									objBank1[i].creatCustomer();
								}
							break;
							
							case 2:System.out.println("accountNo\tname\tuser\tpassword\tbalance");
								for(int i=0;i<2;i++)
								{
									objBank1[i].display();
								}
								break;
							case 3:System.exit(0);
						}// end of switch
						
					} // end of if
					else
					{
						System.out.println("Invalid User and password ");
					} // end of else
				break;
			
				case 2:System.out.println("Enter the user name and password ");
					int flag = -1;
					String cUser = obj.next();
					String cPass = obj.next();
					for(int i=0;i<2;i++)
					{
						if(objBank1[i].custUser.equals(cUser) && objBank1[i].custPastword.equals(cPass))
							flag = i;
						
					}// end of for
					if(flag >= 0)
					{
						int choice1;
						Bank.showCustomerMenu();
						System.out.println("Enter the choice ");
						choice1 = obj.nextInt();
						switch(choice1)
						{
							case 1:System.out.println("Enter the amount you want to withdraw");
								float amount = obj.nextFloat();
								float tempBalance = objBank1[flag].balance - amount;
								if(tempBalance <= 10000)
								{
									System.out.println("Insufficent amount");
								}
								else
								{
									objBank1[flag].balance = tempBalance;
								}
								break;
								case 2:System.out.println("Enter the amount you want to deposite");
								float dAmount = obj.nextFloat();
								if(dAmount <= 0)
								{
									System.out.println("not allowed lest than equal to zero");
								}
								else{
									objBank1[flag].balance = objBank1[flag].balance+dAmount;
								
								}
								break;
								case 3:System.out.println(objBank1[flag].balance);
								break;
						}// end of switch
						
					} // end of if
					else
					{
						System.out.println("Sorry the user name and password doesnt not must ");
					}// end of else
				break;
			
			} // end of main switch
		
		}// end of while
	} // end of class
	
} // end of main