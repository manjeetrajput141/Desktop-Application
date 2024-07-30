Here is my some Desktop Application

<h2>Sunderdeep Bank Management System -------- ATM Simulation System</h2>
It provides all the functionaliy just like ATM 
ex-Deposit,Withdrawl,Fast Cash,Pin Change,Balance Enquiry,Mini-Statement etc
New User can easily signup and then get a card number and pin
So, that they can done a transaction easily....

-----------------------------------------------------------------------------------------------------------------------------------------
If you want to run this project on your System then you just need to clone or pull the project 
and just need a MySql Database

Run these command on your MySQLWorkbench/MySql Command Line Client

create Database sunderdeep;

use sunderdeep;

//Create table Signup

create table signup(formno int,name varchar(50),fname varchar(50),dob  varchar(50),email  varchar(50),
gender varchar(50),marital varchar(50),address varchar(50),state varchar(50),city varchar(50),pin  varchar(50));

//Create a Table SignupTwo

create table signuptwo(formno int,category varchar(50),religion varchar(50),occupation varchar(50),salary varchar(50),
education varchar(50),pancard varchar(50),aadharcard varchar(50),senior_citizen varchar(50),existing_bank varchar(50));


//Create a Table SignupThree

create table signupthree(formno int,accounttype varchar(50),cardnumber varchar(50),pinnumber int,facility varchar(200));


//Create a Table Login

create table login (formno int,cardnumber varchar(20),pinnumber int );


//Create a Table Bank

create table bank (cardnumber varchar(20),pinnumber int ,balance varchar(20),opening_amount varchar(20),date varchar(50),
account_type varchar(50));


//Create a Table Transaction

create table transaction(cardnumber varchar(20),transaction_id BIGINT,transaction_type varchar(50),
transaction_date varchar(100),transaction_amount int ,balance int );






