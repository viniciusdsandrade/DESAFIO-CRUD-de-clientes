package com.restful.apiclient.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Client")
@Table(name = "tb_client", schema = "db_client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client_name")
    private String name;

    @Column(name = "client_cpf")
    private String CPF;

    @Column(name = "client_income")
    private Double income;

    @Column(name = "client_birth_date")
    private LocalDate birthDate;

    @Column(name = "client_children")
    private Integer Children;

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;

        Client that = (Client) o;

        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(CPF, that.CPF) &&
                Objects.equals(income, that.income) &&
                Objects.equals(birthDate, that.birthDate) &&
                Objects.equals(Children, that.Children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, CPF, income, birthDate, Children);
    }

    //Construtor de cópia
    public Client(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.CPF = client.getCPF();
        this.income = client.getIncome();
        this.birthDate = client.getBirthDate();
        this.Children = client.getChildren();
    }
}