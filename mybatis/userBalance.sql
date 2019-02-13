DROP TABLE IF EXISTS `UserBalance`;
CREATE TABLE `UserBalance` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `balance` double DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of UserBalance
-- ----------------------------
INSERT INTO `UserBalance` VALUES ('1', '1000');
INSERT INTO `UserBalance` VALUES ('2', '1000');