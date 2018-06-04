/*
Navicat MariaDB Data Transfer

Source Server         : localhost
Source Server Version : 100013
Source Host           : localhost:3306
Source Database       : cquwl

Target Server Type    : MariaDB
Target Server Version : 100013
File Encoding         : 65001

Date: 2018-03-14 21:31:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cqu_adminrole
-- ----------------------------
DROP TABLE IF EXISTS `cqu_adminrole`;
CREATE TABLE `cqu_adminrole` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_description` varchar(255) DEFAULT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cqu_adminrole
-- ----------------------------

-- ----------------------------
-- Table structure for cqu_adminuser
-- ----------------------------
DROP TABLE IF EXISTS `cqu_adminuser`;
CREATE TABLE `cqu_adminuser` (
  `admin_user_id` int(11) NOT NULL AUTO_INCREMENT,
  `area` varchar(255) DEFAULT NULL,
  `area_detail` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `id_delete` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`admin_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cqu_adminuser
-- ----------------------------
INSERT INTO `cqu_adminuser` VALUES ('1', null, null, '2016-12-14 09:41:22', 'minqingyan_926@sina.com', '1', 'e10adc3949ba59abbe56e057f20f883e', '13220309051', '无名称');
INSERT INTO `cqu_adminuser` VALUES ('2', null, null, '2016-12-14 09:43:45', '36358480@qq.com', '1', 'e10adc3949ba59abbe56e057f20f883e', '13220309041', '无名称');
INSERT INTO `cqu_adminuser` VALUES ('3', null, null, '2016-12-18 16:20:56', 'minqingyan_926@sina.com', '1', 'e10adc3949ba59abbe56e057f20f883e', '13220309054', 'u_65585');

-- ----------------------------
-- Table structure for cqu_adminuserrole
-- ----------------------------
DROP TABLE IF EXISTS `cqu_adminuserrole`;
CREATE TABLE `cqu_adminuserrole` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adminuserrole_role_id` int(11) DEFAULT NULL,
  `adminuserrole_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_bwe4j3ho2jc5ukffv4ntqxyvf` (`adminuserrole_role_id`),
  KEY `FK_7lmhvm16o4367i5tqx5073r3s` (`adminuserrole_user_id`),
  CONSTRAINT `FK_7lmhvm16o4367i5tqx5073r3s` FOREIGN KEY (`adminuserrole_user_id`) REFERENCES `cqu_adminuser` (`admin_user_id`),
  CONSTRAINT `FK_bwe4j3ho2jc5ukffv4ntqxyvf` FOREIGN KEY (`adminuserrole_role_id`) REFERENCES `cqu_adminrole` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cqu_adminuserrole
-- ----------------------------

-- ----------------------------
-- Table structure for cqu_allcarassess
-- ----------------------------
DROP TABLE IF EXISTS `cqu_allcarassess`;
CREATE TABLE `cqu_allcarassess` (
  `car_ass_id` int(11) NOT NULL AUTO_INCREMENT,
  `arrive_score` int(11) DEFAULT NULL,
  `good_safe` int(11) DEFAULT NULL,
  `pay_score` int(11) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `service_score` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `words` varchar(255) DEFAULT NULL,
  `allcarassess_carsource_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`car_ass_id`),
  KEY `FK_k99gtoicl6qwrd48o84nomoq4` (`allcarassess_carsource_id`),
  CONSTRAINT `FK_k99gtoicl6qwrd48o84nomoq4` FOREIGN KEY (`allcarassess_carsource_id`) REFERENCES `cqu_carsource` (`car_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cqu_allcarassess
-- ----------------------------

-- ----------------------------
-- Table structure for cqu_allstoreassess
-- ----------------------------
DROP TABLE IF EXISTS `cqu_allstoreassess`;
CREATE TABLE `cqu_allstoreassess` (
  `store_ass_id` int(11) NOT NULL AUTO_INCREMENT,
  `attitude` int(11) DEFAULT NULL,
  `environment` int(11) DEFAULT NULL,
  `pay` int(11) DEFAULT NULL,
  `quality` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `words` varchar(255) DEFAULT NULL,
  `basic_store_assess_store_souce_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`store_ass_id`),
  KEY `FK_6da8q5fhxusr9g4tsjnyopjlq` (`basic_store_assess_store_souce_id`),
  CONSTRAINT `FK_6da8q5fhxusr9g4tsjnyopjlq` FOREIGN KEY (`basic_store_assess_store_souce_id`) REFERENCES `cqu_store_source` (`store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cqu_allstoreassess
-- ----------------------------

-- ----------------------------
-- Table structure for cqu_basicgood
-- ----------------------------
DROP TABLE IF EXISTS `cqu_basicgood`;
CREATE TABLE `cqu_basicgood` (
  `good_id` int(11) NOT NULL AUTO_INCREMENT,
  `carpool` int(11) DEFAULT NULL,
  `delivery_time` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `place_arrive` varchar(255) DEFAULT NULL,
  `place_start` varchar(255) DEFAULT NULL,
  `publish_time` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `total_pack` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `user_height` float DEFAULT NULL,
  `unit_length` float DEFAULT NULL,
  `user_weight` float DEFAULT NULL,
  `unit_width` float DEFAULT NULL,
  `unload_time` varchar(255) DEFAULT NULL,
  `volumn` float DEFAULT NULL,
  `weight` float DEFAULT NULL,
  `basic_good_publish_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`good_id`),
  KEY `FK_i6kg0xjih6hic7ooq8t4qqa6p` (`basic_good_publish_id`),
  CONSTRAINT `FK_i6kg0xjih6hic7ooq8t4qqa6p` FOREIGN KEY (`basic_good_publish_id`) REFERENCES `cqu_my_publish` (`pu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cqu_basicgood
-- ----------------------------
INSERT INTO `cqu_basicgood` VALUES ('1', null, '2016-12-15', '酒类饮料', '重庆市/重庆市/沙坪坝区', '重庆市/重庆市/沙坪坝区', '2016-12-14 09:44:54', '1', '400', '2', '0.32', '0.7', '0.015', '0.4', '2016-12-15', '9', '11', '4');
INSERT INTO `cqu_basicgood` VALUES ('2', null, '2016-12-15', '酒类饮料', '重庆市/重庆市/沙坪坝区', '重庆市/重庆市/沙坪坝区', '2016-12-14 09:48:38', '1', '400', '2', '0.32', '0.7', '0.015', '0.4', '2016-12-15', '9', '11', '5');
INSERT INTO `cqu_basicgood` VALUES ('3', null, '2016-12-16', '塑料和橡胶', '重庆市/重庆市/沙坪坝区', '重庆市/重庆市/沙坪坝区', '2016-12-14 10:26:24', '1', '400', '2', '0.32', '0.7', '0.015', '0.4', '2016-12-16', '9', '6', '6');
INSERT INTO `cqu_basicgood` VALUES ('4', null, '2016-12-15', '皮革和纺织品', '重庆市/重庆市/沙坪坝区', '重庆市/重庆市/沙坪坝区', '2016-12-14 11:28:13', '1', '400', '2', '0.32', '0.7', '0.015', '0.4', '2016-12-15', '9', '6', '7');
INSERT INTO `cqu_basicgood` VALUES ('5', null, '2016-12-15', '塑料和橡胶', '重庆市/重庆市/沙坪坝区', '重庆市/重庆市/沙坪坝区', '2016-12-14 11:37:51', '1', '400', '2', '0.32', '0.7', '0.015', '0.4', '2016-12-15', '9', '6', '8');
INSERT INTO `cqu_basicgood` VALUES ('6', null, '2016-12-17', '酒类饮料', '重庆市/重庆市/沙坪坝区', '重庆市/重庆市/沙坪坝区', '2016-12-17 16:50:34', '1', '400', '2', '0.32', '0.7', '0.015', '0.4', '2016-12-17', '11', '6', '9');
INSERT INTO `cqu_basicgood` VALUES ('7', null, '2016-12-17', '酒类饮料', '重庆市/重庆市/沙坪坝区', '重庆市/重庆市/沙坪坝区', '2016-12-17 17:19:07', '1', '400', '2', '0.32', '0.7', '0.015', '0.4', '2016-12-17', '9', '11', '10');
INSERT INTO `cqu_basicgood` VALUES ('8', null, '2016-12-17', '酒类饮料', '重庆市/重庆市/沙坪坝区', '重庆市/重庆市/沙坪坝区', '2016-12-17 17:34:20', '1', '400', '2', '0.32', '0.7', '0.015', '0.4', '2016-12-17', '9', '11', '11');
INSERT INTO `cqu_basicgood` VALUES ('9', null, '2016-12-17', '塑料和橡胶', '重庆市/重庆市/沙坪坝区', '重庆市/重庆市/沙坪坝区', '2016-12-17 22:49:24', '2', '400', '2', '0.32', '0.7', '0.015', '0.4', '2016-12-17', '9', '11', '12');
INSERT INTO `cqu_basicgood` VALUES ('10', null, '2016-12-19', '酒类饮料', '重庆市/重庆市/沙坪坝区', '重庆市/重庆市/沙坪坝区', '2016-12-18 10:11:46', '1', '400', '2', '0.32', '0.7', '0.015', '0.4', '2016-12-19', '11', '6', '13');
INSERT INTO `cqu_basicgood` VALUES ('11', null, '2016-12-19', '塑料和橡胶', '重庆市/重庆市/沙坪坝区', '重庆市/重庆市/沙坪坝区', '2016-12-18 10:15:10', '1', '400', '2', '0.32', '0.7', '0.015', '0.4', '2016-12-19', '11', '11', '17');
INSERT INTO `cqu_basicgood` VALUES ('12', null, '2016-12-19', '塑料和橡胶', '重庆市/重庆市/沙坪坝区', '重庆市/重庆市/沙坪坝区', '2016-12-18 10:15:59', '1', '400', '2', '0.32', '0.7', '0.015', '0.4', '2016-12-19', '11', '11', '18');
INSERT INTO `cqu_basicgood` VALUES ('13', null, '2016-12-19', '塑料和橡胶', '重庆市/重庆市/沙坪坝区', '重庆市/重庆市/沙坪坝区', '2016-12-18 10:17:25', '1', '400', '2', '0.32', '0.7', '0.015', '0.4', '2016-12-19', '11', '11', '19');
INSERT INTO `cqu_basicgood` VALUES ('14', null, '2016-12-19', '塑料和橡胶', '重庆市/重庆市/沙坪坝区', '重庆市/重庆市/沙坪坝区', '2016-12-18 10:19:19', '1', '400', '2', '0.32', '0.7', '0.015', '0.4', '2016-12-19', '11', '11', '20');
INSERT INTO `cqu_basicgood` VALUES ('15', null, '2016-12-19', '塑料和橡胶', '重庆市/重庆市/沙坪坝区', '重庆市/重庆市/沙坪坝区', '2016-12-18 10:22:00', '1', '400', '2', '0.32', '0.7', '0.015', '0.4', '2016-12-19', '11', '11', '21');
INSERT INTO `cqu_basicgood` VALUES ('16', null, '2016-12-19', '塑料和橡胶', '重庆市/重庆市/沙坪坝区', '重庆市/重庆市/沙坪坝区', '2016-12-18 10:27:20', '1', '400', '2', '0.32', '0.7', '0.015', '0.4', '2016-12-19', '11', '11', '22');
INSERT INTO `cqu_basicgood` VALUES ('17', null, '2016-12-19', '酒类饮料', '重庆市/重庆市/沙坪坝区', '重庆市/重庆市/沙坪坝区', '2016-12-18 17:04:38', '1', '400', '2', '0.32', '0.7', '0.015', '0.4', '2016-12-19', '11', '6', '23');
INSERT INTO `cqu_basicgood` VALUES ('18', null, '2016-12-19', '酒类饮料', '重庆市/重庆市/沙坪坝区', '重庆市/重庆市/沙坪坝区', '2016-12-18 19:11:09', '1', '400', '2', '0.32', '0.7', '0.015', '0.4', '2016-12-19', '9', '11', '24');
INSERT INTO `cqu_basicgood` VALUES ('19', null, '', '---货物类型---', '重庆市/重庆市/沙坪坝区', '重庆市/重庆市/沙坪坝区', '2017-04-06 08:39:40', '1', null, '1', null, null, null, null, '', '0', '0', '28');
INSERT INTO `cqu_basicgood` VALUES ('20', null, '2017-04-06', '文教用品', '重庆市/重庆市/沙坪坝区', '重庆市/重庆市/沙坪坝区', '2017-04-06 08:50:14', '1', '240', '2', '0.32', '0.7', '0.015', '0.4', '2017-04-07', '9', '3.6', '29');
INSERT INTO `cqu_basicgood` VALUES ('21', null, '2017-04-06', '其他', '重庆市/重庆市/沙坪坝区', '重庆市/重庆市/沙坪坝区', '2017-04-06 08:51:18', '1', '400', '2', '0.32', '0.7', '0.015', '0.4', '2017-04-07', '9', '6', '30');
INSERT INTO `cqu_basicgood` VALUES ('22', null, '2017-04-02', '书和印刷品', '重庆市/重庆市/沙坪坝区', '重庆市/重庆市/沙坪坝区', '2017-04-06 09:12:09', '2', '400', '2', '0.32', '0.7', '0.015', '0.4', '2017-04-05', '9', '6', '31');

-- ----------------------------
-- Table structure for cqu_carassess
-- ----------------------------
DROP TABLE IF EXISTS `cqu_carassess`;
CREATE TABLE `cqu_carassess` (
  `car_ass_id` int(11) NOT NULL AUTO_INCREMENT,
  `arrive_score` int(11) DEFAULT NULL,
  `good_safe` int(11) DEFAULT NULL,
  `pay_score` int(11) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `service_score` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `words` varchar(255) DEFAULT NULL,
  `carassess_carsource_id` int(11) DEFAULT NULL,
  `carassess_carorder_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`car_ass_id`),
  KEY `FK_nm8lsf10ke6sa864yqfyvut7d` (`carassess_carsource_id`),
  KEY `FK_4eihto71vre69btwjc83yhroq` (`carassess_carorder_id`),
  CONSTRAINT `FK_4eihto71vre69btwjc83yhroq` FOREIGN KEY (`carassess_carorder_id`) REFERENCES `cqu_myorders` (`id`),
  CONSTRAINT `FK_nm8lsf10ke6sa864yqfyvut7d` FOREIGN KEY (`carassess_carsource_id`) REFERENCES `cqu_carsource` (`car_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cqu_carassess
-- ----------------------------

-- ----------------------------
-- Table structure for cqu_carsource
-- ----------------------------
DROP TABLE IF EXISTS `cqu_carsource`;
CREATE TABLE `cqu_carsource` (
  `car_id` int(11) NOT NULL AUTO_INCREMENT,
  `arrive_time` varchar(255) DEFAULT NULL,
  `car_count` int(11) DEFAULT NULL,
  `car_heigth` float DEFAULT NULL,
  `car_length` float DEFAULT NULL,
  `car_number` varchar(255) DEFAULT NULL,
  `car_pool` int(11) DEFAULT NULL,
  `car_width` float DEFAULT NULL,
  `carriage` int(11) DEFAULT NULL,
  `place_arrive` varchar(255) DEFAULT NULL,
  `place_start` varchar(255) DEFAULT NULL,
  `publish_time` datetime DEFAULT NULL,
  `start_time` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `volumn` float DEFAULT NULL,
  `weight` float DEFAULT NULL,
  `carsource_publish_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`car_id`),
  KEY `FK_7bpnknw7sotj6k53a4l3rrkj0` (`carsource_publish_id`),
  CONSTRAINT `FK_7bpnknw7sotj6k53a4l3rrkj0` FOREIGN KEY (`carsource_publish_id`) REFERENCES `cqu_my_publish` (`pu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cqu_carsource
-- ----------------------------
INSERT INTO `cqu_carsource` VALUES ('1', '2016-12-13', '1', '1.8', '4.2', '渝A.8888', null, '1.9', '1', '重庆市/重庆市/沙坪坝区', '重庆市/重庆市/沙坪坝区', '2016-12-14 09:42:26', '2016-12-13', '2', '1', '9', '2.5', '1');
INSERT INTO `cqu_carsource` VALUES ('2', '2016-12-13', '1', '2', '6.2', '渝B.6666', null, '2', '2', '重庆市/重庆市/沙坪坝区', '重庆市/重庆市/沙坪坝区', '2016-12-14 09:43:00', '2016-12-13', '2', '1', '11', '3.5', '2');
INSERT INTO `cqu_carsource` VALUES ('3', '2016-12-13', '1', '1.5', '8', '渝B.1111', null, '2.4', '2', '重庆市/重庆市/沙坪坝区', '重庆市/重庆市/沙坪坝区', '2016-12-14 09:43:30', '2016-12-13', '2', '3', '9', '10', '3');
INSERT INTO `cqu_carsource` VALUES ('4', '2016-12-18', '1', '1.8', '4.2', '渝A.0987', null, '1.9', '1', '重庆市/重庆市/沙坪坝区', '重庆市/重庆市/沙坪坝区', '2016-12-18 10:13:39', '2016-12-18', '1', '1', '9', '2.5', '14');
INSERT INTO `cqu_carsource` VALUES ('5', '2016-12-18', '1', '1.5', '8', '渝A.7654', null, '2.4', '2', '重庆市/重庆市/沙坪坝区', '重庆市/重庆市/沙坪坝区', '2016-12-18 10:14:19', '2016-12-18', '2', '1', '9', '10', '15');
INSERT INTO `cqu_carsource` VALUES ('6', '2016-12-18', '1', '2', '6.2', '渝A.9876', null, '2', '1', '重庆市/重庆市/沙坪坝区', '重庆市/重庆市/沙坪坝区', '2016-12-18 10:14:50', '2016-12-18', '1', '3', '9', '3.5', '16');
INSERT INTO `cqu_carsource` VALUES ('7', '2016-12-19', '1', '5', '12', '渝A.8888', null, '3', '1', '重庆市/重庆市/沙坪坝区', '重庆市/重庆市/沙坪坝区', '2016-12-18 19:24:10', '2016-12-19', '1', '1', '11', '11', '26');

-- ----------------------------
-- Table structure for cqu_corporation
-- ----------------------------
DROP TABLE IF EXISTS `cqu_corporation`;
CREATE TABLE `cqu_corporation` (
  `corporation_id` int(11) NOT NULL AUTO_INCREMENT,
  `fob` varchar(255) DEFAULT NULL,
  `fobimage` varchar(255) DEFAULT NULL,
  `co_name` varchar(255) DEFAULT NULL,
  `co_type` int(11) DEFAULT NULL,
  `corporation_adminuer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`corporation_id`),
  KEY `FK_16coe4wqntic42jgon0p85xi2` (`corporation_adminuer_id`),
  CONSTRAINT `FK_16coe4wqntic42jgon0p85xi2` FOREIGN KEY (`corporation_adminuer_id`) REFERENCES `cqu_adminuser` (`admin_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cqu_corporation
-- ----------------------------

-- ----------------------------
-- Table structure for cqu_goodassess
-- ----------------------------
DROP TABLE IF EXISTS `cqu_goodassess`;
CREATE TABLE `cqu_goodassess` (
  `good_ass_id` int(11) NOT NULL AUTO_INCREMENT,
  `assess` int(11) DEFAULT NULL,
  `easy_connect` int(11) DEFAULT NULL,
  `pay_time` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `words` varchar(255) DEFAULT NULL,
  `goodassess_adminuser_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`good_ass_id`),
  KEY `FK_72fql3qtf8he704v4h6sq1lie` (`goodassess_adminuser_id`),
  CONSTRAINT `FK_72fql3qtf8he704v4h6sq1lie` FOREIGN KEY (`goodassess_adminuser_id`) REFERENCES `cqu_adminuser` (`admin_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cqu_goodassess
-- ----------------------------

-- ----------------------------
-- Table structure for cqu_myorders
-- ----------------------------
DROP TABLE IF EXISTS `cqu_myorders`;
CREATE TABLE `cqu_myorders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `flag` int(11) DEFAULT NULL,
  `flag_id` int(11) DEFAULT NULL,
  `order_id` varchar(255) DEFAULT NULL,
  `order_time` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `myorders_admin_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_6jecjd5drj2rddsscbad78rdp` (`myorders_admin_user_id`),
  CONSTRAINT `FK_6jecjd5drj2rddsscbad78rdp` FOREIGN KEY (`myorders_admin_user_id`) REFERENCES `cqu_adminuser` (`admin_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cqu_myorders
-- ----------------------------
INSERT INTO `cqu_myorders` VALUES ('1', '3', '3', 'S1161161854', '2016-12-17 23:18:54', '1', '2');
INSERT INTO `cqu_myorders` VALUES ('2', '3', '1', 'S1161161855', '2016-12-17 23:18:55', '1', '2');
INSERT INTO `cqu_myorders` VALUES ('3', '3', '2', 'S117341213', '2017-04-06 09:12:13', '1', '1');
INSERT INTO `cqu_myorders` VALUES ('4', '3', '5', 'S117341213', '2017-04-06 09:12:13', '1', '1');

-- ----------------------------
-- Table structure for cqu_my_publish
-- ----------------------------
DROP TABLE IF EXISTS `cqu_my_publish`;
CREATE TABLE `cqu_my_publish` (
  `pu_id` int(11) NOT NULL AUTO_INCREMENT,
  `flag` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `my_publish_admin_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`pu_id`),
  KEY `FK_2hgu9ach006d7bipl91xfp8xy` (`my_publish_admin_user_id`),
  CONSTRAINT `FK_2hgu9ach006d7bipl91xfp8xy` FOREIGN KEY (`my_publish_admin_user_id`) REFERENCES `cqu_adminuser` (`admin_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cqu_my_publish
-- ----------------------------
INSERT INTO `cqu_my_publish` VALUES ('1', '3', '1', '1');
INSERT INTO `cqu_my_publish` VALUES ('2', '3', '1', '1');
INSERT INTO `cqu_my_publish` VALUES ('3', '3', '1', '1');
INSERT INTO `cqu_my_publish` VALUES ('4', '2', '1', '2');
INSERT INTO `cqu_my_publish` VALUES ('5', '2', '1', '2');
INSERT INTO `cqu_my_publish` VALUES ('6', '2', '1', '2');
INSERT INTO `cqu_my_publish` VALUES ('7', '2', '1', '2');
INSERT INTO `cqu_my_publish` VALUES ('8', '2', '1', '2');
INSERT INTO `cqu_my_publish` VALUES ('9', '2', '1', '2');
INSERT INTO `cqu_my_publish` VALUES ('10', '2', '1', '2');
INSERT INTO `cqu_my_publish` VALUES ('11', '2', '1', '2');
INSERT INTO `cqu_my_publish` VALUES ('12', '2', '1', '2');
INSERT INTO `cqu_my_publish` VALUES ('13', '2', '1', '2');
INSERT INTO `cqu_my_publish` VALUES ('14', '3', '1', '2');
INSERT INTO `cqu_my_publish` VALUES ('15', '3', '1', '2');
INSERT INTO `cqu_my_publish` VALUES ('16', '3', '1', '2');
INSERT INTO `cqu_my_publish` VALUES ('17', '2', '1', '2');
INSERT INTO `cqu_my_publish` VALUES ('18', '2', '1', '2');
INSERT INTO `cqu_my_publish` VALUES ('19', '2', '1', '2');
INSERT INTO `cqu_my_publish` VALUES ('20', '2', '1', '2');
INSERT INTO `cqu_my_publish` VALUES ('21', '2', '1', '2');
INSERT INTO `cqu_my_publish` VALUES ('22', '2', '1', '2');
INSERT INTO `cqu_my_publish` VALUES ('23', '2', '1', '2');
INSERT INTO `cqu_my_publish` VALUES ('24', '2', '1', '2');
INSERT INTO `cqu_my_publish` VALUES ('25', '1', '1', '2');
INSERT INTO `cqu_my_publish` VALUES ('26', '3', '1', '2');
INSERT INTO `cqu_my_publish` VALUES ('27', '1', '1', '2');
INSERT INTO `cqu_my_publish` VALUES ('28', '2', '1', '1');
INSERT INTO `cqu_my_publish` VALUES ('29', '2', '1', '1');
INSERT INTO `cqu_my_publish` VALUES ('30', '2', '1', '1');
INSERT INTO `cqu_my_publish` VALUES ('31', '2', '1', '1');

-- ----------------------------
-- Table structure for cqu_person
-- ----------------------------
DROP TABLE IF EXISTS `cqu_person`;
CREATE TABLE `cqu_person` (
  `person_id` int(11) NOT NULL AUTO_INCREMENT,
  `idcard` varchar(255) DEFAULT NULL,
  `idcard_back_image` varchar(255) DEFAULT NULL,
  `idcard_front_image` varchar(255) DEFAULT NULL,
  `idcard_hand_image` varchar(255) DEFAULT NULL,
  `persion_admin_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`person_id`),
  KEY `FK_lfm00odo9eoto89jik9wofdln` (`persion_admin_user_id`),
  CONSTRAINT `FK_lfm00odo9eoto89jik9wofdln` FOREIGN KEY (`persion_admin_user_id`) REFERENCES `cqu_adminuser` (`admin_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cqu_person
-- ----------------------------

-- ----------------------------
-- Table structure for cqu_remain_car_source
-- ----------------------------
DROP TABLE IF EXISTS `cqu_remain_car_source`;
CREATE TABLE `cqu_remain_car_source` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `count` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `remaincarsource_basicgood_id` int(11) DEFAULT NULL,
  `remaincarsource_carsource_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_5m00hbj60bqgvtix7itcj1a0s` (`remaincarsource_basicgood_id`),
  KEY `FK_pra7t40pfia878m570gxebeif` (`remaincarsource_carsource_id`),
  CONSTRAINT `FK_5m00hbj60bqgvtix7itcj1a0s` FOREIGN KEY (`remaincarsource_basicgood_id`) REFERENCES `cqu_basicgood` (`good_id`),
  CONSTRAINT `FK_pra7t40pfia878m570gxebeif` FOREIGN KEY (`remaincarsource_carsource_id`) REFERENCES `cqu_carsource` (`car_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cqu_remain_car_source
-- ----------------------------

-- ----------------------------
-- Table structure for cqu_storegood
-- ----------------------------
DROP TABLE IF EXISTS `cqu_storegood`;
CREATE TABLE `cqu_storegood` (
  `good_id` int(11) NOT NULL AUTO_INCREMENT,
  `cover` float DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `publish_date` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `store_area` varchar(255) DEFAULT NULL,
  `store_date` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `volumn` float DEFAULT NULL,
  `weight` float DEFAULT NULL,
  `storegood_mypublish_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`good_id`),
  KEY `FK_gaydjc49gk18e2k3oxuor1jgd` (`storegood_mypublish_id`),
  CONSTRAINT `FK_gaydjc49gk18e2k3oxuor1jgd` FOREIGN KEY (`storegood_mypublish_id`) REFERENCES `cqu_my_publish` (`pu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cqu_storegood
-- ----------------------------
INSERT INTO `cqu_storegood` VALUES ('1', '50', '青云山', '2016-12-18 19:22:28', '1', '重庆市/重庆市/沙坪坝区', '2016-12-19', '机械仪器类', '11', '11', '25');

-- ----------------------------
-- Table structure for cqu_store_assess
-- ----------------------------
DROP TABLE IF EXISTS `cqu_store_assess`;
CREATE TABLE `cqu_store_assess` (
  `store_ass_id` int(11) NOT NULL AUTO_INCREMENT,
  `attitude` int(11) DEFAULT NULL,
  `environment` int(11) DEFAULT NULL,
  `pay` int(11) DEFAULT NULL,
  `quality` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `words` varchar(255) DEFAULT NULL,
  `store_assess_order_id` int(11) DEFAULT NULL,
  `store_assess_store_source_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`store_ass_id`),
  KEY `FK_jxobwijwu2wmhvy32mxko3b89` (`store_assess_order_id`),
  KEY `FK_5j78ei6nldugsh3bbjv8w0wf8` (`store_assess_store_source_id`),
  CONSTRAINT `FK_5j78ei6nldugsh3bbjv8w0wf8` FOREIGN KEY (`store_assess_store_source_id`) REFERENCES `cqu_store_source` (`store_id`),
  CONSTRAINT `FK_jxobwijwu2wmhvy32mxko3b89` FOREIGN KEY (`store_assess_order_id`) REFERENCES `cqu_myorders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cqu_store_assess
-- ----------------------------

-- ----------------------------
-- Table structure for cqu_store_source
-- ----------------------------
DROP TABLE IF EXISTS `cqu_store_source`;
CREATE TABLE `cqu_store_source` (
  `store_id` int(11) NOT NULL AUTO_INCREMENT,
  `area` float DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `place` varchar(255) DEFAULT NULL,
  `publish_time` datetime DEFAULT NULL,
  `start_date` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `volumn` float DEFAULT NULL,
  `store_source_publish_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`store_id`),
  KEY `FK_hrvdkphrdet68c7985ulw7tv0` (`store_source_publish_id`),
  CONSTRAINT `FK_hrvdkphrdet68c7985ulw7tv0` FOREIGN KEY (`store_source_publish_id`) REFERENCES `cqu_my_publish` (`pu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cqu_store_source
-- ----------------------------
INSERT INTO `cqu_store_source` VALUES ('1', '23', '沙中路28仓库', '重庆市/重庆市/沙坪坝区', '2016-12-18 19:26:54', '2016-12-20', '1', '---仓库类型---', '9', '27');

-- ----------------------------
-- Table structure for cqu_totalgoodassess
-- ----------------------------
DROP TABLE IF EXISTS `cqu_totalgoodassess`;
CREATE TABLE `cqu_totalgoodassess` (
  `good_ass_id` int(11) NOT NULL AUTO_INCREMENT,
  `bad_assess` int(11) DEFAULT NULL,
  `good_assess` int(11) DEFAULT NULL,
  `mid_assess` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `totalgoodassess_admin_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`good_ass_id`),
  KEY `FK_9qdbmqbt3sgoj9f2e2jbisovs` (`totalgoodassess_admin_user_id`),
  CONSTRAINT `FK_9qdbmqbt3sgoj9f2e2jbisovs` FOREIGN KEY (`totalgoodassess_admin_user_id`) REFERENCES `cqu_adminuser` (`admin_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cqu_totalgoodassess
-- ----------------------------
