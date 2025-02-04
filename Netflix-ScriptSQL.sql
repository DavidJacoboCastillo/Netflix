drop database if exists netflix;

create database netflix;
use netflix;

create table usuario (
	id int unsigned auto_increment primary key,
    nombre varchar(100),
    correo_electronico varchar(50),
    fecha_registro date,
    fecha_nacimiento date,
    estado_subscripcion enum('activado', 'cancelado'),
    plan_subscripcion enum('premium', 'estandar', 'basico')
);

create table perfil (
	id int unsigned auto_increment primary key,
    nombre varchar (100),
    idioma varchar(100),
    id_usuario int unsigned,
    foreign key (id_usuario) references usuario (id)
);

create table contenido (
	id int unsigned auto_increment primary key,
    titulo varchar(40),
    pais_origen varchar(50),
    sinopsis varchar(200),
    estreno date
);

create table serie (
	id int unsigned auto_increment primary key,
    estado_de_emision enum('activo', 'finalizado', 'cancelado'),
    id_contenido int unsigned,
    foreign key (id_contenido) references contenido (id)
);
create table pelicula (
	id int unsigned auto_increment primary key,
    duracion int,
	id_contenido int unsigned,
    foreign key (id_contenido) references contenido (id)
);

create table temporada (
	id int unsigned auto_increment primary key,
    numero_temporada int,
    estreno date,
    sinopsis varchar(200),
    id_serie int unsigned,
    foreign key (id_serie) references serie (id)
);

create table episodio (
	id int unsigned auto_increment primary key,
    titulo varchar(100),
    duracion int,
    numero_episodio int,
    sinopsis varchar(200),
    id_temporada int unsigned,
    foreign key (id_temporada) references temporada (id)
);

create table genero (
	id int unsigned auto_increment primary key,
    descripcion varchar(200),
    nombre varchar(100)
);
create table persona (
	id int unsigned auto_increment primary key,
    nombre varchar(100),
    fecha_nacimiento date,
    nacionalidad varchar(100),
    biografia varchar(300)
);

create table director (
	id int unsigned auto_increment primary key,
    numero_premios int,
    estilo varchar(100)
);

create table actor (
	id int unsigned auto_increment primary key,
    numero_premios int,
    tipo enum('protagonista','secundario', 'doblaje')
);


create table perfil_contenido (
	id_perfil int unsigned,
    foreign key (id_perfil) references perfil (id),
    id_contenido int unsigned,
    foreign key (id_contenido) references contenido (id),
    primary key (id_perfil, id_contenido)
);

create table contenido_genero (
	id_genero int unsigned,
    foreign key (id_genero) references genero (id),
    id_contenido int unsigned,
    foreign key (id_contenido) references contenido (id),
	primary key (id_genero, id_contenido)

);

create table contenido_persona (
	id_persona int unsigned,
    foreign key (id_persona) references persona (id),
    id_contenido int unsigned,
    foreign key (id_contenido) references contenido (id),
	primary key (id_persona, id_contenido)

);


INSERT INTO usuario (nombre, correo_electronico, fecha_registro, fecha_nacimiento, estado_subscripcion, plan_subscripcion) 
VALUES 
('Juan Pérez', 'juan.perez@email.com', '2023-05-10', '1990-03-25', 'activado', 'premium'),
('María López', 'maria.lopez@email.com', '2022-11-15', '1985-07-19', 'activado', 'estandar'),
('Carlos Sánchez', 'carlos.sanchez@email.com', '2024-01-20', '1998-06-10', 'cancelado', 'basico'),
('Ana Gómez', 'ana.gomez@email.com', '2023-08-05', '1995-02-12', 'activado', 'premium'),
('David Ramírez', 'david.ramirez@email.com', '2021-09-30', '1987-11-03', 'cancelado', 'estandar'),
('Laura Herrera', 'laura.herrera@email.com', '2022-12-25', '1993-04-15', 'activado', 'basico'),
('Fernando Torres', 'fernando.torres@email.com', '2023-06-17', '2000-01-08', 'activado', 'premium'),
('Gabriela Silva', 'gabriela.silva@email.com', '2024-02-01', '1992-09-23', 'activado', 'estandar'),
('Ricardo Castro', 'ricardo.castro@email.com', '2023-04-12', '1996-12-30', 'cancelado', 'basico'),
('Sofía Mendoza', 'sofia.mendoza@email.com', '2023-07-28', '1999-05-14', 'activado', 'premium');


