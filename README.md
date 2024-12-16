# Restaurant tables

## Description
This Spring Boot project uses a H2 Database. 

## Endpoints
#### GET /tables
Return all existing tables

#### GET /table/{id} 
Returns the table with the corresponding id 

#### GET /tables/seats 
Returns all the tables with a specific number of seats. Input parameter as raw integer value. Ex: 4 

#### POST /table 
Create a new table 

#### PUT /table/{id} 
update the table with the corresponding id 

#### DELETE /table/{id} 
Delete the table with the corresponding id 

