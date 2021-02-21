package com.ecomers.api.restaurants.persistence.crud;


import com.ecomers.api.restaurants.persistence.entity.TarifaComercio;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TarifaComercioCrudRepository extends CrudRepository<TarifaComercio,Integer> {
    Optional<List<TarifaComercio>>  findByIdComercioOrderByIdTarifaAsc(int commerceId);
}
