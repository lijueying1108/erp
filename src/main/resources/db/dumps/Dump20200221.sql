-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: mverp_dev
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
-- Table structure for table `as_info`
--

DROP TABLE IF EXISTS `as_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `as_info` (
  `id` varchar(45) NOT NULL,
  `customercompanyempinfoid` varchar(45) NOT NULL,
  `전화통화일` timestamp NULL DEFAULT NULL,
  `전화통화자명` varchar(45) DEFAULT NULL,
  `전화통화내용` varchar(45) DEFAULT NULL,
  `차수` int(11) DEFAULT NULL,
  `비고` varchar(45) DEFAULT NULL,
  `미회수분현황` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customercompany_emp_info_id_idx` (`customercompanyempinfoid`),
  CONSTRAINT `customercompany_emp_info_id` FOREIGN KEY (`customercompanyempinfoid`) REFERENCES `customercompany_emp_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `as_info`
--

LOCK TABLES `as_info` WRITE;
/*!40000 ALTER TABLE `as_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `as_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_classification_code`
--

DROP TABLE IF EXISTS `customer_classification_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_classification_code` (
  `code` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `sort` varchar(45) DEFAULT NULL,
  `note` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`code`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_classification_code`
--

LOCK TABLES `customer_classification_code` WRITE;
/*!40000 ALTER TABLE `customer_classification_code` DISABLE KEYS */;
INSERT INTO `customer_classification_code` VALUES ('B','금용권','2','bank'),('G','일반사','3','general'),('K','공기업','1','korea');
/*!40000 ALTER TABLE `customer_classification_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_code`
--

DROP TABLE IF EXISTS `customer_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_code` (
  `code` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `sort` varchar(45) DEFAULT NULL,
  `note` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`code`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_code`
--

LOCK TABLES `customer_code` WRITE;
/*!40000 ALTER TABLE `customer_code` DISABLE KEYS */;
INSERT INTO `customer_code` VALUES (1,'하나은행','하나은행',NULL),(2,'한국가스공사','한국가스공사',NULL),(3,'경찰청','경찰청',NULL);
/*!40000 ALTER TABLE `customer_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customercompany_address`
--

DROP TABLE IF EXISTS `customercompany_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customercompany_address` (
  `id` varchar(45) NOT NULL,
  `소속부서` varchar(45) NOT NULL,
  `주소` varchar(45) NOT NULL,
  `담당자` varchar(45) DEFAULT NULL,
  `담당자전화버호` varchar(45) DEFAULT NULL,
  `projectId` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `customAddressProjId_FK_idx` (`projectId`),
  CONSTRAINT `customAddressId_projectId_FK` FOREIGN KEY (`id`) REFERENCES `project` (`id`),
  CONSTRAINT `customAddressProjId_FK` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customercompany_address`
--

LOCK TABLES `customercompany_address` WRITE;
/*!40000 ALTER TABLE `customercompany_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `customercompany_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customercompany_emp_exchange_info`
--

DROP TABLE IF EXISTS `customercompany_emp_exchange_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customercompany_emp_exchange_info` (
  `id` varchar(45) NOT NULL,
  `교환신청일` timestamp NULL DEFAULT NULL,
  `교환종류` varchar(45) DEFAULT NULL,
  `교환포장일` timestamp NULL DEFAULT NULL,
  `교환송장일` timestamp NULL DEFAULT NULL,
  `교환송장번호` varchar(45) DEFAULT NULL,
  `교환비고` varchar(45) DEFAULT NULL,
  `교환메세지` varchar(45) DEFAULT NULL,
  `교환입력자` varchar(45) NOT NULL,
  `asinfoId` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customercompany_emp_exchange_info`
--

LOCK TABLES `customercompany_emp_exchange_info` WRITE;
/*!40000 ALTER TABLE `customercompany_emp_exchange_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `customercompany_emp_exchange_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customercompany_emp_info`
--

DROP TABLE IF EXISTS `customercompany_emp_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customercompany_emp_info` (
  `id` varchar(45) NOT NULL,
  `성명` varchar(45) NOT NULL,
  `projectId` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `projectId_FK_idx` (`projectId`),
  CONSTRAINT `projectId_FK` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customercompany_emp_info`
--

LOCK TABLES `customercompany_emp_info` WRITE;
/*!40000 ALTER TABLE `customercompany_emp_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `customercompany_emp_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customercompany_emp_item_exchange_info`
--

DROP TABLE IF EXISTS `customercompany_emp_item_exchange_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customercompany_emp_item_exchange_info` (
  `id` varchar(45) NOT NULL,
  `입력일자` timestamp NOT NULL,
  `갱신일자` varchar(45) NOT NULL,
  `교환정보Id` varchar(45) NOT NULL,
  `품목내역Id` varchar(45) NOT NULL,
  `수량` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `품목내역Id_FK_idx` (`품목내역Id`),
  KEY `교환정보Id_FK_idx` (`교환정보Id`),
  CONSTRAINT `교환정보Id_FK` FOREIGN KEY (`교환정보Id`) REFERENCES `customercompany_emp_exchange_info` (`id`),
  CONSTRAINT `품목내역Id_FK` FOREIGN KEY (`품목내역Id`) REFERENCES `project_item_size` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customercompany_emp_item_exchange_info`
--

LOCK TABLES `customercompany_emp_item_exchange_info` WRITE;
/*!40000 ALTER TABLE `customercompany_emp_item_exchange_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `customercompany_emp_item_exchange_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customercompany_emp_item_new_info`
--

DROP TABLE IF EXISTS `customercompany_emp_item_new_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customercompany_emp_item_new_info` (
  `id` varchar(45) NOT NULL,
  `입력일자` timestamp NOT NULL,
  `갱신일자` varchar(45) NOT NULL,
  `신규정보Id` varchar(45) NOT NULL,
  `폼목Id` varchar(45) NOT NULL,
  `사이즈Id` varchar(45) NOT NULL,
  `수량` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `newInfo_Id_FK_idx` (`신규정보Id`),
  KEY `itemcontents_Id_FK_idx` (`폼목Id`),
  KEY `itemsize_Id_FK_idx` (`사이즈Id`),
  CONSTRAINT `itemcontents_Id_FK` FOREIGN KEY (`폼목Id`) REFERENCES `project_item_info` (`itemId`),
  CONSTRAINT `itemsize_Id_FK` FOREIGN KEY (`사이즈Id`) REFERENCES `project_item_size` (`id`),
  CONSTRAINT `newInfo_Id_FK` FOREIGN KEY (`신규정보Id`) REFERENCES `customercompany_emp_new_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customercompany_emp_item_new_info`
--

LOCK TABLES `customercompany_emp_item_new_info` WRITE;
/*!40000 ALTER TABLE `customercompany_emp_item_new_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `customercompany_emp_item_new_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customercompany_emp_item_recovery_info`
--

DROP TABLE IF EXISTS `customercompany_emp_item_recovery_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customercompany_emp_item_recovery_info` (
  `id` varchar(45) NOT NULL,
  `입력일자` timestamp NULL DEFAULT NULL,
  `갱신일자` timestamp NULL DEFAULT NULL,
  `회수정보Id` varchar(45) DEFAULT NULL,
  `품목내역Id` varchar(45) DEFAULT NULL,
  `수량` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `회수정보Id_FK_idx` (`회수정보Id`),
  KEY `교환품목Id_FK_idx` (`품목내역Id`),
  CONSTRAINT `교환품목Id_FK` FOREIGN KEY (`품목내역Id`) REFERENCES `project_item_size` (`id`),
  CONSTRAINT `회수정보Id_FK` FOREIGN KEY (`회수정보Id`) REFERENCES `customercompany_emp_recovery_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customercompany_emp_item_recovery_info`
--

LOCK TABLES `customercompany_emp_item_recovery_info` WRITE;
/*!40000 ALTER TABLE `customercompany_emp_item_recovery_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `customercompany_emp_item_recovery_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customercompany_emp_new_info`
--

DROP TABLE IF EXISTS `customercompany_emp_new_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customercompany_emp_new_info` (
  `id` varchar(45) NOT NULL,
  `순번` varchar(45) NOT NULL,
  `신청년` varchar(45) NOT NULL,
  `신청월` varchar(45) NOT NULL,
  `신규신청일` varchar(45) NOT NULL,
  `신규포장일` varchar(45) NOT NULL,
  `신규송장일` varchar(45) DEFAULT NULL,
  `신규송장번호` varchar(45) DEFAULT NULL,
  `구분` varchar(45) NOT NULL,
  `비고` varchar(45) DEFAULT NULL,
  `신규메시지` varchar(45) DEFAULT NULL,
  `신규입력자` varchar(45) NOT NULL,
  `customercompanyempinfoId` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `customcompany_emp_info_id_idx` (`customercompanyempinfoId`),
  KEY `신규입력자_Id_idx` (`신규입력자`),
  CONSTRAINT `customcompany_emp_info_id` FOREIGN KEY (`customercompanyempinfoId`) REFERENCES `customercompany_emp_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customercompany_emp_new_info`
--

LOCK TABLES `customercompany_emp_new_info` WRITE;
/*!40000 ALTER TABLE `customercompany_emp_new_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `customercompany_emp_new_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customercompany_emp_recovery_info`
--

DROP TABLE IF EXISTS `customercompany_emp_recovery_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customercompany_emp_recovery_info` (
  `id` varchar(45) NOT NULL,
  `회수일자` timestamp NULL DEFAULT NULL,
  `회수입력자` varchar(45) DEFAULT NULL,
  `회수비고` varchar(45) DEFAULT NULL,
  `asInfoId` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `asInfo_id_idx` (`asInfoId`),
  CONSTRAINT `asInfo_id` FOREIGN KEY (`asInfoId`) REFERENCES `as_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='고객사의 직원별로 회수 정보 테이블';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customercompany_emp_recovery_info`
--

LOCK TABLES `customercompany_emp_recovery_info` WRITE;
/*!40000 ALTER TABLE `customercompany_emp_recovery_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `customercompany_emp_recovery_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customercompany_info`
--

DROP TABLE IF EXISTS `customercompany_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customercompany_info` (
  `id` varchar(45) NOT NULL,
  `고개사명` varchar(45) NOT NULL,
  `은행명` varchar(45) NOT NULL,
  `계좌번호` varchar(45) NOT NULL,
  `주소` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customercompany_info`
--

LOCK TABLES `customercompany_info` WRITE;
/*!40000 ALTER TABLE `customercompany_info` DISABLE KEYS */;
INSERT INTO `customercompany_info` VALUES ('1','하나은행','하나은행','110-110-110-110','서울특별시 중구');
/*!40000 ALTER TABLE `customercompany_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `id` varchar(45) NOT NULL,
  `부서명` varchar(45) NOT NULL,
  `sortstring` varchar(45) NOT NULL,
  PRIMARY KEY (`부서명`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES ('9','경리팀','ㄱ'),('5','디자인실','ㄷ'),('8','물류팀','ㅁ'),('7','생산팀','ㅅ'),('2','영업1팀','ㅇ1'),('3','영업2팀','ㅇ2'),('4','영업3팀','ㅇ3'),('6','자재팀','ㅈㅈ'),('1','지원부서','ㅈㅇ');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `ID` varchar(45) NOT NULL,
  `성명` varchar(45) NOT NULL,
  `주민등록번호` varchar(45) NOT NULL,
  `핸드폰번호` varchar(45) NOT NULL,
  `이메일주소` varchar(45) NOT NULL,
  `자격증유무` char(4) NOT NULL,
  `특이사항` varchar(45) DEFAULT NULL,
  `입사일` timestamp NOT NULL,
  `부서` varchar(45) NOT NULL,
  `직급` varchar(45) NOT NULL,
  `등급` varchar(45) NOT NULL,
  `퇴사일` timestamp NULL DEFAULT NULL,
  `deleteStatus` tinyint(4) DEFAULT NULL,
  `재직상태` varchar(45) NOT NULL,
  `집주소` varchar(45) DEFAULT NULL,
  `certification` varchar(255) DEFAULT NULL,
  `depart` varchar(255) DEFAULT NULL,
  `email_address` varchar(255) DEFAULT NULL,
  `hiredate` datetime DEFAULT NULL,
  `home_address` varchar(255) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `mobile_num` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `office_status` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `resid_registr_num` varchar(255) DEFAULT NULL,
  `resignation_date` datetime DEFAULT NULL,
  `special_note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('12313','123','123','123','123','123','123','2019-12-25 15:00:00','지원부서','팀장','C',NULL,0,'재직',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('3224','김영한','900101-6200000','010-8785-9685','yyoungha@naver.com','유','무','1999-12-31 15:00:00','지원부서','이사','A',NULL,0,'재직',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('3231','전하윤','900101-6200000','010-8735-6554','wjsgkdbs@nvaer.com','유','무','1999-12-31 15:00:00','디자인실','팀장','A',NULL,0,'재직',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('3234','김경순','900101-6200000','010-8985-0855','rlarudtns@naver.com','유','무','1999-12-31 15:00:00','생산팀','팀장','A',NULL,0,'재직',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('3238','금오늘','900101-6200000','010-8807-5293','rmadhsmf@gmail.com','유','무','1999-12-31 15:00:00','디자인실','팀원','C',NULL,0,'재직',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('3320','민홍기','900125-6200000','010-4536-3123','minhk0125@gmail.com','유','무','1999-12-31 15:00:00','지원부서','대표이사','S',NULL,0,'재직',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('3340','홍길동','890808','010-0000-0000','ghdrlfehd@gmail.com','유','토플 만점','2009-08-07 15:00:00','물루팀','팀원','C',NULL,0,'재직','경기도',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('3344','이홍식','821231-4123456','010-4444-0000','li@gmail.com','무',NULL,'2020-01-01 04:41:30','물류팀','부사장','B',NULL,0,'재직',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('3348','민경현','900125-6200000','010-4536-3123','minhk0125@gmail.com','유','무','1999-12-31 15:00:00','물류팀','팀원','C',NULL,1,'퇴사',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('4544','이홍식','821231-1023714','010-5668-4352','jk@gmail.com','무',NULL,'2019-12-31 20:19:51','물류팀','팀원','C',NULL,0,'퇴사',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('921108','이각영','921108-6222222','010-5668-4352','lijueying1108@gmail.com','유','TOPIK4','2019-11-07 15:00:00','지원부서팀','사원','S',NULL,0,'재직','서울시 광진구',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('9300','이각영','931108-6222221','010-5668-4351','lijueying931108@gmail.com','유','TOPIK4','2019-11-07 15:00:00','영업팀','사원','S',NULL,0,'재직',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gender_code`
--

DROP TABLE IF EXISTS `gender_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gender_code` (
  `code` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `sort` varchar(45) DEFAULT NULL,
  `note` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`code`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gender_code`
--

LOCK TABLES `gender_code` WRITE;
/*!40000 ALTER TABLE `gender_code` DISABLE KEYS */;
INSERT INTO `gender_code` VALUES ('F','여성','2','Female'),('M','남성','1','Male'),('U','공용','3','Unisex');
/*!40000 ALTER TABLE `gender_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goodstype_code`
--

DROP TABLE IF EXISTS `goodstype_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `goodstype_code` (
  `code` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `sort` varchar(45) DEFAULT NULL,
  `note` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`code`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='상품유형';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goodstype_code`
--

LOCK TABLES `goodstype_code` WRITE;
/*!40000 ALTER TABLE `goodstype_code` DISABLE KEYS */;
INSERT INTO `goodstype_code` VALUES ('B','복지품','6','well being'),('H','방한복','4','heavy'),('O','근무복','1','Office'),('P','기획','5','Plan'),('S','성하복','3','Summer'),('W','작업복','2','Work');
/*!40000 ALTER TABLE `goodstype_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `numId` int(11) NOT NULL,
  `majorClassficName` varchar(45) NOT NULL DEFAULT '대분류',
  `subClassficName` varchar(45) DEFAULT '소분류',
  PRIMARY KEY (`numId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,'JACKET$COAT','정장자콋'),(2,'MIDDEL WEAR','니트조끼'),(3,'MIDDEL WEAR','가디건'),(4,'BLOUSE','니트블라우스'),(5,'BLOUSE','긴팔블라우스'),(6,'BOTTOM','스커트'),(7,'BOTTOM','정장바지'),(8,'JACKET$COAT','오버코트');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `level`
--

DROP TABLE IF EXISTS `level`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `level` (
  `id` varchar(45) NOT NULL,
  `등급별` varchar(45) NOT NULL,
  PRIMARY KEY (`등급별`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `level`
--

LOCK TABLES `level` WRITE;
/*!40000 ALTER TABLE `level` DISABLE KEYS */;
INSERT INTO `level` VALUES ('2','A'),('3','B'),('4','C'),('1','S');
/*!40000 ALTER TABLE `level` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `major_item_code`
--

DROP TABLE IF EXISTS `major_item_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `major_item_code` (
  `code` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `sort` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`code`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `major_item_code`
--

LOCK TABLES `major_item_code` WRITE;
/*!40000 ALTER TABLE `major_item_code` DISABLE KEYS */;
INSERT INTO `major_item_code` VALUES ('A','ACCESSORY','8'),('B','BOTTOM','6'),('C','JACKET& COAT','1'),('J','JUMPER','2'),('L','BLOUSE','4'),('M','MIDDLE WEAR','3'),('O','ORDERS','7'),('S','SHIRTS','5');
/*!40000 ALTER TABLE `major_item_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `officestatus`
--

DROP TABLE IF EXISTS `officestatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `officestatus` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `officestatus`
--

LOCK TABLES `officestatus` WRITE;
/*!40000 ALTER TABLE `officestatus` DISABLE KEYS */;
INSERT INTO `officestatus` VALUES ('1','재직'),('2','퇴사');
/*!40000 ALTER TABLE `officestatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position`
--

DROP TABLE IF EXISTS `position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `position` (
  `id` varchar(45) NOT NULL,
  `직급명` varchar(45) NOT NULL,
  `sortstring` varchar(45) NOT NULL,
  PRIMARY KEY (`직급명`,`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` VALUES ('1','대표이사','ㄷ'),('2','부사장','ㅂ'),('5','부장','ㅂㅈ'),('6','사원','ㅅ'),('3','상무','ㅅ'),('4','이사','ㅇ'),('8','팀원','ㅌㅇ'),('7','팀장','ㅌㅈ');
/*!40000 ALTER TABLE `position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project` (
  `id` varchar(45) NOT NULL,
  `projectNameCode` varchar(45) NOT NULL COMMENT '''프로젝트명''',
  `businessDepartTeam` varchar(45) DEFAULT NULL COMMENT '''영업부서명''',
  `businessEmp` varchar(45) DEFAULT NULL COMMENT '''영업담당자명''',
  `designEmp` varchar(45) DEFAULT NULL COMMENT '''디자인담당자명''',
  `productEmp` varchar(45) DEFAULT NULL COMMENT '''생산담당자명''',
  `distributionEmp` varchar(45) DEFAULT NULL COMMENT '''물류담당자명''',
  `takeProjectStateDate` timestamp NULL DEFAULT NULL COMMENT '''수주확정일''',
  `goodsEvaluStartDate` timestamp NULL DEFAULT NULL COMMENT '''품평회시작일''',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES ('1',' A007F2121','영업1팀','노요한','김상헌','김선기','홍승현','0000-00-00 00:00:00','0000-00-00 00:00:00'),('2','B2K02FSO001','영업1팀',NULL,NULL,NULL,NULL,NULL,NULL),('3','B0K58MSW002','영업1팀',NULL,NULL,NULL,NULL,NULL,NULL),('4','B0B31FSO003','영업1팀',NULL,NULL,NULL,NULL,NULL,NULL),('5','B0G59MSW004',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('6','B0G62MFB005',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('7','B0G61UFB006',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_item_info`
--

DROP TABLE IF EXISTS `project_item_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project_item_info` (
  `numId` varchar(45) DEFAULT NULL,
  `itemId` varchar(45) NOT NULL COMMENT '''품목ID''',
  `projectNameCode` varchar(45) NOT NULL COMMENT '프로젝트명',
  `majorClassific` varchar(45) NOT NULL COMMENT '''대분류''',
  `subClassific` varchar(45) NOT NULL COMMENT '''소분류''',
  `amount` int(11) NOT NULL COMMENT '수량',
  `unitPrice` int(11) NOT NULL COMMENT '단가',
  PRIMARY KEY (`itemId`,`projectNameCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_item_info`
--

LOCK TABLES `project_item_info` WRITE;
/*!40000 ALTER TABLE `project_item_info` DISABLE KEYS */;
INSERT INTO `project_item_info` VALUES ('6','A0-121-B-01','A007F2121','BOTTOM','스커트',1,40000),('7','A0-121-B-02','A007F2121','BOTTOM','정장바지',1,42000),('1','A0-121-C-01','A007F2121','JACKET& COAT','정장자켓',1,65000),('8','A0-121-C-03','A007F2121','JACKET& COAT','오버코트',1,89000),('5','A0-121-L-01','A007F2121','BLOUSE','긴팔블라우스',2,38000),('4','A0-121-L-03','A007F2121','BLOUSE','니트블라우스',1,42000),('2','A0-121-M-02','A007F2121','MIDDLE WEAR','니트조끼',1,48000),('3','A0-121-M-03','A007F2121','MIDDLE WEAR','가디건',1,57000);
/*!40000 ALTER TABLE `project_item_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_item_size`
--

DROP TABLE IF EXISTS `project_item_size`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project_item_size` (
  `id` varchar(45) NOT NULL,
  `품목코드Id` varchar(45) NOT NULL,
  `사이즈` varchar(45) NOT NULL,
  `비고` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `itemCodeId_FK_idx` (`품목코드Id`),
  CONSTRAINT `itemCodeId_FK` FOREIGN KEY (`품목코드Id`) REFERENCES `project_item_info` (`itemId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_item_size`
--

LOCK TABLES `project_item_size` WRITE;
/*!40000 ALTER TABLE `project_item_size` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_item_size` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_name`
--

DROP TABLE IF EXISTS `project_name`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project_name` (
  `id` varchar(45) NOT NULL,
  `year` varchar(45) DEFAULT NULL,
  `season` varchar(45) DEFAULT NULL,
  `customerCompany` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `projectId` varchar(45) DEFAULT NULL,
  `winStatus` varchar(45) DEFAULT NULL,
  `goodsType` varchar(45) DEFAULT NULL,
  `projectNameCode` varchar(45) DEFAULT NULL COMMENT '프로젝트명',
  `customerClassific` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_name`
--

LOCK TABLES `project_name` WRITE;
/*!40000 ALTER TABLE `project_name` DISABLE KEYS */;
INSERT INTO `project_name` VALUES ('1','2022','하계','(주)강남은행','여성','001','진행중','근무복','B2K02FSO001','금용권'),('2','2020','하계','대한산업안정협회','남성','002','수주됨','작업복','B0K58MSW002','공기업'),('3','2020','하계','산업협동조합중앙','여성','003','진행중','근무복','B0B31FSO003','공기업'),('4','2020','하계','LG전자','남성','004','진행중','작업복','B0G59MSW004','일반사'),('5','2020','사계절','현대자동차','여성','005','진행중','복지품','B0G62MFB005','일반사'),('6','2020','사계절','기아자동차','공용','006','진행중','복지품','B0G61UFB006','일반사'),('7','2019','동계','신한은행','여서','002','수주됨','근무복','A007F2121','금용권');
/*!40000 ALTER TABLE `project_name` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `season_code`
--

DROP TABLE IF EXISTS `season_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `season_code` (
  `code` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `sort` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`code`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='시즌 코드';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `season_code`
--

LOCK TABLES `season_code` WRITE;
/*!40000 ALTER TABLE `season_code` DISABLE KEYS */;
INSERT INTO `season_code` VALUES ('1','하계','1'),('2','동계','2'),('3','춘추','3'),('4','사계절','4'),('5','기타','5');
/*!40000 ALTER TABLE `season_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sub_item_code`
--

DROP TABLE IF EXISTS `sub_item_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sub_item_code` (
  `code` varchar(45) NOT NULL COMMENT '소분류코드',
  `subItemName` varchar(45) NOT NULL COMMENT '소분류',
  `majorItemName` varchar(45) NOT NULL COMMENT '대분류',
  PRIMARY KEY (`code`,`subItemName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='품목 소분류코드테이블';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sub_item_code`
--

LOCK TABLES `sub_item_code` WRITE;
/*!40000 ALTER TABLE `sub_item_code` DISABLE KEYS */;
INSERT INTO `sub_item_code` VALUES ('01','긴팔블라우스','BLOUSE'),('01','긴팔와이셔츠','SHIRTS'),('01','리본','ACCESSORY'),('01','스커트','BOTTOM'),('01','우븐조끼','MIDDLE WEAR'),('01','우의','ORDERS'),('01','정장자켓','JACKET&COAT'),('01','하계점퍼','JUMPER'),('02','니트조끼','MIDDLE WEAR'),('02','반팔블라우스','BLOUSE'),('02','반팔와이셔츠','SHIRTS'),('02','스카프','ACCESSORY'),('02','원피스','BOTTOM'),('02','춘추점퍼','JUMPER'),('02','케쥬얼자켓','JACKET&COAT'),('02','트레이닝복','ORDERS'),('03','가디건','MIDDLE WEAR'),('03','기동복','ORDERS'),('03','넥타이','ACCESSORY'),('03','니트블라우스','BLOUSE'),('03','동계점퍼','JUMPER'),('03','오버코트','JACKET&COAT'),('03','정장바지','BOTTOM'),('03','티셔츠','SHIRTS'),('04','망사조끼','MIDDLE WEAR'),('04','방한점퍼','JUMPER'),('04','방한코트','JACKET&COAT'),('04','벨트','ACCESSORY'),('04','성하복','SHIRTS'),('04','작업복바지','BOTTOM'),('04','칠부블라우스','BLOUSE'),('05','가방','ACCESSORY'),('05','목폴라','SHIRTS'),('05','반바지','BOTTOM'),('05','패딩조끼','MIDDLE WEAR'),('06','방한바지','BOTTOM'),('06','신발','ACCESSORY'),('07','모자','ACCESSORY'),('08','장갑','ACCESSORY');
/*!40000 ALTER TABLE `sub_item_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_permission`
--

DROP TABLE IF EXISTS `sys_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_permission` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  `url` varchar(45) DEFAULT NULL,
  `percode` varchar(45) DEFAULT NULL,
  `sortstring` varchar(45) DEFAULT 'ㄱ ㄴ ㄷ',
  `parentId` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_permission`
--

LOCK TABLES `sys_permission` WRITE;
/*!40000 ALTER TABLE `sys_permission` DISABLE KEYS */;
INSERT INTO `sys_permission` VALUES ('11','직원정보관리','menu','/employee',NULL,'ㅈ',NULL),('12','직원정보추가','permission','/employee/create','employee:create','','11'),('13','직원정보검색','permission','/employee/query','employee:query','','11'),('14','직원정보삭제','permission','/employee/delete','employee:delete','','11'),('15','직원정보수정','permission','/employee/modify','employee:modify','','11');
/*!40000 ALTER TABLE `sys_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `available` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES ('11','S',NULL),('21','A',NULL),('22','B',NULL);
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_permission`
--

DROP TABLE IF EXISTS `sys_role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role_permission` (
  `id` varchar(45) NOT NULL,
  `sys_role_id` varchar(45) NOT NULL,
  `sys_permission_id` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ROLE_PER_ROLE_ID_idx` (`sys_role_id`),
  KEY `FK_ROLE_PER_PER_ID_idx` (`sys_permission_id`),
  CONSTRAINT `FK_ROLE_PER_PER_ID` FOREIGN KEY (`sys_permission_id`) REFERENCES `sys_permission` (`id`),
  CONSTRAINT `FK_ROLE_PER_ROLE_ID` FOREIGN KEY (`sys_role_id`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_permission`
--

LOCK TABLES `sys_role_permission` WRITE;
/*!40000 ALTER TABLE `sys_role_permission` DISABLE KEYS */;
INSERT INTO `sys_role_permission` VALUES ('1','11','11'),('2','11','12'),('3','11','13'),('4','11','14'),('5','11','15'),('6','21','11'),('7','21','13');
/*!40000 ALTER TABLE `sys_role_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user` (
  `id` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `salt` varchar(45) DEFAULT NULL,
  `locked` char(1) DEFAULT NULL,
  `emloyeeId` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_USER_EmloyeeId_idx` (`emloyeeId`),
  CONSTRAINT `FK_USER_EmloyeeId` FOREIGN KEY (`emloyeeId`) REFERENCES `employee` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES ('1','admin','admin','qwerty','0','921108'),('2','민홍기','alsghdrl','qwerty','0','3320'),('3','김영한','rladudgks','qwerty','0','3224'),('4','김경순','rlarudtns','qwerty','0','3234'),('5','금오늘','rmadhsmf','qwerty','0','3238'),('6','전하윤','wjsgkdbs','qwerty','0','3231');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user_role` (
  `id` varchar(45) NOT NULL,
  `sys_user_id` varchar(45) NOT NULL,
  `sys_role_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_SYS_USER_ROLE_USER_ID_idx` (`sys_user_id`),
  KEY `FK_SYS_USER_ROLE_ROLE_ID_idx` (`sys_role_id`),
  CONSTRAINT `FK_SYS_USER_ROLE_ROLE_ID` FOREIGN KEY (`sys_role_id`) REFERENCES `sys_role` (`id`),
  CONSTRAINT `FK_SYS_USER_ROLE_USER_ID` FOREIGN KEY (`sys_user_id`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_role`
--

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` VALUES ('1','1','11'),('2','2','11'),('3','3','11'),('4','4','21'),('5','5','22'),('6','6','21');
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `winstatus_code`
--

DROP TABLE IF EXISTS `winstatus_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `winstatus_code` (
  `code` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `sort` varchar(45) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `winstatus_code`
--

LOCK TABLES `winstatus_code` WRITE;
/*!40000 ALTER TABLE `winstatus_code` DISABLE KEYS */;
INSERT INTO `winstatus_code` VALUES ('I','진행중','2'),('L','루즈','3'),('W','수주됨','1');
/*!40000 ALTER TABLE `winstatus_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `year_code`
--

DROP TABLE IF EXISTS `year_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `year_code` (
  `code` varchar(10) NOT NULL,
  `name` varchar(10) NOT NULL,
  `sort` varchar(45) NOT NULL,
  PRIMARY KEY (`code`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `year_code`
--

LOCK TABLES `year_code` WRITE;
/*!40000 ALTER TABLE `year_code` DISABLE KEYS */;
INSERT INTO `year_code` VALUES ('A','2015','1'),('B','2016','2'),('C','2017','3'),('D','2018','4'),('E','2019','5'),('F','2020','6'),('G','2021','7'),('H','2022','8'),('I','2023','9'),('J','2024','10'),('K','2025','11'),('L','2026','12'),('M','2027','13'),('N','2028','14'),('O','2029','15'),('P','2030','16'),('Q','2031','17'),('R','2032','18'),('S','2033','19'),('T','2034','20'),('U','2035','21'),('V','2036','22'),('W','2037','23'),('X','2038','24'),('Y','2039','25'),('Z','FULL YEAR','26');
/*!40000 ALTER TABLE `year_code` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-21 19:04:18
