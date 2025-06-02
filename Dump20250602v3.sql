CREATE DATABASE  IF NOT EXISTS `bd-ejemplo` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bd-ejemplo`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: bd-ejemplo
-- ------------------------------------------------------
-- Server version	5.7.24-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS admin;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE admin (
  idAdmin int(11) NOT NULL AUTO_INCREMENT,
  Nombre varchar(45) DEFAULT NULL,
  Contrasena varchar(45) DEFAULT NULL,
  PRIMARY KEY (idAdmin)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES admin WRITE;
/*!40000 ALTER TABLE admin DISABLE KEYS */;
INSERT INTO admin VALUES (1,'pepe','123');
/*!40000 ALTER TABLE admin ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumnosbd`
--

DROP TABLE IF EXISTS alumnosbd;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE alumnosbd (
  idAlumnos int(11) NOT NULL AUTO_INCREMENT,
  Nombre varchar(45) DEFAULT NULL,
  `Apellido Paterno` varchar(45) DEFAULT NULL,
  `Apellido Materno` varchar(45) DEFAULT NULL,
  `Fecha Nacimiento` date DEFAULT NULL,
  Correo varchar(45) DEFAULT NULL,
  Telefono varchar(15) DEFAULT NULL,
  Direccion varchar(45) DEFAULT NULL,
  Grado varchar(45) DEFAULT NULL,
  Foto longblob,
  contrasena varchar(45) DEFAULT NULL,
  PRIMARY KEY (idAlumnos)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnosbd`
--

LOCK TABLES alumnosbd WRITE;
/*!40000 ALTER TABLE alumnosbd DISABLE KEYS */;
INSERT INTO alumnosbd VALUES (1,'Jose','Gomez','Lopez','2003-03-08','yo3@gmail.com','6121415561','Los cabos','2',_binary 'null','222'),(2,'ejemplo','yo','aa','2000-04-05','asdsa@alu.uabcs.mx','6124858547','Los cabos','5',_binary 'null','333'),(5,'ejemplo 10','gomez','ayala','2001-04-04','ejemplo10@gmail.com','6128496456','La paz','4',_binary 'null','444');
/*!40000 ALTER TABLE alumnosbd ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asignaturasbd`
--

DROP TABLE IF EXISTS asignaturasbd;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE asignaturasbd (
  idAsignatura int(11) NOT NULL AUTO_INCREMENT,
  Nombre varchar(45) DEFAULT NULL,
  Creditos varchar(45) DEFAULT NULL,
  Docente varchar(45) DEFAULT NULL,
  Semestre varchar(45) DEFAULT NULL,
  idDocente int(11) DEFAULT NULL,
  PRIMARY KEY (idAsignatura),
  KEY idDocente_asig (idDocente),
  CONSTRAINT idDocente_asig FOREIGN KEY (idDocente) REFERENCES docentesbd (idDocente)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asignaturasbd`
--

LOCK TABLES asignaturasbd WRITE;
/*!40000 ALTER TABLE asignaturasbd DISABLE KEYS */;
INSERT INTO asignaturasbd VALUES (1,'Matematicas 1','20','Hector','2',4),(2,'Español 2','10','Hector','5',4),(3,'Paradigmas 2','10','Juna','2',5),(4,'Base de datos','15','Juna','6',5),(5,'Biologia','20','Hector','4',4);
/*!40000 ALTER TABLE asignaturasbd ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `docentesbd`
--

DROP TABLE IF EXISTS docentesbd;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE docentesbd (
  idDocente int(11) NOT NULL AUTO_INCREMENT,
  Nombre varchar(45) DEFAULT NULL,
  `Apellido Paterno` varchar(45) DEFAULT NULL,
  `Apellido Materno` varchar(45) DEFAULT NULL,
  `Fecha Nacimiento` date DEFAULT NULL,
  Correo varchar(45) DEFAULT NULL,
  Telefono varchar(15) DEFAULT NULL,
  Direccion varchar(45) DEFAULT NULL,
  Grado varchar(45) DEFAULT NULL,
  Foto longblob,
  contrasena varchar(45) DEFAULT NULL,
  PRIMARY KEY (idDocente)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docentesbd`
--

LOCK TABLES docentesbd WRITE;
/*!40000 ALTER TABLE docentesbd DISABLE KEYS */;
INSERT INTO docentesbd VALUES (4,'Hector','Gonzalez','Murillo','1980-06-06','murillog@uabcs.mx','6122333334','Tailandia','Doctorado ',_binary 'null','321'),(5,'Juna','Aviles','Marquez','1980-07-06','docente@gmail.com','6121503455','Los cabos','Licenciado',_binary 'null','111');
/*!40000 ALTER TABLE docentesbd ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gruposbd`
--

DROP TABLE IF EXISTS gruposbd;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE gruposbd (
  idGrupos int(11) NOT NULL AUTO_INCREMENT,
  Carrera varchar(45) DEFAULT NULL,
  Asignatura varchar(40) DEFAULT NULL,
  Docente varchar(45) DEFAULT NULL,
  Semestre varchar(45) DEFAULT NULL,
  numAlumnos varchar(45) DEFAULT NULL,
  idDocente int(11) DEFAULT NULL,
  PRIMARY KEY (idGrupos),
  KEY idDocente_grupo (idDocente),
  CONSTRAINT idDocente_grupo FOREIGN KEY (idDocente) REFERENCES docentesbd (idDocente)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gruposbd`
--

LOCK TABLES gruposbd WRITE;
/*!40000 ALTER TABLE gruposbd DISABLE KEYS */;
INSERT INTO gruposbd VALUES (1,'Lenguas','Español 2','Hector','4','10',4),(2,'Ingenieria en sistemas','Matematicas 1','Juna','4','10',5),(4,'Derecho','Español 2','Juna','2','20',5);
/*!40000 ALTER TABLE gruposbd ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-02 15:40:35
