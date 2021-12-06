
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
        return name + " Description: "+description+"\nDirecciones: "+westExit+","+eastExit+","+northExit+","+southExit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
