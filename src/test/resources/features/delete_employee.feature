Feature: Delete Employee

  @Success
  Scenario Outline: Eliminar un empleado
    When consumo el servicio delete employee con el id <id> del empleado a eliminar
    Then se valida el codigo de respuesta <codigo> y el estado <estado> de la peticion con su mensaje <mensaje>
    And valido que el usuario eliminado corresponda al mismo id ingresado <id>

    Examples:
      | id | codigo | estado  | mensaje                               |
      | 26 | 200    | success | Successfully! Record has been deleted |