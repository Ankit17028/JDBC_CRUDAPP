package In.ineuron.factory;

import In.ineuron.controller.IStudentController;
import In.ineuron.controller.StudentControllerImpl;

public class StudentControllerFactory {


	private static IStudentController studentController = null;

	private StudentControllerFactory() {

	}
	
	public static IStudentController getStudentController() {
		
		if (studentController == null) //if it is null then create an object and then return  
			studentController = new StudentControllerImpl();

		return studentController;
			
		
	}
}
