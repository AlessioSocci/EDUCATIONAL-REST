EDUCATIONAL-REST

This is an example of RESTfull java web service, running in Tomcat v9.0 Application Server. 
CRUD operations on local running MYSQL database are made available from Http request, to manage a simple address-book.
Maven are also utilized to import some library as dependencies.

Locally, the web services are tested with Postman, an API client to send Http request (POST, GET, UPDATE, DELETE...), while 
the DB named testdbrest is formed by one table: contacts. The field are: contact_id (primary key), name, email, gender, phone, 
city and country. User-password are setted to "Admin" "Admin". 
Web service are accessible by this URI:

CREATE: 

POST http://localhost:8080/java_JAX-RS/api/resources/create
 
with a body JSON message like this: 
{
"contact_id" : "1",
"name" : "Alessio",
"email" : "alessios",
"gender" : "male",
"phone" : "339",
"city" : "Ancona",
"country" : "Italy"
}
  
READ: 

GET http://localhost:8080/java_JAX-RS/api/resources/find
GET http://localhost:8080/java_JAX-RS/api/resources/find/id/[contact_id]
GET http://localhost:8080/java_JAX-RS/api/resources/find/city/[city]
GET http://localhost:8080/java_JAX-RS/api/resources/find/country/[country]

UPDATE:

PUT http://localhost:8080/java_JAX-RS/api/resources/update/[contact_id]
  
with a body JSON message like this: 
{
"name" : "Alessio",
"email" : "alessios",
"gender" : "male",
"phone" : "339",
"city" : "Ancona",
"country" : "Italy"
}
  
DELETE:

DELETE http://localhost:8080/java_JAX-RS/api/resources/delete/[contact_id]
