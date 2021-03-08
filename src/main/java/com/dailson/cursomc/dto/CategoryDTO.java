package com.dailson.cursomc.dto;

import java.io.Serializable;

import com.dailson.cursomc.domain.Category;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CategoryDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String name;

	public CategoryDTO(Category obj) {
		id = obj.getId();
		name = obj.getName();
	}
}
