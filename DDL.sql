# database 생성
create database cupid;

# database 전환
use cupid;

# table 생성
create table chatting (chatting_id bigint not null auto_increment, created_date datetime(6), deleted bit not null, deleted_date datetime(6), last_modified_date datetime(6), content varchar(255), chatting_room_id bigint, member_id bigint, primary key (chatting_id)) engine=InnoDB;
create table chatting_room (chatting_room_id bigint not null auto_increment, created_date datetime(6), deleted bit not null, deleted_date datetime(6), last_modified_date datetime(6), name varchar(255), primary key (chatting_room_id)) engine=InnoDB;
create table chatting_room_member (chatting_room_member_id bigint not null auto_increment, created_date datetime(6), deleted bit not null, deleted_date datetime(6), last_modified_date datetime(6), chatting_room_id bigint, member_id bigint, primary key (chatting_room_member_id)) engine=InnoDB;
create table member (member_id bigint not null auto_increment, created_date datetime(6), deleted bit not null, deleted_date datetime(6), last_modified_date datetime(6), name varchar(255), primary key (member_id)) engine=InnoDB;
alter table chatting add constraint FKi6wx9n3gd5wd32f9vsmb94gdd foreign key (chatting_room_id) references chatting_room (chatting_room_id);
alter table chatting add constraint FKlv6j5tubiorgcy3hcq1xulhq0 foreign key (member_id) references member (member_id);
alter table chatting_room_member add constraint FKjhhox3yk8o1u5p9q7ixudvhgl foreign key (chatting_room_id) references chatting_room (chatting_room_id);
alter table chatting_room_member add constraint FKatbj5qw57fkw5xheqf9hhgdn foreign key (member_id) references member (member_id);

# member 삽입
INSERT INTO `cupid`.`member` (`created_date`, `last_modified_date`, `deleted`, `name`) VALUES (now(), now(), 0, '김가나');
INSERT INTO `cupid`.`member` (`created_date`, `last_modified_date`, `deleted`, `name`) VALUES (now(), now(), 0, '이다라');
INSERT INTO `cupid`.`member` (`created_date`, `last_modified_date`, `deleted`, `name`) VALUES (now(), now(), 0, '박마바');
INSERT INTO `cupid`.`member` (`created_date`, `last_modified_date`, `deleted`, `name`) VALUES (now(), now(), 0, '신사아');
INSERT INTO `cupid`.`member` (`created_date`, `last_modified_date`, `deleted`, `name`) VALUES (now(), now(), 0, '정자차');
INSERT INTO `cupid`.`member` (`created_date`, `last_modified_date`, `deleted`, `name`) VALUES (now(), now(), 0, '윤카타');
INSERT INTO `cupid`.`member` (`created_date`, `last_modified_date`, `deleted`, `name`) VALUES (now(), now(), 0, '연파하');

# chatting_room 삽입
INSERT INTO `cupid`.`chatting_room` (`created_date`, `last_modified_date`, `deleted`, `name`) VALUES (now(), now(), 0, '저녁식사모임');
INSERT INTO `cupid`.`chatting_room` (`created_date`, `last_modified_date`, `deleted`, `name`) VALUES (now(), now(), 0, '스프링초고수단');
INSERT INTO `cupid`.`chatting_room` (`created_date`, `last_modified_date`, `deleted`, `name`) VALUES (now(), now(), 0, '개발자들');

# chatting_room_member 삽입
INSERT INTO `cupid`.`chatting_room_member` (`created_date`, `last_modified_date`, `deleted`, `member_id`, `chatting_room_id`) VALUES (now(), now(), 0, 1, 1);
INSERT INTO `cupid`.`chatting_room_member` (`created_date`, `last_modified_date`, `deleted`, `member_id`, `chatting_room_id`) VALUES (now(), now(), 0, 1, 2);
INSERT INTO `cupid`.`chatting_room_member` (`created_date`, `last_modified_date`, `deleted`, `member_id`, `chatting_room_id`) VALUES (now(), now(), 0, 1, 3);
INSERT INTO `cupid`.`chatting_room_member` (`created_date`, `last_modified_date`, `deleted`, `member_id`, `chatting_room_id`) VALUES (now(), now(), 0, 2, 1);
INSERT INTO `cupid`.`chatting_room_member` (`created_date`, `last_modified_date`, `deleted`, `member_id`, `chatting_room_id`) VALUES (now(), now(), 0, 2, 2);
INSERT INTO `cupid`.`chatting_room_member` (`created_date`, `last_modified_date`, `deleted`, `member_id`, `chatting_room_id`) VALUES (now(), now(), 0, 2, 3);
INSERT INTO `cupid`.`chatting_room_member` (`created_date`, `last_modified_date`, `deleted`, `member_id`, `chatting_room_id`) VALUES (now(), now(), 0, 3, 1);
INSERT INTO `cupid`.`chatting_room_member` (`created_date`, `last_modified_date`, `deleted`, `member_id`, `chatting_room_id`) VALUES (now(), now(), 0, 3, 3);
INSERT INTO `cupid`.`chatting_room_member` (`created_date`, `last_modified_date`, `deleted`, `member_id`, `chatting_room_id`) VALUES (now(), now(), 0, 4, 1);

# chatting 삽입
INSERT INTO `cupid`.`chatting` (`created_date`, `last_modified_date`, `deleted`, `content`, `member_id`, `chatting_room_id`) VALUES (now(), now(), 0, '안녕하세요', 1, 1);
INSERT INTO `cupid`.`chatting` (`created_date`, `last_modified_date`, `deleted`, `content`, `member_id`, `chatting_room_id`) VALUES (now(), now(), 0, '방가방가', 2, 1);
INSERT INTO `cupid`.`chatting` (`created_date`, `last_modified_date`, `deleted`, `content`, `member_id`, `chatting_room_id`) VALUES (now(), now(), 0, '뭐하고 있어요', 1, 1);
INSERT INTO `cupid`.`chatting` (`created_date`, `last_modified_date`, `deleted`, `content`, `member_id`, `chatting_room_id`) VALUES (now(), now(), 0, '안녕하세요~', 3, 1);
INSERT INTO `cupid`.`chatting` (`created_date`, `last_modified_date`, `deleted`, `content`, `member_id`, `chatting_room_id`) VALUES (now(), now(), 0, '개발중입니당', 2, 1);
INSERT INTO `cupid`.`chatting` (`created_date`, `last_modified_date`, `deleted`, `content`, `member_id`, `chatting_room_id`) VALUES (now(), now(), 0, '반가워유', 4, 1);
INSERT INTO `cupid`.`chatting` (`created_date`, `last_modified_date`, `deleted`, `content`, `member_id`, `chatting_room_id`) VALUES (now(), now(), 0, '개발 고?', 1, 2);
INSERT INTO `cupid`.`chatting` (`created_date`, `last_modified_date`, `deleted`, `content`, `member_id`, `chatting_room_id`) VALUES (now(), now(), 0, '고고', 2, 2);

# data 조회
select * from member;
select * from chatting;
select * from chatting_room;
select * from chatting_room_member;