INSERT INTO perfil (nombre, idioma, id_usuario) VALUES 
('Juan', 'Español', 1),
('María', 'Inglés', 2),
('Carlos', 'Español', 3),
('Ana', 'Francés', 4),
('David', 'Español', 5),
('Laura', 'Portugués', 6),
('Fernando', 'Español', 7),
('Gabriela', 'Inglés', 8),
('Ricardo', 'Italiano', 9),
('Sofía', 'Español', 10);


INSERT INTO contenido (titulo, pais_origen, sinopsis, estreno) VALUES 
('El Viaje Eterno', 'España', 'Una odisea de aventuras a través del tiempo.', '2023-06-15'),
('CyberMinds', 'Estados Unidos', 'Un futuro donde la IA domina la humanidad.', '2024-02-10'),
('Amor en la Tormenta', 'Francia', 'Un romance imposible en medio de un huracán.', '2022-09-21'),
('El Último Guardián', 'México', 'Un héroe ancestral protege su legado.', '2023-12-05'),
('Bajo la Niebla', 'Reino Unido', 'Un thriller de misterio en una ciudad oscura.', '2021-11-30'),
('Código Fantasma', 'Japón', 'Hackers descubren una conspiración mundial.', '2024-03-12'),
('Destino Perdido', 'Brasil', 'Un grupo de viajeros queda atrapado en otra dimensión.', '2022-07-19'),
('La Heredera', 'Argentina', 'Una joven descubre un secreto familiar inesperado.', '2023-10-01'),
('Planeta Rojo', 'Canadá', 'Exploradores intentan colonizar Marte.', '2024-01-20'),
('Reflejos', 'Alemania', 'Un espejo misterioso revela futuros alternativos.', '2023-05-08');


INSERT INTO serie (estado_de_emision, id_contenido) VALUES 
('activo', 1),
('finalizado', 2),
('cancelado', 3),
('activo', 4),
('finalizado', 5);

INSERT INTO pelicula (duracion, id_contenido) VALUES 
(120, 6),
(135, 7),
(110, 8),
(95, 9),
(145, 10);

INSERT INTO temporada (numero_temporada, estreno, sinopsis, id_serie) VALUES 
(1, '2022-06-01', 'El comienzo de una historia épica.', 1),
(2, '2023-06-05', 'Nuevas aventuras y desafíos para los protagonistas.', 1),
(1, '2021-09-15', 'Una serie de eventos inesperados sacude el mundo.', 2),
(1, '2023-02-10', 'Presentación de los personajes y su conflicto principal.', 3),
(2, '2024-03-12', 'El desenlace de la historia con giros impactantes.', 3),
(1, '2020-11-20', 'El inicio de una investigación que cambiará todo.', 4),
(2, '2021-12-15', 'Nuevas revelaciones salen a la luz.', 4),
(3, '2023-01-10', 'La batalla final contra los antagonistas.', 4),
(1, '2019-07-08', 'Un misterio se desarrolla en un pueblo tranquilo.', 5);

INSERT INTO episodio (titulo, duracion, numero_episodio, sinopsis, id_temporada) VALUES 
('El Comienzo', 45, 1, 'Los personajes son introducidos en un nuevo mundo.', 1),
('El Despertar', 50, 2, 'Un evento inesperado cambia el rumbo de la historia.', 1),
('Enemigos Ocultos', 42, 3, 'Se revelan secretos del pasado.', 1),

