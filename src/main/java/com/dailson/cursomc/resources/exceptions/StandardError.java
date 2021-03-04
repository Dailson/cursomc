package com.dailson.cursomc.resources.exceptions;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StandardError implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer status;
	private String msg;
	private Long timeStamp;
	
}
