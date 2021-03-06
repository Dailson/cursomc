package com.dailson.cursomc.domain;

import java.util.Date;

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
public class PaymentBoleto extends Payment{
	private static final long serialVersionUID = 1L;
		
	private Date dueDate;
	
	private Date paymentDate;
	
	public PaymentBoleto(Integer id, PaymentStatus status, Demand demand, Date dueDate, Date paymenteDate) {
		super(id, status, demand);
		this.dueDate = dueDate;
		this.paymentDate = paymenteDate;
	}
}
