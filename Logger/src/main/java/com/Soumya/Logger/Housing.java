package com.Soumya.Logger;
import java.util.*;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.io.*;

class Price
{
	double area= 0.0;
	Price(double area)
	{
		this.area = area;
	}
	double get_Price(double moneyformaterials)
	{
		return area*moneyformaterials;
	}
}

public class Housing {
	static final Logger log= Logger.getLogger(Housing.class);
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicConfigurator.configure();
		Scanner sc = new Scanner(System.in);
		double total_price=0.0;
		log.info("Enter the area of the house : \n");
		double area = sc.nextDouble();
		Price price = new Price(area);
		log.info("Material Options: \n1. Standard \n2. Above Standard \n3. High Standard \n");
		log.info("Enter the option number : \n");
		sc.hasNextLine();
		int material=sc.nextInt();
		if (material == 1)
			total_price = price.get_Price(1200.00);
		else if (material == 2)
			total_price = price.get_Price(1500.00);
		else if (material == 3)
		{
			log.info("Enter if you want the house to be automated[Y/N] : \n");
			char choice=sc.next().charAt(0);
			if(choice=='Y'||choice=='y')
				total_price = price.get_Price(2500.00);
			else
				total_price = price.get_Price(1800.00);
		}
		else
			log.warn("Wrong value : \n");
		
		PrintStream myout =  new PrintStream(new FileOutputStream(FileDescriptor.out));
        log.info("The Price of the house is : Rs");
        myout.printf("%.2f",total_price);
		sc.close();

	}

}
