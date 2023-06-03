package In.ineuron.controller;

import In.ineuron.dto.Student;
import In.ineuron.factory.StudentServiceFactory;
import In.ineuron.service.IStudentService;

public class StudentControllerImpl implements IStudentController {

	IStudentService stdService;
	
	@Override
	public String save(Student student) {
		stdService = StudentServiceFactory.getStudentService();
		return stdService.save(student);
		
	}

	@Override
	public Student findById(Integer sid) {
		stdService = StudentServiceFactory.getStudentService();
		return stdService.findById(sid);
	}

	@Override
	public String updateById(Student student) {
		stdService = StudentServiceFactory.getStudentService();
		return stdService.updateById(student);
	}

	@Override
	public String deleteById(Integer sid) {
		stdService = StudentServiceFactory.getStudentService();
		return stdService.deleteById(sid);
	}

}
