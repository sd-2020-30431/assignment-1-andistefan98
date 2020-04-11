-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: grocerydb
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `items` (
  `id` int NOT NULL AUTO_INCREMENT,
  `calorie_value` float DEFAULT NULL,
  `consumption_date` datetime DEFAULT NULL,
  `expiration_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `purchase_date` datetime DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `list_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrqa704hx19ty2bxvb1w4efous` (`list_id`),
  CONSTRAINT `FKrqa704hx19ty2bxvb1w4efous` FOREIGN KEY (`list_id`) REFERENCES `lists` (`list_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES (11,50,'2019-11-30 00:00:54','2020-04-20 00:00:54','Eggs','2020-04-08 00:00:54',10,6),(12,30,'2019-11-30 00:00:31','2020-04-17 00:00:31','Orange','2020-04-08 00:00:31',6,6),(13,400,'2019-11-30 00:00:48','2020-04-13 00:00:48','bread','2020-04-09 00:00:48',5,7),(14,1000,'2019-11-30 00:00:10','2020-05-25 00:00:10','Pepsi Max','2020-04-09 00:00:10',2,7),(15,500,'2019-11-30 00:00:28','2020-04-20 00:00:28','Cookies','2020-04-09 00:00:28',3,7),(16,300,'2019-11-30 00:00:19','2020-04-19 00:00:19','Lay\'s Chips','2020-04-08 00:00:19',2,9),(17,700,'2019-11-30 00:00:37','2020-04-20 00:00:37','Potatoes','2020-04-08 00:00:37',3,9),(18,450,'2019-11-30 00:00:52','2020-04-13 00:00:52','Bread','2020-04-09 00:00:52',1,11),(19,600,'2019-11-30 00:00:18','2020-05-25 00:00:18','Biscuits','2020-04-09 00:00:18',1,11),(20,150,'2020-04-10 00:00:00','2020-04-11 00:00:04','Yoghurt','2020-04-08 00:00:04',2,12),(21,160,'2019-11-30 00:00:16','2020-04-14 00:00:16','Greek Yoghurt','2020-04-09 00:00:16',1,13),(22,250,NULL,'2020-04-13 00:00:00','Cereals','2020-04-09 00:00:00',2,16),(23,35,NULL,'2020-04-09 00:00:00','Eggs','2020-04-07 00:00:00',10,16),(24,200,NULL,'2020-03-25 00:00:00','Muffins','2020-03-10 00:00:00',3,17);
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lists`
--

DROP TABLE IF EXISTS `lists`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lists` (
  `list_id` int NOT NULL AUTO_INCREMENT,
  `list_name` varchar(255) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`list_id`),
  KEY `FKe59kv852m4k3g8kmefph4i3kx` (`user_id`),
  CONSTRAINT `FKe59kv852m4k3g8kmefph4i3kx` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lists`
--

LOCK TABLES `lists` WRITE;
/*!40000 ALTER TABLE `lists` DISABLE KEYS */;
INSERT INTO `lists` VALUES (6,'initial name',2),(7,NULL,1),(8,NULL,1),(9,NULL,2),(10,NULL,2),(11,'My first list',1),(12,'List no. 2',1),(13,'List no. 2',1),(14,'List no. 3',1),(15,'List april',2),(16,'list test',1),(17,'List no. 4',1),(18,'',1),(19,'',1),(20,'',1);
/*!40000 ALTER TABLE `lists` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `caloric_goal` int DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`,`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,2300,'stefan','andrei'),(2,0,'aprilie','martie');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-11 18:56:12
