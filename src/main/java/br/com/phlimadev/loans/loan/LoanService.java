package br.com.phlimadev.loans.loan;

import br.com.phlimadev.loans.customer.CustomerDTO;
import br.com.phlimadev.loans.customer_loans.CustomerLoansDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {
    private List<LoanEnum> loans = new ArrayList<>();

    public void assessWhetherTheSalaryIsEqualToOrLessThan3000(BigDecimal income) {
        if (income.compareTo(BigDecimal.valueOf(3000)) <= 0) {
            loans.add(LoanEnum.PERSONAL);
            loans.add(LoanEnum.GUARANTEED);
        }
    }

    public boolean assessWhetherTheSalarIsBetween3000And5000(BigDecimal income) {
        return income.compareTo(BigDecimal.valueOf(3000)) > 0 && income.compareTo(BigDecimal.valueOf(5000)) <= 0;
    }

    public void assessAgeAndLocation(Integer age, String location) {
        if (age < 30 && location.equalsIgnoreCase("SP")) {
            loans.add(LoanEnum.PERSONAL);
            loans.add(LoanEnum.GUARANTEED);
        }
    }

    public CustomerLoansDTO evaluateLoanRequest(CustomerDTO data) {
        Integer age = data.age();
        BigDecimal income = data.income();
        String location = data.location();

        assessWhetherTheSalaryIsEqualToOrLessThan3000(income);
        if (assessWhetherTheSalarIsBetween3000And5000(income)) {
            assessAgeAndLocation(age, location);
        }
    }
}