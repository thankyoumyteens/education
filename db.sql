create database Education default character set utf8;
use Education;

create table t_user(
	id int auto_increment primary key not null,
	uid text not null,
	pwd text
);

create table t_exams(
  id int auto_increment primary key not null,
  title text,
  link text
);

insert into t_exams(title, link) values('2015年中级经济师农业经济真题文字版', '2015_01.doc');
insert into t_exams(title, link) values('2016年中级经济师农业经济真题文字版', '2016_01.doc');
insert into t_exams(title, link) values('2017年中级经济师农业经济真题文字版', '2017_01.doc');
