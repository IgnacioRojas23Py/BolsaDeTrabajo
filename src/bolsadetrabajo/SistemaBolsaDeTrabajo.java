package bolsadetrabajo;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;

public class SistemaBolsaDeTrabajo 
{
    private ArrayList<Trabajador> trabajadores;
    private HashMap<String, ArrayList<Empresa>> empresas; 
    
    public SistemaBolsaDeTrabajo()
    {
    	this.trabajadores = new ArrayList<>();
    	this.empresas = new HashMap<>();
    }
    
    //TRABAJADORES
    public boolean agregarTrabajador(Trabajador trabajador) throws TrabajadorExistente
    {
        if (retornarTrabajador(trabajador.getIdentificador()) != null)
        {
            throw new TrabajadorExistente("Ya existe un trabajador con ese identificador");
        }

        trabajadores.add(trabajador);

        return true;
    }
    
    //busqueda de trabajador por id
    public Trabajador retornarTrabajador(String id)
    {
    	for (int i = 0; i < trabajadores.size(); i++)
    	{
            if (trabajadores.get(i).getIdentificador().equals(id))
            {
                return trabajadores.get(i);
            }
    	}
    	return null;
    }
    
    public void eliminarTrabajador(String id)
    {
        Trabajador trabajador = retornarTrabajador(id);

        if (trabajador != null)
        {
            trabajadores.remove(trabajador);
            System.out.println("El trabajador se elimino con exito");
        }
        else
        {
            System.out.println("El trabajador no existe");
        }
    }   
    
    //modificador para cambiar todo y abajo un atributo por uno (misma logica en empresas)
    public void modificarTrabajador(String id, int edad, String Correo, String telefono, String profesion, String sexo, String nombre, int anyosExperiencia)
    {
    	Trabajador p = retornarTrabajador(id);
    	if (p == null) 
    	{
            System.out.println("no existe");
            return;
    	}
    	p.setCorreo(Correo);
    	p.setTelefono(telefono);
    	p.setEdad(edad);
        p.setProfesion(profesion);
        p.setSexo(sexo);
        p.setNombre(nombre);
        p.setAnyosExperiencia(anyosExperiencia);
    	
    	System.out.println("Se han cambiado con exito los atribuos de este trabajador.");
    
    }
    
    //estos metodos evitan que se acceda con getter y setter desde el menu, separando responsabilidades, el menu no necesita saber como estan almacenados los trabajadores
    public void modificarNombreTrabajador(String id, String nuevoNombre)
    {
        Trabajador trabajador = retornarTrabajador(id);

        if (trabajador == null)
        {
            System.out.println("El trabajador no existe");
            return;
        }

        trabajador.setNombre(nuevoNombre);

        System.out.println("Nombre modificado correctamente");
    }


    public void modificarEdadTrabajador(String id, int nuevaEdad)
    {
        Trabajador trabajador = retornarTrabajador(id);

        if (trabajador == null)
        {
            System.out.println("El trabajador no existe");
            return;
        }

        trabajador.setEdad(nuevaEdad);

        System.out.println("Edad modificada correctamente");
    }


    public void modificarSexoTrabajador(String id, String nuevoSexo)
    {
        Trabajador trabajador = retornarTrabajador(id);

        if (trabajador == null)
        {
            System.out.println("El trabajador no existe");
            return;
        }

        trabajador.setSexo(nuevoSexo);

        System.out.println("Sexo modificado correctamente");
    }


    public void modificarProfesionTrabajador(String id, String nuevaProfesion)
    {
        Trabajador trabajador = retornarTrabajador(id);

        if (trabajador == null)
        {
            System.out.println("El trabajador no existe");
            return;
        }

        trabajador.setProfesion(nuevaProfesion);

        System.out.println("Profesión modificada correctamente");
    }


    public void modificarAnyosExperienciaTrabajador(String id, int nuevosAnyosExperiencia)
    {
        Trabajador trabajador = retornarTrabajador(id);

        if (trabajador == null)
        {
            System.out.println("El trabajador no existe");
            return;
        }

        trabajador.setAnyosExperiencia(nuevosAnyosExperiencia);

        System.out.println("Años de experiencia modificados correctamente");
    }


    public void modificarCorreoTrabajador(String id, String nuevoCorreo)
    {
        Trabajador trabajador = retornarTrabajador(id);

        if (trabajador == null)
        {
            System.out.println("El trabajador no existe");
            return;
        }

        trabajador.setCorreo(nuevoCorreo);

        System.out.println("Correo modificado correctamente");
    }


