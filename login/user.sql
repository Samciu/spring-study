DROP TABLE IF EXISTS `User`;
create table User(

userId int auto_increment primary key comment "用户Id",  

userName varchar(100) comment "用户名称",

userPassword varchar(100) comment "用户密码" )

ENGINE=InnoDB  DEFAULT CHARSET=utf8;



insert into User (userName, userPassword) values ("test1", "test1");

insert into User (userName, userPassword) values ("test2", "test2");