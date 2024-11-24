package com.example.blogging.controller;

import com.example.blogging.DTO.RolDTO;
import com.example.blogging.model.Rol;
import com.example.blogging.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public List<Rol> getAllRoles() {
        return rolService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> getRolById(@PathVariable Long id) {
        Optional<Rol> rol = rolService.findById(id);
        return rol.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Rol createRol(@RequestBody RolDTO rolDTO) {
        Rol rol = new Rol();
        rol.setName(rolDTO.getName());
        return rolService.save(rol);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rol> updateRol(@PathVariable Long id, @RequestBody RolDTO rolDTO) {
        Optional<Rol> rol = rolService.findById(id);

        if (rol.isPresent()) {
            Rol updatedRol = rol.get();
            updatedRol.setName(rolDTO.getName());
            return ResponseEntity.ok(rolService.save(updatedRol));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRol(@PathVariable Long id) {
        if (rolService.existsById(id)) {
            rolService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}