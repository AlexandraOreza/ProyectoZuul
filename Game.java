import java.util.NoSuchElementException;

public class Game {
    private Room currentRoom;
    private Lector lector;
    private RoomBuilder roomBuilder;
    public void play(){
        lector = new Lector();
        roomBuilder = new RoomBuilder(lector);
        createRooms();
        muestraBienvenida();
        leerComandos();
    }
    
    public void createRooms(){ 
        try{
        currentRoom = roomBuilder.obtenerPrimerCuarto();
        }catch(NoSuchElementException e){
            currentRoom = null;
        }
    }

    private void leerComandos(){
        Parser entradaUsuario = new Parser();
        boolean salir = false;
        while(salir != true){
        muestraDetallesCuarto();
        Command entrada = entradaUsuario.obtenerComando();
        if(entrada.contieneComando()){
            salir = determinaComando(entrada);
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
    }
    private void mostrarAyuda(){
        System.out.println("\nIngresa un comando ir <<salida>> o salir para continuar o terminar con la aventura\n");
    }
    private void muestraDespedida(){
        System.out.println("\nGracias por jugar a Zuul.\n¡Nos vemos!");
    }
    private void muestraDetallesCuarto(){
        System.out.println("\nEstás en: "+ currentRoom.getName());
        System.out.println("Salidas disponibles: ");
        currentRoom.mostrarDirecciones();
    }
    private boolean determinaComando(Command comando){
        boolean salir = false;
        switch(comando.getComando()){
            case "ir":
                String direccion = comando.getAdicionComando();
                if(direccion != null)
                    irSiguienteCuarto(direccion);
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
        Room salidaDireccion = null;
        switch(direccionSalida){
            case "este":
                salidaDireccion = este;
                break;
            case "oeste":
                salidaDireccion = oeste;
                break;
            case "norte":
                salidaDireccion = norte;
                break;
            case "sur":
                salidaDireccion = sur;
                break;
        }
        if(salidaDireccion != null){
            currentRoom = salidaDireccion;
        }else{
            System.out.println("¡No existe tal salida!");
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