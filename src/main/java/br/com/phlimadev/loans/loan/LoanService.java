package br.com.phlimadev.loans.loan;

import br.com.phlimadev.loans.customer.CustomerDTO;
import br.com.phlimadev.loans.customer_loans.CustomerLoansDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Service
public class LoanService {

    public boolean assessWhetherTheSalaryIsEqualToOrLessThan3000(BigDecimal income) {
        return income.compareTo(BigDecimal.valueOf(3000)) <= 0;
    }

    public boolean assessWhetherTheSalaryIsBetween3000And5000(BigDecimal income) {
        return income.compareTo(BigDecimal.valueOf(3000)) > 0 && income.compareTo(BigDecimal.valueOf(5000)) <= 0;
    }

    public boolean assessAgeAndLocation(Integer age, String location) {
        return age < 30 && location.equalsIgnoreCase("SP");
    }

    public void assessIfTheSalaryIsEqualOrGreaterThan5000(BigDecimal income, Set<LoanDTO> loans) {
        if (income.compareTo(BigDecimal.valueOf(5000)) >= 0) {
            loans.add(new LoanDTO(LoanEnum.CONSIGNMENT.getType(), LoanEnum.CONSIGNMENT.getInterestRate()));
        }
    }

    public void addPersonalAndGuaranteedLoans(Set<LoanDTO> loans) {
        loans.add(new LoanDTO(LoanEnum.PERSONAL.getType(), LoanEnum.PERSONAL.getInterestRate()));
        loans.add(new LoanDTO(LoanEnum.GUARANTEED.getType(), LoanEnum.GUARANTEED.getInterestRate()));
    }

    public CustomerLoansDTO evaluateLoanRequest(CustomerDTO data) {
        Set<LoanDTO> loans = new HashSet<>();

        Integer age = data.age();
        BigDecimal income = data.income();
        String location = data.location();

        if (assessWhetherTheSalaryIsEqualToOrLessThan3000(income)) {
            addPersonalAndGuaranteedLoans(loans);
        }
        if (assessWhetherTheSalaryIsBetween3000And5000(income) && assessAgeAndLocation(age, location)) {
            addPersonalAndGuaranteedLoans(loans);
        }

        assessIfTheSalaryIsEqualOrGreaterThan5000(income, loans);

        return new CustomerLoansDTO(data.name(), loans);
    }
}