package com.epam.engx.cleancode.comments.task1;

import com.epam.engx.cleancode.comments.task1.thirdpartyjar.InvalidInputException;
import org.junit.Assert;
import org.junit.Test;

public class MortgageInstallmentCalculatorTest {
	 
    @Test
    public void shouldCalculateMonthlyPaymentWhenAmountsAreSmall() throws Exception {
       
        Assert.assertEquals(88.84d,  MortgageInstallmentCalculator.calculateMonthlyPayment(1000, 1, 12), 0.01d);
    }

    @Test
    public void shouldCalculateMonthlyPaymentWhenAmountIsLarge() throws Exception {
        
        Assert.assertEquals(888487.88d, MortgageInstallmentCalculator.calculateMonthlyPayment(10000000, 1, 12), 0.01d);
    }

    @Test
    public void shouldCalculateMonthlyPaymentWhenPrincipalIsZero() throws Exception {
       
        Assert.assertEquals(0, MortgageInstallmentCalculator.calculateMonthlyPayment(0, 1, 12), 0.01d);
    }

    @Test
    public void shouldCalculateMonthlyPaymentWhenInterestRateIsZero() throws Exception {
        
        Assert.assertEquals(83.33, MortgageInstallmentCalculator.calculateMonthlyPayment(1000, 1, 0), 0.01d);
    }

    @Test(expected = InvalidInputException.class)
    public void shouldThrowInvalidInputExceptionOnNegativeTenure() throws Exception {
        MortgageInstallmentCalculator.calculateMonthlyPayment(20, -10, 14.5);
    }

    @Test(expected = InvalidInputException.class)
    public void shouldThrowInvalidInputExceptionOnNegativeInterestRate() throws Exception {
        MortgageInstallmentCalculator.calculateMonthlyPayment(20, 1, -12);
    }

    @Test(expected = InvalidInputException.class)
    public void shouldThrowInvalidInputExceptionOnNegativePrincipalAmount() throws Exception {
        MortgageInstallmentCalculator.calculateMonthlyPayment(-20, 10, 14.5);
    }
}
