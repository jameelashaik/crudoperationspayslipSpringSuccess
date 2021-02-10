package com.apcfss.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.apcfss.model.EmployeeDetails;

@Repository("employeedao")
public class EmployeeDetailsDaoImpl implements EmployeeDetailsDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public boolean createEmployee(EmployeeDetails emp) {
		String sql="insert into springemployee(id,name,salary,designation) values('"+emp.getId()+"','"+emp.getName()+"','"+emp.getSalary()+"','"+emp.getDesignation()+"')";
		int i=jdbcTemplate.update(sql);
	//	jdbcTemplate.
		if(i>0){
			return true;
					
		}
		return false;

	}	  
	public List<EmployeeDetails> getEmployees(){    
	    return jdbcTemplate.query("select * from springemployee",new RowMapper<EmployeeDetails>(){    
	        public EmployeeDetails mapRow(ResultSet rs, int row) throws SQLException {    
	        	EmployeeDetails e=new EmployeeDetails();    
	            e.setId(rs.getInt(1));    
	            e.setName(rs.getString(2));    
	            e.setSalary(rs.getFloat(3));    
	            e.setDesignation(rs.getString(4));    
	            return e;    
	        }    
	    });    
	}
	   public int delete(int id) {
		      String SQLc = "delete from springempchild where eid ="+id;
		      String SQLp = "delete from springemployee where id = "+id;
		      System.out.println("chefcking child-------"+SQLc);
		      System.out.println("chefcking parent-------"+SQLp);
		      int delres = jdbcTemplate.update(SQLc);
		     if(delres>0){
		    	 int delp = jdbcTemplate.update(SQLp);
		    	System.out.println("sucess");
		     }else{
		     System.out.println("failed");
		     }
			return delres;
		}
	   public EmployeeDetails getEmpById(int id){    
		    String sql="select * from springemployee where id="+id;    
		    return  jdbcTemplate.query(sql, new ResultSetExtractor<EmployeeDetails>(){
		        public EmployeeDetails extractData(ResultSet rs) throws SQLException,DataAccessException {
		            if (rs.next()) {
		            	EmployeeDetails contact = new EmployeeDetails();
		                contact.setId(rs.getInt("id"));
		                contact.setName(rs.getString("name"));
		                contact.setSalary(rs.getFloat("salary"));
		                contact.setDesignation(rs.getString("designation"));
		                return contact;
		            }
		 
		            return null;
		        }
		 
		    });    
		} 
		public boolean edit(EmployeeDetails emp ,HttpServletRequest req){
			System.out.println("id-------"+emp.getId());
		    String sql="UPDATE public.springemployee SET name='"+emp.getName()+"',salary='"+emp.getSalary()+"',designation='"+emp.getDesignation()+"'WHERE id='"+emp.getId()+"'  ";
		    System.out.println("sql----------"+sql);
		    int editresult=jdbcTemplate.update(sql); 
		    System.out.println("editresult:"+editresult);
		    if(editresult>0){
		    	return true;
		    }
		    else{
			return false;
		    }
		}
		public int attendence(EmployeeDetails emp) {
			
			return 0;
		}
		public int savedayspresent(EmployeeDetails emp) {
			String sql="INSERT INTO public.springempchild(eid, dayspresent) VALUES('"+emp.getId()+"','"+emp.getDayspresent()+"')";
			System.out.println("dayspresentsave:sql:"+sql);
			int dayresult=jdbcTemplate.update(sql);
			System.out.println("dayspresent result:"+dayresult);
			return dayresult;
		}
		public List<EmployeeDetails> getEmployees1() {
			 return jdbcTemplate.query("select * from springemployee",new RowMapper<EmployeeDetails>(){    
			        public EmployeeDetails mapRow(ResultSet rs, int row) throws SQLException {    
			        	EmployeeDetails e=new EmployeeDetails();    
			            e.setId(rs.getInt(1));    
			            e.setName(rs.getString(2));    
			            e.setSalary(rs.getFloat(3));    
			            e.setDesignation(rs.getString(4));    
			            return e;    
			        }    
			    });    
		}
	public List<EmployeeDetails> getEmployeespayslip(int id) {
		    return jdbcTemplate.query("select t.id,t.name,t.salary,ti.dayspresent from springemployee as t, springempchild as ti where (t.id=ti.eid) and t.id="+id,new RowMapper<EmployeeDetails>(){    
		        public EmployeeDetails mapRow(ResultSet rs, int row) throws SQLException {    
		        	EmployeeDetails e=new EmployeeDetails();    
		            e.setId(rs.getInt(1));    
		            e.setName(rs.getString(2));    
		            e.setSalary(rs.getFloat(3));    
		            e.setDayspresent(rs.getInt(4));    
		            return e;    
		        }    
		    }); 
		}
	public EmployeeDetails getSalaryById(int id) {
	    String sql="select * from springemployee where id="+id;    
	    return  jdbcTemplate.query(sql, new ResultSetExtractor<EmployeeDetails>(){
	        public EmployeeDetails extractData(ResultSet rs) throws SQLException,DataAccessException {
	            if (rs.next()) {
	            	EmployeeDetails contact = new EmployeeDetails();
	                contact.setId(rs.getInt("id"));
	                contact.setName(rs.getString("name"));
	              contact.setSalary(rs.getFloat("salary"));
	                contact.setDesignation(rs.getString("designation"));
	                return contact;
	            }
	            
	            return null;
	        }
	 
	    });
	}

		
}
