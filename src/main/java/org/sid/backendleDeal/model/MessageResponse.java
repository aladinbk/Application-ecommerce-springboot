package org.sid.backendleDeal.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageResponse {

	private boolean success; 
	private String message; 
}
