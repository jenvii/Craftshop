package sof03.craftshop.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Seller {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long sellerId;
	private String name;
	private String phonenumber;
	private String email;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "seller")
	@JsonIgnoreProperties("seller")
	private List<Handicraft> handicrafts;

	public Seller(String name, String phonenumber, String email) {
		super();
		this.name = name;
		this.phonenumber = phonenumber;
		this.email = email;
	}

	public Seller() {

	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public List<Handicraft> getHandicrafts() {
		return handicrafts;
	}

	public void setHandicrafts(List<Handicraft> handicrafts) {
		this.handicrafts = handicrafts;
	}

	@Override
	public String toString() {
		return "Seller [sellerId=" + sellerId + ", name=" + name + ", phonenumber=" + phonenumber + ", email=" + email
				+ "]";
	}

}
