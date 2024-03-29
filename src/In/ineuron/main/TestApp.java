package In.ineuron.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import In.ineuron.controller.IStudentController;
import In.ineuron.dto.Student;
import In.ineuron.factory.StudentControllerFactory;

public class TestApp {

	public static void main(String[] args) {

		IStudentController studentController = null;
		String status = null, sid = null,name=null,city=null, email=null, country=null;
		Integer id = null;
//		Integer sid = null;
		Student studentRecord = null;
		
		try {
			while (true) {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
				System.out.println("1. CREATE");
				System.out.println("2. READ");
				System.out.println("3. UPDATE");
				System.out.println("4. DELETE");
				System.out.println("5. EXIT");
				System.out.print("YOUR OPTION :: [1,2,3,4,5]:: ");
				Integer option = Integer.parseInt(br.readLine());
	
				studentController = StudentControllerFactory.getStudentController();
				switch (option) {
				case 1:
//					System.out.print("Enter the id:: ");// 1st Method
//					sid = Integer.parseInt(br.readLine());

					System.out.print("Enter the id:: ");
					sid = br.readLine();
					
					System.out.print("Enter the name:: ");
					name = br.readLine();
					
					System.out.print("Enter the email:: ");
					email = br.readLine();
					
					System.out.print("Enter the city:: ");
					city = br.readLine();
					
					System.out.print("Enter the country:: ");
					country = br.readLine();
					
					Student student = new Student();
					student.setSid(Integer.parseInt(sid)); //if i used 1st method this fucntion will throw Error
					student.setName(name);
					student.setCity(city);
					student.setEmail(email);
					student.setCountry(country);
					status = studentController.save(student);
					if (status.equalsIgnoreCase("success")) { //equalsIgnorecase bc'z return type is String
						System.out.println("Record inserted Successfully....");
					} else if (status.equalsIgnoreCase("failure")) {
						System.out.println("Record insertion failed....");
					} else {
						System.out.println("Some problem occurd.....");
					} 
					
					break;
				case 2:
					System.out.print("Enter the id:: ");
					id = Integer.parseInt(br.readLine());
					studentRecord = studentController.findById(id);
					if (studentRecord != null) 
						System.out.println(studentRecord);
					else
						System.out.println("Record not available for the given id :: " + id);
					break;
				case 3:
					System.out.print("Enter the id of the record to be updated:: ");
					id = Integer.parseInt(br.readLine());
					studentRecord = studentController.findById(id);
					if (studentRecord != null) {
						Student newStudent = new Student();
						newStudent.setSid(id);
						
						
//						System.out.print("StudentSid :: [Old Sid is :: " + studentRecord.getSid() + "]: ");
//						Integer newSid= Integer.parseInt(br.readLine());
//						
//						if (newSid == null || newSid.equals(newSid)) {
//							newStudent.setSid(studentRecord.getSid());
//						} else {
//							newStudent.setSid(newSid);
//						}
						
						System.out.print("StudentName :: [Old Name is :: " + studentRecord.getName() + "]: ");
						String newName = br.readLine();
					
						if (newName == null || newName.equals("")) {
							newStudent.setName(studentRecord.getName());
						} else {
							newStudent.setName(newName);
						}
						
						System.out.print("StudentEmail :: [Old Email is :: " + studentRecord.getEmail() + "]: ");
						String newEmail= br.readLine();
					
						if (newEmail == null || newEmail.equals("")) {
							newStudent.setEmail(studentRecord.getEmail());
						} else {
							newStudent.setEmail(newEmail);
						}
						
						System.out.print("StudentCity :: [Old City is :: " + studentRecord.getCity() + "]: ");
						String newCity= br.readLine();
					
						if (newCity == null || newCity.equals("")) {
							newStudent.setCity(studentRecord.getCity());
						} else {
							newStudent.setCity(newCity);
						}
						
						System.out.print("StudentCountry :: [Old Country is :: " + studentRecord.getCountry() + "]: ");
						String newCountry= br.readLine();
					
						if (newCountry == null || newCountry.equals("")) {
							newStudent.setCountry(studentRecord.getCountry());
						} else {
							newStudent.setCountry(newCountry);
						}
						
						status = studentController.updateById(newStudent);
						if (status.equalsIgnoreCase("success")) { //equalsIgnorecase bc'z return type is String
							System.out.println("Record Updated Successfully....");
						} else if (status.equalsIgnoreCase("failure")) {
							System.out.println("Record updation failed....");
						} else {
							System.out.println("Some problem occurd.....");
						} 
					
					
					}else
						System.out.println("Record not available for the given id :: " + id);
					break;
				case 4:
					System.out.print("Enter the id:: ");
					id = Integer.parseInt(br.readLine());
					status = studentController.deleteById(id);
					if (status.equalsIgnoreCase("success")) { //equalsIgnorecase bc'z return type is String
						System.out.println("Record deleted Successfully....");
					} else if (status.equalsIgnoreCase("failure")) {
						System.out.println("Record deletion failed....");
					} else {
						System.out.println("Record not available for the given id to delete.....");
					}
					break;
				case 5:
					System.out.println("Thanks for using the application");
					System.exit(0);
				
				default:
					System.out.println("Plz enter the option like 1,2,3,4,5 for operation" );
					break;
				
				}
				
			} 
			
		} catch (Exception e) 	{
			e.printStackTrace();
		}
	
	}

}
