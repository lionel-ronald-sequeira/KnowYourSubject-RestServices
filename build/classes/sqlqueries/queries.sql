 CREATE database know_your_subject;
 
 use know_your_subject;
 
 CREATE TABLE KYS_USER(user_id INT AUTO_INCREMENT,user_name VARCHAR(50),password VARCHAR(100), email VARCHAR(50),
 first_name VARCHAR(50),last_name VARCHAR(50), security_question VARCHAR(100),security_answer VARCHAR(50),
 is_admin CHAR(1),dob DATE,contact INT,zipcode VARCHAR(10),department_id VARCHAR(100),
 CONSTRAINT USER_PK PRIMARY KEY(user_id),
 CONSTRAINT USER_FK FOREIGN KEY(department_id) REFERENCES KYS_DEPARTMENT(department_id)ON UPDATE CASCADE ON DELETE SET NULL);
 
 CREATE TABLE KYS_UNIVERSITY(university_id INT AUTO_INCREMENT, 
 university_name VARCHAR(100),university_initials VARCHAR(10),
 university_summary VARCHAR(100),university_city VARCHAR(100),
 university_state VARCHAR(100),university_country VARCHAR(100),
 CONSTRAINT UNIVERSITY_PK PRIMARY KEY(university_id));
 
 
 CREATE TABLE KYS_DISCIPLINE(discipline_id INT AUTO_INCREMENT, 
 discipline_name VARCHAR(100),discipline_initials VARCHAR(10),
 discipline_summary VARCHAR(100),university_id INT,
 CONSTRAINT DISCIPLINE_PK PRIMARY KEY(discipline_id),
 CONSTRAINT DISCIPLINE_FK FOREIGN KEY(university_id) REFERENCES KYS_UNIVERSITY(university_id)ON UPDATE CASCADE ON DELETE SET NULL
 );
 
 CREATE TABLE KYS_DEPARTMENT(department_id INT AUTO_INCREMENT, 
  department_name VARCHAR(100),discipline_id INT,
  department_initials VARCHAR(10),department_summary VARCHAR(100),
  CONSTRAINT DEPARTMENT_PK PRIMARY KEY(department_id),
  CONSTRAINT DEPARTMENT_FK FOREIGN KEY(discipline_id) 
  REFERENCES KYS_DISCIPLINE(discipline_id) ON UPDATE CASCADE ON DELETE CASCADE);
  
  CREATE TABLE KYS_MAJOR(major_id INT AUTO_INCREMENT, 
  major_name VARCHAR(100),department_id INT,
  major_initials VARCHAR(10),major_summary VARCHAR(100),
  CONSTRAINT MAJOR_PK PRIMARY KEY(major_id),
  CONSTRAINT MAJOR_FK FOREIGN KEY(department_id) 
  REFERENCES KYS_DEPARTMENT(department_id) ON UPDATE CASCADE ON DELETE CASCADE);
  
  CREATE TABLE KYS_PROFESSOR (professor_id INT AUTO_INCREMENT,
  name VARCHAR(100),
  email VARCHAR(100),
  contact VARCHAR(100),
  url VARCHAR(100),
  CONSTRAINT PROFESSOR_PK PRIMARY KEY(professor_id));
  
  
  CREATE TABLE KYS_PROFESSOR_COURSE (professor_id INT,
  course_id INT,
  CONSTRAINT PROFESSORCOURSE_PK PRIMARY KEY(professor_id,course_id),
  CONSTRAINT PROFESSORCOURSE_FK1 FOREIGN KEY(professor_id) 
  REFERENCES KYS_PROFESSOR(professor_id) ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT PROFESSORCOURSE_FK2 FOREIGN KEY(course_id) 
  REFERENCES KYS_COURSE(course_id) ON UPDATE CASCADE ON DELETE CASCADE
  );
  
  CREATE TABLE KYS_COURSE (course_id INT AUTO_INCREMENT,
  course_name VARCHAR(100),course_initials VARCHAR(10),
  course_summary VARCHAR(100),no_of_feedback INT,
  course_rating DECIMAL(10,2),major_id INT,
  CONSTRAINT COURSE_PK PRIMARY KEY(course_id),
  CONSTRAINT COURSE_FK FOREIGN KEY(major_id) 
  REFERENCES KYS_MAJOR(major_id) ON UPDATE CASCADE ON DELETE CASCADE);
  
  
   CREATE TABLE KYS_USER(user_id INT AUTO_INCREMENT,
   		password VARCHAR(100),
   		email_id VARCHAR(100),first_name VARCHAR(100),
   		last_name VARCHAR(100),security_question VARCHAR(100),
   		security_answer VARCHAR(100),date_of_birth DATE,
   		contact VARCHAR(100),is_admin CHAR(1),zipcode VARCHAR(10),
   		creation_date DATETIME,department_id INT,
   		CONSTRAINT USER_PK PRIMARY KEY(user_id),
  		CONSTRAINT USER_FK FOREIGN KEY(department_id) 
  		REFERENCES KYS_DEPARTMENT(department_id) ON UPDATE CASCADE ON DELETE SET NULL
   );
   
   CREATE TABLE KYS_FEEDBACK(feedback_id INT AUTO_INCREMENT,
   	title VARCHAR(100),comment VARCHAR(300),rating DECIMAL(10,2),
   	helpful_count INT,unhelpful_count INT,is_spam CHAR(1),is_anonymous CHAR(1),
   	creation_date datetime,user_id INT,professor_id INT,course_id INT,
   	CONSTRAINT FEEDBACK_PK PRIMARY KEY(feedback_id),
   	CONSTRAINT FEEDBACK_USER_FK FOREIGN KEY(user_id) REFERENCES KYS_USER(user_id) ON UPDATE CASCADE ON DELETE SET NULL,
   	CONSTRAINT FEEDBACK_PROFESSOR_FK FOREIGN KEY(professor_id)REFERENCES KYS_PROFESSOR(professor_id) ON UPDATE CASCADE ON DELETE SET NULL,
   	CONSTRAINT FEEDBACK_COURSE_FK FOREIGN KEY(course_id)REFERENCES KYS_COURSE(course_id)ON UPDATE CASCADE ON DELETE SET NULL
   );
 
   
  
  
  