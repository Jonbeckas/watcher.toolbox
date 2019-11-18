package toolbox.os;

import toolbox.process.OSnotDetectedException;

public class OSTools {
    public static final int OS_WINDOWS = 0;
    public static final int  OS_LINUX = 1;
    public static final int OS_MAC = 2;

    public static int getOS() throws OSnotDetectedException {
        String OS = System.getProperty("os.name").toLowerCase();
        if (OS.contains("win")) {
            return OS_WINDOWS;

        } else if (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 ) {
            return OS_LINUX;
        } else if (OS.contains("mac")) {
            return OS_MAC;
        } else {
            throw new OSnotDetectedException();
        }
    }
}
