package classLoader.oneClassLoader;

import java.lang.reflect.Method;

public class ClassLoaderTest {

	public static void main(String[] args) throws Exception {
		String classToBeLoaded = "classLoader.oneClassLoader.ClassToBeLoaded";
		CstmClassLoader classLoaderObj = new CstmClassLoader(ClassLoaderTest.class.getClassLoader());
		Class clas = classLoaderObj.loadClass(classToBeLoaded);
		Method printCL = clas.getMethod("printClassLoaderName", null);
        printCL.invoke(clas.newInstance(), null);
	}
}
