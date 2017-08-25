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

create table t_course(
  id int auto_increment primary key not null,
  category int,
  title text,
  img text,
  link text
);

insert into t_exams(title, link) values('2015年中级经济师农业经济真题文字版', '2015_01.doc');
insert into t_exams(title, link) values('2016年中级经济师农业经济真题文字版', '2016_01.doc');
insert into t_exams(title, link) values('2017年中级经济师农业经济真题文字版', '2017_01.doc');
insert into t_exams(title, link) values('2017年高级级经济师农业经济真题文字版', 'http://localhost:9999/exams/1.rar');


insert into t_course(category, title, img, link) values(0, '初级经济基础', 'http://img.mukewang.com/529dc3380001379906000338-240-135.jpg', 'static.hdslb.com/miniloader.swf?aid=13556227&page=1');
insert into t_course(category, title, img, link) values(0, '初级人力资源', 'http://img.mukewang.com/57035ff200014b8a06000338-240-135.jpg', 'static.hdslb.com/miniloader.swf?aid=12056715&page=1');



<embed height="415" width="544" quality="high" allowfullscreen="true" type="application/x-shockwave-flash" src="//static.hdslb.com/miniloader.swf" flashvars="aid=13556227&page=1" pluginspage="//www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash"></embed>