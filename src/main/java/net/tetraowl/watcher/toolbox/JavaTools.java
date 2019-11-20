package net.tetraowl.watcher.toolbox;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

public class JavaTools {
    public static int javaMajorRelease() {
        String[] javaVersionElements = System.getProperty("java.runtime.version").split("\\.|_|-b");
        int major = Integer.parseInt(javaVersionElements[0]);
        if (major > 1) {
            return major;
        } else {
            return Integer.parseInt(javaVersionElements[1]);
        }
    }

    public static String getJarUrl(Class<?> context) {
        URL url = context.getProtectionDomain().getCodeSource().getLocation();
        try {
            String string = URLDecoder.decode(url.getPath(), "UTF-8");
            String tmp = string.replace("\\", "/");
            int slash = string.lastIndexOf("/");
            return string.substring(0, slash);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
