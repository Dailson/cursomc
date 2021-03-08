package com.dailson.cursomc.domain;

import javax.persistence.Entity;

import com.dailson.cursomc.domain.enums.PaymentStatus;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class PaymentCard extends Payment{
	private static final long serialVersionUID = 1L;

	private Integer installmentNumber;

	public PaymentCard(Integer id, PaymentStatus status, Demand demand, Integer installmentNumber) {
		super(id, status, demand);
		this.installmentNumber = installmentNumber;
	}

	/**
	 * @return the installmentNumber
	 */
	public Integer getInstallmentNumber() {
		return installmentNumber;
	}

	/**
	 * @param installmentNumber the installmentNumber to set
	 */
	public void setInstallmentNumber(Integer installmentNumber) {
		this.installmentNumber = installmentNumber;
	}
	
	
	
	
	
}
