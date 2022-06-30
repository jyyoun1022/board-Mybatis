DROP TABLE IF EXISTS board;

create table board(
    board_id int auto_increment primary key,
    title varchar(30) not null ,
    content varchar(30) not null ,
     member_id varchar(30) not null ,
    viewCnt INTEGER default 0


);
INSERT INTO board(title, content, member_id) VALUES('title1', 'content1', 'name1');
INSERT INTO board(title, content, member_id) VALUES('title1', 'content1', 'name1');
INSERT INTO board(title, content, member_id) VALUES('title1', 'content1', 'name1');
INSERT INTO board(title, content, member_id) VALUES('title1', 'content1', 'name1');
INSERT INTO board(title, content, member_id) VALUES('title1', 'content1', 'name1');
