package com.dailson.cursomc.domain.enums;

import lombok.Getter;

public enum PaymentStatus {
	PENDING(1, "Pending"),
	SETTLED(2, "Settled"),
	CANCELED(3, "Canceled");

	@Getter
	private int cod;

	@Getter
	private String description;

	private PaymentStatus(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public static PaymentStatus toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(PaymentStatus x :  PaymentStatus.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Invalid id:" + cod);
	}
}
