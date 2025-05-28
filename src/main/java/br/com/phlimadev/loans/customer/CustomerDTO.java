package br.com.phlimadev.loans.customer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;

public record CustomerDTO(
        @NotNull
        Integer age,
        @NotBlank @CPF
        String cpf,
        @NotBlank
        String name,
        @NotNull
        BigDecimal income,
        @NotBlank
        String location
) {
}
