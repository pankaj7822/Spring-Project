-- MySQL dump 10.13  Distrib 5.7.24, for Linux (x86_64)
--
-- Host: localhost    Database: bookretailer_mvc
-- ------------------------------------------------------
-- Server version	5.7.24-0ubuntu0.18.04.1

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `state` varchar(50) NOT NULL,
  `district` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `pincode` varchar(50) NOT NULL,
  `landmark` varchar(50) DEFAULT NULL,
  `Profile_id` int(11) NOT NULL,
  `profileid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `address_Profile_id_41c8ef69_fk_profile_id` (`Profile_id`),
  CONSTRAINT `address_Profile_id_41c8ef69_fk_profile_id` FOREIGN KEY (`Profile_id`) REFERENCES `profile` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'sdfas','asdads','asdfadsf','adsfasdfasd','asdfads',2,NULL),(2,'NCT-Delhi','VNS','Delhi','110092','dfds',12,NULL),(3,'Uttar Pradesh','sdfasddsaf','Varanasi','221005','dfasdf',12,NULL),(4,'Uttar Pradesh','DKS','Varanasi','221005','Near HG',13,NULL),(5,'Uttar Pradesh','VNS','Varanasi','221005','Near Hg',14,NULL);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `author` varchar(50) DEFAULT NULL,
  `level` varchar(50) DEFAULT NULL,
  `selling_price` int(11) DEFAULT NULL,
  `marked_price` int(11) DEFAULT NULL,
  `discounted_price` int(11) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `edition` varchar(50) DEFAULT NULL,
  `genre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (4,'You can Win','Shiv Khera','9',100,500,200,50,'10','Motivation'),(7,'Wings on Fire','piyush','10',45,450,40,65,'9','comics');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_order_item`
--

DROP TABLE IF EXISTS `book_order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) NOT NULL,
  `Order_id` int(11) NOT NULL,
  `Book_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `book_order_item_Order_id_ce970758_fk_order_id` (`Order_id`),
  KEY `Book_id` (`Book_id`),
  CONSTRAINT `book_order_item_Order_id_ce970758_fk_order_id` FOREIGN KEY (`Order_id`) REFERENCES `order` (`id`),
  CONSTRAINT `book_order_item_ibfk_1` FOREIGN KEY (`Book_id`) REFERENCES `book` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_order_item`
--

