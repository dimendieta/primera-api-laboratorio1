CREATE TABLE IF NOT EXISTS Usuario(
    id SERIAL,
    username VARCHAR (100) NOT NULL,
    password VARCHAR (100) NOT NULL,
    PRIMARY KEY (id)

    );


CREATE TABLE IF NOT EXISTS Paciente(
  id SERIAL,
  cedula INT,
  name VARCHAR (100) NOT NULL,
  apellido VARCHAR (100) NOT NULL,
  age INT,
  tipo_sangre VARCHAR (100) NOT NULL,
  PRIMARY KEY (id)

  );

CREATE TABLE IF NOT EXISTS Servicios (
    id SERIAL,
    nombre_servicio VARCHAR (100) NOT NULL,
    costo VARCHAR (100) NOT NULL ,
    paciente_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (paciente_id) REFERENCES Paciente (id)
    );

CREATE TABLE IF NOT EXISTS Citas(
    id SERIAL,
    hora  VARCHAR (100) NOT NULL ,
    fecha VARCHAR (100) NOt NULL ,
    paciente_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (paciente_id) REFERENCES Paciente (id)
    );