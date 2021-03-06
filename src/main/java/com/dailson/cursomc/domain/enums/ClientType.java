package com.dailson.cursomc.domain.enums;

import lombok.Getter;


public enum ClientType {

	NATURAL_PERSON(1, "Natural Person"),
	LEGAL_PERSON(2, "Legal Person");

	
	@Getter
	private int cod;
	
	@Getter
	private String description;
	
	private ClientType(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}
	
	
	public static ClientType toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(ClientType x : ClientType.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Invalid Id: " + cod);
	}
}
