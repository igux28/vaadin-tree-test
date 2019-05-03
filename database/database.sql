CREATE DATABASE  IF NOT EXISTS `tree_test` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `tree_test`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: tree_test
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `work_project_module`
--

DROP TABLE IF EXISTS `work_project_module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `work_project_module` (
  `idProject` int(11) NOT NULL,
  `idModule` int(11) NOT NULL,
  `parentId` int(11) DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_da_0900_as_cs DEFAULT NULL,
  `disabled` tinyint(1) DEFAULT '0',
  `idFieldType` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idProject`,`idModule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_da_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_project_module`
--

LOCK TABLES `work_project_module` WRITE;
/*!40000 ALTER TABLE `work_project_module` DISABLE KEYS */;
INSERT INTO `work_project_module` (`idProject`, `idModule`, `parentId`, `description`, `disabled`, `idFieldType`) VALUES (9,1,0,'PREGUNTA DE INVESTIGACION',0,1),(9,2,1,'Q1 - RESULTADOS CENTRADOS EN EL PACIENTE',0,3),(9,3,1,'Q2 - RESULTADOS RELEVANTES PARA CLÍNICOS',0,3),(9,4,1,'Q3 - EVIDENCIA DISPONIBLE',0,2),(9,5,4,'Pregunta de investigación',0,3),(9,6,4,'Estrategia de búsqueda ',0,3),(9,7,4,'Términos de búsqueda utilizados',0,3),(9,8,4,'Estrategia búsqueda realizada',0,4),(9,9,4,'Introducción',0,3),(9,10,4,'Bibliografía ',0,3),(9,11,1,'Q4 - VALORACIÓN DEL IMPACTO',0,3),(9,12,0,'GRUPO INVESTIGADOR',0,1),(9,13,12,'GI1 - ÁREAS PRIORITARIAS',0,3),(9,14,12,'GI3 – UNI O MULTICÉNTRICO',0,3),(9,15,12,'GI4 - COMPOSICIÓN EQUIPO INVESTIGADOR',0,2),(9,16,15,'Investigadores/as jóvenes',0,3),(9,17,15,'Mujeres investigadoras',0,3),(9,18,15,'Curriculum',0,4),(9,19,15,'Conflicto de interés',0,3),(9,20,12,'GI4-EXPERIENCIA DEL GRUPO',0,3),(9,21,0,'MATERIAL Y MÉTODOS',0,1),(9,22,21,'MM1 – OBJETIVOS',0,2),(9,23,22,'Objetivo Principal',0,3),(9,24,22,'Objetivos secundarios',0,3),(9,25,21,'MM2 – DISEÑO DEL ESTUDIO',0,3),(9,26,21,'MM3 – SUJETOS A ESTUDIO',0,2),(9,27,22,'Criterios de inclusión-exclusion',0,3),(9,28,22,'Tamaño de muestra',0,3),(9,29,22,'Procedimiento selección',0,3),(9,30,21,'MM5-DESCRIPCIÓN DE LA INTERVENCIÓN',0,3),(9,31,21,'MM6-VALORACIÓN DE SESGOS',0,3),(9,32,21,'MM7-VARIABLES DEL ESTUDIO',0,3),(9,33,21,'MM8-CIRCUITO DE RECOGIDA DE INFORMACIÓN',0,3),(9,34,21,'MM9 – PLAN ESTADÍSTICO',0,3),(9,35,21,'MM10 – PLAN DE TRABAJO',0,3),(9,36,0,'ASPECTOS ÉTICO-LEGALES',0,1),(9,37,36,'EL1 – PROTECCIÓN DE DATOS ',0,3),(9,38,36,'EL2 – MUESTRAS BIOLÓGICAS',0,3),(9,39,36,'EL3 – ACEPTACIÓN PARTICIPACIÓN ESTUDIO',0,3),(9,40,36,'EL4 – COMPROMISO INVESTIGADOR',0,3),(9,41,36,'AUTORIZACIÓN CEIC',0,4),(9,42,36,'EL5 – PLAN DE DIFUSIÓN',0,2),(9,43,42,'Comunicaciones a congresos',0,3),(9,44,42,'Artículos en revistas',0,3),(9,45,42,'Informes para entidad financiadora',0,3),(9,46,42,'Informes para clínicos',0,4),(9,47,42,'Informes para pacientes',0,4),(9,48,42,'Otros',0,3),(9,49,36,'EL6 – MEMORIA ECONÓMICA',0,2),(9,50,49,'Gastos de personal',0,3),(9,51,49,'Gastos de ejecución (bienes y servicios)',0,3),(9,52,49,'Gastos de viaje',0,3),(9,53,49,'Otros',0,3),(9,54,36,'EL7 – FINANCIACIÓN',0,3),(9,55,0,'DESARROLLO DEL ESTUDIO',1,1),(9,56,55,'DE1 – RECLUTAMIENTO',0,3),(9,57,55,'DE2 – SEGURIDAD DE PARTICIPANTES',0,3),(9,58,55,'DE3 – INCIDENCIAS',0,3),(9,59,0,'RESULTADOS Y DIFUSIÓN',1,1),(9,60,59,'RD1 – ANÁLISIS DE DATOS',0,2),(9,61,60,'Flujograma de pacientes',0,3),(9,62,60,'Descripción general de la muestra',0,3),(9,63,60,'Resultado principal',0,3),(9,64,60,'Resultados secundarios',0,3),(9,65,60,'RD2 – INTERPRETACIÓN',0,3),(9,66,59,'RD3 – REDACCIÓN Y EDICIÓN DEL MANUSCRITO',0,2),(9,67,66,'Manuscrito',0,3),(9,68,66,'Formulario de aceptación del manuscrito a enviar',0,4),(9,69,66,'Revistas',0,3),(9,70,59,'RD5 – REGISTRO DEL PROTOCOLO ',0,2),(9,71,70,'Protocolo ',0,3),(9,72,70,'Formulario de aceptación protocolo a enviar',0,4),(9,73,70,'Clinical Trials u otros',0,3),(9,74,59,'RD6 – DIFUSIÓN A LA CIUDADANÍA',0,2),(9,75,74,'Informe',0,3),(9,76,74,'Formulario de aceptación del informe a enviar',0,4),(9,77,74,'Medio de difusión',0,3),(9,78,59,'DIFUSIÓN A LOS CLÍNICOS',0,2),(9,79,78,'Informe',0,3),(9,80,78,'Formulario de aceptación del informe a enviar',0,4),(9,81,78,'Congreso',0,3),(9,82,59,'DIFUSIÓN ORGANISMOS INSTITUCIONALES',0,2),(9,83,82,'Informe',0,4),(9,84,82,'Formulario de aceptación del informe a enviar',0,4),(9,85,82,'Medio de difusión',0,3),(9,86,59,'COMPROBACIÓN EQUATOR',0,3),(9,87,0,'DATA SHARING',1,1),(9,88,87,'DS1 - DATOS COMPARTIDOS CON LA COMUNIDAD CIENTÍFICA',0,2),(9,89,88,'¿Qué datos compartir y cuándo?',0,3),(9,90,87,'DS2 - ACCESO A LOS DATOS',0,2),(9,91,90,'Disponibilidad de datos',0,3),(9,92,0,'TRANSFERENCIA',1,1),(9,93,92,'TR1-Plan de transferencia',0,2),(9,94,93,'Plan de transferencia',0,3);
/*!40000 ALTER TABLE `work_project_module` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-03 12:41:50
