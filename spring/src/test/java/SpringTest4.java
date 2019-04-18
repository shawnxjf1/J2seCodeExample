import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.enjoy02.service.UserService;

public class SpringTest4 {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("spring4.xml");
		UserService userService = (UserService) app.getBean("userService");
		userService.add03();
	}

}
