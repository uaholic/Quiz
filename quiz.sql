/*
Navicat MySQL Data Transfer

Source Server         : linux mysql
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : quiz

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-01-29 08:43:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `qid` int(11) NOT NULL AUTO_INCREMENT COMMENT '题目id 唯一标识',
  `question` longtext COMMENT '题目',
  `qtext` longtext COMMENT '题目内容的纯文本格式',
  `answer` longtext COMMENT '答案',
  PRIMARY KEY (`qid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------

-- ----------------------------
-- Table structure for uanswer
-- ----------------------------
DROP TABLE IF EXISTS `uanswer`;
CREATE TABLE `uanswer` (
  `uaid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户答案表id 唯一标识',
  `uid` int(11) DEFAULT NULL COMMENT '用户id',
  `qid` int(11) DEFAULT NULL COMMENT '题目id',
  `answer` longtext COMMENT '用户的答案',
  `score` int(11) DEFAULT NULL,
  PRIMARY KEY (`uaid`),
  KEY `uanswer_user_fk` (`uid`),
  KEY `uanswer_question_fk` (`qid`),
  CONSTRAINT `uanswer_question_fk` FOREIGN KEY (`qid`) REFERENCES `question` (`qid`),
  CONSTRAINT `uanswer_user_fk` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of uanswer
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id 唯一标识',
  `name` varchar(255) DEFAULT NULL COMMENT '用户姓名',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名 用于登录',
  `password` varchar(255) DEFAULT NULL COMMENT '用户密码 用于登录 使用md5算法加密',
  `author` int(10) unsigned DEFAULT '0' COMMENT '用户权限 0 普通用户  1 管理员',
  PRIMARY KEY (`uid`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '吴老师', 'admin', 'f379eaf3c831b04de153469d1bec345e', '1');
