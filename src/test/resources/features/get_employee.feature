Feature: Get Employee

  @Success
  Scenario Outline: Obtener  un empleados
    When consumo el servicio get employee con el id <id> del empleado a buscar
    Then se valida el codigo de respuesta <codigo> y el estado <estado> de la peticion con su mensaje <mensaje>
    And obtengo el empleado con el id <id>, el nombre del empleado <nombre>, el salario <salario> y su edad <edad>

    Examples:
      | codigo | estado  | mensaje                                | id | nombre   | salario | edad |
      | 200    | success | Successfully! Record has been fetched. | 20 | Dai Rios | 217500  | 35   |

  @Fails
  Scenario Outline: Obtener empleados response 404
    When consumo el servicio get employee de manera erronea
    Then se valida el codigo de respuesta <codigo> y el mensaje <mensaje> de la peticion

    Examples:
      | codigo | mensaje                                                         |
      | 404    | Error Occured! Page Not found, contact rstapi2example@gmail.com |