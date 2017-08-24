create database Education default character set utf8;
use Education;

create table t_user(
	id int auto_increment primary key not null,
	uid text not null,
	pwd text
);
