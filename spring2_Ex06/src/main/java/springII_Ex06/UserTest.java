package springII_Ex06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class UserTest {
	
	public static void main(String[] args){
		ApplicationContext context = new FileSystemXmlApplicationContext("/src/main/resources/shoes.xml");
		
		User user = (User)context.getBean("user");
		
		System.out.println(user.getShoesBrand());
	}

}
