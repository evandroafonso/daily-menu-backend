ALTER TABLE `product` ADD CONSTRAINT `fk_id_user` FOREIGN KEY ( `id_user` ) REFERENCES `user` ( `id` );
