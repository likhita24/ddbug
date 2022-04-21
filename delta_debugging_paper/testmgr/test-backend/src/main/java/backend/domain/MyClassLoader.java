package backend.domain;

import java.io.*;

public class MyClassLoader extends ClassLoader{
    private String rootUrl;

    public MyClassLoader(String rootUrl) {
        super();
        this.rootUrl = rootUrl;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class LCSCCLZ = null;
        
        byte[] classData = getClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        }
        LCSCCLZ = defineClass(name, classData, 0, classData.length);
        //}
        return LCSCCLZ;
    }

    private byte[] getClassData(String name) {
        InputStream is = null;
        try {
            String path = classNameToPath(name);
            File f = new File(path);
            byte[] buff = new byte[1024*4];
            int len = -1;
            is = new FileInputStream(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while((len = is.read(buff)) != -1) {
                baos.write(buff,0,len);
            }
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }


    private String classNameToPath(String name) {
        System.out.println(rootUrl + "/" + name.replace(".", "/") + ".class");
        return rootUrl + "/" + name.replace(".", "/") + ".class";
    }
}
