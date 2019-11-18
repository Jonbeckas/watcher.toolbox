package toolbox.process;

import toolbox.os.OSnotSupportedException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static toolbox.os.OSTools.*;

public class ProcessTools {
    private static ArrayList<String> getRunningProcesses() throws OSnotSupportedException {
        ArrayList<String> processes = new ArrayList<>();
        try {
            String process;
            Process p = null;
            if (getOS() == OS_LINUX) {
                p = Runtime.getRuntime().exec("ps -few");
            } else if(getOS() ==OS_WINDOWS) {
                p = Runtime.getRuntime().exec(System.getenv("windir") +"\\system32\\"+"tasklist.exe");
            } else if (getOS() == OS_MAC) {
                p = Runtime.getRuntime().exec("ps -e");
            } else {
                throw new OSnotSupportedException();
            }

            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((process = input.readLine()) != null) {
                processes.add(process);
            }
            input.close();
        } catch (Exception err) {
            err.printStackTrace();
        }
        return processes;
    }

    public static boolean isRunning(String prn) throws OSnotSupportedException {
        ArrayList<String> procs = null;
        try {
            procs = getRunningProcesses();
        } catch (OSnotSupportedException e) {
            throw new OSnotSupportedException();
        }
        for (String onep: procs) {
            if (onep.contains(prn)) {
                return true;
            }
        }
        return false;
    }
}
