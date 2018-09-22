package com.capgemini.bankapp;

import java.text.Annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.bankapp.config.AppConfig;
import com.capgemini.bankapp.controller.BankAccountController;
import com.capgemini.bankapp.entities.BankAccount;
import com.capgemini.bankapp.exception.LowBalanceException;

public class Application {
     public static void main(String[] args) throws LowBalanceException {
		/*ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");*/
    	 
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		BankAccountController bankAccountController = context.getBean("bankAccountController", BankAccountController.class);
		
		System.out.println(bankAccountController.getBalance(3));
		System.out.println(bankAccountController.withdraw(2,1000));
        System.out.println(bankAccountController.deposit(2,1000));
        System.out.println(bankAccountController.fundTransfer(3,2,1000));
        BankAccount account = new BankAccount(4,"George","SAVINGS",35000);
		System.out.println(bankAccountController.addBankAccount(account));
        System.out.println(bankAccountController.findBankAccountById(2));
        System.out.println(bankAccountController.findAllBankAccounts());
        BankAccount accountNew = new BankAccount(4,"Georgy","SAVINGS",35000);
        System.out.println(bankAccountController.updateBankAccount(accountNew));
        System.out.println(bankAccountController.deleteBankAccount(2));
		

		

	}
}
