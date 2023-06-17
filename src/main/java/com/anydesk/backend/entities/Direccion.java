package com.anydesk.backend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Table(name = "direcciones")
@Entity
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion", nullable = false)
    private Long idDireccion;

    //@Pattern(regexp = "[a-zA-Z1-9À-ÖØ-öø-ÿ]+\\.?(( |\\-)[a-zA-Z1-9À-ÖØ-öø-ÿ]+\\.?)* (((#|[nN][oO]\\.?) ?)?\\d{1,4}(( ?[a-zA-Z0-9\\-]+)+)?)",
        //    message = "Escribe bien tu calle")
    @NotBlank(message = "No puede estar vacia")
    @Column(nullable = false)
    private String calle;

    //@Pattern(regexp = "[a-zA-Z1-9À-ÖØ-öø-ÿ]+\\.?(( |\\-)[a-zA-Z1-9À-ÖØ-öø-ÿ]+\\.?)*",
      //      message = "Escribe bien tu calle")
    @NotBlank(message = "No puede estar vacia")
    @Column(nullable = false)
    private String municipio;


}
