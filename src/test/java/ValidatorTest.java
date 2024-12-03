import org.junit.jupiter.api.Test;
import src.Main;
import src.Validator;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {

    private String command;
    private boolean validated;
    private ArrayList<String> commandParts;

    //These tests will vary based on the length of the longest line in the file, if the file has a length of n, then your pattern must be a length of n or less
    @Test
    public void validateCommandWorks() {
        commandParts = Main.reformatCommand("find lol doodoo");
        assertNotNull(commandParts);
        validated = Validator.validateCommand(commandParts);
        assertTrue(validated);
    }

    @Test
    public void validateCommandDoesntWorkWhenPartsAreWrong() {
        commandParts = Main.reformatCommand("find lol rock");
        assertNotNull(commandParts);
        validated = Validator.validateCommand(commandParts);
        assertFalse(validated);
    }

    @Test
    public void validateFindWorks() {
        command = "find";
        validated = Validator.validateFind(command);
        assertTrue(validated);
    }

    @Test
    public void validateFindDoesntWork() {
        command = "smooooo";
        validated = Validator.validateFind(command);
        assertFalse(validated);
    }

    @Test
    public void validatePatternWorks() {
        commandParts = Main.reformatCommand("find lol doodoo");
        assertNotNull(commandParts);
        validated = Validator.validatePattern(commandParts.get(1), commandParts.get(2));
        assertTrue(validated);
    }

    @Test
    public void validatePatternDoesntWorkWhenPatternIsLongerThanMaxLineInFile() {
        commandParts = Main.reformatCommand("find adjkoiajdiojadjiajdioajdoijaiosdjaiodjoasjdioajdiojaoids doodoo");
        assertNotNull(commandParts);
        validated = Validator.validatePattern(commandParts.get(1), commandParts.get(2));
        assertFalse(validated);
    }

    @Test
    public void validateFileExistsWorksAsIntendedWithRealFile() {
        command = "doodoo";
        validated = Validator.validateFileExists(command);
        assertTrue(validated);
    }

    @Test
    public void validateFileExistsWorksAsIntendedWithNonExistingFile() {
        command = "non-existent-file";
        validated = Validator.validateFileExists(command);
        assertFalse(validated);
    }

    @Test
    public void validateGettingLengthOfMaxLineWorksAsIntended() {
        command = "doodoo";
        int maxLengthOfLine = Validator.determineMaxLengthOfLineInFile(command);
        assertEquals(20, maxLengthOfLine);
    }
}
