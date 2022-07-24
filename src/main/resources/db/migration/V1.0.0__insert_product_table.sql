CREATE TABLE product (
  id bigint NOT NULL AUTO_INCREMENT,
  change_date datetime(6) DEFAULT NULL,
  id_user bigint DEFAULT NULL,
  inclusion_date datetime(6) DEFAULT NULL,
  uuid binary(255) NOT NULL,
  feature varchar(255) DEFAULT NULL,
  name varchar(255) NOT NULL,
  quantity int NOT NULL,
  PRIMARY KEY (id)
)
