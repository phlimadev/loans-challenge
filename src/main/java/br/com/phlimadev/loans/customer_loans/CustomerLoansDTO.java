package br.com.phlimadev.loans.customer_loans;

import br.com.phlimadev.loans.loan.LoanDTO;

import java.util.Set;

public record CustomerLoansDTO(
        String customer,
        Set<LoanDTO> loans
) {
}