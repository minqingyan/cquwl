 create table AdminUser(
     id int(11) not null primary key AUTO_INCREMENT,
     name VARCHAR(50) DEFAULT NULL,
     login VARCHAR(50),
     password VARCHAR(50),
     phone VARCHAR(11)
 )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
 
 
 
 INSERT INTO AdminUser('name','login','password','phone') values('mqy','mqy','123456','13220309051');