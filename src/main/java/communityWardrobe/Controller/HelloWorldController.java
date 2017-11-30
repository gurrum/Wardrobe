package communityWardrobe.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/communityWardrobe/")
public class HelloWorldController {
	
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String helloWorld() {
		return "Hello from Community Wardrobe";
	}

}
