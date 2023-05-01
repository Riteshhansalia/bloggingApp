package com.ritesh.blog.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
	
	@Column(name ="title", length = 100, nullable = false)
	private String categoryTitle;
	
	@Column(name="description")
	private String categoryDescription;
	
}
