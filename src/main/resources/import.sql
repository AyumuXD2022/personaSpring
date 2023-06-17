INSERT INTO personaroger.telefonos(numero)VALUES('12345678910');
INSERT INTO personaroger.telefonos(numero)VALUES('12345678911');
INSERT INTO personaroger.direcciones(calle, municipio)VALUES('av balba', 'ecatepec');
INSERT INTO personaroger.direcciones(calle, municipio)VALUES('av chico', 'ecatepec');


INSERT INTO personaroger.personas(fecha_nacimiento, create_at, apellido, nombre,email,direccion_id,telefono_id)VALUES('1997-03-06', NOW(), 'apellido', 'nombre','mail@mail.com',1,2);
INSERT INTO personaroger.personas(fecha_nacimiento, create_at, apellido, nombre,email,direccion_id,telefono_id)VALUES('1997-03-07', NOW(), 'apellido2', 'nombre2','mail2@mail.com',2,1);