    public void modificarTelefonoTrabajador(String id, String nuevoTelefono)
    {
        Trabajador trabajador = retornarTrabajador(id);

        if (trabajador == null)
        {
            System.out.println("El trabajador no existe");
            return;
        }

        trabajador.setTelefono(nuevoTelefono);

        System.out.println("Teléfono modificado correctamente");
    }
    
    //manipulacion de las competencias
    public void agregarCompetenciaTrabajador(String id, String competencia)
    {
        Trabajador trabajador = retornarTrabajador(id);

        if (trabajador == null)
        {
            System.out.println("El trabajador no existe");
            return;
        }

        trabajador.agregarCompetencia(competencia);

        System.out.println("Competencia agregada correctamente");
    }
    
    public void eliminarCompetenciaTrabajador(String id, String competencia)
    {
        Trabajador trabajador = retornarTrabajador(id);

        if (trabajador == null)
        {
            System.out.println("El trabajador no existe");
            return;
        }

        if (!trabajador.tieneCompetencia(competencia))
        {
            System.out.println("El trabajador no posee esa competencia");
            return;
        }

        trabajador.eliminarCompetencia(competencia);

        System.out.println("Competencia eliminada correctamente");
    }
    
    public void mostrarTrabajadores()
    {
        if (trabajadores.isEmpty())
        {
            System.out.println("No hay trabajadores");
            return;
        }
        else
        {
            for (Trabajador trabajador : trabajadores)
            { 
                System.out.println(trabajador.obtenerInformacion());   //sobreescritura

                System.out.println("-------------------");
            }
        }
    }
    
    public ArrayList<Trabajador> getTrabajadores() {
    return trabajadores;
}
    
    //EMPRESAS
    public boolean agregarEmpresa(Empresa empresa) throws EmpresaExistente
    {
        if (buscarEmpresaPorIdentificador(empresa.getIdentificador()) != null)
        {
            throw new EmpresaExistente("Ya existe una empresa con ese identificador");
        }

        String sector = empresa.getSector();

        if (!empresas.containsKey(sector))
        {
            empresas.put(sector, new ArrayList<>());
        }

        empresas.get(sector).add(empresa);

        return true;
    }
    
    public Empresa buscarEmpresaPorIdentificador(String id)
    {
        for (ArrayList<Empresa> listaEmpresas : empresas.values())
        {
            for (Empresa empresa : listaEmpresas)
            {
                if (empresa.getIdentificador().equals(id))
                {
                    return empresa;
                }
            }
        }

        return null;
    }
    
    public void eliminarEmpresa(String id)
    {
        Empresa empresa = buscarEmpresaPorIdentificador(id);

        if (empresa == null)
        {
            System.out.println("La empresa no existe");
            return;
        }

        String sector = empresa.getSector();

        ArrayList<Empresa> lista = empresas.get(sector);

        lista.remove(empresa);

        if (lista.isEmpty())
        {
            empresas.remove(sector);
        }

        System.out.println("La empresa se eliminó con éxito");
    }

    //se debe manejar el caso donde se modifica el sector, ya que ante esto, se genera la situacion donde la empresa debe ser cambiada de una lista de sectores a otra. el identificador nunca se toca    
    public void modificarEmpresa(String id, String nuevoNombre, String nuevoSector, String nuevoCorreo, String nuevoTelefono, String nuevaDireccion, String nuevoSitioWeb, String nuevaDescripcionEmpresa)
    {
        Empresa empresa = buscarEmpresaPorIdentificador(id);

        if (empresa == null)
        {
            System.out.println("La empresa no existe");
            return;
        }

        String sectorActual = empresa.getSector();

        empresa.setNombre(nuevoNombre);
        empresa.setCorreo(nuevoCorreo);
        empresa.setTelefono(nuevoTelefono);
        empresa.setDireccion(nuevaDireccion);
        empresa.setSitioWeb(nuevoSitioWeb);
        empresa.setDescripcionEmpresa(nuevaDescripcionEmpresa);

        if (!sectorActual.equals(nuevoSector))
        {
            ArrayList<Empresa> listaActual = empresas.get(sectorActual);

            listaActual.remove(empresa);

            if (listaActual.isEmpty())
            {
                empresas.remove(sectorActual);
            }

            empresa.setSector(nuevoSector);

            if (!empresas.containsKey(nuevoSector))
            {
                empresas.put(nuevoSector, new ArrayList<>());
            }

            empresas.get(nuevoSector).add(empresa);
        }

        System.out.println("Se realizó el cambio correctamente");
    }
    
