package com.anydesk.backend.respositories;

import com.anydesk.backend.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona,Long> {
}
