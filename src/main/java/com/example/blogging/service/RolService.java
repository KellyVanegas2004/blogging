package com.example.blogging.service;

import com.example.blogging.model.Rol;
import com.example.blogging.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public List<Rol> findAll() {
        return rolRepository.findAll();
    }

    public Optional<Rol> findById(Long id) {
        return rolRepository.findById(id);
    }

    public Rol save(Rol rol) {
        return rolRepository.save(rol);
    }

    public void deleteById(Long id) {
        rolRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return rolRepository.existsById(id);
    }

    public Optional<Rol> findByName(String name) {
        return rolRepository.findByName(name);
    }
}
