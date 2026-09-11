package bolsadetrabajo;

public class Usuario 
{
    private String identificador;
    private String nombre;
    private String correo;
    private String telefono;
    

    public Usuario(String identificador, String nombre, String correo, String telefono) 
    {
        this.identificador = identificador;
	this.nombre = nombre;
	this.correo = correo;
	this.telefono = telefono;
    }

    public String getTelefono() 
    {
        return telefono;
    }

    public void setTelefono(String telefono) 
    {
        this.telefono = telefono;
    }

    public String getIdentificador() 
    {
        return identificador;
    }

    public void setIdentificador(String identificador) 
    {
        this.identificador = identificador;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public String getCorreo() 
    {
        return correo;
    }

    public void setCorreo(String correo) 
    {
        this.correo = correo;
    }
    
    public String obtenerInformacion()  //sobreescritura
    {
        return "ID: " + identificador + "\nNombre: " + nombre + "\nCorreo: " + correo + "\nTeléfono: " + telefono;
    }
}
