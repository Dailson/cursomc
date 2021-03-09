package com.dailson.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.dailson.cursomc.domain.enums.ClientType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Client implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private String email;
	
	private String cpfOrCnpj;
	
	private Integer clientType;
	
	/* @JsonManagedReference */
	@OneToMany(mappedBy = "client")
	private List<Address> addresses = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name = "TELEPHONE")
	private Set<String> telephones = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "client")
	private List<Demand> demands = new ArrayList<>();
		
	public Client(Integer id, String name, String email, String cpfOrCnpj, ClientType clientType) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpfOrCnpj = cpfOrCnpj;
		this.clientType = (clientType == null) ? null : clientType.getCod();
	}
	
	
	/**
	 * @return
	 */
	public ClientType getClientType() {
		return ClientType.toEnum(clientType);
	}
	
	/**
	 * @param clientType
	 */
	public void setClienteType(ClientType clientType) {
		this.clientType = clientType.getCod();
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the cpfOrCnpj
	 */
	public String getCpfOrCnpj() {
		return cpfOrCnpj;
	}


	/**
	 * @param cpfOrCnpj the cpfOrCnpj to set
	 */
	public void setCpfOrCnpj(String cpfOrCnpj) {
		this.cpfOrCnpj = cpfOrCnpj;
	}


	/**
	 * @return the addresses
	 */
	public List<Address> getAddresses() {
		return addresses;
	}


	/**
	 * @param addresses the addresses to set
	 */
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}


	/**
	 * @return the telephones
	 */
	public Set<String> getTelephones() {
		return telephones;
	}


	/**
	 * @param telephones the telephones to set
	 */
	public void setTelephones(Set<String> telephones) {
		this.telephones = telephones;
	}


	/**
	 * @return the demands
	 */
	public List<Demand> getDemands() {
		return demands;
	}


	/**
	 * @param demands the demands to set
	 */
	public void setDemands(List<Demand> demands) {
		this.demands = demands;
	}


	/**
	 * @param clientType the clientType to set
	 */
	public void setClientType(Integer clientType) {
		this.clientType = clientType;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
