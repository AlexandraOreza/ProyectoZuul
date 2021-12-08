import java.util.NoSuchElementException;

import javax.xml.stream.events.EntityReference;

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
        }
    }

    private void leerComandos(){
        Parser entradaUsuario = new Parser();
        boolean salir = false;
        while(salir != true){
        Command entrada = entradaUsuario.obtenerComando();
        if(entrada.contieneComando()){
            String comandoString = entrada.getComando();
            salir = determinaComando(comandoString);
        }else{
            System.out.println("¿Quisiste decir... ir, salir o ayuda?\n");
            }
        }
    }

    private void muestraBienvenida(){ 
        System.out.println();
        System.out.println("Bienvenido al mundo de Zuul");
        System.out.println("Mundo de Zuul es un nuevo, juego de aventura muy aburrido.");
        System.out.println("Escribe 'ayuda' si necesitas ayuda.");
        System.out.println();
        System.out.println("Tu estas " + currentRoom);
        System.out.print("Salir: ");
        currentRoom.mostrarDirecciones();
        System.out.println();
    }
    private void mostrarAyuda(){
        System.out.println("\nIngresa un comando ir <<salida>> o salir para continuar o terminar con la aventura\n");
    }
    private void muestraDespedida(){
        System.out.println("\nGracias por jugar a Zuul.\n¡Nos vemos!");
    }
    private boolean determinaComando(String entrada){
        boolean salir = false;
        switch(entrada){
            case "ir":
                break;
            case "ayuda":
                mostrarAyuda();
                break;
            case "salir":
                muestraDespedida();
                salir = true;
                break;
        }
        return salir;
    }
    private void irSiguienteCuarto(String direccionSalida){
        Room este = currentRoom.getEastExit();
        Room oeste= currentRoom.getWestExit();
        Room norte= currentRoom.getNorthExit();
        Room sur= currentRoom.getSouthExit();
        switch(direccionSalida){
            case "este":
                currentRoom = este;
                break;
            case "oeste":
                currentRoom = oeste;
                break;
            case "norte":
                currentRoom = norte;
                break;
            case "sur":
                currentRoom = sur;
                break;
        }
    }
    public static void main(String[] args)throws Exception {
        Game game = new Game();
        try{   
        game.play();
        } catch(Exception e){
            System.err.println("No se pudo ejecutar juego Zuul");
        }
        
    }
}