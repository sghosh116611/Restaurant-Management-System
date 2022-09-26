use `restaurant_management_system`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `employee_type`;

CREATE TABLE `employee_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO restaurant_management_system.employee_type(name)
VALUES("Waiter");

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(100)  NOT NULL,
  `last_name` varchar(100)   NOT NULL,
  `email` varchar(50)  NOT NULL,
  `phone` int(30) NOT NULL,
  `salary` int(30) NOT NULL,
	`is_active` bit NOT NULL,
    `type_id` int NOT NULL,
   KEY `FK_EMPLOYEE_TYPE_idx` (`type_id`),
  CONSTRAINT `FK_EMPLOYEE_TYPE` FOREIGN KEY (`type_id`) REFERENCES `employee_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO restaurant_management_system.employee(first_name,last_name,email,phone,salary,is_active,type_id)
VALUES("Mary","Lee","marylee@example.com",1122334455,4500,1,1);

SET FOREIGN_KEY_CHECKS = 1;