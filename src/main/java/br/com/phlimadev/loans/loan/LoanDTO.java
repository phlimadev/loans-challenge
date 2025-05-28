package br.com.phlimadev.loans.loan;

import com.fasterxml.jackson.annotation.JsonAlias;

public record LoanDTO(
        String type,
        @JsonAlias("interest_rate")
        Integer interestRate
) {
}
