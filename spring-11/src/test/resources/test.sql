insert into genre ( `name`) values('�����');
insert into genre ( `name`) values('�����');

insert into authors (FIRST_NAME,LAST_NAME) values('��������','���');
insert into authors (FIRST_NAME,LAST_NAME) values('������','�������');
insert into authors (FIRST_NAME,LAST_NAME) values('������','���������');

insert into books (title,genreId,authorsId) values ('��������� � ��������� ������',1,1);
insert into books (title,genreId,authorsId) values ('�����.������',1,1);
insert into books (title,genreId,authorsId) values ('�����.Spring-���������',1,1);
insert into books (title,genreId,authorsId) values ('50 �������� ������',2,2);

insert into comments (COMMENT_DATA,COMMENT_NAME,BOOKID) values('2021-12-31','����� ���� ���������',1);
insert into comments (COMMENT_DATA,COMMENT_NAME,BOOKID) values ('2019-12-31','����� ���� �� ���������',1);

