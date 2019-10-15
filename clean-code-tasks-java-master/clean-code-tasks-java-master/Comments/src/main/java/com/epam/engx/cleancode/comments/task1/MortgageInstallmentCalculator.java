package com.epam.engx.cleancode.comments.task1;

import com.epam.engx.cleancode.comments.task1.thirdpartyjar.InvalidInputException;

public class MortgageInstallmentCalculator {

    
    public static double calculateMonthlyPayment(
            int principalAmount, int termOfMortage, double rateOfInterest) {

        
        if (principalAmount < 0 || termOfMortage <= 0 || rateOfInterest < 0) {
            throw new InvalidInputException("Negative values are not allowed");
        }

       
        rateOfInterest /= 100.0;

       
        double termInMonths = termOfMortage * 12;

        
        if(rateOfInterest==0)
            return  principalAmount/termInMonths;

       
        double monthlyRate = rateOfInterest / 12.0;
        double monthlyPayment = (principalAmount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -termInMonths));

        return monthlyPayment;
    }
}
