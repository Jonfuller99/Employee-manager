/**
* View.java
* Jon Fuller / Thursday 2:30
*The View class is like the "face" of the program. It's what users see and interact with. 
It shows stuff like employee names, IDs, and pay, and makes sure that when users type something
in, it's the right kind of info. If there's a problem, like if someone tries to add the same employee 
twice, it tells the user what's wrong. Basically, it's in charge of how everything looks and works for the user.
*/
import java.util.*;
import java.text.DecimalFormat;
public class View{
	private Scanner s;
	private DecimalFormat df = new DecimalFormat("###,###,##0.00");
	
/**
 * Constructs a View object.
 *
 * @param None
 * @return None
 * @throws None
 */	
	public View(){
		s = new Scanner(System.in);
	}

/**
 * Prompts the user to enter an employee's name and validates the input.
 *
 * @return The name entered by the user.
 * @throws IllegalArgumentException if the user enters an empty name.
 */	
	public String getName(){
		boolean validInput= true;
		String name ="";
		do{
			try{
			
				System.out.print("Enter employee's name: ");
				 name = s.nextLine();
				if(name == ""){
					throw new IllegalArgumentException("Name is required. Please re-enter");
				}
				else{
					validInput = true;
				}
			}//end try
			catch(IllegalArgumentException e){
				System.out.println(e.getMessage());
				validInput = false;
			}//end catch
		}while(!validInput);
		return name;
	}	
/**
 * Prompts the user to enter an ID number for the given employee's name and validates the input.
 *
 * @param name The name of the employee.
 * @return The ID number entered by the user.
 * @throws IllegalArgumentException if the user enters an empty ID number.
 */	
	public String getID(String name){
		boolean validInput= true;
		String id ="";
		do{
			try{
			
				System.out.print("Enter "+ name +"'s ID #: ");
				 id = s.nextLine();
				if(id == ""){
					throw new IllegalArgumentException("ID is required. Please re-enter");
				}
				else{
					validInput = true;
				}
			}//end try
			catch(IllegalArgumentException e){
				System.out.println(e.getMessage());
				validInput = false;
			}//end catch
		}while(!validInput);
			
		return id;
	}
/**
 * Prompts the user to specify whether the employee is salaried or hourly and validates the input.
 *
 * @return The type of employee ('S' for salaried, 'H' for hourly).
 * @throws IllegalArgumentException if the user enters an invalid type.
 */	
	public char getType(){
		boolean validInput= true;
		char type ='Z';
		//System.out.print("Is employee S)alaried or H)ourly? ");
		do{
			try{
			
				System.out.print("Is employee S)alaried or H)ourly?");
				String typeString = s.nextLine().toUpperCase();
				if(!typeString.isEmpty()){
					type  = typeString.charAt(0);
					if(type == 'S' || type == 'H'){
						validInput = true;
					}
					else{
						System.out.println("Must be 'H' or 'S'. Please re-enter: ");
						validInput = false;
					}
				}
				else{
					throw new IllegalArgumentException("Employee type is required. Please re-enter");
				}
				
			}//end try
			catch(IllegalArgumentException e){
				System.out.println(e.getMessage());
				validInput = false;
			}//end catch
			
		}while(!validInput);
			
		return type;
	}
/**
 * Prompts the user to enter the yearly salary for the given employee's name and validates the input.
 *
 * @param name The name of the employee.
 * @return The yearly salary entered by the user.
 * @throws IllegalArgumentException if the user enters a non-integer value.
 */	
	public int yearlySal(String name){
		boolean validInput= true;
		int yearly = -1;
		do{
			try{
				validInput = true;
				System.out.print("Enter "+ name +"'s yearly salary: ");
				 yearly = Integer.parseInt(s.nextLine());
			}
			catch (NumberFormatException e){
					System.out.println("No chars or decimals allowed. Enter integers only");
					validInput = false;
				} // end catch
		}while(!validInput);
			
		return yearly;
	}
/**
 * Prompts the user to enter the hourly pay rate for the given employee's name and validates the input.
 *
 * @param name The name of the employee.
 * @return The hourly pay rate entered by the user.
 * @throws IllegalArgumentException if the user enters a non-numeric value.
 */	
	public double hourlyPay(String name){
		boolean validInput = true;
		double hourly =-1;
		do{
			try{
				validInput = true;
				System.out.print("Enter "+ name +"'s pay rate: ");
				 hourly = Double.parseDouble(s.nextLine());
			}
			catch (NumberFormatException e){
				System.out.println("No chars allowed. Enter doubles only");
				validInput = false;
			} // end catch
		}while(!validInput);
			
		return hourly;
	}	
/**
 * Prompts the user to enter the number of hours worked by the given employee's name and validates the input.
 *
 * @param name The name of the employee.
 * @return The number of hours worked entered by the user.
 * @throws IllegalArgumentException if the user enters a non-numeric value.
 */	
	private double hoursWorked(String name){
		boolean validInput = true;
		double hours = -1;
		do{
			try{
			
				System.out.print("Enter "+ name +"'s hours worked: ");
				hours = Double.parseDouble(s.nextLine());
				validInput = true;
			}
			catch (NumberFormatException e){
				System.out.println("No chars allowed. Enter doubles only");
				validInput = false;
			} // end catch
		}while(!validInput);
			
		return hours;
		
	}
/**
 * Prompts the user to enter an ID number to delete an employee and returns the entered ID number.
 *
 * @return The ID number entered by the user for the employee to be deleted.
 */	
	public String idToDelete(){
		System.out.print("Enter an ID number to delete employee: ");
		String toDelete = s.nextLine();
		return toDelete;
	}
/**
 * Prompts the user to decide whether to enter another employee and validates the input.
 *
 * @return true if the user wants to enter another employee, false otherwise.
 */	
	public boolean another(){
		boolean validInput = true;
		boolean ans = true;
		System.out.print("Would you like to enter another employee? (Y/N): ");
		do{
		String input = s.nextLine().toUpperCase();
		char inputChar = input.charAt(0);
		if(inputChar == 'Y'){
			ans = true;
			validInput = true;
			
		}
		else if(inputChar == 'N'){
			ans = false;
			validInput = true;
		}
		else{
			System.out.print("Please enter (Y/N):");
			validInput  = false;
		}
		
		
		}while(!validInput);
		System.out.println();
		return ans;
	}
/**
 * Prints a message indicating that an employee with the specified ID number has been removed from the ArrayList.
 *
 * @param idNum The ID number of the employee that has been removed.
 * @return None
 * @throws None
 */	
	public void printRemoved(String idNum){
		System.out.println("Employee with ID#" + idNum + " removed from ArrayList");
		System.out.println();
	}
/**
 * Displays an error message indicating that the specified ID number was not found for removal.
 *
 * @return None
 * @throws None
 */	
	public void displayRemovalError(){
		System.out.println("ERROR - ID # not found. Please try again");
	}
/**
 * Displays the current contents of the ArrayList, including employee information and weekly gross pay.
 *
 * @param list The ArrayList containing the employee objects.
 * @return None
 * @throws None
 */
	public void currContents(ArrayList <Employee> list){
		View view = new View();
		System.out.println("Current contents of ArrayList:");
		for(Employee em : list){
			if(em.getType()){
				System.out.println(em);
				System.out.println("Weekly Gross Pay - $" + df.format(em.getGrossPay()));
				System.out.println();
			}
			else{
				System.out.println(em);
				double hours = hoursWorked(em.getName());
				System.out.println("Weekly Gross Pay - $" + df.format(em.getGrossPay(hours)));
				System.out.println();
			}
			
		}
		System.out.println();
	}
/**
 * Displays the final contents of the ArrayList, including all employee information.
 *
 * @param employeeList The ArrayList containing the employee objects.
 * @return None
 * @throws None
 */	
	public void finalContents(ArrayList <Employee> employeeList){
		System.out.println("Final contents of ArrayList:");
		for(Employee em : employeeList){
				System.out.println(em);
				System.out.println();
		}
	}
/**
 * Displays an error message indicating that a duplicate employee was not added to the list.
 *
 * @return None
 * @throws None
 */
	public void displayError(){
		System.out.println("Duplicate employee - not added to the list");
		
	}
}// end class