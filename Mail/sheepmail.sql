/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : sheepmail

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2020-04-05 11:32:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sheep_cart`
-- ----------------------------
DROP TABLE IF EXISTS `sheep_cart`;
CREATE TABLE `sheep_cart` (
  `cart_id` int(11) NOT NULL AUTO_INCREMENT,
  `cart_p_filename` varchar(128) DEFAULT NULL,
  `cart_p_name` varchar(64) DEFAULT NULL,
  `cart_p_price` decimal(10,2) DEFAULT NULL,
  `cart_quantify` int(11) DEFAULT NULL,
  `cart_p_stock` int(11) DEFAULT NULL,
  `cart_p_id` int(11) DEFAULT NULL,
  `cart_u_id` varchar(64) DEFAULT NULL,
  `cart_valid` int(11) DEFAULT NULL,
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sheep_cart
-- ----------------------------
INSERT INTO `sheep_cart` VALUES ('12', 'pro01.jpg', '跳舞兰仿真花干花', '18.00', '5', '888', '1', 'aa', '1');
INSERT INTO `sheep_cart` VALUES ('13', 'pro02.jpg', '跳舞兰仿真花干花', '26.00', '2', '888', '2', 'aa', '1');

-- ----------------------------
-- Table structure for `sheep_category`
-- ----------------------------
DROP TABLE IF EXISTS `sheep_category`;
CREATE TABLE `sheep_category` (
  `CATE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CATE_NAME` varchar(20) NOT NULL,
  `CATE_PARENT_ID` decimal(10,0) NOT NULL,
  PRIMARY KEY (`CATE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sheep_category
-- ----------------------------
INSERT INTO `sheep_category` VALUES ('1', '所有商品', '0');
INSERT INTO `sheep_category` VALUES ('2', '装饰摆件', '0');
INSERT INTO `sheep_category` VALUES ('3', '布衣软饰', '0');
INSERT INTO `sheep_category` VALUES ('4', '墙饰壁挂', '0');
INSERT INTO `sheep_category` VALUES ('5', '蜡艺香薰', '0');
INSERT INTO `sheep_category` VALUES ('6', '创意家居', '0');
INSERT INTO `sheep_category` VALUES ('7', '浓情欧式', '1');
INSERT INTO `sheep_category` VALUES ('8', '浪漫美式', '1');
INSERT INTO `sheep_category` VALUES ('9', '雅致中式', '1');
INSERT INTO `sheep_category` VALUES ('10', '简约现代', '1');
INSERT INTO `sheep_category` VALUES ('11', '干花花艺', '2');
INSERT INTO `sheep_category` VALUES ('12', '花瓣花瓶', '2');
INSERT INTO `sheep_category` VALUES ('13', '桌布罩件', '3');
INSERT INTO `sheep_category` VALUES ('14', '抱枕靠垫', '3');

