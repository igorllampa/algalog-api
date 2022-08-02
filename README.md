# algalog-api
API developed during an online course of Algaworks. Rest API with logistic features. The main purpose of this project is to study, discovery and enjoy the functionalities provided by the powerful Spring Framework for java development. Furthermore, using good practises for coding in order to obtain a project organized and easy for maintenance.


# Technologies

-Developed using Java with Spring Framework\
-MySql Database\
-Web Server: TomCat\
-IDE:Spring Tool Suite 4/Eclipse 

# Available endpoints in the API

# Clientes:
## 1. List: 
Method: GET\
URL: //HOST/clientes\

## 2. Get a specific cliente:
Method: GET\
URL: //HOST/clientes/{id}\
              
## 3. Add a cliente:
Method: POST\
URL: //HOST/clientes\
JSON:\
    {
         "nome": "test",
         "email": "test@test.com",
         "telefone": "99 9999999"     
    }
              
## 4. Update a cliente:
Method: PUT\
URL: //HOST/clientes/{id}\
JSON:\
    {
         "nome": "test-2",
         "email": "test@test.com",
         "telefone": "99 9999999"     
    }

## 5. Remove
Method: DELETE\
URL: //HOST/clientes/{id}\
     
     
#### PS: 
- [x] The Software Postman Client was used to execute the tests with the developed REST API.
- [x] The databased used for testing is Mysql running on ........ (Amazon or Heroku);
- [x] The project linguagens-api is now available for tests in Heroku platform and can be acessed by the following link: ...........
