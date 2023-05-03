package com.ritesh.blog.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="categories")
@Getter
@Setter	
@NoArgsConstructor
public class Category {

	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int categoryId;
	
	@NotBlank
	@Size(min = 4,message = "Minimum size of title is 4!")
	@Column(name ="title", length = 100, nullable = false)
	private String categoryTitle;
	
	@NotBlank
	@Size(max = 10,message = "Maximum size of discription is 10!")
	@Column(name="description")
	private String categoryDescription;
	
}
