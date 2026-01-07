DROP DATABASE IF EXISTS school;
create database school;
use school;

CREATE TABLE student (
  student_id int AUTO_INCREMENT PRIMARY KEY,
  first_namecourse_student varchar(255) DEFAULT NULL,
  last_name varchar(255) DEFAULT NULL
);

CREATE TABLE teacher (
  teacher_id int AUTO_INCREMENT PRIMARY KEY,
  first_name varchar(255) DEFAULT NULL,
  last_name varchar(255) DEFAULT NULL,
  dept varchar(255) DEFAULT NULL
);

CREATE TABLE course (
  course_id int AUTO_INCREMENT PRIMARY KEY,
  course_name varchar(255) DEFAULT NULL,
  course_desc varchar(255) DEFAULT NULL,
  teacher_id int DEFAULT NULL,
  FOREIGN KEY (teacher_id) REFERENCES teacher (teacher_id)
);

CREATE TABLE course_student (
  student_id int,
  course_id int,
  PRIMARY KEY (student_id, course_id),
  FOREIGN KEY (student_id) REFERENCES student(student_id),
  FOREIGN KEY (course_id) REFERENCES course(course_id)
);

INSERT INTO teacher VALUES
(1,'Hedy','Lamarr','Computer Science'),
(2,'Radia','Perlman','Computer Science'),
(3,'Annie','Easley','Computer Science'),
(4,'Peter','Denning','Computer Science'),
(5,'Ravi','Sethi','Computer Science'),
(7,'Hilary','Mantel','English'),
(8,'Margaret','Atwood','English'),
(9,'David','Mitchell','English'),
(10,'Michael','Chabon','English'),
(11,'Neil','Gaiman','Math');

INSERT INTO course VALUES
(1,'CS148','Intro to Data Structures',1),
(2,'CS100','Intro to Java',2),
(3,'CS202','Intermediate Java',1),
(4,'CS305','Advanced Python',5),
(5,'CS407','Information Systems Management',4),
(6,'CS206 ','Network Design',4),
(7,'CS503','Advanced Cyber Security',3),
(8,'CS326','Advanced Fortran',5),
(10,'CS324','Advanced Web Services with Java API',3),
(11,'EN220','Fictional Writing',10),
(12,'EN250','Fantasy Fictional Writing',7),
(14,'EN100','Writing Basics',8),
(15,'EN200','English Composition',9),
(16,'M300','Geometry',11);

INSERT INTO student VALUES
(1, 'Jolene','Westcott'),
(2,'Tabby','Daniell'),
(3,'Hans','Wozniak'),
(4,'Ifeanyi','Derichs'),
(5,'Guafrid','Lopez'),
(6,'Helena','Abbandonato'),
(7,'Aime','Larsen'),
(9,'Milada','Dreher');

INSERT INTO course_student VALUES
(1,1),
(1,2),
(1,3),
(1,5),
(1,12),
(1,14),
(2,1),
(2,2),
(2,3),
(2,12),
(2,16),
(3,2),
(3,3),
(3,4),
(3,5),
(3,14),
(3,16),
(4,1),
(4,4),
(4,5),
(4,6),
(4,7),
(4,15),
(4,16),
(5,1),
(5,2),
(5,4),
(5,6),
(5,14),
(5,16),
(6,1),
(6,3),
(6,5),
(6,6),
(6,7),
(6,15),
(7,1),
(7,2),
(7,3),
(7,5),
(7,6),
(7,7),
(9,3),
(9,5),
(9,6),
(9,7),
(9,11),
(9,15);
