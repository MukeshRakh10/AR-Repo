package in.mk.rest.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.mk.DTO.CitizenAppDTO;
import in.mk.ar.yml.ArModuleYmlProperties;
import in.mk.service.ICitizenAppRegService;

@RestController
@CrossOrigin("*")
public class CitizenAppRestController {

	@Autowired
	private ICitizenAppRegService citizenAppService;
	
	@Autowired
	private ArModuleYmlProperties arModuleYmlProperties;
	
	@PostMapping("/citizenApp/save")
	public ResponseEntity<String> registerCitizen(@RequestBody CitizenAppDTO citizenAppDTO) {
		String response = citizenAppService.registerCitizenApp(citizenAppDTO);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/welcome")
	public ResponseEntity<String> welcome() {
		Map<String,String> messages = arModuleYmlProperties.getMessages();
		String msg = messages.get("welcome");
//		String msg = arModuleYmlProperties.getMessages().get("welcome");
		String response = citizenAppService.welcome(msg);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	

}
