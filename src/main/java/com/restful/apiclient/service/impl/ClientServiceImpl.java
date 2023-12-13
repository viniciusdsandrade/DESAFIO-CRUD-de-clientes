package com.restful.apiclient.service.impl;

import com.restful.apiclient.dto.ClientDTO;
import com.restful.apiclient.entity.Client;
import com.restful.apiclient.exception.CpfAlreadyExistsException;
import com.restful.apiclient.exception.ResourceNotFoundException;
import com.restful.apiclient.mapper.ClientMapper;
import com.restful.apiclient.repository.ClientRepository;
import com.restful.apiclient.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private static final Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDTO findProductById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client", "id", id));

        return ClientMapper.mapToClientDTO(client);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClientDTO> findAll(Pageable pageable) {
        Page<ClientDTO> clientDTOPage = clientRepository.findAll(pageable)
                .map(ClientMapper::mapToClientDTO);

        return clientDTOPage.getContent();
    }

    @Override
    @Transactional
    public ClientDTO save(ClientDTO clientDTO) {

        if (clientRepository.existsByCPF(clientDTO.getCPF()))
            throw new CpfAlreadyExistsException("CPF already exists: " + clientDTO.getCPF());

        Client client = ClientMapper.mapToClient(clientDTO);
        Client savedClient = clientRepository.save(client);

        return ClientMapper.mapToClientDTO(savedClient);
    }

    @Override
    @Transactional
    public ClientDTO update(Long id, ClientDTO clientDTO) {

        Client clientToUpdate = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client", "id", id));

        clientToUpdate.setName(clientDTO.getName());
        clientToUpdate.setCPF(clientDTO.getCPF());
        clientToUpdate.setIncome(clientDTO.getIncome());
        clientToUpdate.setBirthDate(clientDTO.getBirthDate());
        clientToUpdate.setChildren(clientDTO.getChildren());

        Client updatedClient = clientRepository.save(clientToUpdate);

        return ClientMapper.mapToClientDTO(updatedClient);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Long id) {

        try {
            clientRepository.deleteById(id);
            logger.info("Client deleted with success for ID: " + id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Client", "id", id);
        } catch (Exception err) {
            String message = String.format("Client not deleted for ID: %s.", id);
            logger.error(message, err);
            throw new DataIntegrityViolationException(message, err);
        }
    }
}
