-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: movie_booking
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `locations`
--

DROP TABLE IF EXISTS `locations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locations` (
  `location_id` varchar(3) NOT NULL,
  `location_name` varchar(20) NOT NULL,
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locations`
--

LOCK TABLES `locations` WRITE;
/*!40000 ALTER TABLE `locations` DISABLE KEYS */;
INSERT INTO `locations` VALUES ('chd','chandigarh'),('chn','chennai'),('hyd','hyderabad'),('mum','mumbai');
/*!40000 ALTER TABLE `locations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movies` (
  `movie_id` varchar(6) NOT NULL,
  `movie_name` varchar(40) NOT NULL,
  PRIMARY KEY (`movie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` VALUES ('avgiw','avengers infinity war'),('fnf8','fast and furious 8'),('jkr','joker'),('saho','sahoo'),('snr','syra narsimha reddy'),('war','war');
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movies_in_location`
--

DROP TABLE IF EXISTS `movies_in_location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movies_in_location` (
  `sno` int(11) NOT NULL AUTO_INCREMENT,
  `location_id` varchar(3) NOT NULL,
  `movie_id` varchar(6) NOT NULL,
  PRIMARY KEY (`sno`),
  KEY `location_id_idx` (`location_id`),
  KEY `movie_id_idx` (`movie_id`),
  CONSTRAINT `location_id` FOREIGN KEY (`location_id`) REFERENCES `locations` (`location_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `movie_id` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`movie_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies_in_location`
--

LOCK TABLES `movies_in_location` WRITE;
/*!40000 ALTER TABLE `movies_in_location` DISABLE KEYS */;
INSERT INTO `movies_in_location` VALUES (1,'chd','avgiw'),(2,'chd','fnf8'),(3,'chd','jkr'),(4,'chd','war'),(5,'chn','avgiw'),(6,'chn','fnf8'),(7,'chn','saho'),(8,'chn','war'),(9,'hyd','avgiw'),(10,'hyd','fnf8'),(11,'hyd','saho'),(12,'hyd','snr'),(13,'mum','fnf8'),(14,'mum','jkr'),(15,'mum','war'),(16,'mum','saho');
/*!40000 ALTER TABLE `movies_in_location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theaters`
--

DROP TABLE IF EXISTS `theaters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `theaters` (
  `theater_id` varchar(7) NOT NULL,
  `theater_name` varchar(40) NOT NULL,
  PRIMARY KEY (`theater_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theaters`
--

LOCK TABLES `theaters` WRITE;
/*!40000 ALTER TABLE `theaters` DISABLE KEYS */;
INSERT INTO `theaters` VALUES ('agcmchn','ags cinemas chennai'),('cnpcmum','cinapolis colava mumbai'),('crnghyd','carnival cinemas hyderabad'),('dcxtchn','devi cineplex triplicane chennai'),('inxbmum','inox bandra mumbai'),('inxcchn','inox centre mall chennai'),('mrjdhyd','miraj cinemas hyderabad'),('nlmschd','neelam sector 17 chandigarh'),('pvrachn','pvr anna nagar chennai'),('pvramum','pvr andheri mumbai'),('pvrdhyd','pvr durgam cheruvu hyderabad'),('pvrechd','pvr elante chandigarh'),('pvrihyd','pvr inoribt mall hyderabad'),('pvrmmum','pvr malad mumbai'),('pvrpchd','pvr picadle chandigarh'),('svckhyd','svc cinemas hyderabad'),('tgrechd','tagore theater sector 18 chandigarh');
/*!40000 ALTER TABLE `theaters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theaters_for_movie`
--

DROP TABLE IF EXISTS `theaters_for_movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `theaters_for_movie` (
  `sno` int(11) NOT NULL AUTO_INCREMENT,
  `movie_id` varchar(6) NOT NULL,
  `theater_id` varchar(7) NOT NULL,
  PRIMARY KEY (`sno`),
  KEY `movie_id_idx` (`movie_id`),
  KEY `theater_id_idx` (`theater_id`),
  CONSTRAINT `theater_id` FOREIGN KEY (`theater_id`) REFERENCES `theaters` (`theater_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theaters_for_movie`
--

LOCK TABLES `theaters_for_movie` WRITE;
/*!40000 ALTER TABLE `theaters_for_movie` DISABLE KEYS */;
INSERT INTO `theaters_for_movie` VALUES (1,'avgiw','nlmschd'),(2,'avgiw','pvrechd'),(3,'avgiw','tgrechd'),(4,'fnf8','nlmschd'),(5,'fnf8','pvrechd'),(6,'fnf8','pvrpchd'),(7,'jkr','nlmschd'),(8,'jkr','pvrechd'),(9,'jkr','pvrpchd'),(10,'war','pvrechd'),(11,'war','pvrpchd'),(12,'war','tgrechd'),(13,'avgiw','agcmchn'),(14,'avgiw','dcxtchn'),(15,'avgiw','inxcchn'),(16,'avgiw','pvrachn'),(17,'fnf8','agcmchn'),(18,'fnf8','inxcchn'),(19,'fnf8','pvrachn'),(20,'saho','agcmchn'),(21,'saho','dcxtchn'),(22,'saho','pvrachn'),(23,'saho','inxcchn'),(24,'war','dcxtchn'),(25,'war','inxcchn'),(26,'war','pvrachn'),(27,'avgiw','crnghyd'),(28,'avgiw','mrjdhyd'),(29,'avgiw','pvrdhyd'),(30,'avgiw','svckhyd'),(31,'fnf8','crnghyd'),(32,'fnf8','mrjdhyd'),(33,'fnf8','pvrihyd'),(34,'fnf8','svckhyd'),(35,'saho','crnghyd'),(36,'saho','pvrdhyd'),(37,'saho','pvrihyd'),(38,'saho','svckhyd'),(39,'snr','mrjdhyd'),(40,'snr','pvrdhyd'),(41,'snr','pvrihyd'),(42,'snr','svckhyd'),(43,'fnf8','inxbmum'),(44,'fnf8','pvramum'),(45,'fnf8','cnpcmum'),(46,'fnf8','pvrmmum'),(47,'jkr','inxbmum'),(48,'jkr','pvramum'),(49,'jkr','cnpcmum'),(50,'jkr','pvrmmum'),(51,'war','inxbmum'),(52,'war','pvramum'),(53,'war','cnpcmum'),(54,'war','pvrmmum'),(55,'saho','inxbmum'),(56,'saho','pvramum'),(57,'saho','cnpcmum'),(58,'saho','pvrmmum');
/*!40000 ALTER TABLE `theaters_for_movie` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-18 18:57:47
