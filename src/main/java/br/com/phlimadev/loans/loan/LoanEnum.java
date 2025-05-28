package br.com.phlimadev.loans.loan;

public enum LoanEnum {
    PERSONAL("PERSONAL", 4),
    GUARANTEED("GUARANTEED", 3),
    CONSIGNMENT("CONSIGNMENT", 2),;

    private String type;
    private Integer interestRate;

    LoanEnum(String type, Integer interestRate) {
        this.type = type;
        this.interestRate = interestRate;
    }

    public String getType() {
        return this.type;
    }

    public Integer getInterestRate() {
        return this.interestRate;
    }
}