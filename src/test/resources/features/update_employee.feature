Feature: Update Employee

  @Success
  Scenario Outline: Actualizar un empleado
    When consumo el servicio put employee con los datos a actulizar del empleado como su nombre <nombre>, su salario <salario> y su edad <edad>
    Then se valida el codigo de respuesta <codigo> y el estado <estado> de la peticion con su mensaje <mensaje>
    And obtengo el empleado con sus datos de nombre <nombre>, su salario <salario> y su edad <edad> actualizados

    Examples:
      | nombre | salario  | edad | codigo | estado  | mensaje                                |
      | Camila | 10000000 | 25   | 200    | success | Successfully! Record has been updated. |