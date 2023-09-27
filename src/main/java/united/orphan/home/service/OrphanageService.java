package united.orphan.home.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import united.orphan.home.conn.DataBaseConnectionManager;
import united.orphan.home.conn.DataBaseSql;
import united.orphan.home.model.ChildInformation;


public class OrphanageService {
	
	public boolean selectAllOrphanageChild(String orphanage_id,String child_id) throws ClassNotFoundException {

		
		try (Connection connection = DataBaseConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("delete from child_information where orphanage_id=? and child_id=?");) {
			preparedStatement.setString(1, orphanage_id);
			preparedStatement.setString(2, child_id);
			System.out.println(preparedStatement);
			int rs = preparedStatement.executeUpdate();
			if(rs>0) {
				return true;
			}
			
		} catch (SQLException e) {
			System.out.print(e);
		}
		return false;
	}
	
	public boolean addChildInformation(ChildInformation child) throws Exception {
		Connection  con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
        	con = DataBaseConnectionManager.getConnection();
        	
        	ps=con.prepareStatement(DataBaseSql.add_child_information_child_id_create);
        	System.out.print(child.getOrphanage_id());
        	ps.setString(1, child.getOrphanage_id());
        	rs=ps.executeQuery();
        	rs.next();
        	int value=Integer.parseInt(rs.getString("value"));
        	String id=rs.getString("id");
        	String child_id="child/100001";
        	if(value > 0) {
        		int i=(Integer.parseInt(id.substring(6)))+1;
        		id=Integer.toString(i);
        		child_id="child/"+id;
        	}
        	System.out.print(child_id);
			ps = con.prepareStatement(DataBaseSql.add_child_information_input_data);
			
       ps.setString(1, child.getOrphanage_id());
       ps.setString(2, child_id);
       ps.setString(3, child.getName());
       ps.setString(4, child.getDob());
       ps.setInt(5, child.getAge());
       ps.setString(6, child.getGender());
       ps.setString(7, child.getReligion());
       ps.setString(8, child.getPhysically_disable());
       
       int i=ps.executeUpdate();  
		if(i>0) {
			return true;  
		}

        } catch (SQLException e) {
			e.printStackTrace();
		}
       return false;
	}
	
	
	public boolean updateChildInformation(ChildInformation child) throws Exception {
		Connection  con=null;
        PreparedStatement ps=null;
        try {
        	con = DataBaseConnectionManager.getConnection();
			ps = con.prepareStatement(DataBaseSql.update_child_information_input_data);
       ps.setString(1, child.getName());
       ps.setString(2, child.getDob());
       ps.setInt(3, child.getAge());
       ps.setString(4, child.getGender());
       ps.setString(5, child.getReligion());
       ps.setString(6, child.getPhysically_disable());
       
       ps.setString(7, child.getOrphanage_id());
       ps.setString(8, child.getChild_id());
       
       int i=ps.executeUpdate();  
		if(i>0) {
			return true;  
		}

        } catch (SQLException e) {
			e.printStackTrace();
		}
       return false;
}
}
