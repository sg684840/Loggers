package com.Soumya.Logger;
import java.util.*;
import java.io.*;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

class SI
{
	double principal=0.0,rate=0.0,time=0.0;
	SI(double principal,double rate,double time)
	{
		this.principal=principal;
		this.rate=rate;
		this.time=time;
	}
	double getSI()
	{
		return ((principal*rate*time)/100);
	}
}

class CI
{
	double principal=0.0,rate=0.0,time=0.0,number=0.0;
	CI(double principal,double rate,double time,double number)
	{
		this.principal=principal;
		this.rate=rate;
		this.time=time;
		this.number=number;
	}
	double getCI()
	{
		return (principal*Math.pow(1+(rate/(number*100)), time*number) -principal);
		
	}
}

public class SI_CI {
	static final Logger log= Logger.getLogger(SI_CI.class);

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicConfigurator.configure();
		double interest=0.0;
		Scanner sc = new Scanner(System.in);
        log.info("Enter Principle Amount: \n");
        double principal = sc.nextDouble();
        log.info("Enter Rate: \n");
        double rate = sc.nextDouble();
        log.info("Enter the time in years: \n");
        double time = sc.nextDouble();
        log.info("Would you want to have the Simple Interest? [Y/N] \n");
        char choice = sc.next().charAt(0);
        if (choice=='Y'||choice=='y')
        {
        	SI simpleInterest = new SI(principal,rate,time);
        	interest = simpleInterest.getSI();
        }
        else
        {
        	log.info("How many times interest is compounded per year: \n");
        	double number=sc.nextDouble();
        	CI compoundInterest = new CI(principal,rate,time,number);
        	interest = compoundInterest.getCI();
        }
        PrintStream myout =  new PrintStream(new FileOutputStream(FileDescriptor.out));
        log.info("The interest is: Rs");
        myout.printf("%0.2f",interest);
        sc.close();

	}

}