-- ----------------------------
-- Table structure for `sheep_product`
-- ----------------------------
DROP TABLE IF EXISTS `sheep_product`;
CREATE TABLE `sheep_product` (
  `PRODUCT_ID` int(10) NOT NULL AUTO_INCREMENT,
  `PRODUCT_NAME` varchar(128) NOT NULL,
  `PRODUCT_DESCRIPTION` varchar(512) DEFAULT NULL,
  `PRODUCT_PRICE` decimal(10,2) NOT NULL,
  `PRODUCT_STOCK` decimal(10,0) DEFAULT NULL,
  `PRODUCT_FID` decimal(10,0) DEFAULT NULL,
  `PRODUCT_CID` decimal(10,0) DEFAULT NULL,
  `PRODUCT_FILENAME` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`PRODUCT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sheep_product
-- ----------------------------
INSERT INTO `sheep_product` VALUES ('1', '跳舞兰仿真花干花', '【破损补寄】【适合放室内、卧室、书房、餐桌、办公室、客厅、电视柜等地方】【无理由退换货】【包邮】【白色现代简约花瓶】', '18.00', '888', '1', '7', 'pro01.jpg');
INSERT INTO `sheep_product` VALUES ('2', '跳舞兰仿真花干花', '买买买！', '26.00', '888', '1', '8', 'pro02.jpg');
INSERT INTO `sheep_product` VALUES ('3', '跳舞兰仿真花干花', '买买买！', '55.00', '888', '1', '9', 'pro03.jpg');
INSERT INTO `sheep_product` VALUES ('4', '跳舞兰仿真花干花', '买买买！', '18.00', '333', '1', '10', 'pro04.jpg');
INSERT INTO `sheep_product` VALUES ('5', '跳舞兰仿真花干花', '买买买！', '18.00', '333', '2', '11', 'pro05.jpg');
INSERT INTO `sheep_product` VALUES ('6', '跳舞兰仿真花干花', '买买买！', '26.00', '888', '3', '13', 'pro06.jpg');
INSERT INTO `sheep_product` VALUES ('7', '跳舞兰仿真花干花', '买买买！', '18.00', '333', '3', '14', 'pro07.jpg');
INSERT INTO `sheep_product` VALUES ('8', '跳舞兰仿真花干花', '买买买！', '18.00', '888', '3', '14', 'pro08.jpg');
INSERT INTO `sheep_product` VALUES ('9', '创意摆件', '买买买！', '18.00', '333', '1', '10', 'id1.jpg');
INSERT INTO `sheep_product` VALUES ('10', '创意摆件', '买买买！', '18.00', '888', '1', '10', 'id2.jpg');
INSERT INTO `sheep_product` VALUES ('11', '创意摆件', '买买买！', '18.00', '888', '1', '9', 'id3.jpg');
INSERT INTO `sheep_product` VALUES ('12', '创意摆件', '买买买！', '111111.00', '888', '1', '7', 'id4.jpg');
INSERT INTO `sheep_product` VALUES ('13', '创意摆件', '买买买！', '22.00', '888', '1', '9', 'id5.jpg');
INSERT INTO `sheep_product` VALUES ('14', '创意摆件', '买买买！', '18.00', '888', '1', '9', 'id6.jpg');
INSERT INTO `sheep_product` VALUES ('15', '创意摆件', '买买买！', '18.00', '888', '1', '7', 'id7.jpg');
INSERT INTO `sheep_product` VALUES ('16', '创意摆件', '买买买！', '26.00', '333', '1', '7', 'id8.jpg');
INSERT INTO `sheep_product` VALUES ('18', '创意摆件', '买买买！', '18.00', '888', '1', '7', 'id10.jpg');
INSERT INTO `sheep_product` VALUES ('19', '创意摆件', '买买买！', '18.00', '888', '1', '7', 'id11.jpg');
INSERT INTO `sheep_product` VALUES ('20', '创意摆件', '买买买！', '111111.00', '888', '1', '7', 'id12.jpg');
INSERT INTO `sheep_product` VALUES ('21', '创意摆件', '买买买！', '18.00', '888', '1', '7', 'id13.jpg');
INSERT INTO `sheep_product` VALUES ('22', '创意摆件', '买买买！', '18.00', '888', '1', '7', 'id14.jpg');
INSERT INTO `sheep_product` VALUES ('23', '创意摆件', '买买买！', '18.00', '888', '1', '7', 'id15.jpg');
INSERT INTO `sheep_product` VALUES ('24', '创意摆件', '买买买！', '18.00', '888', '1', '7', 'id16.jpg');
INSERT INTO `sheep_product` VALUES ('25', '创意摆件', '买买买！', '18.00', '888', '1', '7', 'id9.jpg');
INSERT INTO `sheep_product` VALUES ('26', 'aaa', '132131', '11.00', '136', '1', '7', 'yang.JPG');

-- ----------------------------
-- Table structure for `sheep_user`
-- ----------------------------
DROP TABLE IF EXISTS `sheep_user`;
CREATE TABLE `sheep_user` (
  `USER_ID` varchar(32) NOT NULL,
  `USER_NAME` varchar(20) NOT NULL,
  `USER_PASSWORD` varchar(20) NOT NULL,
  `USER_SEX` varchar(1) NOT NULL,
  `USER_BIRTHDAY` datetime DEFAULT NULL,
  `USER_IDENITY_CODE` varchar(60) DEFAULT NULL,
  `USER_EMAIL` varchar(60) DEFAULT NULL,
  `USER_MOBILE` varchar(11) DEFAULT NULL,
  `USER_ADDRESS` varchar(200) NOT NULL,
  `USER_STATUS` decimal(6,0) NOT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sheep_user
-- ----------------------------
INSERT INTO `sheep_user` VALUES ('aa', 'aa', '123', 'F', '2019-12-18 00:00:00', null, 'aaa@bbb.com', '13854126688', '浙江省杭州市萧山区宁围街道周扒皮', '2');
INSERT INTO `sheep_user` VALUES ('aa2', 'aa2', '123', 'F', '1999-11-25 00:00:00', null, 'aa22@qq.com', '13458682416', '浙江省杭州市萧山区宁围街道葛百通', '1');
INSERT INTO `sheep_user` VALUES ('aa3', 'aa3', '123', 'T', '2008-05-22 20:51:52', null, 'aa3@qq.com', '13458616824', '浙江省杭州市萧山区宁围街道沈万三', '1');
INSERT INTO `sheep_user` VALUES ('aa4', 'aa4', '123', 'F', '1998-10-20 20:52:05', null, 'aa4@qq.com', '13858688825', '浙江省杭州市萧山区宁围街道周扒皮', '1');
INSERT INTO `sheep_user` VALUES ('aa5', 'aa5', '123', 'T', '1997-10-13 20:52:16', null, 'aa5@qq.com', '13868858811', '浙江省杭州市萧山区宁围街道周扒皮', '1');
INSERT INTO `sheep_user` VALUES ('aa6', 'aa6', '123', 'F', '1997-02-05 20:52:27', null, 'aa6@qq.com', '13816885881', '浙江省杭州市萧山区宁围街道周扒皮', '1');
INSERT INTO `sheep_user` VALUES ('aa85', 'aa85', '123', 'T', '1996-09-09 00:00:00', null, 'aaa@bbb.com', '13558816622', '浙江省杭州市萧山区宁围街道周扒皮', '1');
INSERT INTO `sheep_user` VALUES ('aa8777', 'aa8777', '123', 'T', '1996-09-09 00:00:00', null, 'aaa@bbb.com', '13558816622', '浙江省杭州市萧山区宁围街道周扒皮', '1');
INSERT INTO `sheep_user` VALUES ('asd', 'asd', '123', 'F', '1996-09-09 00:00:00', null, 'eee@qq.com', '13837395537', '浙江省杭州市萧山区宁围街道周扒皮', '1');
INSERT INTO `sheep_user` VALUES ('bb', 'bb', '123', 'F', '1997-10-28 20:52:44', null, 'aaa@bbb.com', '13458416682', '浙江省杭州市萧山区宁围街道周扒皮', '1');
INSERT INTO `sheep_user` VALUES ('cc', 'cc', '123', 'F', '1995-08-01 00:00:00', null, 'aaa@bbb.com', '13558816622', '浙江省杭州市萧山区宁围街道周扒皮', '1');
INSERT INTO `sheep_user` VALUES ('dd', 'dd', '123', 'F', '2013-01-31 20:53:00', null, 'ddd@qq.com', '13833956622', '浙江省杭州市萧山区宁围街道周扒皮', '1');
INSERT INTO `sheep_user` VALUES ('ee', 'ee', '123', 'F', '1998-11-04 20:53:06', null, 'eee@qq.com', '13833955377', '浙江省杭州市萧山区宁围街道周扒皮', '1');
INSERT INTO `sheep_user` VALUES ('ff', 'ff', '123', 'T', '1997-10-15 20:53:14', null, 'fff@qq.com', '13833773955', '浙江省杭州市萧山区宁围街道周扒皮', '1');
INSERT INTO `sheep_user` VALUES ('gg', 'gg', '123', 'F', '1996-07-23 20:53:21', null, 'ggg@qq.com', '13766673952', '浙江省杭州市萧山区宁围街道周扒皮', '1');
INSERT INTO `sheep_user` VALUES ('hh', 'hh', '123', 'T', '1996-04-26 20:53:28', null, 'hhh@qq.com', '13785832269', '浙江省杭州市萧山区宁围街道周扒皮', '1');
INSERT INTO `sheep_user` VALUES ('iiiiiiiiii', 'iiiiiiiiii', '123', 'F', '1994-08-11 00:00:00', null, 'aaa@bbb.com', '13833955377', '浙江省杭州市萧山区宁围街道周扒皮', '1');
INSERT INTO `sheep_user` VALUES ('kk', 'kk', '123', 'T', '2010-06-04 00:00:00', null, 'kk@qq.com', '13557723285', '浙江省杭州市萧山区宁围街道周扒皮', '1');
INSERT INTO `sheep_user` VALUES ('ll', 'll', '123', 'F', '1995-07-19 20:53:59', null, 'lll@qq.com', '13558816699', '浙江省杭州市萧山区宁围街道周扒皮', '1');
INSERT INTO `sheep_user` VALUES ('mm', 'mm', '123', 'F', '1995-07-08 20:54:05', null, 'mmm@qq.com', '13558622816', '浙江省杭州市萧山区宁围街道周扒皮', '1');
INSERT INTO `sheep_user` VALUES ('qqq', 'qqq', '123', 'T', '1996-11-11 00:00:00', null, 'qqq@qq.com', '13456789854', 'aqqqqqq', '1');
INSERT INTO `sheep_user` VALUES ('uu', 'uu', '123', 'T', '1995-11-08 00:00:00', null, 'uu@qq.com', '13485670087', 'uuuuuu', '1');
INSERT INTO `sheep_user` VALUES ('yang', 'yagn', '123', 'T', '1996-09-09 00:00:00', null, 'eee@qq.com', '13854126688', '浙江省杭州市萧山区宁围街道周扒皮', '1');
INSERT INTO `sheep_user` VALUES ('yjh', 'yjh', '123', 'T', '1996-11-11 00:00:00', null, 'yjh@qq.com', '316546541', 'xiaosghan', '1');
