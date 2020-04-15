package model.services;

import model.entities.ContractInstallment;

public class InstallmentPaymentService {
    private ContractInstallment contractInstallment;
    private PaymentCompanyService paymentCompany;
    
    public InstallmentPaymentService() {
    }

    public InstallmentPaymentService(ContractInstallment contractInstallment, PaymentCompanyService paymentCompany) {
        this.contractInstallment = contractInstallment;
        this.paymentCompany = paymentCompany;
    }

    public ContractInstallment getContractInstallment() {
        return contractInstallment;
    }

    public void setContractInstallment(ContractInstallment contractInstallment) {
        this.contractInstallment = contractInstallment;
    }

    public PaymentCompanyService getPaymentCompany() {
        return paymentCompany;
    }

    public void setPaymentCompany(PaymentCompanyService paymentCompany) {
        this.paymentCompany = paymentCompany;
    }

    public void calculateInstallments() {
        System.out.println("Installments: ");
        getPaymentCompany().calculateInstallments(contractInstallment);
    }
}
