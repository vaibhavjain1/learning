package autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoAutowire {

	@Autowired
	public Employee obj;
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("contextBeans.xml");
		DemoAutowire obj = (DemoAutowire) context.getBean("beandemo");
		obj.temp();
		/*DemoAutowire ob = new DemoAutowire();
		ob.temp();*/
		((ClassPathXmlApplicationContext) context).close();
	}
	
	public void temp(){
		System.out.println(obj.empId);
	}
}
