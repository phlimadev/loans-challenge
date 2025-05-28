package br.com.phlimadev.loans.customer_loans;

import br.com.phlimadev.loans.customer.CustomerDTO;
import br.com.phlimadev.loans.loan.LoanService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer-loans")
public class CustomerLoansController {
    private final LoanService loanService;

    public CustomerLoansController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    public ResponseEntity<CustomerLoansDTO> evaluateLoanRequest(@RequestBody @Valid CustomerDTO body) {
        return ResponseEntity.ok(loanService.evaluateLoanRequest(body));
    }
}