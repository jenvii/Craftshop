package sof03.craftshop.domain;



public class Handicraft {

	private Long id;
	private String name;
	private String description;
	private Category category;
	private Long price;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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
