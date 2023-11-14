package sof03.craftshop.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long categoryid;
	@NotNull
	@Size(min = 3, max = 25, message = "Please provide a category name that is 3-25 characters long.")
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	@JsonIgnoreProperties("category")
	private List<Handicraft> handicrafts;

	public Category() {

	}

	public Category(String name) {
		super();
		this.name = name;
	}

	public Long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Handicraft> getHandicrafts() {
		return handicrafts;
	}

	public void setHandicrafts(List<Handicraft> handicrafts) {
		this.handicrafts = handicrafts;
	}

	@Override
	public String toString() {
		return "Category [categoryid=" + categoryid + ", name=" + name + "]";
	}

}
