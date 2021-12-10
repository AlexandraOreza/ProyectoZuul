import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Lector {
    private File archivo = null;

    public String leeArchivo(String path) {
        StringBuilder contenido = new StringBuilder();
        try {
            this.archivo = new File(path);
            Scanner scanArchivo = new Scanner(archivo);
            while (scanArchivo.hasNextLine()) {
                String linea = scanArchivo.nextLine();
                contenido.append(linea + "\n");
            }
            scanArchivo.close();
        } catch (NullPointerException | FileNotFoundException e) {
            System.err.println("Ha ocurrido un error con el archivo indicado.");
        }
        return contenido.toString();
    }
}