('Un Nuevo Inicio', 48, 1, 'La historia da un giro inesperado.', 2),
('Caos y Esperanza', 55, 2, 'Las relaciones entre personajes se complican.', 2),

('Primer Contacto', 40, 1, 'Los protagonistas descubren una amenaza inminente.', 3),
('El Plan', 52, 2, 'Estrategias para vencer a sus enemigos.', 3),
('La Batalla Final', 60, 3, 'El enfrentamiento decisivo.', 3);

INSERT INTO genero (descripcion, nombre) VALUES 
('Películas y series de ciencia ficción con tecnologías avanzadas y mundos futuristas.', 'Ciencia Ficción'),
('Historias de detectives, crímenes y misterios por resolver.', 'Misterio'),
('Series y películas llenas de acción, combates y explosiones.', 'Acción'),
('Narraciones de amor y relaciones emocionales.', 'Romance'),
('Películas y series con momentos divertidos y humorísticos.', 'Comedia'),
('Historias de terror y suspenso que buscan asustar al espectador.', 'Terror'),
('Películas animadas dirigidas a todas las edades.', 'Animación'),
('Historias basadas en hechos reales o biográficas.', 'Drama'),
('Narrativas fantásticas con elementos mágicos y criaturas míticas.', 'Fantasía');


INSERT INTO persona (nombre, fecha_nacimiento, nacionalidad, biografia) VALUES 
('Christopher Nolan', '1970-07-30', 'Británica', 'Director de cine conocido por películas como Inception y The Dark Knight.'),
('Quentin Tarantino', '1963-03-27', 'Estadounidense', 'Director y guionista famoso por Pulp Fiction y Kill Bill.'),
('Natalie Portman', '1981-06-09', 'Israelí', 'Actriz ganadora del Oscar por Black Swan y reconocida por su papel en Star Wars.'),
('Leonardo DiCaprio', '1974-11-11', 'Estadounidense', 'Actor galardonado con el Oscar por The Revenant y protagonista de Titanic.'),
('Scarlett Johansson', '1984-11-22', 'Estadounidense', 'Actriz famosa por su papel de Black Widow en el Universo Marvel.'),
('Hayao Miyazaki', '1941-01-05', 'Japonesa', 'Director de animación, creador de películas icónicas como El viaje de Chihiro.'),
('Guillermo del Toro', '1964-10-09', 'Mexicana', 'Director de cine especializado en fantasía y terror, conocido por El laberinto del fauno.'),
('Emma Watson', '1990-04-15', 'Británica', 'Actriz reconocida por su papel como Hermione en la saga de Harry Potter.'),
('Tom Hanks', '1956-07-09', 'Estadounidense', 'Actor famoso por Forrest Gump y Náufrago.'),
('Penélope Cruz', '1974-04-28', 'Española', 'Actriz española reconocida en Hollywood y ganadora del Oscar.');


INSERT INTO director (numero_premios, estilo) VALUES 
(5, 'Surrealismo'), 
(3, 'Ciencia Ficción'),
(6, 'Drama'), 
(8, 'Terror'),
(10, 'Comedia'),
(4, 'Documental');

INSERT INTO actor (numero_premios, tipo) VALUES 
(8, 'protagonista'), 
(4, 'secundario'), 
(5, 'doblaje'),
(7, 'protagonista'),
(9, 'secundario'),
(11, 'doblaje');

INSERT INTO perfil_contenido (id_perfil, id_contenido) VALUES 
(1, 1), 
(1, 2),
(2, 3), 
(3, 4), 
(4, 5), 
(2, 1); 

INSERT INTO contenido_genero (id_genero, id_contenido) VALUES 
(1, 1), 
(4, 2), 
(1, 3), 
(2, 4), 
(2, 5),
(3, 4);

INSERT INTO contenido_persona (id_persona, id_contenido) VALUES 
(1, 1), 
(2, 1),
(3, 4),
(4, 5), 
(5, 2);