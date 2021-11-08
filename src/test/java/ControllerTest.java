import Check_Program.Controller_Check;
import javafx.scene.text.TextFlow;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class ControllerTest {
    @Test
    public void runCode() {
        File fileInput = new File("testFiles/TestCode.myJava");
        assertEquals(new Multiplier().getCheck(), new Controller_Check().checktest(fileInput));
    }
}