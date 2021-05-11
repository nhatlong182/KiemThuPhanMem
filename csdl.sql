-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: vlxd
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
-- Table structure for table `chitiethoadon`
--

DROP TABLE IF EXISTS `chitiethoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitiethoadon` (
  `MaHD` int NOT NULL,
  `MaSP` int NOT NULL,
  `GiaBan` decimal(65,0) DEFAULT NULL,
  `SoLuong` int DEFAULT NULL,
  `ThanhTien` decimal(65,0) DEFAULT NULL,
  KEY `MaHDCTHD_idx` (`MaHD`) /*!80000 INVISIBLE */,
  KEY `MaSPCTHD_idx` (`MaSP`),
  CONSTRAINT `MaHDCTHD` FOREIGN KEY (`MaHD`) REFERENCES `hoadon` (`MaHD`),
  CONSTRAINT `MaSPCTHD` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitiethoadon`
--

LOCK TABLES `chitiethoadon` WRITE;
/*!40000 ALTER TABLE `chitiethoadon` DISABLE KEYS */;
INSERT INTO `chitiethoadon` VALUES (1,2,1188,10,10260),(2,3,93170,20,1677060),(4008,9,390500,15,5857500),(4005,10,380600,100,34600000),(4006,12,214500,10,1950000),(4007,9,390500,25,9274375);
/*!40000 ALTER TABLE `chitiethoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoadon`
--

DROP TABLE IF EXISTS `hoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoadon` (
  `MaHD` int NOT NULL AUTO_INCREMENT,
  `NgayDatHang` datetime DEFAULT NULL,
  `MaKH` int DEFAULT NULL,
  `MaNV` int DEFAULT NULL,
  PRIMARY KEY (`MaHD`),
  KEY `MaKHHD_idx` (`MaKH`),
  KEY `MaNVHD_idx` (`MaNV`),
  CONSTRAINT `MaKHHD` FOREIGN KEY (`MaKH`) REFERENCES `khachhang` (`MaKH`),
  CONSTRAINT `MaNVHD` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`)
) ENGINE=InnoDB AUTO_INCREMENT=4009 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadon`
--

LOCK TABLES `hoadon` WRITE;
/*!40000 ALTER TABLE `hoadon` DISABLE KEYS */;
INSERT INTO `hoadon` VALUES (1,'2018-09-20 00:00:00',5,1),(2,'2018-09-10 00:00:00',1,1),(4005,'2018-10-05 00:00:00',10,1),(4006,'2018-10-05 00:00:00',6,1),(4007,'2018-10-21 00:00:00',7,1),(4008,'2018-10-21 00:00:00',8,1);
/*!40000 ALTER TABLE `hoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khachhang` (
  `MaKH` int NOT NULL AUTO_INCREMENT,
  `HoKH` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `TenKH` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `GioiTinh` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `DiaChi` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `DienThoai` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`MaKH`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
INSERT INTO `khachhang` VALUES (1,'Nguyễn Thị Ánh','Hằng','Nữ','120 Ha Ton Quyen','901298357'),(2,'Trần Minh','Hằng','Nữ','87 Trần Hưng Đạo','937948170'),(3,'Lê Thị','Hồng','Nữ','24 Ky Con','989571892'),(4,'Nguyễn Văn','Tài','Nam','8 Pham Van Hai','1876349701'),(5,'Nguyễn Phú','Cường','Nam','6 Ky Hoa','983274831'),(6,'Lê Thị Hoàng','Dung','Nữ','90 An Duong Vuong','1213879818'),(7,'Trần Hoàng Thái','Phong','Nam','10 Tan Da','990471908'),(8,'Bùi Ngọc Minh','Anh','Nữ','2817 Minh Phung','1238764792'),(9,'Trần Thanh','Tùng','Nam','187 Lao Tu','989717298'),(10,'Hồ Vĩnh','Lợi','Nam','45 Sư Vạn Hạnh','902535533'),(11,'Huỳnh','Minh Huy','Nam','47/3 Ho Hao Hon','523647895'),(12,'a','a','Nam','','');
/*!40000 ALTER TABLE `khachhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loaisp`
--

DROP TABLE IF EXISTS `loaisp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loaisp` (
  `MaLoaiSP` int NOT NULL AUTO_INCREMENT,
  `TenLoai` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`MaLoaiSP`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaisp`
--

