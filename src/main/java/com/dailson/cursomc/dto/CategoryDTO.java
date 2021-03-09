package com.dailson.cursomc.dto;

import java.io.Serializable;


import com.dailson.cursomc.domain.Category;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CategoryDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotEmpty(message = "It's mandatory!")
	@Length(min=5, max=80, message = "The width must be between 5 an 80 carater")
	private String name;

	public CategoryDTO(Category obj) {
		id = obj.getId();
		name = obj.getName();
	}
}
