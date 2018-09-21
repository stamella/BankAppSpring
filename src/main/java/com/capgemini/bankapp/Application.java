package com.capgemini.bankapp;

import java.text.Annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.bankapp.config.AppConfig;
import com.capgemini.bankapp.controller.BankAccountController;
import com.capgemini.bankapp.database.DbUtil;
import com.capgemini.bankapp.entities.BankAccount;
import com.capgemini.bankapp.exception.LowBalanceException;

public class Application {
     public static void main(String[] args) throws LowBalanceException {
		/*ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");*/
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		BankAccountController bankAccountController = context.getBean("bankAccountController", BankAccountController.class);
		
		/*System.out.println(bankAccountController.getBalance(2024));
		System.out.println(bankAccountController.withdraw(2025,500));
		System.out.println(bankAccountController.deposit(2026,500));
		System.out.println(bankAccountController.fundTransfer(2025,2024,500));
		System.out.println(bankAccountController.deleteBankAccount(2026));*/
		System.out.println(bankAccountController.findBankAccountById(2025));
		/*BankAccount account = new BankAccount(2026,"chaitanya","savings",15000);
		System.out.println(bankAccountController.addBankAccount(account));*/
		System.out.println(bankAccountController.findAllBankAccounts());
		BankAccount account1 = new BankAccount(2026,"chaitanyas","savings",15000);
		System.out.println(bankAccountController.updateBankAccount(account1));

		
		/*DbUtil dbutil = context.getBean(DbUtil.class);
		dbutil.getConnection();*/

	}
}