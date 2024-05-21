package com.example.crud.service;

import com.example.crud.entity.Celular;
import com.example.crud.repository.CelularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CelularService {
    @Autowired
    private CelularRepository repository;

    public Celular saveCelular(Celular celular){
        return repository.save(celular);
    }

    public List<Celular> saveCelulares(List<Celular> celulares){
        return repository.saveAll(celulares);
    }

    public List<Celular> getCelulares(){
        return repository.findAll();
    }

    public Celular getCelularById(int id){
        return repository.findById(id).orElse(null);
    }

    public Celular getCelularByMarca(String marca){
        return repository.findByMarca(marca);
    }

    public String deleteCelular(int id){
        repository.deleteById(id);
        return "Celular eliminado: " + id;
    }

    public Celular updateCelular(Celular celular){
        Celular existingCelular = repository.findById(celular.getId()).orElse(null);
        if (existingCelular != null) {
            existingCelular.setMarca(celular.getMarca());
            existingCelular.setSerial(celular.getSerial());
            existingCelular.setFechaDeCompra(celular.getFechaDeCompra());
            existingCelular.setAnoDeLanzamiento(celular.getAnoDeLanzamiento());
            existingCelular.setPrecio(celular.getPrecio());
            existingCelular.setSistemaOperativo(celular.getSistemaOperativo());
            existingCelular.setGama(celular.getGama());
        }
        return repository.save(existingCelular);
    }
}

