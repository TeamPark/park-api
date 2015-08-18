package br.com.park.api.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.park.api.controller.dto.IdentityDTO;
import br.com.park.api.controller.service.SearchService;

@RestController
public class IdentityController {
	
	@Autowired
	private SearchService service;

    @RequestMapping(value="/identities", produces=APPLICATION_JSON_VALUE)
    public List<IdentityDTO> list(@RequestParam(value="email", required=false) String email) {
    	return service.list(email);
    }
    
    @RequestMapping(value="/identities/{id}", produces=APPLICATION_JSON_VALUE)
    public IdentityDTO findById(@PathVariable(value="id") Long id) {
        return service.find(id);
    }
}
