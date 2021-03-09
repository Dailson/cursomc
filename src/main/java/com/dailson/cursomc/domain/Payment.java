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
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer status;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "demand_id")
	@MapsId
	private Demand demand;

	public Payment(Integer id, PaymentStatus status, Demand demand) {
		this.id = id;
		this.status = (status == null) ? null : status.getCod();;
		this.demand = demand;
	}

	public PaymentStatus getStatus() {
		return PaymentStatus.toEnum(status);
	}

	public void setStatus(PaymentStatus paymentStatus) {
		this.status = paymentStatus.getCod();
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the demand
	 */
	public Demand getDemand() {
		return demand;
	}

	/**
	 * @param demand the demand to set
	 */
	public void setDemand(Demand demand) {
		this.demand = demand;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
