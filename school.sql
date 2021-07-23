-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: school
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `appuser`
--

DROP TABLE IF EXISTS `appuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appuser` (
  `id` int NOT NULL AUTO_INCREMENT,
  `app_username` varchar(100) NOT NULL,
  `app_password` varchar(255) NOT NULL,
  `app_privilege` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`app_username`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appuser`
--

LOCK TABLES `appuser` WRITE;
/*!40000 ALTER TABLE `appuser` DISABLE KEYS */;
INSERT INTO `appuser` VALUES (20,'johnd','PBKDF2WithHmacSHA256:2048:21yH75jCmxbcxzQvlMNpIKZO1C8PydROoY0MePYIHDk=:K54C2FDJvmRCKJaMSfzizLyg0nj6Jrc/3XlihAkzAlc=','superadmin'),(43,'henry.m','PBKDF2WithHmacSHA256:2048:wRURLGXm1dJhWMIpbhQ9otPA+0xInp3egCRAI92t/S0=:h8AHM9nWxlKBryqfaC7CvV5gWkwV4Ybm6lvNvp2AFPs=','student'),(47,'ron.j','PBKDF2WithHmacSHA256:2048:RgsE1LUqlqugh/t2VLEaY8Hn4rwctIF9qWCVYh3y+OM=:VxRl9Xkn73OK97gMBR8fhhHpZBW0VlsVqFUCLWLoZ40=','student'),(55,'filipa.b','PBKDF2WithHmacSHA256:2048:ogFoqdCQZnFsBj8gNC7S8RhwrlKICmFopuGVrzRpKno=:dVjxgbV1wyNvdPytP1zwl93kyr5jzrzEWB5cCLWXw+c=','staff'),(60,'mari.ti','PBKDF2WithHmacSHA256:2048:xF094ti28OihF/pD1dzjr09NF22W7YCUGzYiDiCzkNY=:r9ytfX6HMvAmjwLhHf6Xo6zXjcTZBg9LSCZKn8rnLXk=','staff'),(61,'ensi','PBKDF2WithHmacSHA256:2048:NNN8n22WB21q3PHtRdabw3zAm8hVejhony8mKl76wzI=:H2ULpLwLFPEbyxGOC04H/DclXC5BD32wqwHlSp/Wrqk=','staff'),(62,'alen.s','PBKDF2WithHmacSHA256:2048:MfOF0GYvoybYmejKvQ96nokMPhT/JJkIxW/BtO8jYUo=:fmbfk0JETUT3Jqt3rjvEG2oON5Ptbv3gJ+xOXyKqkf0=','staff'),(63,'mark.m','PBKDF2WithHmacSHA256:2048:gk27LiYyiwLzDnO+SehpQXJ62aN2XLIicOHVT12G1xU=:kadsmzXsm4d9/IR0oqM7OtkWYP67G3BMK6Ag8cro4YE=','staff'),(64,'alexi','PBKDF2WithHmacSHA256:2048:aJgLHHFz1oDfc7B49GCux4Nx4xe1p/W7CsRaDDHMsII=:U6OJSnWdMCnL+BzgQnFZ8mOUsMOMEluuOXvQU6f+GRE=','staff'),(66,'tomflo','PBKDF2WithHmacSHA256:2048:ogUgqZqGVlQkSc+K58pvTeXcPiSzPEo/Y1F2d3rvsjM=:nSrHfBfWoCBwXiWf1at93q0AOoob3Ph3o7cWe6J2XGA=','staff'),(67,'mackie.m','PBKDF2WithHmacSHA256:2048:LYBsVb5KUfa+rUP4jZzyadvgPadffs3ovvjyktD50Y0=:bns1eJsTTwaqApXw88jpKK4tgyT66RAVsQ3PGY+UDBk=','staff'),(72,'aron.te','PBKDF2WithHmacSHA256:2048:I1DytRQ+L6KkXr6WGt0xSgrfzv9T+I3G0Z81No+8mwo=:bjXnPle9B953Hy/aW+/3os8Vn1teY0lPgHYruNUqr08=','student'),(74,'marvin','PBKDF2WithHmacSHA256:2048:3q6/O7bYUdmJ8MfMoclNUetFHvazBDYYjicJKjYic74=:N+c7heF4tey4MayugMdFojaDbksLinNYWY9FeQpHT2s=','student'),(75,'mika','PBKDF2WithHmacSHA256:2048:j+cLvaF1SjbSgA3uCWMeAsVb6vWv5QEUt+J+SkfkcsU=:Y02RWr0DaRZeJlrgxQgrwR3mx6bIpc/Bmg80vJXf7II=','student'),(76,'oli','PBKDF2WithHmacSHA256:2048:SR9jS5Bgy1+uPfhh9BGstDNHBpnUckzV4RHrwBtZJ8s=:yIQFnMwCc6kkVMaC6Dd7OMG4obdhcUtyzloHfsLfdiY=','student'),(77,'vlad','PBKDF2WithHmacSHA256:2048:boFAGeF7IndfpiSe++oS9q7FJF9iETkTuGnifm7q3Nc=:htnzEP8LAuV8VvgDzdiKEdIUXR0/WGABI9bD4z2wXoo=','student'),(78,'lui','PBKDF2WithHmacSHA256:2048:zatX2AQbzKyOl0gPIoRzbz5pmClRvCyDi4iMiVh+xPI=:4mCbw07VS0htqAc8St4i1U970Pxd9kGEC0ig5DSnAhE=','student'),(79,'josa','PBKDF2WithHmacSHA256:2048:e9ohJxG27vKTwFXGRYvr5LDoQgviL8y4SVvh7Ts920o=:mFIYSqMmyLbibFnxJ9mnq9jhEM5lxmlQcJTEjI1iLSo=','student'),(80,'tim.d','PBKDF2WithHmacSHA256:2048:uLOFbQB4koZnLKCH4+5sovuGVgvT19V9gvGTZ0M5ZY4=:IlFBE3pyugaSTJQxhmeZ4FFv4MNOQbfhcgae5++WNSc=','staff'),(82,'jasmin.m','PBKDF2WithHmacSHA256:2048:ZtoHDzAxWE8mKYovtLxeiFX84tIrIE1tq9WRgdRrUZM=:vIGueHpAFTrU28S8HhcssKTY8DsdkCqFPUqHbhAjC4M=','staff'),(83,'raffy.dea','PBKDF2WithHmacSHA256:2048:Z1CGKzGnr7xKO+BcaLaRZNFFI+GG6LQr0mXR5diVWLE=:xC33SWAJTUrsScQRfRgcR045lk77XUUKtEGedLZJBVw=','staff'),(84,'ahmet.eric','PBKDF2WithHmacSHA256:2048:sogYhNgTYueY49yJOMO6nVaMVGhAJSIfw5wQ7cCnkR4=:6I7wdcY+jfRE8rTKeUw44pfd9YBy4+5NogqlZAFqttI=','student'),(85,'jelena.t','PBKDF2WithHmacSHA256:2048:glblG7uR0RlBT1EqApR9WPP/2wqmq0LPd6jnlTMFcGU=:/CD1Rod7/dE8v8qyVn0MYivjzKlgeczVmCMOuaeeWNA=','staff'),(86,'alija.a','PBKDF2WithHmacSHA256:2048:kcSO7ceKMgySEMS7k2JMV4WylypfrBc5h9r3jZMTsio=:Z7PhHuNzTGzt41diLXzXYR7zJNp66tgD6riTsuXCiZY=','staff'),(87,'viktor.v','PBKDF2WithHmacSHA256:2048:OkRAzJMlfbj+YQSNfuCV+cp+Z3sLHg65bbzWpl45pwM=:zoGphjYhEXcfRiR41QFWOYPIgt+eTG7WOBRuGMvmedY=','student'),(88,'emir.h','PBKDF2WithHmacSHA256:2048:w4GNAJLEki1kk1vfLEoeB/Df+2BM9QuMBiRxUC6JvUI=:29qBbhhKgL8s0ZDqrsmlqQXLRvJyXW9cwJj4b8xAd4o=','student'),(89,'enis.ba','PBKDF2WithHmacSHA256:2048:cPnH4jAnDavLeBeyExGFUXp9wiCm1Ax6wk5wDaKdiEk=:Sp5Ee+PZw0H4rvZc//fAqzey3fV9RLPxFnIGTPMqj3E=','student'),(90,'fadil.f','PBKDF2WithHmacSHA256:2048:4evT35fm4kVN66S0dueM7oDL0udryhetAXl2bImoND4=:J5zLseNfhiCSIidar7gZ7tqSmf34R5bp0sOOiMf/MGQ=','student'),(91,'senchy','PBKDF2WithHmacSHA256:2048:4cNwfUMPYlspISP2nSUxa7eK7KL24QzY+kACG/+YQvc=:rvsyrP5iaK78szJCZDlQ7/468+clh90qnK+VY4nYBkM=','student'),(92,'alisa.t','PBKDF2WithHmacSHA256:2048:w+8AUqk0kh52ucXpWIjnLyf4OYdgUgNfen54j33z31A=:qjXCHqKRPnwKOMQDd3RA5pYxCXV6adBCtrpfFd0n4bo=','student'),(93,'elma.b','PBKDF2WithHmacSHA256:2048:SBtnjWyZIqALZTjSbZFb0vrAZJZHmL4LwpfOdUhBXkA=:HqGUoFkCKrUmfongcMVoCoOq2j3J0xtl12vswG+TtnQ=','student'),(94,'selma.s','PBKDF2WithHmacSHA256:2048:SJKMBS9CDU0ti2BlSBjWuoWKxH5wQFylkmO82uTZutU=:n7h+Wk7I8GJClSl12ru7euvMC1vf7D9q6dJXB8oyCiU=','student'),(95,'Amer','PBKDF2WithHmacSHA256:2048:wVtXLVpMK1k3ucevPK9qCnlrbMRxhkzUYspvDehvLGU=:+sltvtNpwO0j81+2lOKo+Ex+gyyRJofXNIi3/ST7P7c=','staff');
/*!40000 ALTER TABLE `appuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classgroup`
--

DROP TABLE IF EXISTS `classgroup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classgroup` (
  `id` int NOT NULL AUTO_INCREMENT,
  `grade` int NOT NULL,
  `classroom_id` int NOT NULL,
  `head_staff_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `head_staff_id_UNIQUE` (`head_staff_id`),
  KEY `fk_classroom_id_idx` (`classroom_id`),
  CONSTRAINT `fk_classroom_id` FOREIGN KEY (`classroom_id`) REFERENCES `classroom` (`id`),
  CONSTRAINT `fk_headstaff_id` FOREIGN KEY (`head_staff_id`) REFERENCES `schoolstaff` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classgroup`
--

LOCK TABLES `classgroup` WRITE;
/*!40000 ALTER TABLE `classgroup` DISABLE KEYS */;
INSERT INTO `classgroup` VALUES (29,2,2,4),(34,3,4,7);
/*!40000 ALTER TABLE `classgroup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classroom`
--

DROP TABLE IF EXISTS `classroom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classroom` (
  `id` int NOT NULL AUTO_INCREMENT,
  `room_code` varchar(45) NOT NULL,
  `room_capacity` int NOT NULL,
  `av_equipped` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `room_code_UNIQUE` (`room_code`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classroom`
--

LOCK TABLES `classroom` WRITE;
/*!40000 ALTER TABLE `classroom` DISABLE KEYS */;
INSERT INTO `classroom` VALUES (1,'A01',25,1),(2,'A02',28,0),(3,'A03',27,1),(4,'B01',30,0);
/*!40000 ALTER TABLE `classroom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schoolstaff`
--

DROP TABLE IF EXISTS `schoolstaff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schoolstaff` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `surname` varchar(100) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `appuser_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `appuser_id_UNIQUE` (`appuser_id`),
  CONSTRAINT `fk_staff_appuser_id` FOREIGN KEY (`appuser_id`) REFERENCES `appuser` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schoolstaff`
--

LOCK TABLES `schoolstaff` WRITE;
/*!40000 ALTER TABLE `schoolstaff` DISABLE KEYS */;
INSERT INTO `schoolstaff` VALUES (1,'Filipa','Brkic','filipabrkic@exampl.com',55),(3,'Marija','Timos','some@some.com',60),(4,'Enisa','Salihodzic','snsa@live.com',61),(5,'Alen','Stoja','alenalen@mail.com',62),(6,'Marko','Ivilich','markomarko@mail.com',63),(7,'Alex','Zec','alexz@mail.com',64),(9,'Tom','Floris','flootmo@somemore.com',66),(10,'Mack ','Manson','chill@now.com',67),(13,'Timothy','Dalton','timeh@mail.com',80),(14,'Jasmin','Mujkic','jasko.m@hotmail.com',82),(18,'Rafael','Dean','rafy@raf.com',83);
/*!40000 ALTER TABLE `schoolstaff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff_subject`
--

DROP TABLE IF EXISTS `staff_subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff_subject` (
  `schoolstaff_id` int NOT NULL,
  `subject_id` int NOT NULL,
  PRIMARY KEY (`schoolstaff_id`,`subject_id`),
  UNIQUE KEY `schoolstaff_id_UNIQUE` (`schoolstaff_id`),
  KEY `fk_t_subject_id_idx` (`subject_id`),
  CONSTRAINT `fk_t_staff_id` FOREIGN KEY (`schoolstaff_id`) REFERENCES `schoolstaff` (`id`),
  CONSTRAINT `fk_t_subject_id` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff_subject`
--

LOCK TABLES `staff_subject` WRITE;
/*!40000 ALTER TABLE `staff_subject` DISABLE KEYS */;
INSERT INTO `staff_subject` VALUES (4,7),(5,2),(6,5),(7,6),(10,8);
/*!40000 ALTER TABLE `staff_subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `surname` varchar(100) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `appuser_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `appuser_id_UNIQUE` (`appuser_id`),
  CONSTRAINT `fk_ss_appuser_id` FOREIGN KEY (`appuser_id`) REFERENCES `appuser` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (9,'Henry','Miller','henry.m@hotmail.com',43),(11,'Ronny','Jamesson','ron.j@some.com',47),(14,'Arnel','Tenic','arnel@some.com',72),(16,'Mario','Vincento','min@some.com',74),(17,'Damir','Mijic','mika@mail.com',75),(18,'Oliver','Twist','mailme@ornot.com',76),(19,'Vladimir','Vladimirovich','vlad@yup.com',77),(20,'Luigi','Bros','lui@yup.com',78),(21,'Josip','Rajic','josra@hah.com',79),(22,'Elma','Basic','almba.basic@live.com',93),(23,'Senka','Izetovic','xoxo@real.com',91);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_classgroup`
--

DROP TABLE IF EXISTS `student_classgroup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_classgroup` (
  `student_id` int NOT NULL,
  `classgroup_id` int NOT NULL,
  PRIMARY KEY (`student_id`,`classgroup_id`),
  UNIQUE KEY `student_id_UNIQUE` (`student_id`),
  KEY `fk_sc_group_id_idx` (`classgroup_id`),
  CONSTRAINT `fk_sc_group_id` FOREIGN KEY (`classgroup_id`) REFERENCES `classgroup` (`id`),
  CONSTRAINT `fk_sc_student_id` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_classgroup`
--

LOCK TABLES `student_classgroup` WRITE;
/*!40000 ALTER TABLE `student_classgroup` DISABLE KEYS */;
INSERT INTO `student_classgroup` VALUES (9,29),(11,29),(14,29),(16,29);
/*!40000 ALTER TABLE `student_classgroup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentmark`
--

DROP TABLE IF EXISTS `studentmark`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `studentmark` (
  `id` int NOT NULL AUTO_INCREMENT,
  `mark` enum('1','2','3','4','5') NOT NULL,
  `score` int DEFAULT NULL,
  `type` enum('Oral','Written','Activity','Assignment') NOT NULL,
  `student_id` int NOT NULL,
  `subject_id` int NOT NULL,
  `given_by` varchar(100) NOT NULL,
  `given_on` datetime NOT NULL,
  `optional_note` text,
  PRIMARY KEY (`id`),
  KEY `fk_m_student_id_idx` (`student_id`),
  KEY `fk_m_subject_id_idx` (`subject_id`),
  CONSTRAINT `fk_m_student_id` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
  CONSTRAINT `fk_m_subject_id` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentmark`
--

LOCK TABLES `studentmark` WRITE;
/*!40000 ALTER TABLE `studentmark` DISABLE KEYS */;
/*!40000 ALTER TABLE `studentmark` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
  `id` int NOT NULL AUTO_INCREMENT,
  `subject_name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `subject_name_UNIQUE` (`subject_name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (3,'Biology'),(4,'Chemistry'),(7,'English Language'),(2,'Geography'),(8,'German Language'),(9,'History'),(10,'Information Technology'),(1,'Mathematics'),(6,'Native Language'),(5,'Physics');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-23 13:44:31
