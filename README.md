# DAM! (Depression and Anxiety Manager)

DAM is a mental health application aimed at helping people manage and track their mental health through an array of smart features and functionalities.

## Goal/Inspiration
Mental illness is more prevalent now than ever. It is estimated that one in four of us will experience some mental health problems in our lifetime.</br>
The purpose of this project is to educate people about mental illness; how to track and improve their mental health; and help them increase awareness of their mental health.</br>
In devoting this project to promoting positive mental health, it is hoped that the user of the app gains and in-depth knowledge of mental health, elevating their awareness on the prevalence of mental illness in society and combat the prejudice or bias which has created the stigma in the first place.

## Description

DAM is an Android application developed using android studio. The app will use a Firebase Realtime databse to store relevant data about the user. The app will include a list functionalities and features that will help users who suffer from mental illnesses such as anxiety and depression.

## Prototyping and Development completed so far

### Login

The first screen creaeted was the login screen.
XML code was used to create the layout and the program was run on a phone emulator. (login_activity.xml)</br>
To provide these XML layout features with more functionality, a java file was used. In the LoginActivity.java file an intent was created. An intent is an object that provides runtime biding between separate components. In this case, an intent was created such that once the register button is pressed on the login screen, the user is brought to the register screen. 

### Database Connection

After getting the movement between screens completed, the next step was to set up a database connection. First, a Firebase account was created and the required steps to connect this database to the android project were followed. This proved quite difficult and time consuming at first as Android Studio was causing some issues. </br>
Due to time constraints it was decided to create a local SQLite database first to store some sample user data. To create this a database manager java class (DatabaseManager.java) was created which would create an SQL database and handle the database queries sent to it. 
