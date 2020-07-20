/*
 Navicat Premium Data Transfer

 Source Server         : JavaWeb
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : worker

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 20/07/2020 10:45:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff`  (
  `NUMBER` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `PASSWORD` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `DESK` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `SEX` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `MOBILE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`NUMBER`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES ('0006', '123456', '06', 'T', '1871');
INSERT INTO `staff` VALUES ('001', '123456', '男', '11', '15680967703');
INSERT INTO `staff` VALUES ('002', '123456', '男', '11', '15680967703');
INSERT INTO `staff` VALUES ('003', '123456', '女', '123', '1568');
INSERT INTO `staff` VALUES ('004', '123456789', '女', '007', '1871');
INSERT INTO `staff` VALUES ('005', '1234', '男', '011', '1889');
INSERT INTO `staff` VALUES ('006', '12345', '男', '11', '1889');
INSERT INTO `staff` VALUES ('008', '123456', '男', '112', '1444');
INSERT INTO `staff` VALUES ('111', '123456', '男', '011', '1871');

SET FOREIGN_KEY_CHECKS = 1;
