package com.restful.apiclient.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private Long id;

    @NotBlank(message = "O nome não pode ser vazio.")
    @Size(min = 5, max = 100, message = "O nome deve ter entre 5 e 100 caracteres.")
    private String name;

    @NotBlank(message = "O CPF não pode ser vazio.")
    @CPF(message = "O CPF informado não é válido.")
    private String cpf;

    @NotNull(message = "A renda não pode ser vazia.")
    @PositiveOrZero(message = "A renda não pode ser negativa.")
    @Column(columnDefinition = "DECIMAL(10,2)")
    private Double income;

    @NotNull(message = "A data de nascimento não pode ser vazia.")
    @PastOrPresent(message = "A data de nascimento não pode ser futura.")
    @Column(columnDefinition = "DATE")
    private LocalDate birthDate;

    @NotNull(message = "O número de filhos não pode ser vazio.")
    @PositiveOrZero(message = "O número de filhos não pode ser negativo.")
    @Column(columnDefinition = "TINYINT UNSIGNED")
    private Integer children;

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;

        ClientDTO that = (ClientDTO) o;

        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.cpf, that.cpf) &&
                Objects.equals(this.income, that.income) &&
                Objects.equals(this.birthDate, that.birthDate) &&
                Objects.equals(this.children, that.children);
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int hash = 1;

        hash *= prime + (this.getId() == null ? 0 : this.getId().hashCode());
        hash *= prime + (this.getName() == null ? 0 : this.getName().hashCode());
        hash *= prime + (this.getCpf() == null ? 0 : this.getCpf().hashCode());
        hash *= prime + (this.getIncome() == null ? 0 : this.getIncome().hashCode());
        hash *= prime + (this.getBirthDate() == null ? 0 : this.getBirthDate().hashCode());
        hash *= prime + (this.getChildren() == 0 ? 0 : this.getChildren());

        if (hash < 0)
            hash *= -1;

        return hash;
    }

    //construtor de cópia
    public ClientDTO(ClientDTO clientDTO) {

        this.id = clientDTO.id;
        this.name = clientDTO.name;
        this.cpf = clientDTO.cpf;
        this.income = clientDTO.income;
        this.birthDate = clientDTO.birthDate;
        this.children = clientDTO.children;
    }
}