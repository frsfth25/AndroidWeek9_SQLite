CREATE TABLE Students
(
	StudentId INT NOT NULL, 
	Name VARCHAR(40) NOT NULL,
	Surname VARCHAR(40),
	PRIMARY KEY (StudentId)
);
CREATE TABLE Courses
(
	CourseId INT NOT NULL, 
	Name VARCHAR(40) NOT NULL,
	PRIMARY KEY (CourseId)
);

CREATE TABLE Registeration
(
	RegId INT NOT NULL,
	CourseId INT NOT NULL, 
	StudentId  INT NOT NULL,
	PRIMARY KEY (RegId)
);

---- ADD FOREIGN KEYS

----

INSERT INTO Students (StudentId, Name,Surname) VALUES (1, 'Mehmet','Yanmaz');
INSERT INTO Students (StudentId, Name,Surname) VALUES (2, 'Ali','Songul');
INSERT INTO Students (StudentId, Name,Surname) VALUES (3, 'Veli','Kasli');
INSERT INTO Students (StudentId, Name,Surname) VALUES (4, 'Fatma','Masum');
INSERT INTO Students (StudentId, Name,Surname) VALUES (5, 'Zahide','Suman');
INSERT INTO Students (StudentId, Name,Surname) VALUES (6, 'Hakan','Usta');
INSERT INTO Students (StudentId, Name,Surname) VALUES (7, 'Sena','Yanmaz');


INSERT INTO Courses (CourseId, Name) VALUES (101, 'Introduction to CENG');
INSERT INTO Courses (CourseId, Name) VALUES (427, 'Mobile Programming');
INSERT INTO Courses (CourseId, Name) VALUES (102, 'C Programming');

INSERT INTO Registeration (RegId, CourseId,StudentId) VALUES (1, 101,1);
INSERT INTO Registeration (RegId, CourseId,StudentId) VALUES (2, 101,2);
INSERT INTO Registeration (RegId, CourseId,StudentId) VALUES (3, 101,3);
INSERT INTO Registeration (RegId, CourseId,StudentId) VALUES (4, 427,4);
INSERT INTO Registeration (RegId, CourseId,StudentId) VALUES (5, 427,5);
INSERT INTO Registeration (RegId, CourseId,StudentId) VALUES (6, 427,6);
INSERT INTO Registeration (RegId, CourseId,StudentId) VALUES (7, 102,7);