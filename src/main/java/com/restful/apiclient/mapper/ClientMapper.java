package com.restful.apiclient.mapper;

import com.restful.apiclient.dto.ClientDTO;
import com.restful.apiclient.entity.Client;

public class ClientMapper {
    
    public static ClientDTO mapToClientDTO(Client client){
        return new ClientDTO(
                client.getId(),
                client.getName(),
                client.getCPF(),
                client.getIncome(),
                client.getBirthDate(),
                client.getChildren()
        );
    }
    
    public static Client mapToClient(ClientDTO clientDTO){
        return new Client(
                clientDTO.getId(),
                clientDTO.getName(),
                clientDTO.getCPF(),
                clientDTO.getIncome(),
                clientDTO.getBirthDate(),
                clientDTO.getChildren()
        );
    }
}
