-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: fog_projekt
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `custom_products`
--

DROP TABLE IF EXISTS `custom_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `custom_products` (
  `idcustom_products` int NOT NULL AUTO_INCREMENT,
  `product_length` int NOT NULL,
  `product_width` int NOT NULL,
  `roof_type` varchar(45) NOT NULL,
  `roof_material` varchar(45) NOT NULL,
  `shed_length` int DEFAULT NULL,
  `shed_width` int DEFAULT NULL,
  `product_price` double DEFAULT NULL,
  PRIMARY KEY (`idcustom_products`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `custom_products`
--

LOCK TABLES `custom_products` WRITE;
/*!40000 ALTER TABLE `custom_products` DISABLE KEYS */;
INSERT INTO `custom_products` VALUES (1,0,0,'0','0',0,0,0),(2,1,1,'1','1',1,1,0.9),(3,7800,2400,'flat','plasttrapez',NULL,NULL,11533.21),(4,6600,5100,'flat','plasttrapez',NULL,NULL,10000),(5,4800,5700,'flat','plasttrapez',NULL,NULL,10478.89),(12,2400,2400,'flat','plasttrapez',NULL,NULL,4551.57),(13,6600,5100,'flat','plasttrapez',NULL,NULL,14966.17),(14,7500,3300,'flat','plasttrapez',NULL,NULL,12960.41),(15,6600,3900,'flat','plasttrapez',NULL,NULL,11693.92),(16,7200,3600,'flat','plasttrapez',NULL,NULL,10221.73),(17,6900,3600,'flat','plasttrapez',NULL,NULL,10526.04),(18,4500,4500,'flat','plasttrapez',NULL,NULL,NULL),(19,3900,3900,'flat','plasttrapez',NULL,NULL,NULL),(20,5100,5100,'flat','plasttrapez',NULL,NULL,NULL),(21,7800,6000,'flat','plasttrapez',2100,5400,NULL),(22,2400,2400,'flat','plasttrapez',2100,2100,NULL),(23,7200,5100,'flat','plasttrapez',3000,4800,NULL),(24,7800,4800,'flat','plasttrapez',2100,4500,NULL),(25,6000,4800,'flat','plasttrapez',1500,4500,NULL),(26,2700,2400,'flat','plasttrapez',0,0,NULL),(27,3000,2400,'flat','plasttrapez',0,0,NULL),(28,3000,2700,'flat','plasttrapez',0,0,NULL),(29,3900,2400,'flat','plasttrapez',0,0,NULL),(30,4200,2400,'flat','plasttrapez',0,0,NULL),(31,4500,2400,'flat','plasttrapez',0,0,NULL),(32,4800,2400,'flat','plasttrapez',0,0,NULL),(33,2400,2400,'flat','plasttrapez',0,0,NULL);
/*!40000 ALTER TABLE `custom_products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `done_materials`
--

DROP TABLE IF EXISTS `done_materials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `done_materials` (
  `idmaterials` int NOT NULL AUTO_INCREMENT,
  `material_name` varchar(45) NOT NULL,
  `unit_amount` int NOT NULL,
  `unit_type` varchar(6) NOT NULL,
  PRIMARY KEY (`idmaterials`),
  UNIQUE KEY `idmaterials_UNIQUE` (`idmaterials`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `done_materials`
--

LOCK TABLES `done_materials` WRITE;
/*!40000 ALTER TABLE `done_materials` DISABLE KEYS */;
INSERT INTO `done_materials` VALUES (1,'plastmobundskruer',200,'pakke'),(2,'hulbånd',10,'rulle'),(3,'universal beslag hoejre',1,'stk'),(4,'universal beslag venstre',1,'stk'),(5,'4,5x60mm skruer',200,'pakke'),(6,'4,0x50mm beslagskruer',250,'pakke'),(7,'10x120mm bræddebolt',1,'stk'),(8,'40x40x11mm firkantskiver',1,'stk'),(9,'4,5x70mm skruer',400,'pakke'),(10,'4,5x50mm skruer',300,'pakke'),(11,'50x75 stalddørsgreb',1,'saet'),(12,'390mm t-hængsel',1,'stk'),(13,'35mm vinkelbeslag',1,'stk');
/*!40000 ALTER TABLE `done_materials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `done_products`
--

