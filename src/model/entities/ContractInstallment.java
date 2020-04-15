package model.entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import model.exceptions.InstallmentNumberBelowAllowedException;

public class ContractInstallment {
    private Contract contract;
    private Integer installmentNumber;
    private List<Installment> installments = new ArrayList<>();

    public ContractInstallment(Contract contract, Integer installmentNumber) 
    throws InstallmentNumberBelowAllowedException {
        this.validateInstallmentNumber(installmentNumber);
        this.contract = contract;
        this.installmentNumber = installmentNumber;
        this.initializeInstallments();
    }
        
    public Contract getContract() {
        return contract;
    }

    public Integer getInstallmentNumber() {
        return installmentNumber;
    }

    private void validateInstallmentNumber(Integer installmentNumber) 
    throws InstallmentNumberBelowAllowedException {
        if (installmentNumber <= 0) {
            throw new InstallmentNumberBelowAllowedException("The number of installments is below the allowed!");
        }
    }
    
    private void initializeInstallments() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(contract.getDate());        
        Double amount = contract.getTotalValue() / installmentNumber;
        
        for (int i = 1; i <= installmentNumber; i++) {
            calendar.add(Calendar.MONTH, 1);
            installments.add(new Installment(calendar.getTime(), amount));
        }
    }
    
    public Iterator<Installment> getInstallments() {
        return this.installments.iterator();
    }
}
