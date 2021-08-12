package com.program4.api.Controladores;

import com.program4.api.Entidades.Estudiantes;
import com.program4.api.Repositorios.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EstudianteController {

    //Inyectar dependencias Estudianterepository
    @Autowired
    EstudianteRepository repo;

    @GetMapping("inicio")
    @ResponseBody
    public Estudiantes inicio() {
Estudiantes estu;
estu = repo.findById(1).get();

        return estu;
    }

    @GetMapping("/lista")
    private List<Estudiantes>lista() {
        return repo.findAll();
    }

    @PostMapping("/registro")
    @ResponseBody
    public Estudiantes nuevo(@RequestBody Estudiantes estu) {
        repo.save(estu);
        return estu;

    }



    @DeleteMapping("/eliminar/{id}")
    public String Eliminar(@PathVariable("id") int id) {
        Estudiantes estu = repo.findById(id).get();
        repo.delete(estu);
        return "ELIMINADO";
    }

    @PutMapping("/actualizar/{id}")
    public  Estudiantes  Actualizar (@PathVariable(value = "id") int id,@RequestBody Estudiantes estu){
        Estudiantes estudiante = repo.findById(id).get();
        estudiante.setDireccion(estu.getDireccion());
        repo.save(estudiante);
        return estudiante;
    }
}
