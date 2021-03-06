package com.dailson.cursomc.domain;

import javax.persistence.Entity;

import com.dailson.cursomc.domain.enums.PaymentStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)

@Entity
public class PaymentCard extends Payment{
	private static final long serialVersionUID = 1L;

	private Integer installmentNumber;

	public PaymentCard(Integer id, PaymentStatus status, Demand demand, Integer installmentNumber) {
		super(id, status, demand);
		this.installmentNumber = installmentNumber;
	}
	
	
	
	
	
}
