package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.IndividualTaxpayer;
import entities.Taxpayer;

public class Program {

	public static final char INDIVIDUAL = 'i';
	public static final char COMPANY = 'c';

	public static Taxpayer individualTaxpayer(Scanner sc, String name, double annualIncome) {
		double healthExpenditures;

		do {
			System.out.printf("Health expenditures: ");
			healthExpenditures = sc.nextDouble();
		} while (healthExpenditures < 0.00);
		return new IndividualTaxpayer(name, annualIncome, healthExpenditures);
	}
	public static Taxpayer company(Scanner sc, String name, double annualIncome) {
		int numberOfEmployees;

		do {
			System.out.printf("Number of employees: ");
			numberOfEmployees = sc.nextInt();
		} while (numberOfEmployees < 0);
		return new Company(name, annualIncome, numberOfEmployees);
	}

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Taxpayer> taxpayers;
		Taxpayer taxpayer;
		String name;
		double annualIncome;
		char option;
		int n;

		System.out.printf("Enter the number of tax payers: ");
		n = sc.nextInt();
		taxpayers = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			System.out.printf("Tax payer #%d data:%n", i);
			do {
				System.out.printf("Individual or company (i/c)? ");
				option = sc.next().charAt(0);
			} while (option != INDIVIDUAL && option != COMPANY);
			sc.nextLine();
			System.out.printf("Name: ");
			name = sc.nextLine();
			do {
				System.out.printf("Annual income: ");
				annualIncome = sc.nextDouble();
			} while (annualIncome < 0.00);
			taxpayer = (option == INDIVIDUAL) ? individualTaxpayer(sc, name, annualIncome)
					: company(sc, name, annualIncome);
			taxpayers.add(taxpayer);
		}

		sc.close();

	}

}
