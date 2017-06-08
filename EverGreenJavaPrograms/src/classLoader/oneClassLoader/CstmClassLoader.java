package classLoader.oneClassLoader;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class CstmClassLoader extends ClassLoader {
	/**
     * This constructor is used to set the parent ClassLoader
     */
    public CstmClassLoader(ClassLoader loader) {
		super(loader);
	}
    
	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		System.out.println("Loading class: "+name);
		if (name.startsWith("classLoader.")) {
            System.out.println("Loading Class using CstmClassLoader");
            return getClass(name);
        }
		return super.loadClass(name);
	}

    private Class getClass(String name) throws ClassNotFoundException {
        String file = name.replace('.', File.separatorChar) + ".class";
        byte[] classFileByteStream = null;
        try {
            // This loads the byte code data from the file
            classFileByteStream = loadClassFileData(file);
            // defineClass is inherited from the ClassLoader class that converts byte array into a Class.
            // DefineClass is Final so we cannot override it
            Class c = defineClass(name, classFileByteStream, 0, classFileByteStream.length);
            return c;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Reads the file (.class) into a byte array. The file should be accessible
     * as a resource and make sure that its not in Classpath to avoid any confusion.
     */
    private byte[] loadClassFileData(String name) throws IOException {
        InputStream stream = getClass().getClassLoader().getResourceAsStream(name);
        int size = stream.available();
        byte buff[] = new byte[size];
        DataInputStream in = new DataInputStream(stream);
        in.readFully(buff);
        in.close();
        return buff;
    }

}
