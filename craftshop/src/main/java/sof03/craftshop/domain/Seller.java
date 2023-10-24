package sof03.craftshop.domain;

import java.util.List;

public class Seller {

	private Long id;
	private String name;
	private String phonenumber;
	private String email;
	private List<Handicraft> handicrafts;
	
	public Seller(String name, String phonenumber, String email, List<Handicraft> handicrafts) {
		super();
		this.name = name;
		this.phonenumber = phonenumber;
		this.email = email;
		this.handicrafts = handicrafts;
	}
	
	public Seller() {
	
	}
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Handicraft> getHandicrafts() {
		return handicrafts;
	}
	public void setHandicrafts(List<Handicraft> handicrafts) {
		this.handicrafts = handicrafts;
	}

	@Override
	public String toString() {
		return "Seller [id=" + id + ", name=" + name + ", phonenumber=" + phonenumber + ", email=" + email
				+ ", handicrafts=" + handicrafts + "]";
	}
	
	
	
}
