package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.entities.Contract;
import model.entities.ContractInstallment;
import model.exceptions.InstallmentNumberBelowAllowedException;
import model.services.InstallmentPaymentService;
import model.services.PaypalPaymentService;

public class Program {

    public static void main(String[] args) 
    throws InstallmentNumberBelowAllowedException, ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
        Contract contract = new Contract(8028, dateFormat.parse("25/08/2018"), 600.0);
        ContractInstallment contractInstallment = new ContractInstallment(contract, 3);   
        InstallmentPaymentService paymentService = new InstallmentPaymentService(
            contractInstallment, 
            new PaypalPaymentService()
        );
        paymentService.calculateInstallments();
    }
}
