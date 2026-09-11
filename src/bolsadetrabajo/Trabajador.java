package bolsadetrabajo;

import java.util.ArrayList;

public class Trabajador extends Usuario
{
    private int edad;
    private String sexo;
    private String profesion;
    private int anyosExperiencia;
    private ArrayList<String> competencias;
    

    public Trabajador(String identificador, String nombre, String correo, String telefono, int edad, String sexo, String profesion, int anyosExperiencia)
    {
	super(identificador, nombre, correo, telefono);
	this.edad = edad;
	this.sexo = sexo;
	this.profesion = profesion;
        this.anyosExperiencia = anyosExperiencia;
	this.competencias = new ArrayList<>();
    }

    public int getAnyosExperiencia() 
    {
        return anyosExperiencia;
    }

    public void setAnyosExperiencia(int anyosExperiencia) 
    {
        this.anyosExperiencia = anyosExperiencia;
    }

    public int getEdad()
    {
        return edad;
    }

    public String getSexo()
    {
        return sexo;
    }

    public String getProfesion()
    {
        return profesion;
    }

    public void setEdad(int numero)
    {
        edad = numero;
    }

    public void setSexo(String nuevoSexo)
    {
        sexo = nuevoSexo;
    }

    public void setProfesion(String nuevaProfesion)
    {
        profesion = nuevaProfesion;
    }
    
    //de esta forma no exponemos la coleccion
    public void agregarCompetencia(String competencia) 
    {
        competencias.add(competencia);
    }
    
    public void agregarCompetencia(String competencia1, String competencia2)    //sobrecarga momentanea para agregar 2 metodos a la vez, pensar si puede hacerse otra
    {
        competencias.add(competencia1);
        competencias.add(competencia2);
    }

    public void eliminarCompetencia(String competencia) 
    {
        competencias.remove(competencia);
    }

    public boolean tieneCompetencia(String competencia) 
    {
        return competencias.contains(competencia);
    }

    public int cantidadCompetencias() 
    {
        return competencias.size();
    }
    
    //esta copia se devuelve en caso de necesitar la coleccion para una comparacion por ejemplo. la de competencias y requisitos
    public ArrayList<String> getCompetencias() 
    {
        return new ArrayList<>(competencias);
    }
    
    @Override
    public String obtenerInformacion()    //sobreescritura
    {
        return "===== TRABAJADOR =====\n" + super.obtenerInformacion() + "\nEdad: " + edad + "\nSexo: " + sexo + "\nProfesión: " + profesion + "\nAños de experiencia: " + anyosExperiencia;
    }
}
