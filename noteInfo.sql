--������¼���ͱ�
--drop table NoteInfo;
--��������
create sequence NID
start with 2
increment by 1
cache  5;

create table NoteInfo(
	NID int primary key,--��¼ID
	userid int references userInfo(userid), --�û�ID
	form varchar2(50) check(form = '����' or form = '֧��'),--form���������,��֧���
	AcType varchar2(50) references AccountInfo(AcType),--�˻����
	TypeName varchar2(50) references InOutInfo(TypeName),--��֧��Ŀ
	NDate date default(sysdate),--����
	money number(10,2)  check(money>0) not null,--��֧��Ǯ
	notes   varchar2(100),--��ע
	remark1 varchar2(100),
	remark2 varchar2(100),
	reamrk3 varchar2(100) 
);
--��ѯ��¼���ͱ�
select * from NoteInfo;
--����һ������
insert into NoteInfo values(1,1,'����','���п�','��������',default,6000.00,'','','','');
insert into NoteInfo values(nid.nextval,1,'֧��','�ֽ�','����֧��','default',29.0,'��ȹ��','','','')


drop sequence IOID;
create sequence IOID
start with 2
increment by 1
cache  5;
--������֧��Ŀ������Ŀ
create table InOutInfo(
       IOID int primary key,--��֧ID
       TypeName varchar2(50) unique not null,--��Ŀ����
       form varchar2(50) check(form = '����' or form = '֧��'),--��� ��ʾ�����뻹��֧��
       uname varchar2(50) references userInfo(uname),--uname�û���
       describe varchar2(50),--˵��
       remark1 varchar2(50),
       remark2 varchar2(50),
       remark3 varchar2(50)   
);

select * from InOutInfo;
--drop table InOutInfo;
insert into InOutInfo values(1,'��������','����','ss','','','','');
insert into InOutInfo values(IOID.Nextval,'�Ӱ�����','����','ss','','','','');
insert into InOutInfo values(IOID.Nextval,'��������','����','ss','','','','');
insert into InOutInfo values(IOID.Nextval,'Ͷ������','����','ss','','','','');
insert into InOutInfo values(IOID.Nextval,'�������','����','ss','','','','');
insert into InOutInfo values(IOID.Nextval,'����֧��','֧��','ss','','','','');
insert into InOutInfo values(IOID.Nextval,'��ˮ֧��','֧��','ss','','','','');
insert into InOutInfo values(IOID.Nextval,'�Ӽ�֧��','֧��','ss','','','','');
insert into InOutInfo values(IOID.Nextval,'ͨѶ֧��','֧��','ss','','','','');
insert into InOutInfo values(IOID.Nextval,'����֧��','֧��','ss','','','','');


