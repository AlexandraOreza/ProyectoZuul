import org.testng.annotations.Test;

import java.io.File;

import org.testng.AssertJUnit;
public class LectorTest {
 
    @Test
    void testLeeArchivo() {
        Lector lectorArchivo = new Lector();
        String esperado = "Prueba de archivo.";
        String rutaAbsoluta = "files\\test.txt"; //cambiar por ruta absoluta del archivo para usar el test x/xx/files/test.txt.
        String contenido = lectorArchivo.leeArchivo(rutaAbsoluta);
        System.out.println("El contenido es: "+contenido);
        AssertJUnit.assertEquals(esperado, contenido);
    }
}
