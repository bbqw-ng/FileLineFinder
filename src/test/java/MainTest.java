import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.Main;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MainTest {

    private String command;
    private ArrayList<String> parts;

    @BeforeEach
    public void setUp() {
        parts = new ArrayList<>();
    }

    @Test
    public void reformatOnlyFind() {
        command = "find";
        parts = Main.reformatCommand(command);
        assertNull(parts);
    }

    @Test
    public void reformatFindWithPattern() {
        command = "find john";
        parts = Main.reformatCommand(command);
        assertNull(parts);
    }

    @Test
    public void reformatFindWithFile() {
        command = "find file";
        parts = Main.reformatCommand(command);
        assertNull(parts);
    }

    @Test
    public void reformatPatternWithFile() {
        command = "\"john\" myfile";
        parts = Main.reformatCommand(command);
        assertNull(parts);
    }

    @Test
    public void reformatWithMixedCommandOrder() {
        command = "myfile find pattern";
        parts = Main.reformatCommand(command);
        assertNull(parts);
    }

    @Test
    public void reformatWithTabLiteralQuotes() {
        command = "find \"john\\t\" myfile";
        parts = Main.reformatCommand(command);
        assertEquals(3, parts.size());
        assertEquals("find", parts.get(0));
        assertEquals("john\\t", parts.get(1));
        assertEquals("myfile", parts.get(2));
    }

    @Test
    public void reformatWithTabLiteralNoQuotes() {
        command = "find john\t myfile";
        parts = Main.reformatCommand(command);
        assertEquals(3, parts.size());
        assertEquals("find", parts.get(0));
        assertEquals("john\t", parts.get(1));
        assertEquals("myfile", parts.get(2));
    }

    @Test
    public void reformatWithNewlineLiteralQuotes() {
        command = "find \"john\\n\" myfile";
        parts = Main.reformatCommand(command);
        assertEquals(3, parts.size());
        assertEquals("find", parts.get(0));
        assertEquals("john\\n", parts.get(1));
        assertEquals("myfile", parts.get(2));
    }

    @Test
    public void reformatWithNewlineLiteralNoQuotes() {
        command = "find john\n myfile";
        parts = Main.reformatCommand(command);
        assertEquals(3,parts.size());
        assertEquals("find", parts.get(0));
        assertEquals("john\n", parts.get(1));
        assertEquals("myfile", parts.get(2));
    }

    @Test
    public void reformatWithEndOfSentenceAndNewline() {
        command = "find john.\\n myfile";
        parts = Main.reformatCommand(command);
        assertEquals(3, parts.size());
        assertEquals("find", parts.get(0));
        assertEquals("john.\\n", parts.get(1));
        assertEquals("myfile", parts.get(2));
    }

    @Test
    public void reformatWithWildCardWithQuotes() {
        command = "find \"john*\" myfile";
        parts = Main.reformatCommand(command);
        assertEquals(3, parts.size());
        assertEquals("find", parts.get(0));
        assertEquals("john*", parts.get(1));
        assertEquals("myfile", parts.get(2));
    }

    @Test
    public void reformatWithWithWildCardNoQuotes() {
        command = "find john* myfile";
        parts = Main.reformatCommand(command);
        assertEquals(3, parts.size());
        assertEquals("find", parts.get(0));
        assertEquals("john*", parts.get(1));
        assertEquals("myfile", parts.get(2));
    }

    @Test
    public void reformatNormalCommand() {
        command = "find \"john\" myfile";
        parts = Main.reformatCommand(command);
        assertEquals(3, parts.size());
        assertEquals("find", parts.get(0));
        assertEquals("john", parts.get(1));
        assertEquals("myfile", parts.get(2));
    }

    @Test
    public void reformatNumericPattern() {
        command = "find 123123 myfile";
        parts = Main.reformatCommand(command);
        assertEquals(3, parts.size());
        assertEquals("find", parts.get(0));
        assertEquals("123123", parts.get(1));
        assertEquals("myfile", parts.get(2));
    }

    @Test
    public void reformatMixedPattern() {
        command = "find john123!@# myfile";
        parts = Main.reformatCommand(command);
        assertEquals(3, parts.size());
        assertEquals("find", parts.get(0));
        assertEquals("john123!@#", parts.get(1));
        assertEquals("myfile", parts.get(2));
    }

    @Test
    public void reformatQuotesPattern() {
        command = "find \"\"\"\"\"\"\"\" myfile";
        parts = Main.reformatCommand(command);
        assertEquals(3, parts.size());
        assertEquals("find", parts.get(0));
        assertEquals("\"\"\"\"", parts.get(1));
        assertEquals("myfile", parts.get(2));
    }

    @Test
    public void reformatSpaceWithNoQuotes() {
        command = "find john smith myfile";
        parts = Main.reformatCommand(command);
        assertNull(parts);
    }

    @Test
    public void reformatSpaceWithQuotes() {
        command = "find \"john smith\" myfile";
        parts = Main.reformatCommand(command);
        assertEquals(3, parts.size());
        assertEquals("find", parts.get(0));
        assertEquals("john smith", parts.get(1));
        assertEquals("myfile", parts.get(2));
    }

    @Test
    public void reformatWithQuoteLayoutWeird() {
        command = "find j\"ohn\" myfile";
        parts = Main.reformatCommand(command);
        assertEquals(3, parts.size());
        assertEquals("find", parts.get(0));
        assertEquals("john", parts.get(1));
        assertEquals("myfile", parts.get(2));
    }

    @Test
    public void reformatCaseSensitivityPattern() {
        command = "find joHn myfile";
        parts = Main.reformatCommand(command);
        assertEquals(3, parts.size());
        assertEquals("find", parts.get(0));
        assertEquals("joHn", parts.get(1));
        assertEquals("myfile", parts.get(2));
    }

    @Test
    public void reformatCaseSensitivityFind() {
        command = "FinD joHn myfile";
        parts = Main.reformatCommand(command);
        assertNull(parts);
    }
}
