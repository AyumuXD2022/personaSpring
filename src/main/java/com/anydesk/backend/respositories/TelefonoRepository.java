package com.anydesk.backend.respositories;

import com.anydesk.backend.entities.Telefono;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefonoRepository extends JpaRepository<Telefono,Long> {
}
