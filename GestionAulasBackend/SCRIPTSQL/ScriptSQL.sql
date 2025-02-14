create database if not exists gestionaulas;

insert into `persona` values (1,'Sainz',55555555,'Carlos','DNI');
insert into `persona` values(2,'Hamilton',44444444,'Lewis','DNI');
insert into `persona` values(3,'Verstappen',33333333,'Max','DNI');

insert into `user` values('carlos@gmail.com', '$2a$10$lpeTNBUGJfHxsJNOkAF5IuS5eLZUOuL8vlHMd/9O0rL5Cb3rp.uk6','ADMIN','admin',1);
insert into `user` values('lewis@gmail.com', '$10$biCKEkkZ.J2MZwa3DeVfx.e6w/UKqWFbCV4tiyxvKuvVDkPuQkIvi','ADMINGENERAL','admingeneral',2);
insert into `user` values('max@gmail.com', '$2a$10$XrlKrxecoR6rr4aCwpVnJe.GKtXttVxSlrKv8VdtEjNx5hL7eNomy','ASSISTANT','assistant',3);

INSERT INTO `edificio` VALUES (1,'José Hernandez'),(2,'Scalabrini'),(3,'Ugarte'),(4,'Marechal'),(5,'Manzi'),(6,'Jaureche');
INSERT INTO `aula` VALUES (1,7,1),(2,6,1),(3,19,1),(4,21,1),(5,11,1),(6,1,2),(7,2,2),(8,7,3),(9,10,4),(10,19,2);
INSERT INTO `departamento` VALUES (1,'Desarrollo Productivo'),(2,'Humanidaes y arte'),(3,'Planificacion'),(4,'Salud Comunitaria');
INSERT INTO `carrera` VALUES (1,'Sistemas',1),(2,'Ferroviarias',1);
INSERT INTO `materia` VALUES (5,8604,'Matematica 2 - Plaul',1),(6,86042,'Matematica 2 - Loidi',1),(1,8600,'Programacion de Computadoras',1),(2,8601,'Organizacion de Computadoras',1),(3,8602,'Arquitectura de computadoras',1),(4,8603,'Matematica 1',1);
INSERT INTO `tradicional` VALUES (100,'Tiza',1,1),(50,'Tiza',1,2),(150,'Tiza',1,3),(50,'Fibron',0,4),(100,'Fibron',0,5),(150,'Fibron',0,6);
INSERT INTO `laboratorio` VALUES (10,70,7),(15,70,8),(10,50,9),(30,30,10);

INSERT INTO `espacio` (`fecha`, `libre`, `turno`, `aula_id`)
(
  SELECT 
    DATE_ADD('2025-03-01', INTERVAL seq DAY) AS fecha,
    b'1' AS libre,
    turno,
    aula_id
  FROM 
    (SELECT 0 seq UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 
     UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9 
     UNION SELECT 10 UNION SELECT 11 UNION SELECT 12 UNION SELECT 13 UNION SELECT 14 
     UNION SELECT 15 UNION SELECT 16 UNION SELECT 17 UNION SELECT 18 UNION SELECT 19 
     UNION SELECT 20 UNION SELECT 21 UNION SELECT 22 UNION SELECT 23 UNION SELECT 24 
     UNION SELECT 25 UNION SELECT 26 UNION SELECT 27 UNION SELECT 28 UNION SELECT 29 
     UNION SELECT 30 UNION SELECT 31) AS seq_table
  CROSS JOIN 
    (SELECT 'M' turno UNION SELECT 'T') AS turnos
  CROSS JOIN 
    (SELECT 1 aula_id UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 
     UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9 UNION SELECT 10) AS aulas
  WHERE 
    seq <= DATEDIFF('2025-04-01', '2025-03-01')
);