DROP TABLE IF EXISTS `done_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `done_products` (
  `iddone_products` int NOT NULL AUTO_INCREMENT,
  `product_length` int NOT NULL,
  `product_width` int NOT NULL,
  `product_price` int NOT NULL,
  `product_amount` int DEFAULT NULL,
  `product_type` varchar(45) NOT NULL DEFAULT 'done',
  `product_title` varchar(65) NOT NULL,
  `product_description` varchar(415) NOT NULL,
  PRIMARY KEY (`iddone_products`),
  UNIQUE KEY `iddone_products_UNIQUE` (`iddone_products`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `done_products`
--

LOCK TABLES `done_products` WRITE;
/*!40000 ALTER TABLE `done_products` DISABLE KEYS */;
INSERT INTO `done_products` VALUES (1,5400,3600,24998,NULL,'done','CARPORT ENKELT 3,60X5,40M CAR01H HØJ REJSNING','Uden redskabsrum Trykimprægnerede stolper & stern. Leveres med: Søm, skruer, beslag og betontagstenstag. Udførlig byggevejledning til carport og spær medfølger. Betontagsten i sort med 30 års garanti. NB! Leveres som Byg-selv sæt - usamlet og ubehandlet!'),(2,7200,3600,31498,NULL,'done','CARPORT ENKELT 3,60X7,20M CAR01HR MED REDSKABSRUM 3,20X2,20M','Enkelt carport med høj rejsning. 3,60 x 7,20 m. m/Byg-selv spær. Ink. redskabsrum. Højde; 3,05 mtr. rykimprægnerede stolper, stern og beklædning. Leveres med: søm, skruer beslag og betontagstens tag. Udførlig byggevejledning til carport og spær medfølger. Betontagsten i sort med 30 års garanti. NB! Leveres som Byg-selv sæt - usamlet og ubehandlet! Varen kan ses udstillet i følgende afdelinger: Værebro'),(3,8100,3600,33498,NULL,'done','CARPORT ENKELT 3,60X8,10M CARL01HR MED REDSKABSRUM 3,05X3,20M','Enkelt carport med høj rejsning. Inkl. stort redskabsrum på 3,20 x 3,05 m. . Højde: 3,05 mtr. Trykimprægnerede stolper, stern og beklædning. Leveres med: Søm, skruer, beslag og betontagstenstag. Udførlig byggevejledning til carport og spær medfølger. Betontagsten i sort med 30 års garanti. NB! Leveres som Byg-selv sæt - usamlet og ubehandlet!'),(4,7800,3900,35998,NULL,'done','CARPORT ENKELT 3,90X7,80M CPO01HR MED REDSKABSRUM 2,40X3,30M','Enkelt carport med høj rejsning. m/Byg-selv spær. Inkl. 3,20 x 2,25 m. redskabsrum. Højde; 3,05 mtr. Trykimprægnerede stolper, stern og beklædning. Leveres med: søm, skruer beslag og betontagstens tag. Udførlig byggevejledning til carport og spær medfølger. Betontagsten i sort med 30 års garanti. NB! Leveres som Byg-selv sæt - usamlet og ubehandlet! Varen kan ses udstillet i følgende afdelinger: Værebro'),(5,4800,3000,6498,NULL,'done','CARPORT ENKELT 3,00X4,80M CAR01 FLADT TAG','3,00 x 4,80 mtr. Højde; 2,25 mtr. Trykimprægnerede stolper og stern. Leveres med: søm, skruer, beslag og plasttrapez tag m/bundskruer. NB! Leveres som Byg-selv sæt - usamlet, umalet og ubehandlet!');
/*!40000 ALTER TABLE `done_products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `idorders` int NOT NULL AUTO_INCREMENT,
  `product_id` int NOT NULL,
  `product_type` varchar(45) NOT NULL,
  `user_id` int NOT NULL,
  `user_orderid` int NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`idorders`),
  UNIQUE KEY `idorders_UNIQUE` (`idorders`),
  KEY `fk_producttypedone_orders_link_idx` (`product_type`),
  KEY `fk_orders_users_idx` (`user_id`),
  CONSTRAINT `fk_orders_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (2,1,'done',2,0,'paid'),(3,5,'done',2,0,'paid'),(4,4,'done',2,0,'paid'),(5,2,'done',2,1,'paid'),(6,3,'custom',2,2,'Awaits offer'),(7,4,'custom',2,2,'Paid'),(17,13,'custom',1,1,'Awaits offer'),(18,14,'custom',1,2,'Paid'),(20,16,'custom',2,3,'Paid'),(21,17,'custom',5,1,'Paid'),(23,20,'custom',2,3,'Awaits offer'),(24,21,'custom',2,3,'Awaits offer'),(25,22,'custom',2,3,'Awaits offer'),(26,23,'custom',2,3,'Awaits offer'),(27,24,'custom',2,3,'Awaits offer'),(28,25,'custom',2,3,'Awaits offer'),(29,26,'custom',2,3,'Awaits offer'),(30,27,'custom',2,5,'Awaits offer'),(31,28,'custom',2,6,'Awaits offer'),(32,29,'custom',2,7,'Awaits offer'),(33,30,'custom',2,8,'Awaits offer'),(34,31,'custom',2,9,'Awaits offer'),(35,32,'custom',2,10,'Awaits offer'),(36,33,'custom',2,3,'Awaits offer');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(90) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(20) NOT NULL DEFAULT 'customer',
  `order_id` int NOT NULL DEFAULT '0',
  `balance` int DEFAULT NULL,
  `telephone` int DEFAULT NULL,
  `zipcode` int DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `street` varchar(45) DEFAULT NULL,
  `house_number` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'barbie@world.dk','jensen','customer',0,0,30185952,2500,'valby','foggade','3B'),(2,'ken@world.com','jensen','customer',2,0,91056832,2600,'glostrup','skruegade','21'),(3,'robin@gotham.com','batman','employee',0,0,0,0,'0','',''),(4,'1','1','customer',0,NULL,1,1,NULL,'1','1'),(5,'1234@email.dk','1234','customer',0,NULL,12345678,1234,'bybyby','gadegade','12'),(6,'2','2','customer',0,NULL,2,2,'2','2','2');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workable_materials`
