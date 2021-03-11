package com.dailson.cursomc.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ClientNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private String name;

	private String email;

	private String cpfOrCnpj;

	private Integer clientType;
	
	private String street;

	private String number;

	private String complement;

	private String district;

	private String postCode;

	private String telephone1;

	private String telephone2;

	private String telephone3;

	private Integer cityId;
}
