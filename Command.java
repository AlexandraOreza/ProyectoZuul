public class Command {
    private String comando;
    private String adicionComando;

    public Command(String prefijo, String adicion) {
        comando = prefijo;
        adicionComando = adicion;
    }

    public String getComando() {
        return comando;
    }

    public String getAdicionComando() {
        return adicionComando;
    }
    
    public boolean contieneComando() {
        return comando != null ? true : false;
    }

    public boolean contieneAdicionComando() {
      return adicionComando != null ? true : false;
    }

    public boolean esSalir(){
        return comando.equals("salir") ? true: false;
    }
}