    public void modificarNombreEmpresa(String id, String nuevoNombre)
    {
        Empresa empresa = buscarEmpresaPorIdentificador(id);

        if (empresa == null)
        {
            System.out.println("La empresa no existe");
            return;
        }

        empresa.setNombre(nuevoNombre);

        System.out.println("Nombre modificado correctamente");
    }


    public void modificarCorreoEmpresa(String id, String nuevoCorreo)
    {
        Empresa empresa = buscarEmpresaPorIdentificador(id);

        if (empresa == null)
        {
            System.out.println("La empresa no existe");
            return;
        }

        empresa.setCorreo(nuevoCorreo);

        System.out.println("Correo modificado correctamente");
    }


    public void modificarTelefonoEmpresa(String id, String nuevoTelefono)
    {
        Empresa empresa = buscarEmpresaPorIdentificador(id);

        if (empresa == null)
        {
            System.out.println("La empresa no existe");
            return;
        }

        empresa.setTelefono(nuevoTelefono);

        System.out.println("Teléfono modificado correctamente");
    }


    public void modificarDireccionEmpresa(String id, String nuevaDireccion)
    {
        Empresa empresa = buscarEmpresaPorIdentificador(id);

        if (empresa == null)
        {
            System.out.println("La empresa no existe");
            return;
        }

        empresa.setDireccion(nuevaDireccion);

        System.out.println("Dirección modificada correctamente");
    }


    public void modificarSitioWebEmpresa(String id, String nuevoSitioWeb)
    {
        Empresa empresa = buscarEmpresaPorIdentificador(id);

        if (empresa == null)
        {
            System.out.println("La empresa no existe");
            return;
        }

        empresa.setSitioWeb(nuevoSitioWeb);

        System.out.println("Sitio web modificado correctamente");
    }


    public void modificarDescripcionEmpresa(String id, String nuevaDescripcion)
    {
        Empresa empresa = buscarEmpresaPorIdentificador(id);

        if (empresa == null)
        {
            System.out.println("La empresa no existe");
            return;
        }

        empresa.setDescripcionEmpresa(nuevaDescripcion);

        System.out.println("Descripción modificada correctamente");
    }
    
    //modificar el sector es particular, porque al modificarlo se debe modificar la ubicacion de la empresa en el mapa, cambiandola de sector
    public void modificarSectorEmpresa(String id, String nuevoSector)
    {
        Empresa empresa = buscarEmpresaPorIdentificador(id);

        if (empresa == null)
        {
            System.out.println("La empresa no existe");
            return;
        }

        String sectorActual = empresa.getSector();

        if (sectorActual.equals(nuevoSector))
        {
            System.out.println("La empresa ya pertenece a ese sector");
            return;
        }

        ArrayList<Empresa> listaActual = empresas.get(sectorActual);

        listaActual.remove(empresa);

        if (listaActual.isEmpty())
        {
            empresas.remove(sectorActual);
        }
        empresa.setSector(nuevoSector);
        if (!empresas.containsKey(nuevoSector))
        {
            empresas.put(nuevoSector, new ArrayList<>());
        }
        empresas.get(nuevoSector).add(empresa);

        System.out.println("Sector modificado correctamente");
    }
    
    //coleccion de ofertas
    public void agregarOfertaEmpresa(String idEmpresa, OfertaLaboral oferta)
    {
        Empresa empresa = buscarEmpresaPorIdentificador(idEmpresa);

        if (empresa == null)
        {
            System.out.println("La empresa no existe");
            return;
        }

        if (empresa.agregarOferta(oferta))
        {
            System.out.println("Oferta laboral agregada correctamente");
        }
        else
        {
            System.out.println("Ya existe una oferta con ese identificador");
        }
    }
    
    public void eliminarOfertaEmpresa(String idEmpresa, String idOferta)
    {
        Empresa empresa = buscarEmpresaPorIdentificador(idEmpresa);

        if (empresa == null)
        {
            System.out.println("La empresa no existe");
            return;
        }

        boolean eliminada = empresa.eliminarOferta(idOferta);

        if (eliminada)
        {
            System.out.println("Oferta eliminada correctamente");
        }
        else
        {
            System.out.println("La oferta no existe");
        }
    }
    
    public OfertaLaboral buscarOfertaEmpresa(String idEmpresa, String idOferta)
    {
        Empresa empresa = buscarEmpresaPorIdentificador(idEmpresa);

        if (empresa == null)
        {
            return null;
        }

        return empresa.buscarOferta(idOferta);
    }
    
