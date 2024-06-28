/**
* Proj9.java
* Jon Fuller / Thursday 2:30
* This program manages a list of employees, allowing users to add, view, and delete employee information. 
It starts by prompting users to input employee details like name, ID, and type of employment (salaried or hourly). 
Then, it creates Employee objects with this information and adds them to an ArrayList. If an employee with the same ID 
already exists, it displays an error message. After adding all employees, it displays the current list of employees and 
asks if the user wants to delete any. If the user chooses to delete an employee, it removes the employee from the list and 
displays the updated list of employees.

	-------------EXTRA CREDIT INCLUDED (VIEW CLASS, AND GUI_VIEW)-------------
*/

import java.util.*;

public class Proj9{
	public static void main(String [] args){
		ArrayList <Employee> employeeList = new ArrayList<>();
		//View view = new View();
		View view = new View();
		boolean yes = true;
		
		
		while(yes){
			String name = view.getName();
			String id = view.getID(name);
			char type = view.getType();
			
			if(type == 'S'){
				int sal = view.yearlySal(name);
				Employee newEmployee = new Employee(name, id, type, sal);
				if(newEmployee.equals(employeeList)){
					view.displayError();
				}
				else{	
					employeeList.add(newEmployee);	
				}

			}// end if
			else{
				double rate = view.hourlyPay(name);
				Employee newEmployee = new Employee(name, id, type, rate);
				
				if(newEmployee.equals(employeeList)){
					view.displayError();
				}
				else{	
					employeeList.add(newEmployee);	
				}
			}// end else
				
			
			yes = view.another();
		}// end while yes
		
		view.currContents(employeeList);
		
		boolean validInput = true;
		do{
			String idDelete = view.idToDelete();
			for(Employee em : employeeList){
				if(idDelete.equals(em.getID())){
					employeeList.remove(em);
					validInput = true;
					view.printRemoved(idDelete);
					break;
				}
				else{
					
					validInput = false;
				}
				
			}
			if(!validInput){
				view.displayRemovalError();
			}
		}while(!validInput);
		view.finalContents(employeeList);
				
				
			
		
	}// end main
}// end class