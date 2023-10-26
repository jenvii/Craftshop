package sof03.craftshop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Handicraft {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;
	// private Category category;
	private Long price;
	// private Seller seller;

	public Handicraft(String name, String description, Long price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public Handicraft() {

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;

	}

	@Override
	public String toString() {
		return "Handicraft [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + "]";
	}

}
