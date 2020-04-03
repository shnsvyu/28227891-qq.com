/*
 Navicat Premium Data Transfer

 Source Server         : 134.134.2.27(EHR系统开发库_salary)
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : 134.134.2.27:3306
 Source Schema         : salary

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 03/04/2020 23:49:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for p_salary_items
-- ----------------------------
DROP TABLE IF EXISTS `p_salary_items`;
CREATE TABLE `p_salary_items`  (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `creater_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `creater_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `creater_date` datetime(0) NULL DEFAULT NULL,
  `salary_items_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `salary_items_type` tinyint(4) NULL DEFAULT NULL COMMENT '1=导入项，2=计算项',
  `accuracy` tinyint(4) NULL DEFAULT NULL COMMENT '保留小数位数',
  `is_salary_archives` tinyint(4) NULL DEFAULT NULL COMMENT '0=否，1=是',
  `status_c` tinyint(4) NULL DEFAULT NULL COMMENT '1=启用，2=禁用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '薪酬项目' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
