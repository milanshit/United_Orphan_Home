package united.orphan.home.model;

public class ChildInformation {
	private String orphanage_id;
	private String child_id;
	private String name;
	private String dob;
	private int age;
	private String gender;
	private String religion;
	private String physically_disable;
	public String getOrphanage_id() {
		return orphanage_id;
	}
	public void setOrphanage_id(String orphanage_id) {
		this.orphanage_id = orphanage_id;
	}
	public String getChild_id() {
		return child_id;
	}
	public void setChild_id(String child_id) {
		this.child_id = child_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getPhysically_disable() {
		return physically_disable;
	}
	public void setPhysically_disable(String physically_disable) {
		this.physically_disable = physically_disable;
	}
}
