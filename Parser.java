import java.util.Scanner;

/**
  * El analizador comprueba los comandos que el usuario introduce y lo compara 
  * con los comando válidos que se permiten en el programa.
 */

public class Parser {
    private CommandWords comandos;
    private Scanner scanEntrada;
    
    public Parser() {
        comandos = new CommandWords();
        scanEntrada = new Scanner(System.in);
    }

    public Command obtenerComando() {
        Command nuevoComando=null;
        System.out.print("[x] ");
        String entrada = scanEntrada.nextLine();
        String comandoPre = null, adicionComando = null;
        Scanner datos = new Scanner(entrada);
        while (datos.hasNext()) {
            comandoPre = datos.next();
            adicionComando = datos.hasNext() ? datos.next() : null;
        }
        nuevoComando = comandos.comandoValido(comandoPre) ? new Command(comandoPre, adicionComando) : new Command(null, null);
        datos.close();
        return nuevoComando;
    }
}
