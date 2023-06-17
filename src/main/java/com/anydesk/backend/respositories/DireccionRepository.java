package com.anydesk.backend.respositories;

import com.anydesk.backend.entities.Direccion;
import com.anydesk.backend.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DireccionRepository extends JpaRepository<Direccion,Long> {

}
