Feature: Get Employees

  @Success
  Scenario Outline: Obtener empleados
    When consumo el servicio get employees
    Then se valida el codigo de respuesta <codigo> y el estado <estado> de la peticion con su mensaje <mensaje>
    And obtengo la lista de empleados que contiene el id <id>, el nombre del empleado <nombre>, el salario <salario> y sus edades <edad>

    Examples:
      | codigo | estado  | mensaje                                     | id | nombre       | salario | edad |
      | 200    | success | Successfully! All records has been fetched. | 4  | Cedric Kelly | 433060  | 22   |
      | 200    | success | Successfully! All records has been fetched. | 17 | Paul Byrd    | 725000  | 64   |


  @Fails
  Scenario Outline: Obtener empleados response 404
    When consumo el servicio get employees de manera erronea
    Then se valida el codigo de respuesta <codigo> y el mensaje <mensaje> de la peticion

    Examples:
      | codigo | mensaje                                                         |
      | 404    | Error Occured! Page Not found, contact rstapi2example@gmail.com |