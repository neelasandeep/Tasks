-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: movie_booking
-- ------------------------------------------------------
-- Server version	8.0.18

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
  PRIMARY KEY (`sno`)
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
-- Table structure for table `seat_details`
--

DROP TABLE IF EXISTS `seat_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seat_details` (
  `sno` int(11) NOT NULL AUTO_INCREMENT,
  `booking_date` date NOT NULL,
  `theater_id` varchar(7) NOT NULL,
  `sccreen_no` varchar(9) NOT NULL,
  `seat_no` varchar(40) NOT NULL,
  `showtime` varchar(10) NOT NULL,
  `booking_id` varchar(40) NOT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat_details`
--

LOCK TABLES `seat_details` WRITE;
/*!40000 ALTER TABLE `seat_details` DISABLE KEYS */;
INSERT INTO `seat_details` VALUES (1,'2019-10-29','pvrm','screen-3','a1-a2-a3','9.00','592581'),(2,'2019-10-29','pvrm','screen-3','a4-a5','9.00','289742'),(3,'2019-10-29','pvrm','screen-3','e5','9.00','243074'),(4,'2019-10-29','pvrm','screen-3','f1','9.00','668437'),(5,'2019-10-29','pvrm','screen-3','g3','9.00','609131'),(6,'2019-10-29','pvrm','screen-3','h3-i5-d3','9.00','516456'),(7,'2019-10-29','svck','screen-3','a1-a2-a3','8.00','664947'),(8,'2019-10-29','svck','screen-3','a4-f3','8.00','238306'),(9,'2019-10-29','pvrm','screen-3','i3-i7','9.00','637290'),(10,'2019-10-30','agcm','screen-3','a1-a2-g5','10.00','964605'),(11,'2019-11-01','crng','screen-3','a1-c2-i3','11.00','963049'),(12,'2019-10-30','pvre','screen-4','a1-e1-f3-b3','12.00','485170'),(13,'2019-10-29','pvre','screen-4','a1-a2','12.00','405784'),(14,'2019-10-30','inxb','screen-2','a1-a2-a4','9.00','857946');
/*!40000 ALTER TABLE `seat_details` ENABLE KEYS */;
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
INSERT INTO `theaters` VALUES ('agcm','ags cinemas chennai'),('cnpc','cinapolis colava mumbai'),('crng','carnival cinemas hyderabad'),('dcxt','devi cineplex triplicane chennai'),('inxb','inox bandra mumbai'),('inxc','inox centre mall chennai'),('mrjd','miraj cinemas hyderabad'),('nlms','neelam sector 17 chandigarh'),('pvra','pvr andheri mumbai'),('pvraa','pvr anna nagar chennai'),('pvrd','pvr durgam cheruvu hyderabad'),('pvre','pvr elante chandigarh'),('pvri','pvr inoribt mall hyderabad'),('pvrm','pvr malad mumbai'),('pvrp','pvr picadle chandigarh'),('svck','svc cinemas hyderabad'),('tgre','tagore theater sector 18 chandigarh');
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
  `location_id` varchar(4) NOT NULL,
  `screen_no` varchar(9) NOT NULL,
  `screen_capacity` varchar(10) NOT NULL,
  `timings` varchar(60) NOT NULL,
  PRIMARY KEY (`sno`),
  KEY `movie_id_idx` (`movie_id`),
  KEY `theater_id_idx` (`theater_id`,`movie_id`),
  KEY `locatioin_id_idx` (`location_id`),
  CONSTRAINT `location_id` FOREIGN KEY (`location_id`) REFERENCES `locations` (`location_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `movie_id` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`movie_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `theater_id` FOREIGN KEY (`theater_id`) REFERENCES `theaters` (`theater_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theaters_for_movie`
--

LOCK TABLES `theaters_for_movie` WRITE;
/*!40000 ALTER TABLE `theaters_for_movie` DISABLE KEYS */;
INSERT INTO `theaters_for_movie` VALUES (1,'avgiw','nlms','chd','screen-1','10-10','9.00 AM 12.00 PM 4.00 PM 8.00 PM'),(2,'avgiw','pvre','chd','screen-1','15-15','11.00 AM 2.00 PM 6.00 PM 9.00 PM'),(3,'avgiw','tgre','chd','screen-1','8-8','8.00 AM 12.00 PM 3.00 PM 6.00 PM 9.00PM'),(4,'fnf8','nlms','chd','screen-2','7-7','10.00 AM 1.00 PM 4.00 PM 7.00 PM'),(5,'fnf8','pvre','chd','screen-2','8-8','9.00 AM 11.00 AM 2.00PM 4.00 PM 10.00 PM'),(6,'fnf8','pvrp','chd','screen-1','6-6','10.00 AM 12.00 PM 3.00 PM 5.00 PM 8.00 PM'),(7,'jkr','nlms','chd','screen-3','10-10','11.00 AM 12.00 PM 3.30 PM 6.30 PM 9.00 PM'),(8,'jkr','pvre','chd','screen-3','15-15','9.00 AM 12.00 PM 4.00 PM 8.00 PM'),(9,'jkr','pvrp','chd','screen-2','8-8','11.00 AM 2.00 PM 6.00 PM 9.00 PM'),(10,'war','pvre','chd','screen-4','7-7','8.00 AM 12.00 PM 3.00 PM 6.00 PM 9.00PM'),(11,'war','pvrp','chd','screen-3','6-6','10.00 AM 1.00 PM 4.00 PM 7.00 PM'),(12,'war','tgre','chd','screen-2','10-10','9.00 AM 11.00 AM 2.00PM 4.00 PM 10.00 PM'),(13,'avgiw','agcm','chn','screen-1','15-15','10.00 AM 12.00 PM 3.00 PM 5.00 PM 8.00 PM'),(14,'avgiw','dcxt','chn','screen-1','8-8','11.00 AM 12.00 PM 3.30 PM 6.30 PM 9.00 PM'),(15,'avgiw','inxc','chn','screen-1','4-4','9.00 AM 12.00 PM 4.00 PM 8.00 PM'),(16,'avgiw','pvraa','chn','screen-1','6-6','11.00 AM 2.00 PM 6.00 PM 9.00 PM'),(17,'fnf8','agcm','chn','screen-2','8-8','8.00 AM 12.00 PM 3.00 PM 6.00 PM 9.00PM'),(18,'fnf8','inxc','chn','screen-2','15-8','10.00 AM 1.00 PM 4.00 PM 7.00 PM'),(19,'fnf8','pvraa','chn','screen-2','7-10','9.00 AM 11.00 AM 2.00PM 4.00 PM 10.00 PM'),(20,'saho','agcm','chn','screen-3','6-12','10.00 AM 12.00 PM 3.00 PM 5.00 PM 8.00 PM'),(21,'saho','dcxt','chn','screen-2','7-13','11.00 AM 12.00 PM 3.30 PM 6.30 PM 9.00 PM'),(22,'saho','pvraa','chn','screen-3','8-14','9.00 AM 12.00 PM 4.00 PM 8.00 PM'),(23,'saho','inxc','chn','screen-3','9-14','11.00 AM 2.00 PM 6.00 PM 9.00 PM'),(24,'war','dcxt','chn','screen-3','10-7','8.00 AM 12.00 PM 3.00 PM 6.00 PM 9.00PM'),(25,'war','inxc','chn','screen-4','9-9','10.00 AM 1.00 PM 4.00 PM 7.00 PM'),(26,'war','pvraa','chn','screen-4','5-5','9.00 AM 11.00 AM 2.00PM 4.00 PM 10.00 PM'),(27,'avgiw','crng','hyd','screen-1','8-9','10.00 AM 12.00 PM 3.00 PM 5.00 PM 8.00 PM'),(28,'avgiw','mrjd','hyd','screen-1','4-8','11.00 AM 12.00 PM 3.30 PM 6.30 PM 9.00 PM'),(29,'avgiw','pvrd','hyd','screen-1','5-6','9.00 AM 12.00 PM 4.00 PM 8.00 PM'),(30,'avgiw','svck','hyd','screen-1','7-8','11.00 AM 2.00 PM 6.00 PM 9.00 PM'),(31,'fnf8','crng','hyd','screen-2','6-5','8.00 AM 12.00 PM 3.00 PM 6.00 PM 9.00PM'),(32,'fnf8','mrjd','hyd','screen-2','4-9','10.00 AM 1.00 PM 4.00 PM 7.00 PM'),(33,'fnf8','pvri','hyd','screen-1','7-8','9.00 AM 11.00 AM 2.00PM 4.00 PM 10.00 PM'),(34,'fnf8','svck','hyd','screen-2','6-5','10.00 AM 12.00 PM 3.00 PM 5.00 PM 8.00 PM'),(35,'saho','crng','hyd','screen-3','8-9','11.00 AM 12.00 PM 3.30 PM 6.30 PM 9.00 PM'),(36,'saho','pvrd','hyd','screen-2','7-8','9.00 AM 12.00 PM 4.00 PM 8.00 PM'),(37,'saho','pvri','hyd','screen-2','10-10','11.00 AM 2.00 PM 6.00 PM 9.00 PM'),(38,'saho','svck','hyd','screen-3','6-6','8.00 AM 12.00 PM 3.00 PM 6.00 PM 9.00PM'),(39,'snr','mrjd','hyd','screen-3','4-4','10.00 AM 1.00 PM 4.00 PM 7.00 PM'),(40,'snr','pvrd','hyd','screen-3','8-9','9.00 AM 11.00 AM 2.00PM 4.00 PM 10.00 PM'),(41,'snr','pvri','hyd','screen-3','4-6','10.00 AM 12.00 PM 3.00 PM 5.00 PM 8.00 PM'),(42,'snr','svck','hyd','screen-4','8-5','11.00 AM 12.00 PM 3.30 PM 6.30 PM 9.00 PM'),(43,'fnf8','inxb','mum','screen-1','10-4','9.00 AM 12.00 PM 4.00 PM 8.00 PM'),(44,'fnf8','pvra','mum','screen-1','8-9','11.00 AM 2.00 PM 6.00 PM 9.00 PM'),(45,'fnf8','cnpc','mum','screen-1','7-7','8.00 AM 12.00 PM 3.00 PM 6.00 PM 9.00PM'),(46,'fnf8','pvrm','mum','screen-1','5-9','10.00 AM 1.00 PM 4.00 PM 7.00 PM'),(47,'jkr','inxb','mum','screen-2','6-9','9.00 AM 11.00 AM 2.00PM 4.00 PM 10.00 PM'),(48,'jkr','pvra','mum','screen-2','7-5','10.00 AM 12.00 PM 3.00 PM 5.00 PM 8.00 PM'),(49,'jkr','cnpc','mum','screen-2','4-8','11.00 AM 12.00 PM 3.30 PM 6.30 PM 9.00 PM'),(50,'jkr','pvrm','mum','screen-2','6-9','9.00 AM 12.00 PM 4.00 PM 8.00 PM'),(51,'war','inxb','mum','screen-3','7-6','11.00 AM 2.00 PM 6.00 PM 9.00 PM'),(52,'war','pvra','mum','screen-3','9-8','8.00 AM 12.00 PM 3.00 PM 6.00 PM 9.00PM'),(53,'war','cnpc','mum','screen-3','7-9','10.00 AM 1.00 PM 4.00 PM 7.00 PM'),(54,'war','pvrm','mum','screen-3','8-7','9.00 AM 11.00 AM 2.00PM 4.00 PM 10.00 PM'),(55,'saho','inxb','mum','screen-4','8-8','10.00 AM 12.00 PM 3.00 PM 5.00 PM 8.00 PM'),(56,'saho','pvra','mum','screen-4','9-9','11.00 AM 12.00 PM 3.30 PM 6.30 PM 9.00 PM'),(57,'saho','cnpc','mum','screen-4','8-5','9.00 AM 11.00 AM 2.00PM 4.00 PM 10.00 PM'),(58,'saho','pvrm','mum','screen-4','7-7','10.00 AM 1.00 PM 4.00 PM 7.00 PM');
/*!40000 ALTER TABLE `theaters_for_movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userdata`
--

DROP TABLE IF EXISTS `userdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userdata` (
  `booking_id` varchar(20) NOT NULL,
  `location` varchar(45) NOT NULL,
  `moviename` varchar(45) NOT NULL,
  `theatername` varchar(45) NOT NULL,
  `screen` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `no_of_tickets` varchar(45) NOT NULL,
  `seatno` varchar(45) NOT NULL,
  `time` varchar(45) NOT NULL,
  `date` date NOT NULL,
  `totalCost` int(11) NOT NULL,
  PRIMARY KEY (`booking_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userdata`
--

LOCK TABLES `userdata` WRITE;
/*!40000 ALTER TABLE `userdata` DISABLE KEYS */;
INSERT INTO `userdata` VALUES ('857946','mumbai','joker','inox bandra mumbai','screen-2','premium','3','a1-a2-a4','9.00','2019-10-30',750);
/*!40000 ALTER TABLE `userdata` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-27 23:50:47