    public void mostrarEmpresas()
    {
        if (empresas.isEmpty())
        {
            System.out.println("No hay empresas registradas");
            return;
        }

        for (String sector : empresas.keySet())
        {
            System.out.println("Sector: " + sector);

            ArrayList<Empresa> listaEmpresas = empresas.get(sector);

            for (Empresa empresa : listaEmpresas)
            {
                System.out.println(empresa.obtenerInformacion());    //por sobreescritura
                System.out.println("-------------------");
            }
        }
    }
    public void mostrarEmpresas(String sector)    //sobrecarga
    {
        ArrayList<Empresa> listaEmpresas = empresas.get(sector);

        if (listaEmpresas == null || listaEmpresas.isEmpty())
        {
            System.out.println("No hay empresas registradas en el sector " + sector);
            return;
        }

        System.out.println("Sector: " + sector);

        for (Empresa empresa : listaEmpresas)
        {
            System.out.println(empresa.obtenerInformacion());
            System.out.println("-------------------");
        }
    }
    
    
    public void mostrarOfertasEmpresa(String idEmpresa)
    {
        Empresa empresa = buscarEmpresaPorIdentificador(idEmpresa);

        if (empresa == null)
        {
            System.out.println("La empresa no existe");
            return;
        }

        if (empresa.cantidadOfertas() == 0)
        {
            System.out.println("La empresa no posee ofertas laborales");
            return;
        }

        for (OfertaLaboral oferta : empresa.getOfertas())
        {
            System.out.println("ID: " + oferta.getId());
            System.out.println("Cargo: " + oferta.getCargo());
            System.out.println("Salario: " + oferta.getSalario());
            System.out.println("Modalidad: " + oferta.getModalidad());

            System.out.println("-------------------");
        }
    }
    
   
    
    //PARA LOS REQUISITOS
    public void agregarRequisitoOferta(String idEmpresa, String idOferta, String requisito)
    {
        OfertaLaboral oferta = buscarOfertaEmpresa(idEmpresa, idOferta);

        if (oferta == null)
        {
            System.out.println("La oferta laboral no existe");
            return;
        }

        oferta.agregarRequisito(requisito);

        System.out.println("Requisito agregado correctamente");
    }
    
    public void eliminarRequisitoOferta(String idEmpresa, String idOferta, String requisito)
    {
        OfertaLaboral oferta = buscarOfertaEmpresa(idEmpresa, idOferta);

        if (oferta == null)
        {
            System.out.println("La oferta laboral no existe");
            return;
        }

        if (!oferta.tieneRequisito(requisito))
        {
            System.out.println("La oferta no posee ese requisito");
            return;
        }

        oferta.eliminarRequisito(requisito);

        System.out.println("Requisito eliminado correctamente");
    }
    
    public void mostrarRequisitosOferta(String idEmpresa, String idOferta)
    {
        OfertaLaboral oferta = buscarOfertaEmpresa(idEmpresa, idOferta);

        if (oferta == null)
        {
            System.out.println("La oferta laboral no existe");
            return;
        }

        if (oferta.cantidadRequisitos() == 0)
        {
            System.out.println("La oferta no posee requisitos");
            return;
        }

        System.out.println("\n===== REQUISITOS =====");

        for (String requisito : oferta.getRequisitos())
        {
            System.out.println("- " + requisito);
        }
    }
    
    //AUTOMATIZACION
    //se haran calculos porcentuales para definir los trabajadores mas aptos segun la oferta laboral, si empatan, se ordena por años de experiencia, y si vuelven a empatar, lo hacen por quien ingreso primero al sistema.
    
    
    //solo compara requisitos y competencias
    public double calcularCompatibilidad(Trabajador trabajador, OfertaLaboral oferta)
    {
        int requisitosCumplidos = 0;
        int totalRequisitos = oferta.cantidadRequisitos();

        if (totalRequisitos == 0)
        {
            return 0;
        }

        for (String requisito : oferta.getRequisitos()) 
        {
            if (trabajador.tieneCompetencia(requisito))
            {
                requisitosCumplidos++;
            }
        }
        
        return (requisitosCumplidos * 100.0) / totalRequisitos;
    }

    
    //obtener los candidatos que cumplan con la profesion buscada, despues se hace el filtro por competencias
    //es un modelado por capas, y se va adaptando el arrayList para finalmente retornar uno final
    public ArrayList<Trabajador> buscarCandidatos(OfertaLaboral oferta)
    {
        ArrayList<Trabajador> candidatos = new ArrayList<>();

        for (Trabajador trabajador : trabajadores)
        {
            if (trabajador.getProfesion().equals(oferta.getProfesionRequerida()))
            {
                candidatos.add(trabajador);
            }
        }
        return candidatos;
    }
    
