Feature: Create Employee

  @Success
  Scenario Outline: Crear  un empleados
    When consumo el servicio post employee con los datos del empleado nuevo como su nombre <nombre>, su salario <salario> y su edad <edad>
    Then se valida el codigo de respuesta <codigo> y el estado <estado> de la peticion con su mensaje <mensaje>
    And obtengo el nuevo empleado con su id asociado y se presenta su nombre <nombre>, su salario <salario> y su edad <edad>

    Examples:
      | nombre | salario | edad | codigo | estado  | mensaje                              |
      | Yordan | 6000000 | 26   | 200    | success | Successfully! Record has been added. |