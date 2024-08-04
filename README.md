# demo
Java version: jdk21
Database: postgresSQL
ensure postgres contains database named as "demo"
configure user and password from application.properties

API end points:
http://localhost:8080/api/subjects
http://localhost:8080/api/students
for both method get and post

for post sample json and ensure subject already exist in database 
Subject sample json:
{
    "id": 2,
    "name": "Chemistry",
    "students": {
        "3": "Alice Brown",
        "4": "Bob Smith"
    }

student sample json:
{
    "id": 3,
    "name": "Alice Brown",
    "address": "789 Pine St",
    "subjects": {
        "1": "Mathematics",
        "2": "Physics"
    }
}

}
