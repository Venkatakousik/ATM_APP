package com.cdg.Atm.console.app;

import java.util.Scanner;

public class AdaminLogin {
	Scanner scan =new Scanner(System.in);
	private static final String adminpin="1234";
	 static Account[] accs=new Account[100];
	 Account[] backup=new Account[100];
	 int backupCount=0;
    static int accountCount=0;
    int no_of_accounts;
	
	
     public  void admin() {
     	AdaminLogin admin = new AdaminLogin();
     	System.out.println("===================================================================================");
        System.out.println(colour.GREEN+"\t\t\t   You have choosen Admin. "+colour.RESET); 
    	System.out.println("===================================================================================");
     	System.out.print(colour.GREEN+"Please enter your PIN : "+colour.RESET);
     	int count= 3;
     	while(true) {
     		String enteredPin =scan.next();
     		if(admin.login(enteredPin)) {
     			System.out.println(colour.GREEN+"\t\t\t   Login successful! "+colour.RESET);
     			while(true) {
                 System.out.print(colour.BLUE+"Choose your option: \n\t\t choose 1: creacc \n\t\t choose 2: viewAllaccounts \n\t\t choose 3: Delete Account \n\t\t choose 4: Backup \n\t\t choose 5: Exit \n");
                 System.out.print("choose : "+colour.RESET);
                 int option=scan.nextInt();
                 
     			switch(option){
     				case 1:
     					creacc();
     					break;
     				case 2:
     					ViewAllAccounts();
     					break;
     				case 3:
     					System.out.print(colour.GREEN+"Enter account number to delete :"+colour.RESET);
     					String delete =scan.next();
     					deleteAccount(delete);
     					break;
     				case 4:
     					System.out.print(colour.GREEN+"TO View backUp account \n"+colour.RESET);
     					backUp();
     					break;
     				 case 5:
     	                    System.out.println(colour.RED+" \t\t Exiting from Admin"+colour.RESET);
     	                    return; // Exit the method
     				default: 
                         System.out.println(colour.YELLOW+"Please choose a correct option."+colour.RESET);
     			}
     			
     			}
     		}
     		count--;
     		System.out.println(colour.YELLOW+"you only "+count+" trys!");         
     		System.out.println(colour.GREEN+"please enter correct pin : ");
     		if(count==0) {
     			System.out.println(colour.RED+"please try After Sometime  (or) contact Administartion "+colour.RESET);
     			break;
     		}
     		
     	}
     }
     
     
     
     
     
	public boolean login(String enteredPin) {
		return adminpin.equals(enteredPin);
	}
	
	public void creacc() {
		System.out.print("\t\t USER NAME \t\t: ");
		String username=scan.next();		
		System.out.print("\t\t Location  \t\t: ");
		String loc =scan.next();
		
		String accnumber ="SBI"+no_of_accounts++;
		System.out.println("\t\t User Account number is : "+accnumber);
		System.out.print("\t\t Enter pin for user     : ");
		int pin =scan.nextInt();
		System.out.print("\t\t Deposit your money     : ");
		int deposite=scan.nextInt();
		if(deposite >=500 && deposite%100==0) {
		Account ac=new Account(username,loc,accnumber, pin, deposite);
		accs[accountCount++]=ac;
		System.out.println(colour.GREEN+"\t\t ACCOUNT SUCCESSFULLY CREATED!"+colour.RESET);
		return;
		}
		else {
			System.out.println(colour.RED+"\t\t Minimum balance should be atleast 500!"+colour.RESET);
			return ;
		}
	}
	
	
	
	public void ViewAllAccounts() {
		if(accountCount>0) {
		System.out.println(colour.GREEN+"Account holders : "+colour.RESET);
		int j=1;
		for(int i=0;i<accountCount;i++) {
			
			System.out.println(colour.BLUE+" Account "+j+" :- ");
			System.out.println(accs[i]);
			j++;
		}
		System.out.println();
		}else {
		System.out.println(colour.RED+"No user Found. "+colour.RESET);
	}
	}
	
	public void deleteAccount(String accnumber) {
        boolean found = false;
        for (int i = 0; i < accountCount; i++) {
            if (accs[i].getAccnumber().equals(accnumber)) {
                backup[backupCount++] = accs[i];
                accs[i] = null;
                // Shifting  accounts to fill the gap
                for (int j = i; j < accountCount - 1; j++) {
                    accs[j] = accs[j + 1];
                }
                accs[--accountCount] = null; 
                found = true;
                System.out.println(colour.RED+"Account " + accnumber + " has been deleted."+colour.RESET);
                break;
            }
        }
        if (!found) {
            System.out.println(colour.RED+"Account " + accnumber + " not found."+colour.RESET);
        }
    }
	
	public void backUp() {
        while (true) {
            System.out.print(colour.BLUE+"Choose your option: \n\t\t choose 1: View All Backup Accounts \n\t\t choose 2: Delete Permanent Backup Account \n\t\t choose 3: Exit \n");
            System.out.print("choose : "+colour.RESET);
            int option = scan.nextInt();
            switch (option) {
                case 1:
                    backupView();
                    break;
                case 2:
                	if(backupCount>0) {
                    System.out.print("Enter account number to delete permanently: ");
                    String accnumber = scan.next();
                    
                    backupAccount(accnumber);
                    }else {
                    	System.out.print(colour.RED+" No users!"+colour.RESET);
                    }
                    break;
                case 3:
                    System.out.println(colour.RED+" Exiting from Back up"+colour.RESET);
                    return; // Exit the method
                default:
                    System.out.println(colour.YELLOW+" Please choose a correct option."+colour.RESET);
            }
        }
    }
	
	public void backupAccount(String accnumber) {
		boolean found =false;
		
		for(int i=0;i<backupCount;i++) {
			 if (backup[i].getAccnumber().equals(accnumber)) {
				 
				for(int j=0;j<backupCount-1;j++) {
					backup[j]=backup[j+1];
				}				
				backup[--backupCount]=null;
				found =true;
				System.out.println(colour.GREEN+"Account "+accnumber+" has been perminently deleted ."+colour.RESET);
				break;
			}
			
		}
		if(!found) {
			System.out.println(colour.RED+" Account "+accnumber+" not found in backUp Files "+colour.RESET);
		}
		}
	
	
	public void backupView() {
		if(backupCount>0) {
		System.out.println(colour.GREEN+" Account holders : ");
		for(int i=0;i<backupCount;i++) {
			System.out.println(backup[i]);
		}
		}
		System.out.println(colour.RED+" No user Founds "+colour.RESET);
	}
	
	
}
