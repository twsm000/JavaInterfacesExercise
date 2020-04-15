package model.services;

import model.entities.ContractInstallment;

public interface PaymentCompanyService {
    public void calculateInstallments(ContractInstallment contractInstallment);
}
