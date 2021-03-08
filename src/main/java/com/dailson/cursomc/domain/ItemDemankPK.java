package com.dailson.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Embeddable
@Data
public class ItemDemankPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "demand_id")
	private Demand demand;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	
}
