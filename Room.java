
public class Room {
    private String name;
    private String description;
    private Room westExit;
    private Room eastExit;
    private Room northExit;
    private Room southExit;

    public Room(String Name, String desc){
        name = Name;
        description = desc;
    }

    public void setExits(Room westE, Room eastE, Room northE, Room southE){
        if(westE != null){
            this.westExit = westE;
        }
        if(eastE != null){
            this.eastExit = eastE;
        }
        if(northE != null){
            this.northExit = northE;
        }
        if(southE != null){
            this.southExit = southE;
        }
    }

    @Override
    public String toString() {
        return name + " Description: "+description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void mostrarDirecciones(){
        StringBuilder cadena= new StringBuilder();
        cadena = westExit != null ? cadena.append("Oeste: "+westExit+", ") : cadena.append("Oeste: , ");
        cadena = eastExit != null ? cadena.append("Este: "+eastExit+", ") : cadena.append("Este: , ");
        cadena = northExit != null ? cadena.append("Norte: "+northExit+", ") : cadena.append("Norte: ,");
        cadena = southExit != null ? cadena.append("Sur: "+southExit) : cadena.append("Sur: ");
        System.out.println(cadena);
        
    }
    
}
