create database Education default character set utf8;
use Education;

-- 登陆
create table t_user(
	id int auto_increment primary key not null,
	delFlag int, -- 删除标记 1表示删除
	accessLevel int, -- 会员等级 0:普通会员 1:正式会员
	uid text not null, -- 手机号
	pwd text -- 密码
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

-- 用户信息
create table t_profile(
	id int auto_increment primary key not null,
	uid text, -- 用户名
	nickname text, -- 昵称
	name text, -- 姓名
	gender text, -- 性别
	address text, -- 住址
	mail text, -- 邮箱
	idCard text, -- 身份证号
	schoolCard text, -- 学号
	qqAccount text, -- QQ号
	wechatAccount text, -- 微信
	weiboAccount text -- 微博
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

-- 模拟题
create table t_simulation(
  id int auto_increment primary key not null,
  title text,
  link text
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

-- 历年真题
create table t_exams(
  id int auto_increment primary key not null,
  title text,
  link text
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

-- 课程录像
create table t_course(
  id int auto_increment primary key not null,
  category int, -- -1:全部 100:免费课程 200:录音
  title text,
  img text,
  link text
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;



insert into t_user(delFlag, accessLevel, uid, pwd) values(0, 0, '12345678901', '123');
insert into t_user(delFlag, accessLevel, uid, pwd) values(0, 1, '22345678901', '123');

insert into t_simulation(title, link) values('中级级经济师考试模拟题', '/course/exams/1.rar');
insert into t_exams(title, link) values('2017年高级级经济师农业经济真题文字版', '/course/exams/1.rar');


insert into t_course(category, title, img, link) values(100, '初级经济基础', 'http://img.mukewang.com/529dc3380001379906000338-240-135.jpg', 'static.hdslb.com/miniloader.swf?aid=13556227&page=1');
insert into t_course(category, title, img, link) values(0, '初级经济基础', 'http://img.mukewang.com/529dc3380001379906000338-240-135.jpg', 'static.hdslb.com/miniloader.swf?aid=13556227&page=1');
insert into t_course(category, title, img, link) values(1, '中级经济基础', 'http://img.mukewang.com/529dc3380001379906000338-240-135.jpg', 'static.hdslb.com/miniloader.swf?aid=13556227&page=1');
insert into t_course(category, title, img, link) values(2, '高级经济基础', 'http://img.mukewang.com/529dc3380001379906000338-240-135.jpg', 'static.hdslb.com/miniloader.swf?aid=13556227&page=1');
insert into t_course(category, title, img, link) values(0, '初级人力资源', 'http://img.mukewang.com/57035ff200014b8a06000338-240-135.jpg', 'static.hdslb.com/miniloader.swf?aid=12056715&page=1');
insert into t_course(category, title, img, link) values(1, '中级人力资源', 'http://img.mukewang.com/57035ff200014b8a06000338-240-135.jpg', 'static.hdslb.com/miniloader.swf?aid=12056715&page=1');
insert into t_course(category, title, img, link) values(2, '高级人力资源', 'http://img.mukewang.com/57035ff200014b8a06000338-240-135.jpg', 'static.hdslb.com/miniloader.swf?aid=12056715&page=1');