--

DROP TABLE IF EXISTS `workable_materials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `workable_materials` (
  `idworkable_materials` int NOT NULL AUTO_INCREMENT,
  `material_name` varchar(45) NOT NULL,
  `material_type` varchar(45) NOT NULL,
  `material_length` int NOT NULL,
  `material_width` int NOT NULL,
  `material_height` int NOT NULL,
  `material_price` int NOT NULL,
  PRIMARY KEY (`idworkable_materials`),
  UNIQUE KEY `idworkable_materials_UNIQUE` (`idworkable_materials`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workable_materials`
--

LOCK TABLES `workable_materials` WRITE;
/*!40000 ALTER TABLE `workable_materials` DISABLE KEYS */;
INSERT INTO `workable_materials` VALUES (1,'trykimp.braet','trae',3600,200,25,36),(2,'trykimp.braet','trae',5400,200,25,54),(3,'trykimp.braet','trae',3600,125,25,36),(4,'trykimp.braet','trae',5400,125,25,54),(5,'Lægte ubh.','trae',4200,73,38,42),(6,'reglar ubh.','trae',2700,95,45,27),(7,'reglar ubh.','trae',2400,95,45,24),(8,'spaertrae ubh.','trae',6000,195,45,60),(9,'spaertrae ubh.','trae',4800,195,45,48),(10,'trykimp. stolpe','trae',3000,97,97,30),(11,'trykimp.braet','trae',5400,100,19,54),(12,'trykimp.braet','trae',3600,100,19,36),(13,'trykimp.braet','trae',2100,100,19,21),(14,'plastmo ecolite blaatonet','tagplader',6000,1090,20,60),(15,'plastmo ecolite blaatonet','tagplader',3600,1090,20,36),(16,'spaertrae ubh.','trae',5400,195,45,54),(17,'spaertrae ubh.','trae',4200,195,45,42),(18,'spaertrae ubh.','trae',3600,195,45,36),(19,'spaertrae ubh.','trae',3000,195,45,30),(20,'spaertrae ubh.','trae',6600,195,45,66),(21,'spaertrae ubh.','trae',7200,195,45,72),(22,'plastmo ecolite blaatonet','tagplader',2400,1090,20,24),(23,'plastmo ecolite blaatonet','tagplader',3000,1090,20,30),(24,'plastmo ecolite blaatonet','tagplader',4200,1090,20,42),(25,'plastmo ecolite blaatonet','tagplader',4800,1090,20,48),(26,'trykimp.braet','trae',3000,200,25,30),(27,'trykimp.braet','trae',4200,200,25,42),(28,'trykimp.braet','trae',4800,200,25,48),(29,'trykimp.braet','trae',6000,200,25,60),(30,'trykimp.braet','trae',3000,125,25,30),(31,'trykimp.braet','trae',4200,125,25,42),(32,'trykimp.braet','trae',4800,125,25,48),(33,'trykimp.braet','trae',6000,125,25,60);
/*!40000 ALTER TABLE `workable_materials` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-21 11:23:29
