# Customer relationship management API

Its a springboot rest api app.


## Features

- Create a new customer.
- Get a single customer.
- Get all customers. 
- Update all the attributes (at once).
- Delete an existing customer.




## Endpoints
#### To retrieve all customers
- make a get request to:
```bash
/api/customers
```
#### Retrieve specific customer
- make a get request to:
```bash
/api/customers/id
```
example:
```bash
/api/customers/1
```
#### To add a new customers
- make a post request to:
```bash
/api/customers
```
#### To update a specific customer data
-  make a put request to:
```bash
/api/customers/id
```
example:
```bash
/api/customers/1
```
#### To delete a specific customer
-  make a delete request to:
```bash
/api/customers/id
```
example:
```bash
/api/customers/1
```

## Installation

Create a docker image using the dockerfile from the project (root directory), then run it.

```bash
  docker build -t crmapp .
  docker run -p 8080:8080 crmapp
```
    
## Tech Stack

**Server:** Java, Springboot

