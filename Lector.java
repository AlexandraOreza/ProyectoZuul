import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;


public class Lector {
    private File archivo = null;

    private String leeArchivo(String path){
        StringBuilder contenido = new StringBuilder();
        try{
            this.archivo = new File(path);
            Scanner scanArchivo = new Scanner(archivo);
            while(scanArchivo.hasNextLine()){
                String linea = scanArchivo.nextLine();
                contenido.append(linea+"\n");
            }
            scanArchivo.close();
            
        }catch(NullPointerException  | FileNotFoundException e){
            System.err.println("Ha ocurrido un error con el archivo indicado.");
        }
        return contenido.toString();
    }

    public Collection<Room> obtenerCuartos(){
        String contenido = leeArchivo("files/room.txt");
        Collection<Room> Cuartos = new ArrayList<>();
        Scanner scanContenido = new Scanner(contenido);
        while(scanContenido.hasNextLine()){
            String linea = scanContenido.nextLine();
            List<String> datos = Arrays.asList(linea.split(","));
            String nombre = datos.get(0).trim(); 
            String descripcion = datos.get(1);
            Room cuarto = new Room(nombre, descripcion);
            Cuartos.add(cuarto);
        }
        agregarSalidas(Cuartos);
        scanContenido.close();
        return Cuartos;
    }

    private void agregarSalidas(Collection<Room> Cuartos){
        String infoCuartos = leeArchivo("files/exits.txt");
        Scanner scanInfo = new Scanner(infoCuartos);
        ArrayList<String> salidasArray = new ArrayList<>();
        while(scanInfo.hasNextLine())
        {
            String salidas = scanInfo.nextLine();
            salidasArray.add(salidas);
        }
        int i = 0;
        try{
        for (Room cuartoAsignar : Cuartos) {
            String lineaDatos = salidasArray.get(i);
            Scanner scanLinea = new Scanner(lineaDatos);
            scanLinea.useDelimiter(",");
            scanLinea.next(); //Salta la primera linea que indica el nombre del cuarto.
            generaDirecciones(scanLinea, Cuartos, cuartoAsignar);
            i++;
        }
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Los datos sobre salidas se han acabado.");
        }
        scanInfo.close();
    }

    private void generaDirecciones(Scanner scanDatos, Collection<Room> Cuartos, Room cuartoAsignar){
        Room oeste, este, norte, sur = null;
        oeste=este=norte=sur;
        String cuartoOeste =  scanDatos.next();
        String cuartoEste =  scanDatos.next();
        String cuartoNorte =  scanDatos.next();
        String cuartoSur =  scanDatos.next();
        for (Room cuarto : Cuartos) {
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
    
}


