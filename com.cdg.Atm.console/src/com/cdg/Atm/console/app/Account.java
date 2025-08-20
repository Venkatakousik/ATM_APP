package com.cdg.Atm.console.app;
public class Account {
	private String username;
	private String location;
	private String accnumber;
	private int pin;
	private int balance;
	public Account(String username, String location, String accnumber, int pin, int balance) {
		this.username = username;
		this.location = location;
		this.accnumber = accnumber;
		this.pin = pin;
		this.balance = balance;
	}
	
	public String getUsername() {
		return username;
	}
	public String getLocation() {
		return location;
	}
	public String getAccnumber() {
		return accnumber;
	}
	public int getPin() {
		return pin;
	}
	public int getBalance() {
		return balance;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setAccnumber(String accnumber) {
		this.accnumber = accnumber;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public void setBalance(int balance) {
			this.balance = balance;
		
	}
	
	public Account getBankDetails() {
		return this;
	}
	
	@Override
    public String toString() {
		return "\t\t Username       =   " +username +"\n" +"\t\t Location       =   " + location +"\n" + "\t\t AccountNumber  =    " + accnumber +"\n"+ "\t\t Balance        =   " + balance ;
    }
	
}
