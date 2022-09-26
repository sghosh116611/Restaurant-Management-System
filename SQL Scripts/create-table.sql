use `restaurant_management_system`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `table_type`;

CREATE TABLE `table_type` (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `type` varchar(30)  NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO restaurant_management_system.table_type(type)
VALUES("Open Air");

DROP TABLE IF EXISTS `table`;

CREATE TABLE `table` (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `capacity` int(10)  NOT NULL,
  `type_id` int(30)  NOT NULL,
  `is_booked` bit  DEFAULT NULL,
  KEY `FK_TABLE_TYPE_idx` (`type_id`),
  CONSTRAINT `FK_TABLE_TYPE` FOREIGN KEY (`type_id`) REFERENCES `table_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO restaurant_management_system.table(capacity,type_id,is_booked)
VALUES(2,1,0);

DROP TABLE IF EXISTS `table_request`;

CREATE TABLE `table_request` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `full_name` varchar(150)  NOT NULL,
  `request_date` DATE  NOT NULL,
  `mobile` int  NOT NULL,
  `seating_capacity` int  NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO restaurant_management_system.table_request(full_name,request_date,mobile,seating_capacity)
VALUES("John Doe","2010-08-22",112234455,2);

DROP TABLE IF EXISTS `table_book`;

CREATE TABLE `table_book` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `table_request_id` BIGINT(20)  NOT NULL,
  `table_id` int  NOT NULL,
   KEY `FK_REQUEST_idx` (`table_request_id`),
   KEY `FK_TABLE_idx` (`table_id`),
  CONSTRAINT `FK_REQUEST` FOREIGN KEY (`table_request_id`) REFERENCES `table_request` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_TABLE_BOOK` FOREIGN KEY (`table_id`) REFERENCES `table` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO restaurant_management_system.table_book(table_request_id,table_id)
VALUES(1,1);

SET FOREIGN_KEY_CHECKS = 1;

