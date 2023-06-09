-- MySQL dump 10.13  Distrib 5.7.24, for Win64 (x86_64)
--
-- Host: localhost    Database: bd-ejemplo
-- ------------------------------------------------------
-- Server version	5.7.24-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `idAdmin` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) DEFAULT NULL,
  `Contrasena` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idAdmin`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'pepe','123');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumnosbd`
--

DROP TABLE IF EXISTS `alumnosbd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumnosbd` (
  `idAlumnos` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) DEFAULT NULL,
  `Apellido Paterno` varchar(45) DEFAULT NULL,
  `Apellido Materno` varchar(45) DEFAULT NULL,
  `Fecha Nacimiento` date DEFAULT NULL,
  `Correo` varchar(45) DEFAULT NULL,
  `Telefono` varchar(15) DEFAULT NULL,
  `Direccion` varchar(45) DEFAULT NULL,
  `Grado` varchar(45) DEFAULT NULL,
  `Foto` longblob,
  PRIMARY KEY (`idAlumnos`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnosbd`
--

LOCK TABLES `alumnosbd` WRITE;
/*!40000 ALTER TABLE `alumnosbd` DISABLE KEYS */;
INSERT INTO `alumnosbd` VALUES (17,'Nicolas','Ramirez','Piinto','2000-05-23','Atarusv@hotmail.com','6122037095','Bahia de las Ballenas 152','1',_binary 'null'),(18,'in','ni','ni','2005-01-01','fsgdsf@hotmail.com','612203709h','','1',_binary 'null'),(19,'rulo','rulo','rulo','1998-05-06','sdagags@sdg.com','6111111111','toreto','1',_binary 'null'),(20,'dsfhsdf','fdshg','dsfdfshsd','2005-01-01','sdgnjs@hotmail.com','5555555555','sol','6',_binary 'null'),(21,'dsfhsdf','fdshg','dsfdfshsd','2005-01-01','sdgnjs@hotmail.com','5555555555','sol','0',_binary 'null'),(22,'dsfhsdf','fdshg','dsfdfshsd','2005-01-01','sdgnjs@hotmail.com','5555555555','sol','6',_binary 'null'),(23,'dsfhsdf','fdshg','dsfdfshsd','2005-01-01','sdgnjs@hotmail.com','5555555555','sol','0',_binary 'null'),(24,'tryj','ghk','ghk','2000-04-05','ghkfgk@hotmail.com','8888888888','domingo','5',_binary 'null');
/*!40000 ALTER TABLE `alumnosbd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `docentesbd`
--

DROP TABLE IF EXISTS `docentesbd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `docentesbd` (
  `idDocente` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) DEFAULT NULL,
  `Apellido Paterno` varchar(45) DEFAULT NULL,
  `Apellido Materno` varchar(45) DEFAULT NULL,
  `Fecha Nacimiento` date DEFAULT NULL,
  `Correo` varchar(45) DEFAULT NULL,
  `Telefono` varchar(15) DEFAULT NULL,
  `Direccion` varchar(45) DEFAULT NULL,
  `Grado` varchar(45) DEFAULT NULL,
  `Foto` longblob,
  PRIMARY KEY (`idDocente`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docentesbd`
--

LOCK TABLES `docentesbd` WRITE;
/*!40000 ALTER TABLE `docentesbd` DISABLE KEYS */;
INSERT INTO `docentesbd` VALUES (1,'sadg','sadg','sadg','1998-05-01','sadgag@hotmail.com','2222222222','sagasdgasd','Magíster ',_binary 'null'),(2,'asgas','sdadgaasd','sadgas','2004-04-05','csdagas@hotmai.com','5555555555','panama','Magíster ',_binary 'null'),(3,'asgas','sdadgaasd','sadgas','2004-04-05','csdagas@hotmai.com','5555555555','panama','Bachiller',_binary 'null');
/*!40000 ALTER TABLE `docentesbd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bd-ejemplo'
--

--
-- Dumping routines for database 'bd-ejemplo'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-09  3:53:48
