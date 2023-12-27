package classLoader.simpleClassLoader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

class CustomClassLoader extends ClassLoader {
    @Override
    public Class<?> findClass(String name) {
        byte[] bt = loadClassData(name);
        return defineClass(name, bt, 0, bt.length);
    }
    private byte[] loadClassData(String className) {
        //read class
        InputStream is = getClass().getClassLoader().getResourceAsStream(className.replace(".", "/")+".class");
        ByteArrayOutputStream byteSt = new ByteArrayOutputStream();
        //write into byte
        int len =0;
        try {
            while((len=is.read())!=-1){
                byteSt.write(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //convert into byte array
        return byteSt.toByteArray();
    }
}

public class CustomClassLoaderDemo {
    public static void main(String[] args) throws Exception {
        CustomClassLoader loader = new CustomClassLoader();
        Class<?> c = loader.findClass("classLoader.simpleClassLoader.Test");
        Object ob = c.newInstance();
        Method md = c.getMethod("show");
        md.invoke(ob);
    }
}