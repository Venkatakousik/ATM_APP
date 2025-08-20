package com.cdg.Atm.console.app;

public class colour {
	// ANSI color codes
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";

    public static void main(String[] args) {
        System.out.println(GREEN + "Transaction successful!" + RESET);
        System.out.println(RED + "Error: Insufficient funds!" + RESET);
        System.out.println(YELLOW + "Warning: Invalid input!" + RESET);
        System.out.println(BLUE + "Welcome to the ATM System!" + RESET);
    }

}
