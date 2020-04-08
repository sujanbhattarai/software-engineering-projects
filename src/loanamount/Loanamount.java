/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loanamount;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author sujan
 */
public class Loanamount 
{   
   public static void main(String[] args)
   {
       Scanner scanner = new Scanner(System.in);            // creating Scanner class object
       double  loanAmount, annualInterestRate;
        
       
       System.out.print("Please Enter the Loan Amount in $ : ");                   // ask the loan total amount and store as an double 
         loanAmount = scanner.nextDouble();
       System.out.print("Number of Years: ");               // ask the user to inpu the numbers of years and store as an double 
       int numYears = scanner.nextInt();
       
       System.out.print("Annual Interest Rate (in %): ");   // ask the user to input the interest rate and store as double 
       annualInterestRate = scanner.nextDouble();
       System.out.println(); 
       printTable(loanAmount, annualInterestRate, numYears);        //calling method printTable
   }
   
   /**The method printTable that takes principal, annual interest rate and years
   * and generates a table of monthly payment on console.*/
   public static void printTable(double principal,double annualInterestRate,int numYears) // this generate the table in monthly payemnt consel
   {

       double amount=principal;
       double interestPaid, principalPaid, newBalance,monthlyInterestRate, monthlyPayment;
       int month;
       int numMonths = numYears * 12;
       double totalInterest=0;

                                                                        // to calculate the monthly rate 
       monthlyInterestRate = annualInterestRate / 12;
       monthlyPayment = monthlyPayment(principal, monthlyInterestRate, numYears);

       // Print the table header of the table
       System.out.printf("%10s%10s%10s%10s%15s\n","","","", "Unpaid","      Total Interest");
       System.out.printf("%10s%10s%10s%10s%15s\n","Payment ","Principal","Interest", "Balance","to Date");

       //generate a tabel of values for payment, principal, interest ,unpaid balance
       //interest to date
       for (month = 1; month <= numMonths; month++)                         // compare if the months is less than aother months if it is than goes to the next line
            {
          
                interestPaid = principal * (monthlyInterestRate / 100);       // calculatin the interest paid 
                principalPaid = monthlyPayment - interestPaid;               // calculate the principle paid 
                newBalance = principal - principalPaid;                     //calculating the new balance
                totalInterest+=interestPaid;
           
                if(newBalance<=0)                                                // compare if the new balance is 0
                    System.out.format("%8d%10.2f%10.2f%12.2f%12.2f\n",month, interestPaid,principalPaid, 0.00,totalInterest);  // comparing the if new alance is less than zero or not 
                else
                        System.out.format("%8d%10.2f%10.2f%12.2f%12.2f\n", month, interestPaid,principalPaid, newBalance,totalInterest); // else print theis statement 
                principal = newBalance;          // this set newbalance to  the principal
            }
   }
   static double monthlyPayment(double loanAmount, double monthlyInterestRate, int numberOfYears) // this return the monthly interest rate and number of years 
   {  
       //convert interest rate to decimal value
       monthlyInterestRate = monthlyInterestRate/ 100.0;
       return loanAmount * monthlyInterestRate / ( 1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12) );
   }
}               //end of class