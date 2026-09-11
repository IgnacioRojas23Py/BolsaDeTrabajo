package bolsadetrabajo;

public class TrabajadorExistente extends Exception
{
    public TrabajadorExistente(String mensaje)
    {
        super(mensaje);
    }
}