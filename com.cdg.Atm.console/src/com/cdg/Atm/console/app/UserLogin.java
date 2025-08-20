package com.cdg.Atm.console.app;
import java.util.*;
public class UserLogin {
	Scanner scan =new Scanner(System.in);
	 public  void userCreation() throws AccountDefaults{		 	
		 	System.out.println("===================================================================================");
	        System.out.println(colour.GREEN+"\t\t\t   You have chosen User. "+colour.RESET); 
	    	System.out.println("===================================================================================");
	        while(true) {
		        System.out.println(colour.BLUE+"Choose your option:\n\t\t choose 1: Deposit \n\t\t choose 2: withdraw \n\t\t choose 3: Cheak balance  \n\t\t choose 4: Transection \n\t\t choose 5: Exit ");
		        System.out.print("choose : "+colour.RESET);
	        	int option =scan.nextInt();
	        	switch(option){
	        		
	        		case 1:
	        			sdeposit();
	        			break;
	        		case 2:
	        				
	        			swithDraw();
	        			break;
	        		case 3:
	        			
	        			scheck();
	        			break;
	        		case 4:
	        			Transection();
	        			break;
	        		case 5:
	        			System.out.println(colour.RED+"\t\t Exiting from user"+colour.RESET);
	        			return;
	        		default:
	        			System.out.println(colour.YELLOW+"\t\t choose correct option"+colour.RESET);
	        	}
	        }
	 }
	 
	 public void sdeposit() {
		 try {
			 deposit();
		 }catch(AccountDefaults e) {
			 e.printStackTrace();
			 sdeposit();
		 }
	 }
	
	 
	 public void deposit() throws AccountDefaults {		 
		 System.out.print(colour.GREEN+"please enter your account number To deposite : "+colour.RESET);
		 String acc =scan.next();
		 boolean found =false;
		 for(int i=0;i<AdaminLogin.accountCount;i++) {
			 if (AdaminLogin.accs[i].getAccnumber().equals(acc)) {
				 if(passwordCheck(i)) {
					 System.out.print(colour.GREEN+"Enter the how much you want deposit : "+colour.RESET);
				 	 int deposite =scan.nextInt();
				 	 if(deposite>=500 && deposite%100==0) {
				 		deposite+=AdaminLogin.accs[i].getBalance();
				 		AdaminLogin.accs[i].setBalance(deposite);
						System.out.println(colour.GREEN+"\t\t Toatal balance is : "+AdaminLogin.accs[i].getBalance()+colour.RESET+"\n");
					 	found =true;
					 } else {
						 	 found =true;
					 		 throw new AccountDefaults(colour.YELLOW+"\t\t deposite should be at least 500! "+colour.RESET);
					 		 
					 	 	}
					 	}
				
				 	}
		 }
			if(!found) {
				throw new AccountDefaults(colour.YELLOW+" \t\t Account "+acc+" not found"+colour.RESET);
			}
		
	 }
	 
	 public void swithDraw() {
		 try {
			 withDraw();
		 }catch(AccountDefaults e) {
			 e.printStackTrace();
			 swithDraw();
		 }
	 }
	 
	 public void withDraw() throws AccountDefaults{		 
		 System.out.print(colour.GREEN+"Please enter your account number : ");
		 String acc =scan.next();
		 boolean found =false;
			for(int i=0;i<AdaminLogin.accountCount;i++) {
				 if (AdaminLogin.accs[i].getAccnumber().equals(acc)) {
					 if(passwordCheck(i)) {
						 System.out.print("Enter how much you want withdraw : "+colour.RESET);
					 	 int withdraw =scan.nextInt();
					 	 if(AdaminLogin.accs[i].getBalance()-withdraw>=500) {
					 		int balance=AdaminLogin.accs[i].getBalance()-withdraw;
					 		AdaminLogin.accs[i].setBalance(balance);
					 		System.out.println(colour.GREEN+" \t\t Sucsessfully withdrwan :  "+colour.RESET+withdraw);
					 		System.out.println(colour.GREEN+" \t\t Remaining balance "+colour.RESET+AdaminLogin.accs[i].getBalance()+"\n");
					 		found =true;
					 	 } else {
					 		 found =true;
					 		 throw new AccountDefaults(colour.YELLOW+"\t\t Insufficient balance "+colour.RESET);
					 		
					 	 	}
					 	}
				
				 	}
			
			}
			if(!found) {
				throw new AccountDefaults(colour.YELLOW+"\t\t Account "+acc+" not found"+colour.RESET);
			}
	 }
	 
