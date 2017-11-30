package communityWardrobe.Controller;

import communityWardrobe.Controller.model.LoggedInUserDTO;
import communityWardrobe.Controller.model.NGORegistrationDTO;
import communityWardrobe.Controller.model.UserLoginDTO;
import communityWardrobe.tiacloud.service.NGORegistrationService;
import communityWardrobe.tiacloud.service.UserService;
import communityWardrobe.tiacloud.service.impl.UserServiceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class UserController {
  private UserService userService = new UserServiceImpl();

  @RequestMapping(value = "/userInfo", method = RequestMethod.POST)
  public ResponseEntity<LoggedInUserDTO> loginUser(@RequestBody UserLoginDTO userLoginDTO){

    LoggedInUserDTO response = userService.loginUser(userLoginDTO);
    HttpHeaders headers = new HttpHeaders();
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
