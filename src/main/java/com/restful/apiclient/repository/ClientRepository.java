package com.restful.apiclient.repository;

import com.restful.apiclient.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    
    boolean existsByCPF(String CPF);
}
