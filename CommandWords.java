public class CommandWords {
    private static final String[] comandosExistentes = {
        "ir", "salir", "ayuda"
    };


    public boolean comandoValido(String command) {
        boolean encontrado = false;
        for (String comandoExistente : comandosExistentes) {
            if (command.equals(comandoExistente))
                encontrado = true;
        }
        return encontrado;
    }
}