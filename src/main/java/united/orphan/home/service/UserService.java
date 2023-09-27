package united.orphan.home.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import united.orphan.home.conn.DataBaseConnectionManager;
import united.orphan.home.model.ChildInformation;
import united.orphan.home.model.Orphanage;

public class UserService {
	
	public List<Orphanage> selectAllOrphanage() throws ClassNotFoundException, SQLException {

		List<Orphanage> all_orphanage = new ArrayList<>();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet rs=null;
		
		try {
			connection = DataBaseConnectionManager.getConnection();
			preparedStatement = connection.prepareStatement("select * from orphanage");
			
			System.out.println(preparedStatement);
			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Orphanage orphanage =new Orphanage();
				
				orphanage.setId(rs.getString("orphanage_id"));
				orphanage.setName(rs.getString("name"));
				orphanage.setRegistration_id(rs.getString("registration_id"));
				orphanage.setPhone_number_1(rs.getString("phone_number_1"));
				orphanage.setPhone_number_2(rs.getString("phone_number_2"));
				orphanage.setAddress(rs.getString("address"));
				orphanage.setEmail(rs.getString("email"));
				orphanage.setCountry(rs.getString("country"));
				orphanage.setState(rs.getString("state"));
				orphanage.setCity(rs.getString("city"));
				orphanage.setDescription(rs.getString("description"));

				all_orphanage.add(orphanage);
			}
		} catch (SQLException e) {
			System.out.print(e);
		}finally{
			DataBaseConnectionManager.close(preparedStatement);
			DataBaseConnectionManager.close(rs);
			DataBaseConnectionManager.close(connection);
		}
		return all_orphanage;
	}
	
	public List<ChildInformation> selectAllOrphanageChild(String id) throws ClassNotFoundException, SQLException {

		List<ChildInformation> all_child = new ArrayList<>();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet rs=null;
		
		try{
			connection = DataBaseConnectionManager.getConnection();
			preparedStatement = connection.prepareStatement("select * from child_information where orphanage_id=?");
			preparedStatement.setString(1, id);
			System.out.println(preparedStatement);
			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ChildInformation childinformation =new ChildInformation();
				
				childinformation.setOrphanage_id(rs.getString("orphanage_id"));
				childinformation.setName(rs.getString("name"));
				childinformation.setChild_id(rs.getString("child_id"));
				childinformation.setDob(rs.getString("dob"));
				childinformation.setAge(rs.getInt("age"));
				childinformation.setGender(rs.getString("gender"));
				childinformation.setReligion(rs.getString("religion"));
				childinformation.setPhysically_disable(rs.getString("physically_disable"));

				all_child.add(childinformation);
			}
		} catch (Exception e) {
			System.out.print(e);
		}finally{
			DataBaseConnectionManager.close(preparedStatement);
			DataBaseConnectionManager.close(rs);
			DataBaseConnectionManager.close(connection);
		}
		return all_child;
	}
	
	public ChildInformation selectOrphanageChildById(String orphanage_id,String child_id) throws ClassNotFoundException, SQLException {

		ChildInformation child =new ChildInformation();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet rs=null;
		
		try{
			System.out.println(orphanage_id);
			System.out.println(child_id);
			connection = DataBaseConnectionManager.getConnection();
			preparedStatement = connection.prepareStatement("select * from child_information where orphanage_id=? and child_id=?");
			preparedStatement.setString(1, orphanage_id);
			preparedStatement.setString(2, child_id);
			System.out.println(preparedStatement);
			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
				child.setOrphanage_id(rs.getString("orphanage_id"));
				child.setName(rs.getString("name"));
				child.setChild_id(rs.getString("child_id"));
				child.setDob(rs.getString("dob"));
				child.setAge(rs.getInt("age"));
				child.setGender(rs.getString("gender"));
				child.setReligion(rs.getString("religion"));
				child.setPhysically_disable(rs.getString("physically_disable"));

			}
		} catch (Exception e) {
			System.out.print(e);
		}finally{
			DataBaseConnectionManager.close(preparedStatement);
			DataBaseConnectionManager.close(rs);
			DataBaseConnectionManager.close(connection);
		}
		return child;
	}
}
