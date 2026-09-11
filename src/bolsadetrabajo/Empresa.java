package bolsadetrabajo;

import java.util.ArrayList;

public class Empresa extends Usuario
{
    private String sector;
    private String direccion;
    private String sitioWeb;
    private String descripcionEmpresa;
    private ArrayList<OfertaLaboral> ofertas;
    
    
    public Empresa(String identificador, String nombre, String correo, String telefono, String sector, String direccion, String sitioWeb, String descripcionEmpresa) 
    {
	super(identificador, nombre, correo, telefono);
	this.sector = sector;
	this.direccion = direccion;
	this.sitioWeb = sitioWeb;
        this.descripcionEmpresa = descripcionEmpresa;
        this.ofertas = new ArrayList<>();
    }

    public String getSector() 
    {
        return sector;
    }

    public void setSector(String sector) 
    {
        this.sector = sector;
    }

    public String getDireccion() 
    {
        return direccion;
    }

    public void setDireccion(String direccion) 
    {
        this.direccion = direccion;
    }

    public String getSitioWeb() 
    {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) 
    {
        this.sitioWeb = sitioWeb;
    }

    public String getDescripcionEmpresa() 
    {
        return descripcionEmpresa;
    }
    
    public ArrayList<OfertaLaboral> getOfertas()
    {
        return new ArrayList<>(ofertas);
    }

    public void setDescripcionEmpresa(String descripcionEmpresa) 
    {
        this.descripcionEmpresa = descripcionEmpresa;
    }
    
    public boolean agregarOferta(OfertaLaboral oferta)
    {
        if (buscarOferta(oferta.getId()) != null)
        {
            return false;
        }

        ofertas.add(oferta);
        return true;
    }

    public OfertaLaboral buscarOferta(String id)
    {
        for (OfertaLaboral oferta : ofertas)
        {
            if (oferta.getId().equals(id))
            {
                return oferta;
            }
        }

        return null;
    }

    public boolean eliminarOferta(String id)
    {
        OfertaLaboral oferta = buscarOferta(id);

        if (oferta != null)
        {
            ofertas.remove(oferta);
            return true;
        }

        return false;
    }

    public int cantidadOfertas()
    {
        return ofertas.size();
    }
    
    @Override
    public String obtenerInformacion()   //sobreescritura
    {
        return "===== EMPRESA =====\n" + super.obtenerInformacion() + "\nSector: " + sector + "\nDirección: " + direccion + "\nSitio web: " + sitioWeb + "\nDescripción: " + descripcionEmpresa;
    }
}
