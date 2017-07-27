package beanContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("contextBeans.xml");
		MainMessage obj = (MainMessage) context.getBean("beanId");
		obj.getMessage();
		((ClassPathXmlApplicationContext) context).close();
	}

}
