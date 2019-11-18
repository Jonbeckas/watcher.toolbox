package net.tetraowl.watcher.toolbox;

public class JavaTools {
    public static int javaMajorRelease() {
        String[] javaVersionElements = System.getProperty("java.runtime.version").split("\\.|_|-b");
        int major = Integer.parseInt(javaVersionElements[0]);
        if (major>1) {
            return major;
        } else {
            return  Integer.parseInt(javaVersionElements[1]);
        }
    }
}
