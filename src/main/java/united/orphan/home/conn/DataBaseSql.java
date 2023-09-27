package united.orphan.home.conn;

public interface DataBaseSql {
	// ************************** loginService **************************
	String validate_user_sql="SELECT * FROM users where email=? and password=?";
	String validate_orphanage_sql="SELECT * FROM orphanage where email=? and password=?";
	String register_user_user_id_create="select max(user_id) as user_id from users";
	String register_user_input_data="insert into users(user_id,name,email,phone_number,password,gender,country,state,city)values(?,?,?,?,?,?,?,?,?)";
	String register_orphanage_orphanage_id_create="select max(orphanage_id) as orphanage_id from orphanage";
	String register_orphanage_input_data="insert into orphanage"
			+ "(orphanage_id,name,registration_id,email,phone_number_1,phone_number_2,password,address,country,state,city,description)"
			+ "values" + 
			"(?,?,?,?,?,?,?,?,?,?,?,?)";
	
	
	// ************************** userService **************************
	String add_child_information_child_id_create=" select count(*) as value,max(child_id) as id from orphanage a,child_information b where a.orphanage_id=b.orphanage_id and b.orphanage_id=?";
	String add_child_information_input_data="insert into child_information"
			+ "(orphanage_id,child_id,name,dob,age,gender,religion,physically_disable)"
			+ "values(?,?,?,?,?,?,?,?)";
	String update_child_information_input_data="update child_information set"
			+ " name=?,dob=?,age=?,gender=?,religion=?,physically_disable=? where orphanage_id=? and child_id=?";
}
