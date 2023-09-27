package united.orphan.home.service;


import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import united.orphan.home.conn.DataBaseConnectionManager;
import united.orphan.home.conn.DataBaseSql;
import united.orphan.home.model.Orphanage;
import united.orphan.home.model.Users;



public class LoginService {
	public Users validateUser(String email, String password)throws Exception{
		Connection  con=null;
	  	PreparedStatement ps=null;
	  	ResultSet rs=null;
  		Users user = new Users();
	      try {
	    	  	con=DataBaseConnectionManager.getConnection();
	    	  	
	    	  		PreparedStatement preparedStatement = con.prepareStatement(DataBaseSql.validate_user_sql);
					
					preparedStatement.setString(1, email);	
					preparedStatement.setString(2, password);	
					rs=preparedStatement.executeQuery();
					
					while (rs.next()) {
						user.setId(rs.getString("user_id"));
						user.setName(rs.getString("name"));
						user.setEmail(rs.getString("email"));
						user.setPhone_number(rs.getString("phone_number"));
						user.setPassword(rs.getString("password"));
						user.setGender(rs.getString("gender"));
						user.setCountry(rs.getString("country"));
						user.setState(rs.getString("state"));
						user.setCity(rs.getString("city"));
						user.setStatus(true);
					}
					
	    	  		
			} catch (Exception e) {
				throw new Exception(e);
			}finally{
				DataBaseConnectionManager.close(ps);
				DataBaseConnectionManager.close(rs);
				DataBaseConnectionManager.close(con);
			}
		return user;
	}
	
	public Orphanage validateOrphanage(String email, String password)throws Exception{
		Connection  con=null;
	  	PreparedStatement ps=null;
	  	ResultSet rs=null;
  		Orphanage orphanage = new Orphanage();
	      try {
	    	  	con=DataBaseConnectionManager.getConnection();
	    	  	
	    	  	PreparedStatement preparedStatement = con.prepareStatement(DataBaseSql.validate_orphanage_sql);
	    		
	    		preparedStatement.setString(1, email);	
	    		preparedStatement.setString(2, password);	
	    		rs=preparedStatement.executeQuery();
	    		
	    		while (rs.next()) {
	    			orphanage.setId(rs.getString("orphanage_id"));
	    			orphanage.setName(rs.getString("name"));
	    			orphanage.setRegistration_id(rs.getString("registration_id"));
	    			orphanage.setEmail(rs.getString("email"));
	    			orphanage.setPhone_number_1(rs.getString("phone_number_1"));
	    			orphanage.setPhone_number_2(rs.getString("phone_number_2"));
	    			orphanage.setPassword(rs.getString("password"));
	    			orphanage.setAddress(rs.getString("address"));
	    			orphanage.setCountry(rs.getString("country"));
	    			orphanage.setState(rs.getString("state"));
	    			orphanage.setCity(rs.getString("city"));
	    			orphanage.setDescription(rs.getString("description"));
	    			orphanage.setStatus(true);
	    		}
	    	  		
			} catch (Exception e) {
				throw new Exception(e);
			}finally{
				DataBaseConnectionManager.close(ps);
				DataBaseConnectionManager.close(rs);
				DataBaseConnectionManager.close(con);
			}
		return orphanage;
	}
	
	
	
	

	public boolean registerUser(Users user) throws Exception {
	        Connection  con=null;
	        PreparedStatement ps=null;
	        ResultSet rs=null;
	        String user_id="user/1000001";
	        try {
	        	con = DataBaseConnectionManager.getConnection();
	        	ps=con.prepareStatement(DataBaseSql.register_user_user_id_create);
	        	rs=ps.executeQuery();
	        	System.out.print(rs);
	        	rs.next();
	        	String id=rs.getString("user_id");
	        	
	        	if(id!=null) {
	        		int i=(Integer.parseInt(id.substring(5)))+1;
	        		id=Integer.toString(i);
	        		user_id="user/"+id;
	        	}
	   
				ps = con.prepareStatement(DataBaseSql.register_user_input_data);
				
           ps.setString(1, user_id);
           ps.setString(2, user.getName());
           ps.setString(3, user.getEmail());
           ps.setString(4, user.getPhone_number());
           ps.setString(5, user.getPassword());
           ps.setString(6, user.getGender());
           ps.setString(7, user.getCountry());
           ps.setString(8, user.getState());
           ps.setString(9, user.getCity());
           
           int i=ps.executeUpdate();  
			if(i>0) {
				return true;  
			}

	        }catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DataBaseConnectionManager.close(ps);
				DataBaseConnectionManager.close(rs);
				DataBaseConnectionManager.close(con);
			}
	       return false;
	}
	

	public boolean registerOrphanage(Orphanage orphanage) throws Exception {
	        Connection  con=null;
	        PreparedStatement ps=null;
	        ResultSet rs=null;
	        String orphanage_id="orph/100001";
	        try {
	        	con = DataBaseConnectionManager.getConnection();
	        	ps=con.prepareStatement(DataBaseSql.register_orphanage_orphanage_id_create);
	        	rs=ps.executeQuery();
	        	rs.next();
	        	String id=rs.getString("orphanage_id");
	        	
	        	if(id!=null) {
	        		int i=(Integer.parseInt(id.substring(5)))+1;
	        		id=Integer.toString(i);
	        		orphanage_id="orphan/"+id;
	        	}
	        	System.out.print(orphanage_id);
			   ps = con.prepareStatement(DataBaseSql.register_orphanage_input_data);
			
	           ps.setString(1, orphanage_id);
	           ps.setString(2, orphanage.getName());
	           ps.setString(3, orphanage.getRegistration_id());
	           ps.setString(4, orphanage.getEmail());
	           ps.setString(5, orphanage.getPhone_number_1());
	           ps.setString(6, orphanage.getPhone_number_2());
	           ps.setString(7, orphanage.getPassword());
	           ps.setString(8, orphanage.getAddress());
	           ps.setString(9, orphanage.getCountry());
	           ps.setString(10, orphanage.getState());
	           ps.setString(11, orphanage.getCity());
	           ps.setString(12, orphanage.getDescription());
	           
	           
	           int i=ps.executeUpdate();  
				if(i>0) {
					return true;  
				}
	        }catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DataBaseConnectionManager.close(ps);
				DataBaseConnectionManager.close(rs);
				DataBaseConnectionManager.close(con);
			}
	       return false;
	}
}
