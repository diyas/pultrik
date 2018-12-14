/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50560
Source Host           : localhost:3306
Source Database       : pultrik

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2018-12-14 16:17:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for operator
-- ----------------------------
DROP TABLE IF EXISTS `operator`;
CREATE TABLE `operator` (
  `id_operator` bigint(20) NOT NULL AUTO_INCREMENT,
  `nama` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_operator`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for transaksi
-- ----------------------------
DROP TABLE IF EXISTS `transaksi`;
CREATE TABLE `transaksi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `harga` varchar(255) DEFAULT NULL,
  `id_user` bigint(20) NOT NULL,
  `id_voucher` bigint(20) NOT NULL,
  `no_hp` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7x9yh1tpjt4idhbhcq7sfvp75` (`id_user`),
  KEY `FKjsw3ugmmgs0b8vug5visjbdr7` (`id_voucher`),
  CONSTRAINT `FK7x9yh1tpjt4idhbhcq7sfvp75` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`),
  CONSTRAINT `FKjsw3ugmmgs0b8vug5visjbdr7` FOREIGN KEY (`id_voucher`) REFERENCES `voucher` (`id_voucher`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id_user` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for voucher
-- ----------------------------
DROP TABLE IF EXISTS `voucher`;
CREATE TABLE `voucher` (
  `id_voucher` bigint(20) NOT NULL AUTO_INCREMENT,
  `harga` varchar(255) DEFAULT NULL,
  `pulsa` varchar(255) DEFAULT NULL,
  `id_operator` bigint(20) NOT NULL,
  PRIMARY KEY (`id_voucher`),
  KEY `FK88b6nub3yb3jsvd6ke04oxvkn` (`id_operator`),
  CONSTRAINT `FK88b6nub3yb3jsvd6ke04oxvkn` FOREIGN KEY (`id_operator`) REFERENCES `operator` (`id_operator`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
