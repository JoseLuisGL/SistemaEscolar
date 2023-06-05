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
  `Foto` blob,
  PRIMARY KEY (`idAlumnos`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnosbd`
--

LOCK TABLES `alumnosbd` WRITE;
/*!40000 ALTER TABLE `alumnosbd` DISABLE KEYS */;
INSERT INTO `alumnosbd` VALUES (1,'sdgas','sdagasg','sgasg','2005-01-01','sdgasdgasdg@dgsasg.com','612222222','La paz','1',_binary '[B@64b32ca7'),(2,'gdhf','jfgjd','ffgjdf','2005-01-01','fgjfdjdf','555555555','Monterrey','1',_binary '[B@427261dd'),(3,'gdhf','jfgjd','ffgjdf','2005-01-01','fgjfdjdf','612203340','Monterrey','1',_binary '[B@427261dd'),(4,'pepe','dsagasgd','sdgsag','2005-01-01','sdagasdg','999999','sdgsaga','1',_binary '[B@42299012'),(5,'Nicolas Eduardo','Ramirez','Pinto','2005-01-01','AtarusV@hotmail.com','612203709','Bahia de las Ballenas 152','1',_binary '[B@3bf65da2'),(6,'','','','2005-01-01','','6122037095','','1',_binary 'null');
/*!40000 ALTER TABLE `alumnosbd` ENABLE KEYS */;
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

-- Dump completed on 2023-06-05  6:03:19
