package united.orphan.home.model;
public class Orphanage extends Register {

	private String registration_id;
	private String phone_number_1;
	private String phone_number_2;
	private String address;
	private String description;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRegistration_id() {
		return registration_id;
	}
	public void setRegistration_id(String registration_id) {
		this.registration_id = registration_id;
	}
	public String getPhone_number_1() {
		return phone_number_1;
	}
	public void setPhone_number_1(String phone_number_1) {
		this.phone_number_1 = phone_number_1;
	}
	public String getPhone_number_2() {
		return phone_number_2;
	}
	public void setPhone_number_2(String phone_number_2) {
		this.phone_number_2 = phone_number_2;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
