package model.services;

import java.util.Iterator;

import model.entities.ContractInstallment;
import model.entities.Installment;

public class PaypalPaymentService implements PaymentCompanyService {
    public double paymentFee() {
        return 0.02;
    }

    public double simpleInterest() {
        return 0.01;
    }

    @Override
    public void calculateInstallments(ContractInstallment contractInstallment) {
        int month = 0;        
        Iterator<Installment> iterator = contractInstallment.getInstallments();
        while (iterator.hasNext()) {
            month++;
            Installment installment = iterator.next();
            double amount = installment.getAmount();
            double interestCost = (amount * simpleInterest() * month); 
            double feeCost = (amount + interestCost) * paymentFee();
            installment.setExtraCost(interestCost + feeCost);
        }
    }
}
