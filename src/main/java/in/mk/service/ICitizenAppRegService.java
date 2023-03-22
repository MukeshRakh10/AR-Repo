package in.mk.service;

import in.mk.DTO.CitizenAppDTO;

public interface ICitizenAppRegService {
	public String registerCitizenApp(CitizenAppDTO citizenAppDTO);

	public String welcome(String msg);
	

}
