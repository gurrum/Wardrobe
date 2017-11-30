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

  @Override
  public LoggedInUserDTO loginUser(UserLoginDTO userLoginDTO) {
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
}