    //en este caso si puedo recibir una coleccion como parametro porque estoy usando la coleccion para realizar una operacion, y no cambiandola, donde podria generar incoherencias con la modificacion
    public ArrayList<Trabajador> filtrarPorCompetencias(ArrayList<Trabajador> candidatos, OfertaLaboral oferta)
    {
        ArrayList<Trabajador> candidatosAptos = new ArrayList<>();

        for (Trabajador trabajador : candidatos)
        {
            double porcentaje = calcularCompatibilidad(trabajador, oferta);

            //50% como porcentaje minimo de aceptacion
            if (porcentaje >= 50)
            {
                candidatosAptos.add(trabajador);
            }
        }
        return candidatosAptos;
    }
    
    //el ordenamiento segun los mejores para el puesto
    public ArrayList<Trabajador> ordenarCandidatos(ArrayList<Trabajador> candidatosAptos, OfertaLaboral oferta)
    {
        // Creamos una copia para no modificar la lista recibida
        ArrayList<Trabajador> candidatosOrdenados = new ArrayList<>(candidatosAptos);

        for (int i = 0; i < candidatosOrdenados.size() - 1; i++)
        {
            for (int j = i + 1; j < candidatosOrdenados.size(); j++)
            {
                Trabajador trabajadorActual = candidatosOrdenados.get(i);
                Trabajador trabajadorComparado = candidatosOrdenados.get(j);
                double porcentajeActual = calcularCompatibilidad(trabajadorActual, oferta);
                double porcentajeComparado = calcularCompatibilidad(trabajadorComparado, oferta);
                
            // Primer criterio: mayor porcentaje
                if (porcentajeComparado > porcentajeActual)
                {
                    candidatosOrdenados.set(i, trabajadorComparado);
                    candidatosOrdenados.set(j, trabajadorActual);
                }
            // Segundo criterio: mismos porcentajes,
            // gana quien tenga más años de experiencia
                else if (porcentajeComparado == porcentajeActual)
                {
                    if (trabajadorComparado.getAnyosExperiencia() > trabajadorActual.getAnyosExperiencia())
                    {
                        candidatosOrdenados.set(i, trabajadorComparado);
                        candidatosOrdenados.set(j, trabajadorActual);
                    }
                }
            // Si porcentaje y experiencia son iguales,
            // no se intercambian y se mantiene el orden de llegada.
            }
        }

        return candidatosOrdenados;
    }

    //EL INICIO DE LA AUTOMATIZACION
    public ArrayList<Trabajador> buscarMejoresCandidatos(OfertaLaboral oferta)
    {
        ArrayList<Trabajador> candidatos = buscarCandidatos(oferta);

        ArrayList<Trabajador> candidatosAptos = filtrarPorCompetencias(candidatos, oferta);

        ArrayList<Trabajador> candidatosOrdenados = ordenarCandidatos(candidatosAptos, oferta);

        return candidatosOrdenados;
    }   
    
    //PERSISTENCIA SIA-11
    public ArrayList<Empresa> obtenerTodasLasEmpresas(){
        ArrayList<Empresa> todasLasEmpresas = new ArrayList<>();

        for (ArrayList<Empresa> listaPorSector : empresas.values()){
            todasLasEmpresas.addAll(listaPorSector);

        }
        return todasLasEmpresas;
    }    
    public void guardarDatos() throws IOException{
        ArrayList<Empresa> todasLasEmpresas = obtenerTodasLasEmpresas();

        PersistenciaCSV.registrarTrabajadoresCSV(trabajadores, "data/trabajadores.csv");
        PersistenciaCSV.registrarEmpresasCSV(todasLasEmpresas, "data/empresas.csv");
        PersistenciaCSV.registrarOfertasCSV(todasLasEmpresas, "data/ofertas.csv");
    }
    public void cargarDatos() throws IOException
    {
        trabajadores = PersistenciaCSV.cargarTrabajadoresCSV("data/trabajadores.csv");

        ArrayList<Empresa> empresasCargadas = PersistenciaCSV.cargarEmpresasCSV("data/empresas.csv");

        for (Empresa empresa : empresasCargadas){
            try{
                agregarEmpresa(empresa);
            }
            catch (EmpresaExistente e){
                System.out.println(e.getMessage());
            }
        }

        PersistenciaCSV.cargarOfertasCSV(this, "data/ofertas.csv");
    }
    
    public boolean hayDatos()
    {
        return !trabajadores.isEmpty() || !empresas.isEmpty();
    }
}