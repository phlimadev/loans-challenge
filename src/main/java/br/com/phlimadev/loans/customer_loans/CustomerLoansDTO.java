package br.com.phlimadev.loans.customer_loans;

import br.com.phlimadev.loans.loan.LoanEnum;

import java.util.List;

public record CustomerLoansDTO(
        String customer,
        List<LoanEnum> loans
) {
}