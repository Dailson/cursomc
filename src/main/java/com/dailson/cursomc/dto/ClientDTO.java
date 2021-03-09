package com.dailson.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.dailson.cursomc.domain.Client;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ClientDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotEmpty(message = "It's mandatory!")
	@Length(min=5, max=120, message = "The width must be between 5 an 120 carater")
	private String name;

	@NotEmpty(message = "It's mandatory!")
	@Email(message = "Invalid Email!")
	private String email;

	public ClientDTO(Client obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
	}
}
