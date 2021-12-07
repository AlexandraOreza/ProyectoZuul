import java.util.NoSuchElementException;

public class Game {

    private Room currentRoom;
    private Lector lector;

    public void play(){
        lector = new Lector();
        createRooms();
        muestraBienvenida();
        leerComandos();
    }
    
    public void createRooms(){ 
        try{
        currentRoom = lector.obtenerCuartos().iterator().next();
        }catch(NoSuchElementException e){
            currentRoom = null;
            System.out.println("AAA");
        }
    }

    private void leerComandos(){
        Parser entradaUsuario = new Parser();

        while(true){
            entradaUsuario.obtenerComando();
        }
    }

    private void muestraBienvenida(){ 
        System.out.println();
        System.out.println("Bienvenido al mundo de Zuul");
        System.out.println("Mundo de Zuul es un nuevo, juego de aventura muy aburrido.");
        System.out.println("Escribe 'help' si necesitas ayuda.");
        System.out.println();
        System.out.println("Tu estas " + currentRoom);
        System.out.print("Salir: ");
        currentRoom.mostrarDirecciones();
        System.out.println();
    }

    public static void main(String[] args)throws Exception {
        
        Game game = new Game();
        game.play();
        
        try{   

        } catch(Exception e){
            System.err.println("No se pudo ejecutar");
        }
        
    }
}