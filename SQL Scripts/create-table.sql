use `restaurant_management_system`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `table`;

CREATE TABLE `table` (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `capacity` int(10)  NOT NULL,
  `type` bit  NOT NULL,
  `IsBooked` bit  DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;