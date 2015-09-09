CREATE DATABASE  IF NOT EXISTS `fca_uv` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `fca_uv`;
-- MySQL dump 10.13  Distrib 5.6.24, for osx10.8 (x86_64)
--
-- Host: 127.0.0.1    Database: fca_uv
-- ------------------------------------------------------
-- Server version	5.5.5-10.0.20-MariaDB

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
-- Table structure for table `estados`
--

DROP TABLE IF EXISTS `estados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estados` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `abreviacion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estados`
--

LOCK TABLES `estados` WRITE;
/*!40000 ALTER TABLE `estados` DISABLE KEYS */;
INSERT INTO `estados` VALUES (1,'Aguascalientes','Ags.'),(2,'Aguascalientes','Ags.'),(3,'Baja California','BC'),(4,'Baja California Sur','BCS'),(5,'Campeche','Camp.'),(6,'Coahuila de Zaragoza','Coah.'),(7,'Colima','Col.'),(8,'Chiapas','Chis.'),(9,'Chihuahua','Chih.'),(10,'Distrito Federal','DF'),(11,'Durango','Dgo.'),(12,'Guanajuato','Gto.'),(13,'Guerrero','Gro.'),(14,'Hidalgo','Hgo.'),(15,'Jalisco','Jal.'),(16,'México','Mex.'),(17,'Michoacán de Ocampo','Mich.'),(18,'Morelos','Mor.'),(19,'Nayarit','Nay.'),(20,'Nuevo León','NL'),(21,'Oaxaca','Oax.'),(22,'Puebla','Pue.'),(23,'Querétaro','Qro.'),(24,'Quintana Roo','Q. Roo'),(25,'San Luis Potosí','SLP'),(26,'Sinaloa','Sin.'),(27,'Sonora','Son.'),(28,'Tabasco','Tab.'),(29,'Tamaulipas','Tamps.'),(30,'Tlaxcala','Tlax.'),(31,'Veracruz de Ignacio de la Llave','Ver.'),(32,'Yucatán','Yuc.'),(33,'Zacatecas','Zac.');
/*!40000 ALTER TABLE `estados` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-09-09 15:39:47
