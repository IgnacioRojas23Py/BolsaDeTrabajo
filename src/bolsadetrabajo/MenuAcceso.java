package bolsadetrabajo;
import java.util.ArrayList;
public class MenuAcceso
{
    private SistemaBolsaDeTrabajo sistema;
    private LectorGeneral lector;
    public MenuAcceso(SistemaBolsaDeTrabajo sistema, LectorGeneral lector)
    {
        this.sistema = sistema;
        this.lector = lector;
    }

    public void iniciar()
    {
        int opcion;

        do
        {
            mostrarMenuPrincipal();

            opcion = lector.leerEntero("Seleccione una opción: ", 0, 2);

            switch (opcion)
            {
                case 1:
                    menuTrabajadores();
                    break;

                case 2:
                    menuEmpresas();
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 0);
    }

    private void mostrarMenuPrincipal()
    {
        System.out.println("\n===== SISTEMA BOLSA DE TRABAJO =====");
        System.out.println("1. Gestión de trabajadores");
        System.out.println("2. Gestión de empresas");
        System.out.println("0. Salir");

    }
    
    
    private void menuTrabajadores()
    {
        int opcion;

        do
        {
            System.out.println("\n===== GESTIÓN DE TRABAJADORES =====");
            System.out.println("1. Agregar trabajador");
            System.out.println("2. Mostrar trabajadores");
            System.out.println("3. Buscar trabajador");
            System.out.println("4. Modificar trabajador");
            System.out.println("5. Eliminar trabajador");
            System.out.println("6. Gestionar competencias");
            System.out.println("0. Volver");

            opcion = lector.leerEntero("Seleccione una opción: ", 0, 6);

            switch (opcion)
            {
                case 1:
                    agregarTrabajadorMenu();
                    break;

                case 2:
                    sistema.mostrarTrabajadores();
                    break;
                    
                case 3:
                    buscarTrabajadorMenu();
                    break;
                    
                case 4:
                    modificarTrabajadorMenu();
                    break;
                    
                case 5:
                    eliminarTrabajadorMenu();
                    break;
                    
                case 6:
                    gestionarCompetenciasMenu();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opción aún no implementada");
            }

        } while (opcion != 0);
    }
    
    private void agregarTrabajadorMenu()
    {
        System.out.println("\n===== AGREGAR TRABAJADOR =====");

        String id = lector.leerString("Identificador: ");
        String nombre = lector.leerString("Nombre: ");
        String correo = lector.leerString("Correo: ");
        String telefono = lector.leerString("Teléfono: ");
        int edad = lector.leerEntero("Edad: ", 16, 120);
        String sexo = lector.leerString("Sexo: ");
        String profesion = lector.leerString("Profesión: ");
        int anyosExperiencia = lector.leerEntero("Años de experiencia: ", 0, 80);
       
        Trabajador trabajador = new Trabajador(id, nombre, correo, telefono, edad, sexo, profesion, anyosExperiencia);

        try
        {
            sistema.agregarTrabajador(trabajador);

            System.out.println("Trabajador agregado correctamente");
        }
        catch (TrabajadorExistente e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    private void menuEmpresas()
    {
        int opcion;

        do
        {
            System.out.println("\n===== GESTIÓN DE EMPRESAS =====");
            System.out.println("1. Agregar empresa");
            System.out.println("2. Mostrar empresas");
            System.out.println("3. Buscar empresa");
            System.out.println("4. Modificar empresa");
            System.out.println("5. Eliminar empresa");
            System.out.println("6. Gestionar ofertas laborales");
            System.out.println("7. Mostrar empresas por sector");
            System.out.println("0. Volver");
            opcion = lector.leerEntero("Seleccione una opción: ", 0, 7);
            
            switch (opcion)
            {
                case 1:
                    agregarEmpresaMenu();
                    break;

                case 2:
                    sistema.mostrarEmpresas();
                    break;
                    
                case 3:
                    buscarEmpresaMenu();
                    break;

                case 4:
                    modificarEmpresaMenu();
                    break;

                case 5:
                    eliminarEmpresaMenu();
                    break;

                case 6:
                    gestionarOfertasMenu();
                    break;
                    
                case 7:
                    String sector = lector.leerString("Sector a filtrar: ");
                    sistema.mostrarEmpresas(sector);
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opción aún no implementada");
            }

        } while (opcion != 0);
    }
    
    private void agregarEmpresaMenu()
    {
        System.out.println("\n===== AGREGAR EMPRESA =====");

        String id = lector.leerString("Identificador: ");
        String nombre = lector.leerString("Nombre: ");
        String correo = lector.leerString("Correo: ");
        String telefono = lector.leerString("Teléfono: ");
        String sector = lector.leerString("Sector: ");
        String direccion = lector.leerString("Dirección: ");
        String sitioWeb = lector.leerString("Sitio web: ");
        String descripcion = lector.leerString("Descripción: ");

        Empresa empresa = new Empresa(id, nombre, correo, telefono, sector, direccion, sitioWeb, descripcion);

        try
        {
            sistema.agregarEmpresa(empresa);

            System.out.println("Empresa agregada correctamente");
        }
        catch (EmpresaExistente e)
        {
            System.out.println(e.getMessage());    //getMessage es de la clase Exception
        }
    }
    
    //PROPIOS DE LOS TRABAJADORES
    private void buscarTrabajadorMenu()
    {

        String id = lector.leerString("Ingrese el identificador del trabajador: ");

        Trabajador trabajador = sistema.retornarTrabajador(id);

        if (trabajador == null)
        {
            System.out.println("El trabajador no existe");
            return;
        }

        System.out.println(trabajador.obtenerInformacion());   //sobreescritura
    }
    
    private void eliminarTrabajadorMenu()
    {
        String id = lector.leerString("Ingrese el identificador del trabajador a eliminar: ");

        sistema.eliminarTrabajador(id);
    }
    
    private void gestionarCompetenciasMenu()
    {
        String id = lector.leerString("Ingrese el identificador del trabajador: ");

        Trabajador trabajador = sistema.retornarTrabajador(id);

        if (trabajador == null)
        {
            System.out.println("El trabajador no existe");
            return;
        }

        int opcion;

        do
        {
            System.out.println("\n===== GESTIÓN DE COMPETENCIAS =====");
            System.out.println("1. Agregar competencia");
            System.out.println("2. Eliminar competencia");
            System.out.println("0. Volver");

            opcion = lector.leerEntero("Seleccione una opción: ", 0, 2);

            switch (opcion)
            {
                case 1:
                    String competenciaAgregar = lector.leerString("Ingrese la competencia: ");
                    sistema.agregarCompetenciaTrabajador(id, competenciaAgregar);
                    break;

                case 2:
                    String competenciaEliminar = lector.leerString("Ingrese la competencia a eliminar: ");
                    sistema.eliminarCompetenciaTrabajador(id, competenciaEliminar);
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 0);
    }
    
    
    //EL MODIFICADOR DE TRABAJADORES FUNCIONA EN CAPAS, DANDO LA OPCION DE SI MODIFICAR TODO O SI MODIFICAR SOLO UN ATRIBUTO
    private void modificarTrabajadorMenu()
    {
        String id = lector.leerString("Ingrese el identificador del trabajador: ");
        
        Trabajador trabajador = sistema.retornarTrabajador(id);

        if (trabajador == null)
        {
            System.out.println("El trabajador no existe");
            return;
        }


        System.out.println("\n===== MODIFICAR TRABAJADOR =====");
        System.out.println("1. Modificar todos los datos");
        System.out.println("2. Modificar un atributo específico");
        System.out.println("0. Volver");


        int opcion = lector.leerEntero("Seleccione una opción: ", 0, 2);

        switch (opcion)
        {
            case 1:
                modificarTodoTrabajadorMenu(id);
                break;

            case 2:
                modificarAtributoTrabajadorMenu(id);
                break;

            case 0:
                break;

            default:
                System.out.println("Opción inválida");
        }
    }
    
    private void modificarTodoTrabajadorMenu(String id)
    {
        System.out.println("\n===== MODIFICAR TODOS LOS DATOS =====");

       String nombre = lector.leerString("Nuevo nombre: ");
        String correo = lector.leerString("Nuevo correo: ");
        String telefono = lector.leerString("Nuevo Teléfono: ");
        int edad = lector.leerEntero("Nueva edad: ", 16, 120);
        String sexo = lector.leerString("Nuevo Sexo: ");
        String profesion = lector.leerString("Nueva profesión: ");
        int anyosExperiencia = lector.leerEntero("Nuevos años de experiencia: ", 20, 80);

        sistema.modificarTrabajador(id, edad, correo, telefono, profesion, sexo, nombre, anyosExperiencia);
    }
    
    //este funciona para la modificacion de un atributo en particular, el metodo anterior es la opcion para modificar todo
    private void modificarAtributoTrabajadorMenu(String id)
    {
        int opcion;

        do
        {
            System.out.println("\n===== MODIFICAR ATRIBUTO =====");
            System.out.println("1. Nombre");
            System.out.println("2. Edad");
            System.out.println("3. Sexo");
            System.out.println("4. Profesión");
            System.out.println("5. Años de experiencia");
            System.out.println("6. Correo");
            System.out.println("7. Teléfono");
            System.out.println("0. Volver");

            System.out.print("Seleccione una opción: ");

            opcion = lector.leerEntero("Seleccione una opción: ", 0, 7);

            switch (opcion)
            {
                case 1:
                    sistema.modificarNombreTrabajador(id, lector.leerString("Nuevo nombre: "));
                    break;
        
                case 2:
                    sistema.modificarEdadTrabajador(id, lector.leerEntero("Nueva edad: ", 16, 120));
                    break;
        
                case 3:
                    sistema.modificarSexoTrabajador(id, lector.leerString("Nuevo sexo: "));
                    break;
        
                case 4:
                    sistema.modificarProfesionTrabajador(id, lector.leerString("Nueva profesión: "));
                    break;
        
                case 5:
                    sistema.modificarAnyosExperienciaTrabajador(id, lector.leerEntero("Nuevos años de experiencia: ", 0, 80));
                    break;
        
                case 6:
                    sistema.modificarCorreoTrabajador(id, lector.leerString("Nuevo correo: "));
                    break;
        
                case 7:
                    sistema.modificarTelefonoTrabajador(id, lector.leerString("Nuevo teléfono: "));
                    break;
        
                case 0:
                    break;
        
                default:
                    System.out.println("Opción inválida");
            }
        }while(opcion != 0);
        
    }
    private void buscarEmpresaMenu()
    {
        String id = lector.leerString("Ingrese el identificador de la empresa: ");

        Empresa empresa = sistema.buscarEmpresaPorIdentificador(id);

        if (empresa == null)
        {
            System.out.println("La empresa no existe");
            return;
        }

        System.out.println(empresa.obtenerInformacion());
    }
    
    private void eliminarEmpresaMenu()
    {
        String id = lector.leerString("Ingrese el identificador de la empresa a eliminar: ");

        sistema.eliminarEmpresa(id);
    }
    
    private void modificarEmpresaMenu()
    {
        String id = lector.leerString("Ingrese el identificador de la empresa: ");

        Empresa empresa = sistema.buscarEmpresaPorIdentificador(id);

        if (empresa == null)
        {
            System.out.println("La empresa no existe");
            return;
        }

        System.out.println("\n===== MODIFICAR EMPRESA =====");
        System.out.println("1. Modificar todos los datos");
        System.out.println("2. Modificar un atributo específico");
        System.out.println("0. Volver");

        int opcion = lector.leerEntero("Seleccione una opción: ", 0, 2);

        switch (opcion)
        {
            case 1:
                modificarTodoEmpresaMenu(id);
                break;

            case 2:
                modificarAtributoEmpresaMenu(id);
                break;

            case 0:
                break;
            
            default:
                System.out.println("Opción inválida");
        }
    }
    
    private void modificarTodoEmpresaMenu(String id)
    {
        System.out.println("\n===== MODIFICAR TODOS LOS DATOS =====");
        String nombre = lector.leerString("Nuevo nombre: ");
        String sector = lector.leerString("Nuevo sector: ");
        String correo = lector.leerString("Nuevo correo: ");
        String telefono = lector.leerString("Nuevo teléfono: ");
        String direccion = lector.leerString("Nueva dirección: ");
        String sitioWeb = lector.leerString("Nuevo sitio web: ");
        String descripcion = lector.leerString("Nueva descripción: ");

        sistema.modificarEmpresa(id, nombre, sector, correo, telefono, direccion, sitioWeb, descripcion);
    }
    
    private void modificarAtributoEmpresaMenu(String id)
    {
        int opcion;
        do
        {
            System.out.println("\n===== MODIFICAR ATRIBUTO =====");
            System.out.println("1. Nombre");
            System.out.println("2. Sector");
            System.out.println("3. Correo");
            System.out.println("4. Teléfono");
            System.out.println("5. Dirección");
            System.out.println("6. Sitio web");
            System.out.println("7. Descripción");
            System.out.println("0. Volver");
            opcion = lector.leerEntero("Seleccione una opción: ", 0, 7);
        
            switch (opcion)
            {
                case 1:
                    sistema.modificarNombreEmpresa(id, lector.leerString("Nuevo nombre: "));
                    break;
                case 2:
                    sistema.modificarSectorEmpresa(id, lector.leerString("Nuevo sector: "));
                    break;
                case 3:
                    sistema.modificarCorreoEmpresa(id, lector.leerString("Nuevo correo: "));
                    break;
                case 4:
                    sistema.modificarTelefonoEmpresa(id, lector.leerString("Nuevo teléfono: "));
                    break;
                case 5:
                    sistema.modificarDireccionEmpresa(id, lector.leerString("Nueva dirección: "));
                    break;
                case 6:
                    sistema.modificarSitioWebEmpresa(id, lector.leerString("Nuevo sitio web: "));
                    break;
                case 7:
                    sistema.modificarDescripcionEmpresa(id, lector.leerString("Nueva descripción: "));
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 0);
    }
    
    private void gestionarOfertasMenu()
    {
        String idEmpresa = lector.leerString("Ingrese el identificador de la empresa: ");
        Empresa empresa = sistema.buscarEmpresaPorIdentificador(idEmpresa);
        if (empresa == null)
        {
            System.out.println("La empresa no existe");
            return;
        }
        int opcion;
        do
        {
            System.out.println("\n===== GESTIÓN DE OFERTAS LABORALES =====");
            System.out.println("1. Agregar oferta laboral");
            System.out.println("2. Mostrar ofertas laborales");
            System.out.println("3. Buscar oferta laboral");
            System.out.println("4. Eliminar oferta laboral");
            System.out.println("5. Gestionar requisitos");
            System.out.println("6. Buscar mejores candidatos");
            System.out.println("0. Volver");
            opcion = lector.leerEntero("Seleccione una opción: ", 0, 6);
            switch (opcion)
            {
                case 1:
                    agregarOfertaMenu(idEmpresa);
                    break;
                case 2:
                    sistema.mostrarOfertasEmpresa(idEmpresa);
                    break;
                case 3:
                    buscarOfertaMenu(idEmpresa);
                    break;
                case 4:
                    eliminarOfertaMenu(idEmpresa);
                    break;
                case 5:
                    gestionarRequisitosMenu(idEmpresa);
                    break;
                case 6:
                    buscarMejoresCandidatosMenu(idEmpresa);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 0);
    }
    
    private void agregarOfertaMenu(String idEmpresa)
    {
        System.out.println("\n===== AGREGAR OFERTA LABORAL =====");

        String idOferta = lector.leerString("Identificador de la oferta: ");
        String cargo = lector.leerString("Cargo: ");
        String descripcion = lector.leerString("Descripción: ");
        int salario = lector.leerEntero("Salario: ", 0);
        String modalidad = lector.leerString("Modalidad: ");
        String profesionRequerida = lector.leerString("Profesión requerida: ");

        OfertaLaboral oferta = new OfertaLaboral(idOferta, cargo, descripcion, salario, modalidad, profesionRequerida);

        sistema.agregarOfertaEmpresa(idEmpresa, oferta);
    }
    
    private void buscarOfertaMenu(String idEmpresa)
    {
        String idOferta = lector.leerString("Ingrese el identificador de la oferta: ");

        OfertaLaboral oferta = sistema.buscarOfertaEmpresa(idEmpresa, idOferta);

        if (oferta == null)
        {
            System.out.println("La oferta laboral no existe");
            return;
        }

        System.out.println("\n===== OFERTA ENCONTRADA =====");
        System.out.println("ID: " + oferta.getId());
        System.out.println("Cargo: " + oferta.getCargo());
        System.out.println("Descripción: " + oferta.getDescripcion());
        System.out.println("Salario: " + oferta.getSalario());
        System.out.println("Modalidad: " + oferta.getModalidad());
        System.out.println("Profesión requerida: " + oferta.getProfesionRequerida());
    }
    
    private void eliminarOfertaMenu(String idEmpresa)
    {
        String idOferta = lector.leerString("Ingrese el identificador de la oferta a eliminar: ");

        sistema.eliminarOfertaEmpresa(idEmpresa, idOferta);
    }
    
    private void gestionarRequisitosMenu(String idEmpresa)
    {
        String idOferta = lector.leerString("Ingrese el identificador de la oferta: ");

        OfertaLaboral oferta = sistema.buscarOfertaEmpresa(idEmpresa, idOferta);

        if (oferta == null)
        {
            System.out.println("La oferta laboral no existe");
            return;
        }

        int opcion;

        do
        {
            System.out.println("\n===== GESTIÓN DE REQUISITOS =====");
            System.out.println("1. Agregar requisito");
            System.out.println("2. Eliminar requisito");
            System.out.println("3. Mostrar requisitos");
            System.out.println("0. Volver");

            opcion = lector.leerEntero("Seleccione una opción: ", 0, 3);
            switch (opcion)
            {
                case 1:
                    agregarRequisitoMenu(idEmpresa, idOferta);
                    break;

                case 2:
                    eliminarRequisitoMenu(idEmpresa, idOferta);
                    break;

                case 3:
                    mostrarRequisitosMenu(idEmpresa, idOferta);
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 0);
    }
    
    private void agregarRequisitoMenu(String idEmpresa, String idOferta)
    {
        String requisito = lector.leerString("Ingrese el requisito: ");

        sistema.agregarRequisitoOferta(idEmpresa, idOferta, requisito);
    }
    
    private void eliminarRequisitoMenu(String idEmpresa, String idOferta)
    {
        String requisito = lector.leerString("Ingrese el requisito a eliminar: ");

        sistema.eliminarRequisitoOferta(idEmpresa, idOferta, requisito);
    }
    
    private void mostrarRequisitosMenu(String idEmpresa, String idOferta)
    {
        sistema.mostrarRequisitosOferta(idEmpresa, idOferta);
    }
    
    private void buscarMejoresCandidatosMenu(String idEmpresa)
    {
        String idOferta = lector.leerString("Ingrese el identificador de la oferta: ");

        OfertaLaboral oferta = sistema.buscarOfertaEmpresa(idEmpresa, idOferta);

        if (oferta == null)
        {
            System.out.println("La oferta laboral no existe");
            return;
        }
    
        ArrayList<Trabajador> candidatos = sistema.buscarMejoresCandidatos(oferta);

        if (candidatos.isEmpty())
        {
            System.out.println("No se encontraron candidatos aptos");
            return;
        }

        System.out.println("\n===== MEJORES CANDIDATOS =====");

        for (Trabajador trabajador : candidatos)
        {
            double compatibilidad = sistema.calcularCompatibilidad(trabajador, oferta);

            System.out.println("ID: " + trabajador.getIdentificador());
            System.out.println("Nombre: " + trabajador.getNombre());
            System.out.println("Profesión: " + trabajador.getProfesion());
            System.out.println("Años de experiencia: " + trabajador.getAnyosExperiencia());

            System.out.println("Compatibilidad: " + compatibilidad + "%");

            System.out.println("-------------------");
        }
    }   
}