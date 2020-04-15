package model.exceptions;

public class InstallmentNumberBelowAllowedException extends Exception {
    private static final long serialVersionUID = 1L;
    
    public InstallmentNumberBelowAllowedException(String message) {
        super(message);
    }
}
