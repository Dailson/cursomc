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
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Client implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer id;
	
	private String name;
	
	private String email;
	
	private String cpfOrCnpj;
	
	private Integer clientType;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "client")
	private final List<Address> addresses = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name = "TELEPHONE")
	private final Set<String> telephones = new HashSet<>();
	
	public Client(Integer id, String name, String email, String cpfOrCnpj, ClientType clientType) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpfOrCnpj = cpfOrCnpj;
		this.clientType = clientType.getCod();
	}
	
	
	public ClientType getClientType() {
		return ClientType.toEnum(clientType);
	}
	
	public void setClienteType(ClientType clientType) {
		this.clientType = clientType.getCod();
	}
}
