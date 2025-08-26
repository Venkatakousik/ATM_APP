package com.cdg.Atm.console.app;
import java.util.Scanner;
public class Main {
	// Main servers
	public static Scanner scan = new Scanner(System.in);
	
    public static void main(String[] args) throws AccountDefaults {
    	AdaminLogin.loadAccounts();
    	AdaminLogin admins = new AdaminLogin();
    	UserLogin user =new UserLogin();
    	System.out.println("===================================================================================");
        System.out.println(colour.GREEN+"\t\t\t\t Welcome to the SBI Bank. "+colour.RESET); 
    	System.out.println("==================================================================================="+"\n\n");
    	System.out.println(colour.RED+"Please Read conditions before creating your account in our bank  ");
    	System.out.print("\t1.Minimum Deposit: The initial deposit should be at least $500.\r\n");
    	System.out.print("\t2.Password Requirements: Your password must consist of digits only.\r\n");
    	System.out.print("\t3.Maintain Balance: Please ensure that your account balance is always above $500.\r\n"+ "");
    	System.out.print("\t4.Security Assurance: Your money is safe in our bank.\r\n\n"+colour.RESET);
    	
    while(true) {
            System.out.print(colour.BLUE+"Choose your option: \n\t\t choose 1: Admin \n\t\t choose 2: User \n\t\t choose 3: Exit \n");
            System.out.print("choose : "+colour.RESET);
            int option = scan.nextInt();
            switch (option) {
                case 1:
                	// Admin functionality 
                	admins.admin();
                    break;
                    
                case 2:
                	//  user functionality 
                	if(AdaminLogin.accountCount>0) {
                		user.userCreation();   
                	}
                	else {
                		System.out.print(colour.RED+" \t\t No User Found \n"+colour.RESET);
                	}
                    break;
                    
                case 3:
                		// For Exit the program
                	AdaminLogin.saveAccounts();
                    System.out.println(colour.RED+"Exiting the program... "+colour.RESET);
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println(colour.YELLOW+"Please choose a correct option."+colour.RESET);
            }
        }
    }      
}