LOCK TABLES `loaisp` WRITE;
/*!40000 ALTER TABLE `loaisp` DISABLE KEYS */;
INSERT INTO `loaisp` VALUES (1,'Gạch'),(2,'Cát'),(3,'Đá'),(4,'Xi Măng'),(5,'Thép'),(6,'Bột Trét Tường');
/*!40000 ALTER TABLE `loaisp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvien` (
  `MaNV` int NOT NULL AUTO_INCREMENT,
  `HoNV` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `TenNV` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `GioiTinh` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `DiaChi` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `DienThoai` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`MaNV`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES (1,'Ma Hoàng Hải','Nguyên',NULL,NULL,NULL),(4,'trần','long','Nam','',''),(5,'trần','long','Nam','','');
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhasanxuat`
--

DROP TABLE IF EXISTS `nhasanxuat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhasanxuat` (
  `MaNSX` int NOT NULL AUTO_INCREMENT,
  `TenCongTyNSX` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `DiaChiNSX` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `DienThoaiNSX` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`MaNSX`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhasanxuat`
--

LOCK TABLES `nhasanxuat` WRITE;
/*!40000 ALTER TABLE `nhasanxuat` DISABLE KEYS */;
INSERT INTO `nhasanxuat` VALUES (1,'CÔNG TY TNHH GẠCH AN PHÚ GIA','178/11 Đường D1, Phường 25, Quận Bình Thạnh, Tp.HCM','903568698'),(2,'CÔNG TY CỔ PHẦN GẠCH MEN THANH THANH','Khu Công Nghiệp Biên Hòa I - Đồng Nai','(0251)3836066'),(3,'Công Ty TNHH Xi Măng Bảo Chứng','89/2 Phan Huy ích, P. 15, Q. Tân Bình,Tp.HCM','(028)38155100'),(4,'Công ty cổ phần xi măng hà tiên 1','360 Võ Văn Kiệt, P.Cầu Kho, Quận 1','(08)38368363');
/*!40000 ALTER TABLE `nhasanxuat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sanpham`
--

DROP TABLE IF EXISTS `sanpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sanpham` (
  `MaSP` int NOT NULL,
  `TenSP` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `SoLuongTon` int DEFAULT NULL,
  `DonGia` double DEFAULT NULL,
  `DonviTinh` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `MoTa` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `HinhAnh` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `MaLoaiSP` int DEFAULT NULL,
  `MaNSX` int DEFAULT NULL,
  PRIMARY KEY (`MaSP`),
  KEY `MaLoaiSPSP_idx` (`MaLoaiSP`),
  KEY `MaNSXSP_idx` (`MaNSX`),
  CONSTRAINT `MaLoaiSPSP` FOREIGN KEY (`MaLoaiSP`) REFERENCES `loaisp` (`MaLoaiSP`),
  CONSTRAINT `MaNSXSP` FOREIGN KEY (`MaNSX`) REFERENCES `nhasanxuat` (`MaNSX`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sanpham`
--

LOCK TABLES `sanpham` WRITE;
/*!40000 ALTER TABLE `sanpham` DISABLE KEYS */;
INSERT INTO `sanpham` VALUES (2,'Gạch Phước Thành',2000,1080,'vien',NULL,'GachPhuocThanh.jpg',1,1),(3,'Xi măng Hà Tiên',400,84700,'bao','bao 50kg','XiMangHaTien.jpg',4,3),(4,'Xi măng Thăng Long',500,77000,'bao','bao 50kg','XiMangThangLong.jpg',4,3),(5,'Gạch men',1000,261000,'m2','kích thước 40x40','GachMen.jpg',1,2),(6,'Bột Jotun',300,396000,'bao','bao 40kg','BotJotun.png',6,3),(7,'Gạch Thành Tâm',1500,1100,'vien',NULL,'GachThanhTam.jpg',1,NULL),(8,'Bột Dulux',200,436000,'bao','bao 40kg','BotDulux.jpg',6,3),(9,'Cát xây',700,355000,'m3',NULL,'CatXay.jpg',2,NULL),(10,'Đá xây',900,346000,'m3',NULL,'DaXay.jpg',3,NULL),(11,'Cát san lấp',800,126000,'m3',NULL,'CatSanLap.jpg',2,NULL),(12,'Thép phi 10 ',250,195000,'cây','cây 12m','SatPhi10.jpg',5,NULL),(13,'Thép phi 15 ',150,215000,'cây','cây 12m','SatPhi15.png',5,NULL),(14,'Xi măng Hocim',600,86900,'bao','bao 50kg','XiMangHolcim.png',4,3);
/*!40000 ALTER TABLE `sanpham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taikhoankh`
--

DROP TABLE IF EXISTS `taikhoankh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taikhoankh` (
  `MaTK` int NOT NULL AUTO_INCREMENT,
  `TenTaiKhoan` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `MatKhau` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `MaKH` int DEFAULT NULL,
  PRIMARY KEY (`MaTK`),
  KEY `MaKHTK_idx` (`MaKH`),
  CONSTRAINT `MaKHTK` FOREIGN KEY (`MaKH`) REFERENCES `khachhang` (`MaKH`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taikhoankh`
--

LOCK TABLES `taikhoankh` WRITE;
/*!40000 ALTER TABLE `taikhoankh` DISABLE KEYS */;
INSERT INTO `taikhoankh` VALUES (1,'nguyenthianhhang','anhhangtkNu',1),(2,'tranminhhhang','minhhangtkNu',2),(3,'lethihong','thihongtkNu',3),(4,'nguyenvantai','vantaitkNam',4),(5,'nguyenphucuong','phucuongtkNam',5),(6,'a','a',12);
/*!40000 ALTER TABLE `taikhoankh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taikhoannv`
--

DROP TABLE IF EXISTS `taikhoannv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taikhoannv` (
  `MaTK` int NOT NULL AUTO_INCREMENT,
  `TenTaiKhoan` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `MatKhau` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `MaNV` int DEFAULT NULL,
  PRIMARY KEY (`MaTK`),
  KEY `MaNVTK_idx` (`MaNV`),
  CONSTRAINT `MaNVTK` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taikhoannv`
--

LOCK TABLES `taikhoannv` WRITE;
/*!40000 ALTER TABLE `taikhoannv` DISABLE KEYS */;
INSERT INTO `taikhoannv` VALUES (1,'mahoanhainguyen','123456789',1),(3,'admin','123',5);
/*!40000 ALTER TABLE `taikhoannv` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-18 10:18:02
