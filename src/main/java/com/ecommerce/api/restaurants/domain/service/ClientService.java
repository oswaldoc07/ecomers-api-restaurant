package com.ecommerce.api.restaurants.domain.service;

import com.ecommerce.api.restaurants.domain.dto.Client;
import com.ecommerce.api.restaurants.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public Optional<List<Client>> getAll() {
        return repository.getAll();
    }

    public Optional<Client> getClientById(int id) {
        return repository.getClientById(id);
    }

    public Optional<Client> getClientByEmailOrPhone(String email,String phone) {

        Optional<Client> dto = repository.getClientByEmail(email);
        if(dto.isPresent()){
            return  dto;
        }else {
            if(phone!=null){
                return repository.getClientByPhone(phone);
            }
            return Optional.empty();
        }


    }

    public Optional<Client>  save(Client dto) {
        Optional<Client> client = this.getClientByEmailOrPhone(dto.getEmail(),dto.getPhoneNumber());
        if(client.isPresent()){
            return client;
        }else{
            return repository.save(dto);
        }

    }

    public Optional<Client>  update(Client dto) {
        return repository.update(dto);
    }
    public boolean delete(int id) {
        return getClientById(id).map(product -> {
            repository.delete(id);
            return true;
        }).orElse(false);
    }

}
