package communityWardrobe.tiacloud.service.impl;

import communityWardrobe.Controller.model.NGORegistrationDTO;
import communityWardrobe.tiacloud.model.entity.NGOEntity;
import communityWardrobe.tiacloud.model.entity.UserEntity;
import communityWardrobe.tiacloud.repository.NGORepository;
import communityWardrobe.tiacloud.repository.UserRepository;
import communityWardrobe.tiacloud.service.NGORegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class NGORegistrationServiceImpl implements NGORegistrationService{

	@Autowired
	private NGORepository ngoRepository;
	@Autowired
  private UserRepository userRepository;



  @Override
  public NGORegistrationDTO getNGORegistration(String userName) {
    NGORegistrationDTO ngoRegistrationDTO = new NGORegistrationDTO();
    NGOEntity ngoEntity = ngoRepository.findByname(userName);
    if(ngoEntity != null){
      ngoRegistrationDTO.setCert80GNo(ngoEntity.getCert80GNo());
      ngoRegistrationDTO.setCert80G(ngoEntity.isCert80G());
      ngoRegistrationDTO.setName(ngoEntity.getName());
      ngoRegistrationDTO.setEmail(ngoEntity.getEmail());
      ngoRegistrationDTO.setAddress(ngoEntity.getAddress());
      ngoRegistrationDTO.setPhone(ngoEntity.getPhone());
      ngoRegistrationDTO.setDocUploaded(ngoEntity.isDocUploaded());
      ngoRegistrationDTO.setPptUploaded(ngoEntity.isPptUploaded());
      ngoRegistrationDTO.setNoYearsOfReg(ngoEntity.getNoOfYearOFReg());

      return ngoRegistrationDTO;

    }
    return null;
  }

  @Override
	public void registerNGO(NGORegistrationDTO ngoRegistrationDTO) {

    //Save in NGO Table
		NGOEntity ngoEntity = new NGOEntity();
    UserEntity userEntity = new UserEntity();
		ngoEntity.setCert80GNo(ngoRegistrationDTO.getCert80GNo());
		ngoEntity.setCert80G(ngoRegistrationDTO.getCert80G());
		ngoEntity.setName(ngoRegistrationDTO.getName());
		ngoEntity.setEmail(ngoRegistrationDTO.getEmail());
		ngoEntity.setAddress(ngoRegistrationDTO.getAddress());
		ngoEntity.setPhone(ngoRegistrationDTO.getPhone());
		ngoEntity.setDocUploaded(ngoRegistrationDTO.getDocUploaded());
		ngoEntity.setPptUploaded(ngoRegistrationDTO.getPptUploaded());
		ngoEntity.setNoOfYearOFReg(ngoRegistrationDTO.getNoYearsOfReg());

		ngoRepository.save(ngoEntity);

		//Save in User Table
		userEntity.setUserName(ngoRegistrationDTO.getName());
		userEntity.setFullName(ngoRegistrationDTO.getName());
		userEntity.setPassword("welcome");
		userEntity.setEmail(ngoRegistrationDTO.getEmail());
		userEntity.setUserType("NGO");
    userRepository.save(userEntity);
	}
}