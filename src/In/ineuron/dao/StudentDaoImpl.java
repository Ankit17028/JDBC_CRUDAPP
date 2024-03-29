package In.ineuron.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import In.ineuron.dto.Student;
import In.ineuron.util.JdbcUtil;

public class StudentDaoImpl implements IStudentDao {

	Connection connection = null;
	
	
	@Override
	public String save(Student student) {
		String sqlInsertQuery ="insert into student2 values(?,?,?,?,?)";
		PreparedStatement pstmt = null;
		String status = null;
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) 
				 pstmt =  connection.prepareStatement(sqlInsertQuery);
			if (pstmt != null) {
//				pstmt.setString(1, Integer.parseInt(student.getSid())); Not valid
//				pstmt.setLong(1, student.getSid());
				pstmt.setInt(1, student.getSid());
				pstmt.setString(2, student.getName());
				pstmt.setString(3, student.getEmail());
				pstmt.setString(4, student.getCity());
				pstmt.setString(5, student.getCountry());
				
			}	
			if (pstmt != null) {
				int rowAffected = pstmt.executeUpdate();
				if (rowAffected == 1) {
					status = "success";
				} else {
					status = "failure";
				}
			}
		
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			status = "failure";
		}
		return status;
	}

	@Override
	public Student findById(Integer sid) {
		String sqlSelectQuery ="select sid,name,email,city,country from student2 where sid=?";
		PreparedStatement pstmt = null;
		Student student = null;
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) 
				 pstmt =  connection.prepareStatement(sqlSelectQuery);
			if (pstmt != null) {
				pstmt.setInt(1, sid);
			}	
			if (pstmt != null) {
				ResultSet resultSet = pstmt.executeQuery();
				if (resultSet.next()) {
					//copy the resultSet data to studentDTO and transfer to the view
					student = new Student();
					student.setSid(resultSet.getInt(1));
					student.setName(resultSet.getString(2));
					student.setEmail(resultSet.getString(3));
					student.setCity(resultSet.getString(4));
					student.setCountry(resultSet.getString(5));
				}
			}
		
		
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return student;
		
		
	}

	@Override
	public String updateById(Student student) {
		
		String sqlUpdateQuery ="update student2 set name=?,email=?,city=?,country=? where sid=?";
		PreparedStatement pstmt = null;
		String status = null;
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) 
				 pstmt =  connection.prepareStatement(sqlUpdateQuery);
			if (pstmt != null) {
//				pstmt.setString(1, Integer.parseInt(student.getSid())); Not valid
//				pstmt.setLong(1, student.getSid());
				pstmt.setString(1, student.getName());
				pstmt.setString(2, student.getEmail());
				pstmt.setString(3, student.getCity());
				pstmt.setString(4, student.getCountry());
				pstmt.setInt(5, student.getSid());

				
			}	
			if (pstmt != null) {
				int rowAffected = pstmt.executeUpdate();
				if (rowAffected == 1) {
					status = "success";
				} else {
					status = "failure";
				}
			}
		
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			status = "failure";
		}
		return status;
	
	}

	@Override
	public String deleteById(Integer sid) {
		String sqlDeleteQuery ="delete from student2 where sid = ? ";
		PreparedStatement pstmt = null;
		String status = null;
		try {
			Student student = findById(sid);
			if (student != null) {
				connection = JdbcUtil.getJdbcConnection();
				if (connection != null) 
					 pstmt =  connection.prepareStatement(sqlDeleteQuery);
				if (pstmt != null) {
					pstmt.setInt(1, sid);
					
				}	
				if (pstmt != null) {
					int rowAffected = pstmt.executeUpdate();
					if (rowAffected == 1) 
						status = "success";
				}
			}else {
				status = "not available";
			}
		
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			status = "failure";
		}
		return status;

	
	}

}
