package br.com.park.api.controller.service;

import static java.util.Arrays.asList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import br.com.park.api.controller.dto.IdentityDTO;

@Service
public class SearchService {
	
	private static final String NOT_DIGIT = "\\D";
	private static final String DEFAULT_EMAIL = "teste%s@gmail.com";

	public List<IdentityDTO> list(String email) {
		
		if (StringUtils.isBlank(email)) {
			return asList(build(1L), build(2L));
		}
		
		return asList(build(email));
	}
	
	public IdentityDTO find(Long id) {
		return build(id);
	}
	
	private IdentityDTO build(Long id) {
		return new IdentityDTO(id, String.format(DEFAULT_EMAIL, id));
	}
	
	private IdentityDTO build(String email) {
		
		final String justDigits = email.replaceAll(NOT_DIGIT, StringUtils.EMPTY);
		
		if (StringUtils.isBlank(justDigits)) {
			return null;
		}
		
		return build(new Long(justDigits));
	}
}
