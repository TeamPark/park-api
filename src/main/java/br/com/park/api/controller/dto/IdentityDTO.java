package br.com.park.api.controller.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="identity")
public class IdentityDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String email;

	public IdentityDTO() {}
	
	public IdentityDTO(Long id, String email) {
		this.id = id;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
