import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.Finder;
import src.Main;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class FinderTest {

    private ArrayList<String> commandParts;
    private Finder finder;
    private ArrayList<String> lines;

    @BeforeEach
    public void setUp() {
        finder = new Finder();
    }

    @Test
    public void findWorksAsIntended() {
        commandParts = Main.reformatCommand("find rock doodoo");
        assertNotNull(commandParts);
        lines = finder.find(commandParts.get(1), commandParts.get(2));
        assertEquals(2, lines.size());
        assertEquals(lines.get(0), "rock paper scissor20");
        assertEquals(lines.get(1), "rock solid");
    }

    @Test
    public void findWorksWithoutDuplicate() {
        commandParts = Main.reformatCommand("find meow doodoo");
        assertNotNull(commandParts);
        lines = finder.find(commandParts.get(1), commandParts.get(2));
        assertEquals(1, lines.size());
        assertEquals(lines.get(0), "meow meow kitty");
    }

    @Test
    public void findReturnsNothingIfNotFound() {
        commandParts = Main.reformatCommand("find WASDASDSD doodoo");
        assertNotNull(commandParts);
        lines = finder.find(commandParts.get(1), commandParts.get(2));
        assertTrue(lines.isEmpty());
    }

}
