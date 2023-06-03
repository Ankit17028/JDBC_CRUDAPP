package In.ineuron.service;

import In.ineuron.dto.Student;

public interface IStudentService {

	String save(Student student);//For Creating a record
	
	Student findById(Integer sid);//For Reading record
	
	String updateById(Student student);//Updating a record
	
	String deleteById(Integer sid);//Deleting a record
}
