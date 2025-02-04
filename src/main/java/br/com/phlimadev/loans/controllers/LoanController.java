package br.com.phlimadev.loans.controllers;

import br.com.phlimadev.loans.dtos.CustomerDTO;
import br.com.phlimadev.loans.dtos.ResponseDTO;
import br.com.phlimadev.loans.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer-loans")
public class LoanController {
    @Autowired
    private LoanService loanService;

    @PostMapping
    public ResponseEntity<ResponseDTO> releaseCustomerLoans(@RequestBody CustomerDTO customerDTO) {
        ResponseDTO response = loanService.releaseCustomerLoans(customerDTO);
        return ResponseEntity.ok(response);
    }
}
