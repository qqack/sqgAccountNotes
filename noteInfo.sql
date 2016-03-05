--创建记录类型表
--drop table NoteInfo;
--创建序列
create sequence NID
start with 2
increment by 1
cache  5;

create table NoteInfo(
	NID int primary key,--记录ID
	userid int references userInfo(userid), --用户ID
	form varchar2(50) check(form = '收入' or form = '支出'),--form不能作外键,收支类别
	AcType varchar2(50) references AccountInfo(AcType),--账户类别
	TypeName varchar2(50) references InOutInfo(TypeName),--收支类目
	NDate date default(sysdate),--日期
	money number(10,2)  check(money>0) not null,--收支金钱
	notes   varchar2(100),--备注
	remark1 varchar2(100),
	remark2 varchar2(100),
	reamrk3 varchar2(100) 
);
--查询记录类型表
select * from NoteInfo;
--插入一行数据
insert into NoteInfo values(1,1,'收入','银行卡','工资收入',default,6000.00,'','','','');
insert into NoteInfo values(nid.nextval,1,'支出','现金','衣饰支出','default',29.0,'买裙子','','','')


drop sequence IOID;
create sequence IOID
start with 2
increment by 1
cache  5;
--创建收支类目管理类目
create table InOutInfo(
       IOID int primary key,--收支ID
       TypeName varchar2(50) unique not null,--类目名称
       form varchar2(50) check(form = '收入' or form = '支出'),--组别 显示是收入还是支出
       uname varchar2(50) references userInfo(uname),--uname用户名
       describe varchar2(50),--说明
       remark1 varchar2(50),
       remark2 varchar2(50),
       remark3 varchar2(50)   
);

select * from InOutInfo;
--drop table InOutInfo;
insert into InOutInfo values(1,'工资收入','收入','ss','','','','');
insert into InOutInfo values(IOID.Nextval,'加班收入','收入','ss','','','','');
insert into InOutInfo values(IOID.Nextval,'奖金收入','收入','ss','','','','');
insert into InOutInfo values(IOID.Nextval,'投资收入','收入','ss','','','','');
insert into InOutInfo values(IOID.Nextval,'礼金收入','收入','ss','','','','');
insert into InOutInfo values(IOID.Nextval,'衣饰支出','支出','ss','','','','');
insert into InOutInfo values(IOID.Nextval,'酒水支出','支出','ss','','','','');
insert into InOutInfo values(IOID.Nextval,'居家支出','支出','ss','','','','');
insert into InOutInfo values(IOID.Nextval,'通讯支出','支出','ss','','','','');
insert into InOutInfo values(IOID.Nextval,'娱乐支出','支出','ss','','','','');


