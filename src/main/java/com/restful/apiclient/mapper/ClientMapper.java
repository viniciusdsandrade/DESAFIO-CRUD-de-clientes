package com.restful.apiclient.mapper;

import com.restful.apiclient.dto.ClientDTO;
import com.restful.apiclient.entity.Client;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class ClientMapper {

    @Contract("_ -> new")
    public static @NotNull ClientDTO mapToClientDTO(@NotNull Client client) {
        return new ClientDTO(
                client.getId(),
                client.getName(),
                client.getCpf(),
                client.getIncome(),
                client.getBirthDate(),
                client.getChildren()
        );
    }

    @Contract("_ -> new")
    public static @NotNull Client mapToClient(@NotNull ClientDTO clientDTO) {
        return new Client(
                clientDTO.getId(),
                clientDTO.getName(),
                clientDTO.getCpf(),
                clientDTO.getIncome(),
                clientDTO.getBirthDate(),
                clientDTO.getChildren()
        );
    }
}
