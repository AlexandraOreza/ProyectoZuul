import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class GameTest {
    @Test
    void testIrSiguienteCuarto() {
        Game newGame = new Game();
        Room eastRoom = new Room("Cocina","una cocina comun");
        Room currentRoom = new Room("Sala de espera","Hub del hotel 'Magic Rooms'");
        currentRoom.setExits(null, eastRoom, null, null);
        eastRoom.setExits(currentRoom, null, null, null);
        newGame.setCurrentRoom(currentRoom);
        newGame.irSiguienteCuarto("este");
        String nombreEsperado = eastRoom.getName();
        AssertJUnit.assertEquals(nombreEsperado, newGame.getCurrentRoom().getName());
    }
}
