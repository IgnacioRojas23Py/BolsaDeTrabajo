package bolsadetrabajo;

import java.util.ArrayList;

public class OfertaLaboral 
{
    private String id;   //el id de una oferta laboral es unico en su empresa, osea, en otra empresa distinta puede repetirse
    private String cargo;
    private String descripcion;
    private int salario;
    private String modalidad;
    private String profesionRequerida;
    private ArrayList<String> requisitos;
    //requisitos abarca todo lo requerido. da igual el orden tanto de requisitos como de las competencias en el array del trabajador, lo que importa es que para la comparacion del trabajador mas apto, es mas facil

    public String getId() {
        return id;
    }

    public OfertaLaboral(String id, String cargo, String descripcion, int salario, String modalidad, String profesionRequerida) 
    {
	this.id = id;
	this.cargo = cargo;
	this.descripcion = descripcion;
	this.salario = salario;
	this.modalidad = modalidad;
	this.profesionRequerida = profesionRequerida;
	this.requisitos = new ArrayList<>();
    }

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getCargo() 
    {
        return cargo;
    }

    public void setCargo(String cargo) 
    {
        this.cargo = cargo;
    }

    public String getDescripcion() 
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion) 
    {
        this.descripcion = descripcion;
    }

    public int getSalario() 
    {
        return salario;
    }

    public void setSalario(int salario) 
    {
        this.salario = salario;
    }

    public String getModalidad() 
    {
        return modalidad;
    }

    public void setModalidad(String modalidad) 
    {
        this.modalidad = modalidad;
    }

    public String getProfesionRequerida() 
    {
        return profesionRequerida;
    }

    public void setProfesionRequerida(String profesionRequerida) 
    {
        this.profesionRequerida = profesionRequerida;
    }
    
    //la copia para la comparacion
    public ArrayList<String> getRequisitos() 
    {
        return new ArrayList<>(requisitos);
    }

    public void agregarRequisito(String requisito) 
    {
        requisitos.add(requisito);
    }
    
    public void agregarRequisito(String requisito1, String requisito2)
    {
        requisitos.add(requisito1);
        requisitos.add(requisito2);
    }

    public void eliminarRequisito(String requisito) 
    {
        requisitos.remove(requisito);
    }

    public boolean tieneRequisito(String requisito) 
    {
        return requisitos.contains(requisito);
    }

    public int cantidadRequisitos() 
    {
        return requisitos.size();
    }
}
