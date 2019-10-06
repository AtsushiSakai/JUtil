package ShellUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ShellUtil {

    public static class CommandResult{
        public String resultString;
        public int resultCode;

        public CommandResult(String aResultString, int aResultCode){
            resultString = aResultString;
            resultCode = aResultCode;
        }

    }

    public static CommandResult runCommand(List<String> command){

        try {
            Process process = new ProcessBuilder(command).start();
            InputStreamReader isr = new InputStreamReader(process.getInputStream(), "UTF-8");
            BufferedReader reader = new BufferedReader(isr);
            StringBuilder builder = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                builder.append((char)c);
            }
            return new CommandResult(builder.toString(), process.waitFor());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

}
