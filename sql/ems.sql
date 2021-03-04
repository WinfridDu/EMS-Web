/*
 Navicat MySQL Data Transfer

 Source Server         : ubuntu
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : 192.168.159.130:3306
 Source Schema         : ems

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 13/01/2021 10:21:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for courier
-- ----------------------------
DROP TABLE IF EXISTS `courier`;
CREATE TABLE `courier`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '快递员ID',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '快递员姓名',
  `tel` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '手机号码',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '密码',
  `region` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '派送区',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `tel`(`tel`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '快递员信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of courier
-- ----------------------------
INSERT INTO `courier` VALUES (11, '王五', '44444444444', '$2a$10$vg9a5eJZIiVBInkjd5GJwuP9k7VaSiRXU8p8kLFowekyQA/gapvIO', '天心区');
INSERT INTO `courier` VALUES (12, '肖凯', '13016164965', '$2a$10$U3uUQw81Jqfp2htVwrmPrOXU.bQFww5hhh0pFsgh5mpBYvhaVG4wq', '中南大学');
INSERT INTO `courier` VALUES (17, '赵四', '33333333333', '$2a$10$2732rqCGVya.BTNnRjZdbOAWJTjngHtXCR86huiPMLx4sUaEbmBae', '岳麓区');

-- ----------------------------
-- Table structure for express
-- ----------------------------
DROP TABLE IF EXISTS `express`;
CREATE TABLE `express`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '快递ID',
  `courier_num` char(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '快递单号',
  `rec_tel` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收件人电话',
  `rec_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收件人姓名',
  `send_tel` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发件人电话',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收件地址',
  `courier_tel` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '快递员电话',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT '0未分配1已分配',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '派送时间',
  `qr_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '二维码图片地址',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_courier_num`(`courier_num`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '快递信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of express
-- ----------------------------
INSERT INTO `express` VALUES (9, '14956281', '17877781181', '张三', '11111111111', '升华公寓', '33333333333', 1, '2021-01-13 09:57:02', '1610499489550');
INSERT INTO `express` VALUES (11, '13726371', '17877777777', '李四', '22222222222', '中南大学', '33333333333', 1, '2021-01-13 09:59:18', '1610502668870');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户姓名',
  `tel` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '手机号码',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `tel`(`tel`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '11111111111', '$2a$10$mWcpJQ1FhcDBjEvzeCQsp..ER99qVXSnF5WKQ8Z7iS5iWDG01GyvK');
INSERT INTO `user` VALUES (10, '张三', '22222222222', '$2a$10$XWmH8NTf/DoAUrz0qS0WE.GZgJN6CfL4e4akWT/8tACMUfTtxLG9S');

SET FOREIGN_KEY_CHECKS = 1;
