import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Lector {
    private File archivo = null;

    public void leeArchivo(String path){
        try{
            this.archivo = new File(path);
            Scanner scanArchivo = new Scanner(archivo);
            while(scanArchivo.hasNextLine()){
                String linea = scanArchivo.nextLine();
                String[] datos;
                datos=linea.split(",");
                System.out.println(datos[0]);
            }
            scanArchivo.close();
        }catch(NullPointerException  | FileNotFoundException e){
            System.err.println("Ha ocurrido un error con el archivo indicado.");
        }
    }
}
