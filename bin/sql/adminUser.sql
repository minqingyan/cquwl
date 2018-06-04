 create table AdminUser(
     id int(11) not null primary key AUTO_INCREMENT,
     username VARCHAR(50) DEFAULT NULL,
     login VARCHAR(50),
     password VARCHAR(50),
     phone VARCHAR(11)
 )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
 
 
 
 INSERT INTO AdminUser('username','password','phone','isDelete','createDate') values('mqy','123456','13220309051',1,'2016-07-10 23:21:31');
 
  create table AdminRole(
     id int(11) not null primary key AUTO_INCREMENT,
     name VARCHAR(50) DEFAULT NULL,
     description VARCHAR(50)
 )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
 
    create table AdminPermissoin(
     id int(11) not null primary key AUTO_INCREMENT,
     token VARCHAR(50) DEFAULT NULL,
     url VARCHAR(50),
     description VARCHAR(50),
     roleId int(11),
     constraint FK_roleId foreign key(roleId) references AdminRole(id)  
 )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
 
 
 
 create table AdminUser_Role_xref(
     id int(11) not null primary key AUTO_INCREMENT,
     userId int(11),
     roleId int(11),
     constraint FK_UserRole_userId foreign key(userId) references AdminUser(id), 
     constraint FK_UserRole_roleId foreign key(roleId) references AdminRole(id)
 )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
 
 insert into 
 
 
 
 