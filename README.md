# This is a Project created during my education in Cooding Bootcamp
# The Projects is not connected with a database.
# In this Project, the User can use synthetic data or create Students,Trainers,Courses and Assignments for the Courses.
# He can also enroll Trainers and Students in a Course.
# The User has some print options.

•	You can find the Main, in the package privateschool, in class Application.
•	The Main consists of the class PrivateSchool, which is in the same package.
•	The PrivateSchool class is divided into 4 sections:
1.	The value initialization
2.	The data loader by the User
3.	The Synthetic data
4.	The Print selection

2.	The data loader by User, uses the AddInputsFromUser class, in order to fill up the data we need from the User. In some methods in that class(AddInputsFromUser), I use the ShowCourseList class, in order to show the User the available Courses that can enroll a Student or a Trainer.
3.	In the class Synthetic data I fill the data by the constructors.
4.	The Print selection is done in the printMethods package. In the PrintChoice class, the user can choose what to print and the PrintLists class does the right prints. 
•	In the models package there are all the classes that are given in the Project Brief, plus the SchoolCourse class, which is used to connect a Course with its Assignments, its Trainers and its Students.
•	In validation package there are:
o	the CheckFloatNumbers class, where I check if I’m getting the right float numbers.
o	the CheckIntegerNumbers class, where I check if I’m getting the right integer numbers, in a min- max range.
o	the DateMethods class, where I convert a String to a LocalDate and I check if a date is between some boundaries.
