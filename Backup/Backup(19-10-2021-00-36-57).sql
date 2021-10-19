-- MySQL dump 10.13  Distrib 5.7.35, for Win64 (x86_64)
--
-- Host: localhost    Database: convenio
-- ------------------------------------------------------
-- Server version	5.7.35-log

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `idcliente` int(11) NOT NULL AUTO_INCREMENT,
  `idconvenio` int(11) NOT NULL,
  `idsexo` int(11) NOT NULL,
  `idestadocivil` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `telefone` varchar(25) DEFAULT NULL,
  `celular` varchar(25) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `endereconr` varchar(15) DEFAULT NULL,
  `bairro` varchar(45) DEFAULT NULL,
  `cpf` varchar(25) DEFAULT NULL,
  `identidade` varchar(25) DEFAULT NULL,
  `naturalidade` varchar(45) DEFAULT NULL,
  `pai` varchar(45) DEFAULT NULL,
  `mae` varchar(45) DEFAULT NULL,
  `emprego` varchar(45) DEFAULT NULL,
  `cargo` varchar(45) DEFAULT NULL,
  `dataadmissao` date DEFAULT NULL,
  `renda` double DEFAULT NULL,
  `datanasc` date DEFAULT NULL,
  `limite` double DEFAULT NULL,
  `situacao` enum('ativo','inativo','bloqueado') DEFAULT 'ativo',
  `observacao` text,
  PRIMARY KEY (`idcliente`),
  KEY `fk_cliente_convenio_idx` (`idconvenio`),
  KEY `fk_cliente_sexo1_idx` (`idsexo`),
  KEY `fk_cliente_estadocivil1_idx` (`idestadocivil`),
  CONSTRAINT `fk_cliente_convenio` FOREIGN KEY (`idconvenio`) REFERENCES `convenio` (`idconvenio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cliente_estadocivil1` FOREIGN KEY (`idestadocivil`) REFERENCES `estadocivil` (`idestadocivil`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cliente_sexo1` FOREIGN KEY (`idsexo`) REFERENCES `sexo` (`idsexo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=360 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (357,23,1,2,'NASSER OTHMAN RAHMANB','34116960',NULL,'DUQUE','1929','CENTRO','97086100030','5073825332','','','','','',NULL,0,'1980-09-23',1500,'ativo',''),(358,23,1,1,'SAMER','34122096',NULL,'','','','','','','','','','',NULL,0,'1984-10-10',500,'ativo',''),(359,24,2,2,'JUSSARA','34125544',NULL,'','','','123456','','','','','','',NULL,0,'1970-01-01',1250,'ativo','');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `convenio`
--

DROP TABLE IF EXISTS `convenio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `convenio` (
  `idconvenio` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `responsavel` varchar(255) DEFAULT NULL,
  `telefone` varchar(10) DEFAULT NULL,
  `situacao` enum('ativo','inativo','bloqueado') DEFAULT 'ativo',
  `nrparcelas` int(11) DEFAULT NULL,
  `vencimento` int(11) DEFAULT NULL,
  `datalimite` int(11) DEFAULT NULL,
  `comissao` double DEFAULT '5',
  PRIMARY KEY (`idconvenio`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `convenio`
--

LOCK TABLES `convenio` WRITE;
/*!40000 ALTER TABLE `convenio` DISABLE KEYS */;
INSERT INTO `convenio` VALUES (23,'TOTALTECH INFORMATICA','NASSER','5534116960','ativo',6,10,23,3),(24,'LOLIPOP','JUSSARA','5534112030','ativo',4,15,20,4);
/*!40000 ALTER TABLE `convenio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empresa` (
  `idEmpresa` int(11) NOT NULL,
  `razaosocial` varchar(255) DEFAULT NULL,
  `fantasia` varchar(255) DEFAULT NULL,
  `cnpj` varchar(25) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `telefone` varchar(25) DEFAULT NULL,
  `cidade` varchar(45) DEFAULT NULL,
  `validanf` tinyint(4) DEFAULT '0',
  `bloqinadimplente` tinyint(4) DEFAULT '0',
  `bloqlimite` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`idEmpresa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` VALUES (1,'TOTALTECH COM INFORMATICA','TOTALTECH','11614444000133','DUQUE DE CAXIAS 1929 SALA A','5534116960','URUGUAIANA-RS',0,0,0),(2,'RAWHI ABDEL RAHMAN','BAZAR DA PRACA','22548888000187','DUQUE DE CAXIAS','5534122096','URUGUAIANA-RS',0,0,0);
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadocivil`
--

DROP TABLE IF EXISTS `estadocivil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estadocivil` (
  `idestadocivil` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idestadocivil`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadocivil`
--

LOCK TABLES `estadocivil` WRITE;
/*!40000 ALTER TABLE `estadocivil` DISABLE KEYS */;
INSERT INTO `estadocivil` VALUES (1,'Solteiro(a)'),(2,'Casado(a)'),(3,'Divorciado(a)'),(4,'Viuvo(a)');
/*!40000 ALTER TABLE `estadocivil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parcela`
--

DROP TABLE IF EXISTS `parcela`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parcela` (
  `idparcela` int(11) NOT NULL AUTO_INCREMENT,
  `nrparcela` int(11) DEFAULT NULL,
  `idvenda` int(11) DEFAULT NULL,
  `valorparcela` float DEFAULT NULL,
  `vencimento` date DEFAULT NULL,
  `pago` tinyint(4) DEFAULT '0',
  `datapgto` date DEFAULT NULL,
  PRIMARY KEY (`idparcela`),
  KEY `fk_parcela_venda1_idx` (`idvenda`),
  CONSTRAINT `fk_parcela_venda1` FOREIGN KEY (`idvenda`) REFERENCES `venda` (`idvenda`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=229 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parcela`
--

LOCK TABLES `parcela` WRITE;
/*!40000 ALTER TABLE `parcela` DISABLE KEYS */;
INSERT INTO `parcela` VALUES (207,1,64,166.67,'2021-11-15',1,'2021-10-14'),(208,2,64,166.67,'2021-12-15',0,NULL),(209,3,64,166.66,'2022-01-15',0,NULL),(210,1,65,30,'2021-11-10',1,'2021-10-18'),(211,2,65,30,'2021-12-10',0,NULL),(212,3,65,30,'2022-01-10',0,NULL),(213,4,65,30,'2022-02-10',0,NULL),(214,1,66,33.33,'2021-11-10',1,'2021-10-18'),(215,2,66,33.33,'2021-12-10',0,NULL),(216,3,66,33.34,'2022-01-10',0,NULL),(217,1,67,37.5,'2021-11-10',1,'2021-10-18'),(218,2,67,37.5,'2021-12-10',0,NULL),(219,3,67,37.5,'2022-01-10',0,NULL),(220,4,67,37.5,'2022-02-10',0,NULL),(221,1,68,40,'2021-11-10',1,'2021-10-18'),(222,2,68,40,'2021-12-10',0,NULL),(223,3,68,40,'2022-01-10',0,NULL),(224,4,68,40,'2022-02-10',0,NULL),(225,5,68,40,'2022-03-10',0,NULL),(226,1,69,100,'2021-11-10',1,'2021-10-18'),(227,2,69,100,'2021-12-10',0,NULL),(228,3,69,100,'2022-01-10',0,NULL);
/*!40000 ALTER TABLE `parcela` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sexo`
--

DROP TABLE IF EXISTS `sexo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sexo` (
  `idsexo` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idsexo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sexo`
--

LOCK TABLES `sexo` WRITE;
/*!40000 ALTER TABLE `sexo` DISABLE KEYS */;
INSERT INTO `sexo` VALUES (1,'M'),(2,'F');
/*!40000 ALTER TABLE `sexo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venda`
--

DROP TABLE IF EXISTS `venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venda` (
  `idvenda` int(11) NOT NULL AUTO_INCREMENT,
  `data` date DEFAULT NULL,
  `nrparcelas` int(11) DEFAULT NULL,
  `notafiscal` int(11) DEFAULT NULL,
  `valor` float DEFAULT NULL,
  `idcliente` int(11) NOT NULL,
  `observacao` text,
  PRIMARY KEY (`idvenda`),
  KEY `fk_venda_cliente1_idx` (`idcliente`),
  CONSTRAINT `fk_venda_cliente1` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venda`
--

LOCK TABLES `venda` WRITE;
/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
INSERT INTO `venda` VALUES (64,'2021-10-13',3,123,500,359,NULL),(65,'2021-10-13',4,12212,120,357,NULL),(66,'2021-10-14',3,111,100,358,NULL),(67,'2021-10-14',4,1111,150,358,NULL),(68,'2021-10-14',5,1111,200,357,NULL),(69,'2021-10-14',3,111,300,357,NULL);
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-19  0:37:09
