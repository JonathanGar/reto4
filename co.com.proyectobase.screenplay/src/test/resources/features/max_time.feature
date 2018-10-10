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
    When He register a task in two reports
    | report_user | client_code | hour_type   | service                        | activity             | executed_hours | comment                                                  | 
    | jgarciae    | CMK19 - S   | H. Proyecto |	"P. generales CVDS ágiles "    | EJECUCIÓN DE PRUEBAS | 4              | Ejecución de pruebas Soporte Inversiones - Célula Kairos |
    | jgarciae    | CMK19 - S   | H. Proyecto |	"P. generales CVDS ágiles "    | EJECUCIÓN DE PRUEBAS | 4              | Ejecución de pruebas Soporte Inversiones - Célula Kairos   |    	 	
    Then He should see the current day closed
