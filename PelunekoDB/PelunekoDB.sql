CREATE TABLE Raza (
    idRaza INT NOT NULL AUTO_INCREMENT,
    raza VARCHAR(50) NOT NULL,
    CONSTRAINT pk_idRaza PRIMARY KEY (idRaza)
);

CREATE TABLE VoluntariosCentro (
    DNIVoluntario VARCHAR(15) NOT NULL,
    NombreVoluntario VARCHAR(50) NOT NULL,
    Apellido1Voluntario VARCHAR(50) NOT NULL,
    Apellido2Voluntario VARCHAR(50),
    DireccionVoluntario VARCHAR(100),
    LocalidadVoluntario VARCHAR(50),
    CodigoPostalVoluntario VARCHAR(10),
    CONSTRAINT pk_dniVoluntario PRIMARY KEY (DNIVoluntario),
);

CREATE TABLE Animales (
    idAnimal INT NOT NULL AUTO_INCREMENT ,
    tipoAnimal VARCHAR(50) NOT NULL,
    Peso DECIMAL(5,2),
    Estado VARCHAR(50),
    imagen VARCHAR(255),
    idRaza INT NOT NULL,
    DNIVoluntario VARCHAR(15),
    CONSTRAINT pk_idAnimal PRIMARY KEY (idAnimal),
    CONSTRAINT fk_idRaza FOREIGN KEY (idRaza) REFERENCES Raza(idRaza),
    CONSTRAINT fk_dniVoluntario FOREIGN KEY (DNIVoluntario) REFERENCES VoluntariosCentro(DNIVoluntario)
);

CREATE TABLE NuevosDuenos (
    DNI VARCHAR(15) NOT NULL,
    Nombre VARCHAR(50) NOT NULL,
    Apellido1 VARCHAR(50) NOT NULL,
    Apellido2 VARCHAR(50),
    Direccion VARCHAR(100),
    Localidad VARCHAR(50),
    CodigoPostal VARCHAR(10),
    CONSTRAINT pk_dniNuevoPropietarios PRIMARY KEY (DNI)
);

CREATE TABLE LoginCentros (
    idVoluntario VARCHAR(15) NOT NULL,
    Passwd VARCHAR(100) NOT NULL,
    Rol VARCHAR(20) NOT NULL,
    CONSTRAINT fk_voluntarioID FOREIGN KEY (idVoluntario) REFERENCES VoluntariosCentro(DNIVoluntario),
    CONSTRAINT pk_voluntarioID PRIMARY KEY (idVoluntario)
);

CREATE TABLE Adopciones (
    idAnimal INT NOT NULL,
    DNI VARCHAR(15) NOT NULL,
    FechaAdopcion DATE,
    CONSTRAINT pk_Adopciones PRIMARY KEY (idAnimal, DNI),
    CONSTRAINT fk_animalId FOREIGN KEY (idAnimal) REFERENCES Animales(idAnimal),
    CONSTRAINT fk_propietarioIdFOREIGN KEY (DNI) REFERENCES NuevosDuenos(DNI)
);


INSERT INTO Raza (raza) VALUES 
('Labrador'),
('Pastor Alemán'),
('Persa'),
('Siames'),
('Mestizo'),
('Golden Retriever'),
('Bengala'),
('Bulldog'),
('Husky Siberiano'),
('Chihuahua');


INSERT INTO VoluntariosCentro (DNIVoluntario, NombreVoluntario, Apellido1Voluntario, Apellido2Voluntario, DireccionVoluntario, LocalidadVoluntario, CodigoPostalVoluntario) VALUES 
('12345678A', 'Laura', 'Martínez', 'Gómez', 'Calle Sol 5', 'Madrid', '28001'),
('87654321B', 'Carlos', 'Ruiz', 'López', 'Avda. Luna 10', 'Barcelona', '08010'),
('23456789C', 'Marta', 'Fernández', 'Rodríguez', 'Calle Mar 12', 'Málaga', '29001'),
('34567890D', 'Luis', 'Torres', 'Serrano', 'Calle Norte 8', 'Bilbao', '48001'),
('45678901E', 'Elena', 'Navarro', 'García', 'Calle Río 22', 'Zaragoza', '50001');


INSERT INTO LoginCentros (idVoluntario, Passwd, Rol) VALUES 
('12345678A', 'laura123', 'Admin'),
('87654321B', 'carlos456', 'Voluntario'),
('23456789C', 'marta123', 'Voluntario'),
('34567890D', 'luis123', 'Voluntario'),
('45678901E', 'elena123', 'Admin');


INSERT INTO Animales (tipoAnimal, Peso, Estado, imagen, idRaza, DNIVoluntario) VALUES 
('Perro', 23.5, 'Saludable', 'perro1.jpg', 1, '12345678A'),
('Gato', 4.2, 'Vacunado', 'gato1.jpg', 3, '12345678A'),
('Perro', 12.0, 'En tratamiento', 'perro2.jpg', 2, '87654321B'),
('Gato', 3.8, 'Saludable', 'gato2.jpg', 4, '87654321B'),
('Perro', 18.0, 'Vacunado', 'perro3.jpg', 6, '23456789C'),
('Gato', 5.1, 'En tratamiento', 'gato3.jpg', 7, '23456789C'),
('Perro', 22.7, 'Saludable', 'perro4.jpg', 8, '34567890D'),
('Perro', 3.5, 'Saludable', 'perro5.jpg', 10, '34567890D'),
('Gato', 3.9, 'Vacunado', 'gato4.jpg', 4, '45678901E'),
('Perro', 25.2, 'En tratamiento', 'perro6.jpg', 9, '45678901E');


INSERT INTO NuevosDuenos (DNI, Nombre, Apellido1, Apellido2, Direccion, Localidad, CodigoPostal) VALUES 
('11223344C', 'Ana', 'Sánchez', 'Pérez', 'Calle Olivo 3', 'Sevilla', '41001'),
('55667788D', 'Jorge', 'Ramírez', 'Díaz', 'Plaza Mayor 12', 'Valencia', '46001'),
('99887766E', 'Paula', 'Castro', 'Moreno', 'Calle Cedro 10', 'Alicante', '03001'),
('88776655F', 'David', 'López', 'Jiménez', 'Avda. del Mar 5', 'Córdoba', '14001'),
('77665544G', 'Sara', 'Martín', 'Nieto', 'Calle Verde 15', 'Granada', '18001'),
('66554433H', 'Manuel', 'Iglesias', 'Herrera', 'Paseo Sur 9', 'Toledo', '45001');


INSERT INTO Adopciones (idAnimal, DNI, FechaAdopcion) VALUES 
(1, '11223344C', '2024-11-15'),
(2, '55667788D', '2024-12-05'),
(3, '99887766E', '2025-01-10'),
(4, '88776655F', '2025-01-20'),
(5, '77665544G', '2025-02-05'),
(6, '66554433H', '2025-02-15'),
(7, '11223344C', '2025-03-01');






