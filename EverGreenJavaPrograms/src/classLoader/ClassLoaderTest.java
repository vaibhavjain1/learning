package classLoader;

import java.lang.reflect.Method;

public class ClassLoaderTest {

	public static void main(String[] args) throws Exception {
		String classToBeLoadedA = "classLoader.ClassToBeLoadedA";
		String classToBeLoadedB = "classLoader.ClassToBeLoadedB";
		
		CustomClassLoader classLoaderObj = new CustomClassLoader(ClassLoaderTest.class.getClassLoader());
		Class clas = classLoaderObj.loadClass(classToBeLoadedA);
		Class mainArgType[] = { (new String[0]).getClass() };
		Method main = clas.getMethod("main", mainArgType);
		String[] params = null;
		main.invoke(null, (Object)params);
		Method printCL = clas.getMethod("printClassLoaderName", null);
        printCL.invoke(clas.newInstance(), null);
	}
}
