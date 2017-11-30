package communityWardrobe.tiacloud.service;

import communityWardrobe.Controller.model.NGORegistrationDTO;

public interface NGORegistrationService {

	NGORegistrationDTO getNGORegistration(String userName);

	void registerNGO(NGORegistrationDTO ngoRegistrationDTO);

}