LOCK TABLES `book_order_item` WRITE;
/*!40000 ALTER TABLE `book_order_item` DISABLE KEYS */;
INSERT INTO `book_order_item` VALUES (1,1,1,4),(2,1,1,9),(3,1,2,4),(4,1,2,7),(5,1,2,9),(6,1,3,4),(7,1,4,4),(8,1,5,4);
/*!40000 ALTER TABLE `book_order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_purchase`
--

DROP TABLE IF EXISTS `book_purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_purchase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `unit_price` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `date_of_purchase` date NOT NULL,
  `vendor_name` varchar(50) NOT NULL,
  `Book_id` int(11) NOT NULL,
  `Expense_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `book_purchase_Book_id_97cc637b_fk_book_id` (`Book_id`),
  KEY `book_purchase_Expense_id_fd2aef05_fk_expense_id` (`Expense_id`),
  CONSTRAINT `book_purchase_Book_id_97cc637b_fk_book_id` FOREIGN KEY (`Book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `book_purchase_Expense_id_fd2aef05_fk_expense_id` FOREIGN KEY (`Expense_id`) REFERENCES `expense` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_purchase`
--

LOCK TABLES `book_purchase` WRITE;
/*!40000 ALTER TABLE `book_purchase` DISABLE KEYS */;
/*!40000 ALTER TABLE `book_purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_level` varchar(50) DEFAULT NULL,
  `no_of_students` int(11) NOT NULL,
  `School_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `class_School_id_f5f63aa2_fk_school_id` (`School_id`),
  CONSTRAINT `class_School_id_f5f63aa2_fk_school_id` FOREIGN KEY (`School_id`) REFERENCES `school` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
INSERT INTO `class` VALUES (1,'5',15,1),(2,'6',15,1),(3,'7',15,1);
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_Book`
--

DROP TABLE IF EXISTS `class_Book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class_Book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `class_Book_class_id_book_id_45af1001_uniq` (`class_id`,`book_id`),
  KEY `class_Book_book_id_94cd56e3_fk_book_id` (`book_id`),
  CONSTRAINT `class_Book_book_id_94cd56e3_fk_book_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `class_Book_class_id_6e88dca1_fk_class_id` FOREIGN KEY (`class_id`) REFERENCES `class` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_Book`
--

LOCK TABLES `class_Book` WRITE;
/*!40000 ALTER TABLE `class_Book` DISABLE KEYS */;
/*!40000 ALTER TABLE `class_Book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `joining_date` date NOT NULL,
  `salary` int(11) NOT NULL,
  `post` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expense`
--

DROP TABLE IF EXISTS `expense`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expense` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `service` varchar(50) DEFAULT NULL,
  `amount` int(11) NOT NULL,
  `date_of_expense` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expense`
--

LOCK TABLES `expense` WRITE;
/*!40000 ALTER TABLE `expense` DISABLE KEYS */;
INSERT INTO `expense` VALUES (1,'pankaj@123',50,NULL),(2,'pankaj@123',50,'2018-12-03');
/*!40000 ALTER TABLE `expense` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_date` date NOT NULL,
  `delivery_status` varchar(50) NOT NULL,
  `payment_status` varchar(50) NOT NULL,
  `payment_mode` varchar(50) NOT NULL,
  `Delivery_Address_id` int(11) NOT NULL,
  `PhoneNumber_id` int(11) NOT NULL,
  `Profile_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `order_Delivery_Address_id_1b82a8da_fk_address_id` (`Delivery_Address_id`),
  KEY `order_PhoneNumber_id_07d1e0c2_fk_phone_number_id` (`PhoneNumber_id`),
  KEY `order_Profile_id_8f82f730_fk_profile_id` (`Profile_id`),
  CONSTRAINT `order_Delivery_Address_id_1b82a8da_fk_address_id` FOREIGN KEY (`Delivery_Address_id`) REFERENCES `address` (`id`),
  CONSTRAINT `order_PhoneNumber_id_07d1e0c2_fk_phone_number_id` FOREIGN KEY (`PhoneNumber_id`) REFERENCES `phone_number` (`id`),
  CONSTRAINT `order_Profile_id_8f82f730_fk_profile_id` FOREIGN KEY (`Profile_id`) REFERENCES `profile` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (1,'2019-10-15','Not Delivered','PAID','Cash',2,3,12),(2,'2019-10-15','Not Delivered','PAID','Netbanking',3,4,12),(3,'2019-10-15','Not Delivered','PAID','Cash',4,5,13),(4,'2019-10-15','Not Delivered','PAID','Cash',4,5,13),(5,'2019-10-15','Not Delivered','PAID','Cash',5,6,14);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone_number`
--

DROP TABLE IF EXISTS `phone_number`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phone_number` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone_number` varchar(50) NOT NULL,
  `Profile_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `phone_number_Profile_id_71e530c9_fk_profile_id` (`Profile_id`),
  CONSTRAINT `phone_number_Profile_id_71e530c9_fk_profile_id` FOREIGN KEY (`Profile_id`) REFERENCES `profile` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone_number`
--

LOCK TABLES `phone_number` WRITE;
/*!40000 ALTER TABLE `phone_number` DISABLE KEYS */;
INSERT INTO `phone_number` VALUES (1,'5115168131',2),(2,'51151681351',2),(3,'7854123698',12),(4,'435132632513',12),(5,'7854123690',13),(6,'7854123690',14);
/*!40000 ALTER TABLE `phone_number` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profile`
--

DROP TABLE IF EXISTS `profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profile` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `points` int(11) DEFAULT NULL,
  `name` varchar(150) NOT NULL,
  `User_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `User_id` (`User_id`),
  CONSTRAINT `profile_User_id_eabb913b_fk_user_id` FOREIGN KEY (`User_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profile`
--

LOCK TABLES `profile` WRITE;
/*!40000 ALTER TABLE `profile` DISABLE KEYS */;
INSERT INTO `profile` VALUES (2,50,'amit',2),(3,55,'Pankaj Kumar Jha',1),(4,55,'Pankaj Kumar Jha',3),(10,0,'unkonown',8),(11,0,'unkonown',9),(12,0,'Piyush Maurya',10),(13,0,'Piyush Maurya',11),(14,0,'admin',12);
/*!40000 ALTER TABLE `profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `refund`
--

DROP TABLE IF EXISTS `refund`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `refund` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `request_date` date NOT NULL,
  `Amount` int(11) DEFAULT NULL,
  `Approved` tinyint(1) NOT NULL,
  `Expense_id` int(11) NOT NULL,
  `Order_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `refund_Expense_id_fa637086_fk_expense_id` (`Expense_id`),
  KEY `refund_Order_id_acf7d4d4_fk_order_id` (`Order_id`),
  CONSTRAINT `refund_Expense_id_fa637086_fk_expense_id` FOREIGN KEY (`Expense_id`) REFERENCES `expense` (`id`),
  CONSTRAINT `refund_Order_id_acf7d4d4_fk_order_id` FOREIGN KEY (`Order_id`) REFERENCES `order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `refund`
--

LOCK TABLES `refund` WRITE;
/*!40000 ALTER TABLE `refund` DISABLE KEYS */;
/*!40000 ALTER TABLE `refund` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `retailer_stationary_purchase`
--

DROP TABLE IF EXISTS `retailer_stationary_purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `retailer_stationary_purchase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `unit_price` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `date_of_purchase` date NOT NULL,
  `vendor_name` varchar(50) NOT NULL,
  `Expense_id` int(11) NOT NULL,
  `Stationary_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `retailer_stationary_purchase_Expense_id_6cb06da4_fk_expense_id` (`Expense_id`),
  KEY `retailer_stationary__Stationary_id_a7fadbea_fk_stationar` (`Stationary_id`),
  CONSTRAINT `retailer_stationary__Stationary_id_a7fadbea_fk_stationar` FOREIGN KEY (`Stationary_id`) REFERENCES `stationary` (`id`),
  CONSTRAINT `retailer_stationary_purchase_Expense_id_6cb06da4_fk_expense_id` FOREIGN KEY (`Expense_id`) REFERENCES `expense` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `retailer_stationary_purchase`
--

LOCK TABLES `retailer_stationary_purchase` WRITE;
/*!40000 ALTER TABLE `retailer_stationary_purchase` DISABLE KEYS */;
/*!40000 ALTER TABLE `retailer_stationary_purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'student'),(2,'admin');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary_expenses`
--

DROP TABLE IF EXISTS `salary_expenses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salary_expenses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Employee_id` int(11) NOT NULL,
  `Expense_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Expense_id` (`Expense_id`),
  KEY `salary_expenses_Employee_id_3867c6ba_fk_employee_id` (`Employee_id`),
  CONSTRAINT `salary_expenses_Employee_id_3867c6ba_fk_employee_id` FOREIGN KEY (`Employee_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `salary_expenses_Expense_id_080a2d58_fk_expense_id` FOREIGN KEY (`Expense_id`) REFERENCES `expense` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary_expenses`
--

LOCK TABLES `salary_expenses` WRITE;
/*!40000 ALTER TABLE `salary_expenses` DISABLE KEYS */;
/*!40000 ALTER TABLE `salary_expenses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `school`
--

DROP TABLE IF EXISTS `school`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `school` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `phone_number` varchar(50) DEFAULT NULL,
  `agent_name` varchar(50) DEFAULT NULL,
  `address` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `school`
--

LOCK TABLES `school` WRITE;
/*!40000 ALTER TABLE `school` DISABLE KEYS */;
INSERT INTO `school` VALUES (1,'Gyan Mandir','789965412','rohit','jkn');
/*!40000 ALTER TABLE `school` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stationary`
--

DROP TABLE IF EXISTS `stationary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stationary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_type` varchar(50) DEFAULT NULL,
  `stock` int(11) NOT NULL,
  `brand` varchar(50) DEFAULT NULL,
  `selling_price` int(11) DEFAULT NULL,
  `marked_price` int(11) DEFAULT NULL,
  `discounted_price` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stationary`
--

LOCK TABLES `stationary` WRITE;
/*!40000 ALTER TABLE `stationary` DISABLE KEYS */;
INSERT INTO `stationary` VALUES (1,'Pen',55,'Natraj',5,8,4),(2,'Pen',75,'Finegrip',5,8,4);
/*!40000 ALTER TABLE `stationary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stationary_order_item`
--

DROP TABLE IF EXISTS `stationary_order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stationary_order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) NOT NULL,
  `Order_id` int(11) NOT NULL,
  `Stationary_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `stationary_order_item_Order_id_af7ca0d2_fk_order_id` (`Order_id`),
  KEY `Stationary_id` (`Stationary_id`),
  CONSTRAINT `stationary_order_item_Order_id_af7ca0d2_fk_order_id` FOREIGN KEY (`Order_id`) REFERENCES `order` (`id`),
  CONSTRAINT `stationary_order_item_ibfk_1` FOREIGN KEY (`Stationary_id`) REFERENCES `stationary` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stationary_order_item`
--

LOCK TABLES `stationary_order_item` WRITE;
/*!40000 ALTER TABLE `stationary_order_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `stationary_order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(1000) DEFAULT NULL,
  `user_name` varchar(50) NOT NULL,
  `email` varchar(254) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (4,'$2a$10$QQ.dfhFeDSrfFUKZujIP1OLEwWp7g8vPtvhSizY6SLFHRdmWcW/Ce','piyush@gmail.com','piyush@gmail.com'),(5,'$2a$10$SybHty.8Wko62BlRdlGaBeOdOvLwXk91EhxyAIaWdpY3PEwB/I.AK','pankaj@gmail.com','pankaj@gmail.com'),(6,'$2a$10$39X43LWObYK514RADX0rCengpfbUsWueVsQr4iG9KxXTo2.80QAAa','amit@gmail.com','amit@gmail.com'),(7,'$2a$10$FSx9SwIMRTf/m3ssTgiMauvZApEXKW5INtR2voT7fkO6X8lnIIgbK','ramu@gmail.com','ramu@gmail.com'),(8,'$2a$10$zFyi.C2HD16mPcV/zmcFD.SZW2tsGD77SWyfyZCm22BV1aoXWhkUy','amit','Ramesh@gmail.com'),(9,'$2a$10$nhSE0ivGTMYl1rETbr.1..6aEdztX5SGX5Ojp.Bl/r3VlgW.QVaU2','pankaj','Ramesh@gmail.com'),(10,'$2a$10$pLMgT3WxYuPSu5NNySyRjuvZLmaMMO3p3PwCKdYiVONj9nQIfg8OO','pandey','coal@gmail.com'),(11,'$2a$10$4L5F1lWWUnel6KyHdPyXau8apBOG6jq60aldY.pQyHR7FJGM6WRZ2','rohit','rohit@gmail.com'),(12,'$2a$10$Z4g9cY..NZ4K36bSbD16FeYFv/0gyEDW/tkL2v9ah1RMHIAJJx98q','admin','admin@gmail.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_Role`
--

DROP TABLE IF EXISTS `user_Role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_Role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_Role_user_id_role_id_5f72fd84_uniq` (`user_id`,`role_id`),
  KEY `user_Role_role_id_9954ab90_fk_role_id` (`role_id`),
  CONSTRAINT `user_Role_role_id_9954ab90_fk_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `user_Role_user_id_a226122b_fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_Role`
--

LOCK TABLES `user_Role` WRITE;
/*!40000 ALTER TABLE `user_Role` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_Role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-15 12:53:11
