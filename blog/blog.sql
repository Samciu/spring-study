create table Blog(

blogId int auto_increment primary key comment "博客Id",  

blogTitle varchar(10) comment "博客标题",

blogContent varchar(100) comment "博客内容" )

ENGINE=InnoDB  DEFAULT CHARSET=utf8;