package sof03.craftshop.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Handicraft {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;

	@ManyToOne
	@JsonIgnoreProperties("handicrafts")
	@JoinColumn(name = "categoryid")
	private Category category;
	private Long price;

	@ManyToOne
	@JsonIgnoreProperties("handicrafts")
	@JoinColumn(name = "sellerId")
	private Seller seller;

	public Handicraft(String name, String description, Category category, Long price, Seller seller) {
		super();
		this.name = name;
		this.description = description;
		this.category = category;
		this.price = price;
		this.seller = seller;
	}

	public Handicraft() {

	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	@Override
	public String toString() {
		return "Handicraft [id=" + id + ", name=" + name + ", description=" + description + ", category=" + category
				+ ", price=" + price + ", seller=" + seller + "]";
	}

}
