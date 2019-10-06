package ShellUtil;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ShellUtilTest {

    @Test
    public void runCommand() {
        ShellUtil.CommandResult commandResult = ShellUtil.runCommand(new ArrayList<>(Arrays.asList("ls", "-l")));
        System.out.println(commandResult.resultCode);
        System.out.println(commandResult.resultString);
        assertEquals(commandResult.resultCode, 0);
    }
}