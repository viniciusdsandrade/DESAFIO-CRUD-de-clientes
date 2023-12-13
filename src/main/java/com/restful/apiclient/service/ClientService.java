package com.restful.apiclient.service;

import com.restful.apiclient.dto.ClientDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ClientService {
    /*
    1 - Busca paginada de recursos
    2 - Busca de recurso por id
    3 - Inserir novo recurso
    4 - Atualizar recurso
    5 - Deletar recurso
    */
    
    ClientDTO findProductById(Long id);

    @Transactional(readOnly = true)
    List<ClientDTO> findAll(Pageable pageable);

    @Transactional(readOnly = true)
    ClientDTO save(ClientDTO clientDTO);

    @Transactional
    ClientDTO update(Long id, ClientDTO clientDTO);

    void delete(Long id);
}