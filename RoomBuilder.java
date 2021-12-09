import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class RoomBuilder {
    private Collection<Room> listaCuartos;
    private Lector lector;
    public RoomBuilder(Lector lectorArchivo){
        listaCuartos = new ArrayList<>();
        lector = lectorArchivo;
    }

    private Collection<Room> obtenerCuartos(){
        String contenido = lector.leeArchivo("files/room.txt");
        Scanner scanContenido = new Scanner(contenido);
        while(scanContenido.hasNextLine()){
            String linea = scanContenido.nextLine();
            List<String> datos = Arrays.asList(linea.split(","));
            String nombre = datos.get(0).trim(); 
            String descripcion = datos.get(1);
            Room cuarto = new Room(nombre, descripcion);
            listaCuartos.add(cuarto);
        }
        agregarSalidas();
        scanContenido.close();
        return listaCuartos;
    }

    private void agregarSalidas(){
        String infoCuartos = lector.leeArchivo("files/exits.txt");
        Scanner scanInfo = new Scanner(infoCuartos);
        ArrayList<String> salidasArray = new ArrayList<>();
        while(scanInfo.hasNextLine())
        {
            String salidas = scanInfo.nextLine();
            salidasArray.add(salidas);
        }
        int i = 0;
        try{
        for (Room cuartoAsignar : listaCuartos) {
            String lineaDatos = salidasArray.get(i);
            Scanner scanLinea = new Scanner(lineaDatos);
            scanLinea.useDelimiter(",");
            scanLinea.next(); //Salta la primera linea que indica el nombre del cuarto.
            generaDirecciones(scanLinea, cuartoAsignar);
            i++;
        }
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Los datos sobre salidas se han acabado.");
        }
        scanInfo.close();
    }

    private void generaDirecciones(Scanner scanDatos, Room cuartoAsignar){
        Room oeste, este, norte, sur = null;
        oeste=este=norte=sur;
        String cuartoOeste =  scanDatos.next();
        String cuartoEste =  scanDatos.next();
        String cuartoNorte =  scanDatos.next();
        String cuartoSur =  scanDatos.next();
        for (Room cuarto : listaCuartos) {
            String nombreCuarto = cuarto.getName();
            if(cuartoOeste.equals(nombreCuarto)){
                oeste = cuarto;
            }
            if(cuartoEste.equals(nombreCuarto)){
                este = cuarto;
            }
            if(cuartoNorte.equals(nombreCuarto)){
                norte = cuarto;
            }
            if(cuartoSur.equals(nombreCuarto)){
                sur = cuarto;
            }
        }
        cuartoAsignar.setExits(oeste, este, norte, sur);
    }

    public Room obtenerPrimerCuarto(){
        return this.obtenerCuartos().iterator().next();
    }
}
