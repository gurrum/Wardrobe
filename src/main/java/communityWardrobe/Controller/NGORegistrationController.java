package communityWardrobe.Controller;

import communityWardrobe.Controller.model.NGORegistrationDTO;
import communityWardrobe.tiacloud.service.NGORegistrationService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class NGORegistrationController {
  private NGORegistrationService ngoRegistrationService;

  @RequestMapping(value = "/ngodetail/{userName}", method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity<NGORegistrationDTO> getNGO(@PathVariable String userName){
    NGORegistrationDTO response = ngoRegistrationService.getNGORegistration(userName);
    HttpHeaders headers = new HttpHeaders();
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @RequestMapping(value = "/ngodetail", method = RequestMethod.POST)
  public ResponseEntity registerNGO(@RequestBody NGORegistrationDTO ngoRegistration){

    ngoRegistrationService.registerNGO(ngoRegistration);
    HttpHeaders headers = new HttpHeaders();
    return new ResponseEntity<>(headers, HttpStatus.ACCEPTED);
  }
}
