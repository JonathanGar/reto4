#Author: your.email@your.domain.com

@tag
Feature: Report employees activities on MaxTime
	As a tester
	I want to perform the report of my activities on MaxTime 
	To comply with the task that I have to do daily
  
  @tag1
  Scenario: Report activities for a day 
    Given Jonathan want to report his activities on MaxTime
    | user_name | password    |
    | jgarciae  |	pgnRS4Rro5_ |       
    When He register a task
    | report_user | client_code | hour_type   | service                  | activity             | excetuted_hours | comment                                                  | 
    | jgarciae    | CMK19 - S   | H. Proyecto |	P. generales CVDS �giles | EJECUCI�N DE PRUEBAS | 4               | Ejecuci�n de pruebas Soporte Inversiones - c�lula Kairos | 	
    Then He should see the current day closed
