package com.dailson.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.dailson.cursomc.domain.enums.PaymentStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@EqualsAndHashCode.Include
	private Integer id;

	private Integer status;

	@OneToOne
	@JoinColumn(name = "demand_id")
	@MapsId
	private Demand demand;

	public Payment(Integer id, PaymentStatus status, Demand demand) {
		super();
		this.id = id;
		this.status = status.getCod();
		this.demand = demand;
	}

	public PaymentStatus getStatus() {
		return PaymentStatus.toEnum(status);
	}

	public void setStatus(PaymentStatus paymentStatus) {
		this.status = paymentStatus.getCod();
	}
}
