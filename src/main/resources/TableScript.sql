DROP SCHEMA IF EXISTS meeting_db;

CREATE SCHEMA meeting_db;
USE meeting_db;
   
create table meeting(
	meeting_id INT AUTO_INCREMENT,
	scheduler_name VARCHAR(50) not null,
	team_name VARCHAR(50) not null,
	purpose VARCHAR(50) not null,
	meeting_date date not null,
   CONSTRAINT ps_meeting_id_pk PRIMARY KEY (meeting_id)
);





INSERT INTO meeting VALUES(1001,'Ravi Teja','ETAMYSUI', 'Demonstartion',sysdate());
INSERT INTO meeting VALUES(1002,'Prabhas','ETAMYSMS', 'Presentation',sysdate());
INSERT INTO meeting VALUES(1003,'Ram Charan','ETAMYSBI', 'Demonstartion',sysdate());
INSERT INTO meeting VALUES(1004,'Allu Arjun','ETAMYSJAVA', 'Doubt clearing',sysdate());


commit;

select * from meeting;

