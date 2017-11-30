package communityWardrobe.tiacloud.service.impl;

import communityWardrobe.Controller.model.LoggedInUserDTO;
import communityWardrobe.Controller.model.UserLoginDTO;
import communityWardrobe.tiacloud.model.entity.UserEntity;
import communityWardrobe.tiacloud.repository.UserRepository;
import communityWardrobe.tiacloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class UserServiceImpl implements UserService{

  @Autowired
  private UserRepository userRepository;

  public UserServiceImpl() {
    //generateUserData();
  }

  @Override
  public LoggedInUserDTO loginUser(UserLoginDTO userLoginDTO) {
    //generateUserData();
    UserEntity userEntity = userRepository.findByuserName(userLoginDTO.getUserName());
    if(userEntity!=null){
      if(userEntity.getPassword().equalsIgnoreCase(userLoginDTO.getPassword())){
        LoggedInUserDTO loggedInUserDTO = new LoggedInUserDTO();
        loggedInUserDTO.setUserName(userEntity.getUserName());
        loggedInUserDTO.setFullName(userEntity.getFullName());
        loggedInUserDTO.setEmail(userEntity.getEmail());
        loggedInUserDTO.setUserType(userEntity.getUserType());

        return loggedInUserDTO;
      }
    }
    return null;
  }

  void generateUserData(){
    userRepository.save(new UserEntity("admin", "adminuser", "admin@akamai.com", "ADMIN", "welcome"));
    userRepository.save(new UserEntity("ashish", "ashishkumar", "ashish@akamai.com", "AKA_VOLUNTEER", "welcome"));
    userRepository.save(new UserEntity("aasha", "aashav", "aasha@akamai.com", "AKA_VOLUNTEER", "welcome"));
    userRepository.save(new UserEntity("bisu", "biswajeetjena", "bisu@akamai.com", "AKA_VOLUNTEER", "welcome"));
    userRepository.save(new UserEntity("gurum", "gurumnagaraj", "gurum@akamai.com", "AKA_VOLUNTEER", "welcome"));
  }


}
