package com.ecommerce.api.restaurants.persistence.mapper;

import com.ecommerce.api.restaurants.domain.dto.Client;
import com.ecommerce.api.restaurants.persistence.entity.Cliente;


import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface ClientMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "usuario.idUsuario", target = "userId"),
            @Mapping(source = "usuario.nombre", target = "displayName"),
            @Mapping(source = "usuario.correo", target = "email"),
            @Mapping(source = "usuario.celular", target = "phoneNumber"),
            @Mapping(source = "usuario.imagen", target = "photoURL"),
            @Mapping(source = "usuario.idRol", target = "role"),
            @Mapping(source = "usuario.activo", target = "active")
    })
    Client toClient(Cliente entity);
    List<Client> toClients(List<Cliente> entities);

    @InheritInverseConfiguration
    @Mapping(target = "ordenes", ignore = true)
    //@Mapping(target = "usuario", ignore = true)
    Cliente toCliente(Client dto);
}