	 public void scheck() {
		 try {
			 CheakBalance();
		 }catch(AccountDefaults e) {
			 e.printStackTrace();
			 scheck();
		 }
	 }
	 public void CheakBalance() throws AccountDefaults{
		 System.out.print(colour.GREEN+"Please enter your account number : "+colour.RESET);
		 String acc =scan.next();
		 boolean found =false;
			for(int i=0;i<AdaminLogin.accountCount;i++) {
				 if (AdaminLogin.accs[i].getAccnumber().equals(acc)) {
					 if(passwordCheck(i)) {
						System.out.println(colour.GREEN+" \t\t Balance is : "+colour.RESET+AdaminLogin.accs[i].getBalance()+"\n");
						found=true;
					 	}
				 	}
			}
			if(!found) {
				throw new AccountDefaults(colour.YELLOW+" \t\t Account "+acc+" not found"+colour.RESET);
			}
		
	 }	 
	 
	 public boolean passwordCheck(int i) throws NumberFormatException {
		    System.out.print(colour.GREEN + "Please enter your password : " + colour.RESET);
		    int count = 3;

		    while (count > 0) {
		        try {
		        	
		            String input = scan.next(); 
		            int pass = Integer.parseInt(input); //  throw NumberFormatException

		            if (input.length() != 4) {
		                throw new NumberFormatException("Password must be exactly 4 digits.");
		            }

		            if (AdaminLogin.accs[i].getPin() == pass) {
		                return true;
		            } else {
		                System.out.println(colour.YELLOW + "Incorrect password!" + colour.RESET);
		            }

		        } catch (NumberFormatException e) {
		            System.out.println(colour.RED + "\t\t !Invalid input  " + colour.RESET);
		        }

		        count--;
		        if (count > 0) {
		            System.out.println(colour.YELLOW + "Attempts left: " + count + colour.RESET);
		            System.out.print("Please enter Correct Password : ");
		        }
		    }
		    return false;
		}

	 
	 
	 public void Transection() {
		 System.out.print(colour.GREEN+"Enter your Account number : "+colour.RESET);
		 String TransferAcc =scan.next();
		 boolean found =false;
		 //Checking for sender
		 for(int i=0;i<AdaminLogin.accountCount;i++) {
			 if(AdaminLogin.accs[i].getAccnumber().equals(TransferAcc)) {
				 if(passwordCheck(i)) {
					 System.out.print(colour.GREEN+"Enter reciever Account number : "+colour.RESET);
					 String recAcc =scan.next();
					 Account reciever = null;
					 //Checking for receiver
					 for(int j=0;j<AdaminLogin.accountCount;j++) {
						 if(AdaminLogin.accs[j].getAccnumber().equals(recAcc)  && !recAcc.equals(TransferAcc)) {
							 reciever =AdaminLogin.accs[j];
							 break;
						 }
					 }
					 if(reciever==null) {
						 System.out.print(colour.YELLOW+" \t\t Recevier not found! (or) inValid Account Number "+"\n"+colour.RESET);
						 return;
					 }
					 
					 System.out.print(colour.GREEN+"Enter ammount to transfer : "+colour.RESET);
					 int transferAmmount =scan.nextInt();
					 if(transferAmmount>100 && transferAmmount%100==0) {
						 if(AdaminLogin.accs[i].getBalance()-transferAmmount>=500) {
							 AdaminLogin.accs[i].setBalance(AdaminLogin.accs[i].getBalance() - transferAmmount);
							 reciever.setBalance(reciever.getBalance() + transferAmmount);
			                    System.out.println(colour.GREEN+"\t\t Transfer successful!"+colour.RESET);
			                    System.out.println(colour.GREEN+"\t\t Your balance: "+colour.RESET + AdaminLogin.accs[i].getBalance());
			                    found = true;
							 
						 }else {
							 System.out.println(colour.RED+"\t\t  Insufficent balance! "+"\n");
							 return;
						 }
					 }

				 }
			 }
		 }
		 if(!found) {
			 System.out.println(colour.YELLOW+"\t\t Account "+TransferAcc+" not found "+"\n");
		 }
	 }
	 }





