package communityWardrobe.tiacloud.service;

import communityWardrobe.Controller.model.LoggedInUserDTO;
import communityWardrobe.Controller.model.NGORegistrationDTO;
import communityWardrobe.Controller.model.UserLoginDTO;

public interface UserService {

	LoggedInUserDTO loginUser(UserLoginDTO userLoginDTO);

}
