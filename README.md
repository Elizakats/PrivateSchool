# This is a Project created during my education in Cooding Bootcamp.
# The Projects is connected with a Database. 
# In this Project, the User has some print options and he can create Students,Trainers,Courses and Assignments for the Courses.
# He can also enroll Trainers and Students in a Course.
# When a Student enrolls in a Course, there is a trigger in the database, which assigns all the course's assignments to the Student.

•	You can find the Main, in the package privateschool, in class Application.
•	The Main consists of the class PrivateSchool, which is in the same package.
•	The PrivateSchool class is divided into 2 sections:
1.	The Print data (PrintChoise)
2.	The Insert data (InsertChoise)

1.	The Print data is done in the printMethods package. In the PrintChoice class, the user can choose what to print and the PrintLists class in the some package and the SelectAndPrint class in the database package do the right prints. 

2.	The Insert data, uses the AddInputsFromUser class, in order to fill up the data we need from the User. Then with the InsertToDatabase class I put the data in the database.  I use the ShowData class, in order to show the User the available values he/she needs for the inserts.
•	In the models package there are all the classes that are given in the Project Brief.
•	In validation package there are:
o	the CheckFloatNumbers class, where I check if I’m getting the right float numbers.
o	the CheckIntegerNumbers class, where I check if I’m getting the right integer numbers, in a min- max range.
o	the DateMethods class, where I convert a String to a LocalDate and I check if a date is between some boundaries.
o	the CheckForDuplicates class, where I insure that no duplicate data will be insert to the database.


Database: 
•	The entities are: Students, Courses, Trainers, Assignments
•	Courses can have many Students, Trainers, Assignments. Students and Trainers can belong to many courses. An Assignment belongs to one Course.
•	We assume that when a Student enrolls in a Course, takes all the Assignment of the Course. Due to that a trigger has been made, which when a Student enrolls in a Course the table Student_Grades gets filled with the Student’s Assignments that need to be graded in the future.
