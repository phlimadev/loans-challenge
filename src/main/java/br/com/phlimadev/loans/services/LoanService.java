package br.com.phlimadev.loans.services;

import br.com.phlimadev.loans.dtos.CustomerDTO;
import br.com.phlimadev.loans.dtos.LoanDTO;
import br.com.phlimadev.loans.dtos.LoanType;
import br.com.phlimadev.loans.dtos.ResponseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LoanService {

    public ResponseDTO releaseCustomerLoans(CustomerDTO customerDTO) {
        ArrayList<LoanDTO> loans = validatingLoanTypes(customerDTO.age(), customerDTO.income(), customerDTO.location());
        return new ResponseDTO(customerDTO.name(), loans);
    }

    private ArrayList<LoanDTO> validatingLoanTypes(Integer age, Double income, String location) {
        ArrayList<LoanDTO> loans = new ArrayList<>();

        if (income <= 3000) {
            loans.add(new LoanDTO(LoanType.PERSONAL, 4));
            loans.add(new LoanDTO(LoanType.GUARANTEED, 3));
        }

        if ((income > 3000 && income < 5000) || (age < 30 && location.equalsIgnoreCase("SP"))) {
            loans.add(new LoanDTO(LoanType.PERSONAL, 4));
            loans.add(new LoanDTO(LoanType.GUARANTEED, 3));
        }

        if (income >= 5000) {
            loans.add(new LoanDTO(LoanType.CONSIGNMENT, 2));
        }

        return loans;
    }

}