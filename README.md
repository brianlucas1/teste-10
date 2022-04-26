# T10
 Aplicatction service
 
 # Tec
. JAVA 11
. CRUS
. SPRING BOOT
. JPA
. HIBERNATE
. LOMBOK
. H2
. VALIDATION
. TEST
. MAVEN

# ACESSO BANCO

. LINK : http://localhost:8080/h2-console
. USER : sa
. PASSWORD : password

# STUDENT CONTROLLER

1 - PARA CONSEGUIR CADASTRAR UM ESTUDANT É NECESSÁRIO PRIMEIRO CRIAR UM NOVO COURSE

1.1 - PARA CADASTRAR UM COURSE FAZER A SEGUINTE CHAMADA:

POST - http://localhost:8080/api/course/insert
{
    "departamentName": "teste",
    "instructorId": "1",
    "duration": 10,
    "name": "brian"

}

1.2 - PARA VISUALIZAR OS COURSES CADASTRADO:

GET - http://localhost:8080/api/course/find
OU
GET - http://localhost:8080/api/course/id

1.3 - PARA CADASTRAR UM STUNDT REALIZAR A SEGUINTE CHAMADA
 
POST - http://localhost:8080/api/studant/insert

{
    "firstName": "b",
    "lastName": "lucas",
    "phone": "12222",
    "idCourse": 1

}

1.4 - CONSULTA DE ESTUDANTES
GET - http://localhost:8080/api/studant/2 
OU 
GET - http://localhost:8080/api/studant/id

1.5 - ATUALIZAR ESTUDANTE.
PUT - http://localhost:8080/api/studant/update/2 
{
    "firstName": "brian",
    "lastName": "zzzz123z",
    "phone": "11948458193"

}

1.6 - DELETAR ESTUDANTE
DELET - http://localhost:8080/api/studant/delet/2


# INSTRUCTOR CONTROLLER

1.1  - CADASTRO
POST - http://localhost:8080/api/instructor/insert 

{
    "departamentName": "teste",
    "headedBy": "b",
    "firstName": "b",
    "lastName": "c",
    "phone": "1234"
    
}

1.2 - CONSULTA
GET  - http://localhost:8080/api/instructor/all  
OU
GET -  http://localhost:8080/api/instructor/ID

1.3 - UPDATE
PUT -  http://localhost:8080/api/instructor/update/1

{
    "departamentName": "teste",
    "headedBy": "b",
    "firstName": "zzzzz",
    "lastName": "c",
    "phone": "1234"
    
}

1.4 - DELETE
DELET - http://localhost:8080/api/instructor/delet/1

