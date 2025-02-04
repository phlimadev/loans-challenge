package br.com.phlimadev.loans.dtos;

import java.util.ArrayList;

public record ResponseDTO(String customer, ArrayList<LoanDTO> loans) {
}
