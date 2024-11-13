
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `alumnos` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `alumnos`;
DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumno` (
  `nro_libreta` int NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) NOT NULL,
  `dni` bigint DEFAULT NULL,
  `fecha_nacimiento` date NOT NULL,
  `genero` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`nro_libreta`),
  UNIQUE KEY `UK_i7t6tk197mqapln1teornwd68` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES (21,'Pérez',12345678,'1995-05-15','Masculino','Juan','La Plata'),(22,'González',87654321,'1994-07-20','Femenino','Ana','Mar del Plata'),(23,'Rodríguez',23456789,'1993-03-30','Masculino','Luis','Bahía Blanca'),(24,'Fernández',34567890,'1995-12-25','Femenino','María','Tandil'),(25,'Lopez',45678901,'1996-01-10','Masculino','Carlos','Necochea'),(26,'Sánchez',56789012,'1992-09-15','Femenino','Lucía','Pilar'),(27,'García',67890123,'1994-04-04','Masculino','Martín','San Nicolás'),(28,'Pérez',78901234,'1991-11-11','Femenino','Valeria','San Fernando'),(29,'Díaz',89012345,'1995-06-20','Masculino','Fernando','Zárate'),(30,'Álvarez',90123456,'1990-08-18','Femenino','Silvia','Avellaneda'),(31,'Torres',11111111,'1995-05-15','Masculino','Joaquín','Lanús'),(32,'Ramírez',22222222,'1994-07-20','Femenino','Claudia','Morón'),(33,'Ponce',33333333,'1993-03-30','Masculino','Diego','Lomas de Zamora'),(34,'Castro',44444444,'1995-12-25','Femenino','Carla','Quilmes'),(35,'Cabrera',55555555,'1996-01-10','Masculino','Nicolás','Berazategui'),(36,'Mendoza',66666666,'1992-09-15','Femenino','Romina','Esteban Echeverría'),(37,'Sosa',77777777,'1994-04-04','Masculino','Lucas','Ituzaingó'),(38,'Ríos',88888888,'1991-11-11','Femenino','Cecilia','Lomas de Zamora'),(39,'Vargas',99999999,'1995-06-20','Masculino','Alberto','Morón'),(40,'Cano',10101010,'1990-08-18','Femenino','Inés','Morón'),(41,'Rodríguez',23456129,'1993-03-30','Masculino','Adan','Bahía Blanca');
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;
DROP TABLE IF EXISTS `alumno_carrera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumno_carrera` (
  `id_carrera` int NOT NULL,
  `alumno_nro_libreta` int NOT NULL,
  `anio_inscripcion` int NOT NULL,
  `finalizada` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_carrera`,`alumno_nro_libreta`),
  KEY `FKp9bxlgrd3iat6w70bx417f0wy` (`alumno_nro_libreta`),
  CONSTRAINT `FKp9bxlgrd3iat6w70bx417f0wy` FOREIGN KEY (`alumno_nro_libreta`) REFERENCES `alumno` (`nro_libreta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `alumno_carrera` WRITE;
/*!40000 ALTER TABLE `alumno_carrera` DISABLE KEYS */;
INSERT INTO `alumno_carrera` VALUES (21,25,2024,0),(21,38,2023,0),(22,21,2023,0),(23,21,2024,0),(24,23,2024,0),(24,25,2023,0),(26,21,2024,0),(26,22,2024,0),(27,32,2023,0),(28,34,2020,0),(29,37,2023,0),(30,23,2024,0),(30,40,2021,0);
/*!40000 ALTER TABLE `alumno_carrera` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

