public class Game {

    private Room currentRoom;

    
    public void play(){
        createRooms();
        readComms();
    }
    
    public void createRooms(){  
        currentRoom = /**Metodo para obtener el main room */ ;
    }

    private void readComms(){
        
    }

    private void printWelcome(){
        
        System.out.println();
        System.out.println("Bienvenido al mundo de Zuul");
        System.out.println("Mundo de Zuul es un nuevo, juego de aventura muy aburrido.");
        System.out.println("Escribe 'help' si necesitas ayuda.");
        System.out.println();
        System.out.println("Tu estas " + currentRoom);
        System.out.print("Salir: ");
        if(currentRoom.northExit != null) {
            System.out.print("Norte ");
        }
        if(currentRoom.eastExit != null) {
            System.out.print("Este ");
        }
        if(currentRoom.southExit != null) {
            System.out.print("South ");
        }
        if(currentRoom.westExit != null) {
            System.out.print("Oeste ");
        }
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