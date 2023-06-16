package com.anydesk.backend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank; //Vacio o null
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern; ///Expresiones regulares
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
@Table(name = "personas")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona", nullable = false)
    private Long idPersona; // id

    @Column(nullable = false)
    @NotBlank(message = "No puede ir vacio")
    @Pattern(regexp = "[a-zA-ZÀ-ÖØ-öø-ÿ]+\\.?(( |\\-)[a-zA-ZÀ-ÖØ-öø-ÿ]+\\.?)*",
            message = "Nombre invalido")
    private String nombre;

    @Column(nullable = false)
    @NotBlank(message = "No puede ir vacio")
    @Pattern(regexp = "[a-zA-ZÀ-ÖØ-öø-ÿ]+\\.?(( |\\-)[a-zA-ZÀ-ÖØ-öø-ÿ]+\\.?)*",
             message = "Apellido invalido")
    private String apellido;

    @Column(nullable = false)
    @NotBlank(message = "No puede ir vacio")
    @Pattern(regexp = "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$",
            message = "Correo invalido")
    private String email;

    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull(message = "No puede ir vacio")
    private Date fechaNacimiento;

    @Column(name = "create_at", nullable = false)
    @CreationTimestamp //Se vas a crear al momento del registro
    private Date createAt;

    @Column(name = "update_at")
    private Date updateAt;

    @PreUpdate
    public void update(){
        this.updateAt = new Date();
    }
}
