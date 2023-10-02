Feature: Test petstore

  Background:
    * def urlBase = 'https://petstore.swagger.io'

  Scenario: Crear usuario
    Given url urlBase + '/#/user/createUser'
    And request {"id": 1, "username": "string", "firstName": "string", "lastName": "string", "email": "string", "password": "string", "phone": "string", "userStatus": 0 }
    When method post
    Then status 200

  Scenario: Buscar usuario creado
    Given url urlBase + '/#/user/getUserByName'
    When method get
    Then status 200
    And match $ contains {"firstName": "Olga"}

  Scenario: Actualizar el nombre y correo del usuario
    Given url urlBase + '/#/user/updateUser'
    And request {"firstName": "Olga", "email": "olgga@outlook.com"}
    When method put
    Then status 200
    And match response == {"firstName": "Olga Gabriela", "email": "olggm@outlook.com"}

  Scenario: Buscar al usuario actualizado
    Given url urlBase + '/#/user/getUserByName'
    When method get
    Then status 200
    And match $ contains {"firstName": "Olga Gabriela"}

  Scenario: Eliminar el usuario
    Given url urlBase + '/#/user/deleteUser'
    And request {"firstName": "Olga Gabriela"}
    When method delete
    Then status 200
