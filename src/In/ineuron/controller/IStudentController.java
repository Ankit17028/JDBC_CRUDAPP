package In.ineuron.controller;

import In.ineuron.dto.Student;

public interface IStudentController {
	
	String save(Student student);//For Creating a record
	
	Student findById(Integer sid);//For Reading record
	
	String updateById(Student student);//Updating a record
	
	String deleteById(Integer sid);//Deleting a record
	
	
}
