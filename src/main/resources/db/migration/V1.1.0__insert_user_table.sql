CREATE TABLE daily_menu.user (
  id bigint NOT NULL AUTO_INCREMENT,
  change_date datetime(6) DEFAULT NULL,
  id_user bigint DEFAULT NULL,
  inclusion_date datetime(6) DEFAULT NULL,
  uuid varchar(255) NOT NULL,
  login varchar(255) DEFAULT NULL,
  password varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) 
