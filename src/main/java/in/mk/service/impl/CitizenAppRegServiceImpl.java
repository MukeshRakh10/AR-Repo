package in.mk.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import in.mk.DTO.CitizenAppDTO;
import in.mk.entity.CitizenApp;
import in.mk.repository.CitizenAppRepository;
import in.mk.service.ICitizenAppRegService;

@Service
public class CitizenAppRegServiceImpl implements ICitizenAppRegService {

	@Autowired
	private CitizenAppRepository citizenAppRepo;

	private static final String REST_URL = "";

	@Override
	public String registerCitizenApp(CitizenAppDTO citizenAppDTO) {

		Long ssn = citizenAppDTO.getSsn();
		WebClient webClient = WebClient.create();
/*
		String stateName = webClient.get().uri(REST_URL, ssn) // passs
				.retrieve() // (extract the response) Getting thre response given by webClient that response
							// catch by retrive()
				.bodyToMono(String.class) // store the response in string variables.
				.block(); // represent as synchronious. // synch call
		// .subscribe() ; //asynch call
*/
		CitizenApp app = new CitizenApp();
		BeanUtils.copyProperties(citizenAppDTO, app);
		
//		if ("Rhode Island".equals(stateName)) {
			// insert record into db
			citizenAppRepo.save(app);
//			return "Citizen App Created  App Id :{appId}";
			System.out.println("Record Successfully Saved. !!!");
//		}

		return "Citizen not belongs to RI";
	}

	@Override
	public String welcome(String msg) {
		return msg;
	}

}
