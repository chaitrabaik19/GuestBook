# GuestBook
Sample spring mvc program 



1)The application module "Guestbook " consists of the Crud operations of a user .Which can be handled by user and admin .

there are 2 ways of login: 
1)Login as user :

user1 :
user name : abc
password : guest 

user 2:
user name : chaitra
password : guest 

for the moment the login details are validated from static table as we do not register functionality 


2) login as Admin 

admin credentials:
 usernname : admin
 password  : admin 


when you login as user , you will have a entry form where you can add your message and also upload the image
on submit , these details are stored in our guestbook db.


When you login as admin , you will have a grid view, where you can see all entries by user and also reject or approve them 

There is logout function in each screen which enables you to go back to login screen .


Project architecture :


IDE used : eclipse mars
jdk version : 8.0.1
database : oracle db 11g 
framework : java /spring mvc framework and jdbctemplate on db layer 
server : tomcat 7.0


































