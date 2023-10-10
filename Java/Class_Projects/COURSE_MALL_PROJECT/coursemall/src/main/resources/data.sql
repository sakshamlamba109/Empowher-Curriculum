--id,name,category,link,createdAt,author;
--id,author,highestDegree,email,createdAt,fk_course

INSERT INTO COURSE(ID,NAME,LINK,CATEGORY,CREATED_AT) VALUES ('course-Id-1','course name 1','course link 1','category 1','2023-06-20 10:26:42.889985');
INSERT INTO AUTHOR(ID,AUTHOR,DEGREE,EMAIL,CREATED_AT,FK_COURSE) VALUES ('author-id-1','author name 1','HIGHEST DEGREE 1','enamil-1@test.com','2023-06-20 10:26:42.889985','course-Id-1');

INSERT INTO COURSE(ID,NAME,LINK,CATEGORY,CREATED_AT) VALUES ('course-Id-2','course name 2','course link 2','category 2','2023-06-20 10:26:42.889985');
INSERT INTO AUTHOR(ID,AUTHOR,DEGREE,EMAIL,CREATED_AT,FK_COURSE) VALUES ('author-id-2','author name 2','HIGHEST DEGREE 2','enamil-2@test.com','2023-06-20 10:26:42.889985','course-Id-2');

INSERT INTO COURSE(ID,NAME,LINK,CATEGORY,CREATED_AT) VALUES ('course-Id-3','course name 3','course link 3','category 3','2023-06-20 10:26:42.889985');
INSERT INTO AUTHOR(ID,AUTHOR,DEGREE,EMAIL,CREATED_AT,FK_COURSE) VALUES ('author-id-3','author name 3','HIGHEST DEGREE 3','enamil-3@test.com','2023-06-20 10:26:42.889985','course-Id-3');

INSERT INTO COURSE(ID,NAME,LINK,CATEGORY,CREATED_AT) VALUES ('course-Id-4','course name 4','course link 4','category 1','2023-06-20 10:26:42.889985');
INSERT INTO AUTHOR(ID,AUTHOR,DEGREE,EMAIL,CREATED_AT,FK_COURSE) VALUES ('author-id-4','author name 4','HIGHEST DEGREE 4','enamil-4@test.com','2023-06-20 10:26:42.889985','course-Id-4');

INSERT INTO COURSE(ID,NAME,LINK,CATEGORY,CREATED_AT) VALUES ('course-Id-5','course name 5','course link 5','category 1','2023-06-20 10:26:42.889985');
INSERT INTO AUTHOR(ID,AUTHOR,DEGREE,EMAIL,CREATED_AT,FK_COURSE) VALUES ('author-id-5','author name 5','HIGHEST DEGREE 5','enamil-5@test.com','2023-06-20 10:26:42.889985','course-Id-5');