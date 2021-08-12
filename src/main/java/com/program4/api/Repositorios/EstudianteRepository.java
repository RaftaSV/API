package com.program4.api.Repositorios;

import com.program4.api.Entidades.Estudiantes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiantes,Integer > {

}
