use `restaurant_management_system`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `order_date` DATE  NOT NULL,
  `is_paid` bit  NOT NULL,
  `payment_mode` varchar(50)  NOT NULL,
  `table_id` int(30) NOT NULL,
   KEY `FK_TABLE_idx` (`table_id`),
  CONSTRAINT `FK_TABLE` FOREIGN KEY (`table_id`) REFERENCES `table` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO restaurant_management_system.order(order_date,is_paid,payment_mode,table_id)
VALUES ("2010-08-22",0,"Cash",1);

DROP TABLE IF EXISTS `order_item`;

CREATE TABLE `order_item` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `quantity` int  NOT NULL,
  `unit_price` int  NOT NULL,
  `order_id` BIGINT(20) NOT NULL,
  `item_id` int(90) NOT NULL,
   KEY `FK_ORDER_idx` (`order_id`),
   KEY `FK_ITEM_idx` (`item_id`),
  CONSTRAINT `FK_ORDER` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ITEM` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO restaurant_management_system.order_item(quantity,unit_price,order_id,item_id)
VALUES (1,100,1,1);

SET FOREIGN_KEY_CHECKS = 1;