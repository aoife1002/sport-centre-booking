/*
 Navicat Premium Data Transfer

 Source Server         : 杭州
 Source Server Type    : MySQL
 Source Server Version : 80200
 Source Host           : 47.96.155.51:3306
 Source Schema         : vb

 Target Server Type    : MySQL
 Target Server Version : 80200
 File Encoding         : 65001

 Date: 09/05/2024 16:29:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for vb_account
-- ----------------------------
DROP TABLE IF EXISTS `vb_account`;
CREATE TABLE `vb_account`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `type` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1787139641558102027 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vb_account
-- ----------------------------
INSERT INTO `vb_account` VALUES (1787139641558102018, '212121', '122121', 1);
INSERT INTO `vb_account` VALUES (1787139641558102019, '1', '2', 1);
INSERT INTO `vb_account` VALUES (1787139641558102020, 'test', 'test', 1);
INSERT INTO `vb_account` VALUES (1787139641558102021, 'test1', 'test1', 1);
INSERT INTO `vb_account` VALUES (1787139641558102023, 'test2', '111', 1);
INSERT INTO `vb_account` VALUES (1787139641558102024, 'demo1', '123', 1);
INSERT INTO `vb_account` VALUES (1787139641558102025, 'abo', '123', 0);
INSERT INTO `vb_account` VALUES (1787139641558102026, '112', '111', 1);

-- ----------------------------
-- Table structure for vb_activity
-- ----------------------------
DROP TABLE IF EXISTS `vb_activity`;
CREATE TABLE `vb_activity`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `type` int NULL DEFAULT NULL,
  `activity_type` int NULL DEFAULT NULL,
  `capacity` int NULL DEFAULT NULL,
  `start_time` timestamp NULL DEFAULT NULL,
  `end_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1787141832385683461 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vb_activity
-- ----------------------------
INSERT INTO `vb_activity` VALUES (580313094, 2, 1, 10, '1970-01-21 04:22:02', '1970-01-21 04:22:02');
INSERT INTO `vb_activity` VALUES (580313095, 2, 1, 10, '1970-01-21 04:22:02', '1970-01-21 04:22:02');
INSERT INTO `vb_activity` VALUES (580313096, 3, 2, 10, '1970-01-21 04:22:02', '1970-01-21 04:22:02');
INSERT INTO `vb_activity` VALUES (580313097, 3, 2, 10, '2024-05-05 23:20:59', '2024-05-05 23:20:59');
INSERT INTO `vb_activity` VALUES (580313111, 1, 1, 10, '1970-01-21 04:22:02', '1970-01-21 04:22:02');
INSERT INTO `vb_activity` VALUES (5803131112, 3, 2, 10, '2024-05-05 23:20:59', '2024-05-05 23:20:59');
INSERT INTO `vb_activity` VALUES (5803131113, 4, 1, 10, '2024-05-06 22:45:22', '2024-05-06 22:55:22');
INSERT INTO `vb_activity` VALUES (5803131114, 4, 2, 1, '2024-05-06 22:45:22', '2024-05-06 22:55:22');

-- ----------------------------
-- Table structure for vb_order
-- ----------------------------
DROP TABLE IF EXISTS `vb_order`;
CREATE TABLE `vb_order`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `account_id` bigint NULL DEFAULT NULL,
  `activity_id` bigint NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vb_order
-- ----------------------------
INSERT INTO `vb_order` VALUES (1, 1787139641558102020, 1787141832385683459, 1);
INSERT INTO `vb_order` VALUES (2, 1787139641558102020, 1787141832385683460, 1);
INSERT INTO `vb_order` VALUES (8, 1787139641558102024, 580313094, 1);
INSERT INTO `vb_order` VALUES (9, 1787139641558102024, 580313095, 2);

-- ----------------------------
-- Table structure for vb_user
-- ----------------------------
DROP TABLE IF EXISTS `vb_user`;
CREATE TABLE `vb_user`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `account_id` bigint NULL DEFAULT NULL,
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `age` int NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vb_user
-- ----------------------------
INSERT INTO `vb_user` VALUES (1, 1787139641558102024, '小崔', 18, '123456@qq.com');

SET FOREIGN_KEY_CHECKS = 1;
