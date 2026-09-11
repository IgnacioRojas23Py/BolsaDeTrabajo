package bolsadetrabajo;

import java.io.*;
import java.util.Scanner;

public class BolsaDeTrabajo {

    public static void main(String[] args)
    { 
        SistemaBolsaDeTrabajo sistema = new SistemaBolsaDeTrabajo();
        Scanner scanner = new Scanner(System.in);
        LectorGeneral lector = new LectorGeneral(scanner);

        // =========================
        // DATOS INICIALES
        // =========================

        Empresa empresa1 = new Empresa(
            "E001",
            "Tech Solutions",
            "contacto@techsolutions.cl",
            "912345678",
            "Tecnología",
            "Santiago",
            "www.techsolutions.cl",
            "Empresa dedicada al desarrollo de software"
        );

        Empresa empresa2 = new Empresa(
            "E002",
            "Servicios Digitales",
            "contacto@digital.cl",
            "923456789",
            "Tecnología",
            "Valparaíso",
            "www.serviciosdigitales.cl",
            "Empresa de soluciones digitales"
        );

        Empresa empresa3 = new Empresa(
            "E003",
            "Innovación Global",
            "contacto@innovacion.cl",
            "934567890",
            "Consultoría",
            "Concepción",
            "www.innovacionglobal.cl",
            "Empresa dedicada a servicios de consultoría"
        );

        Trabajador trabajador1 = new Trabajador(
            "T001",
            "Juan Pérez",
            "juan@email.com",
            "945678901",
            28,
            "Masculino",
            "Ingeniero Informático",
            4
        );

        trabajador1.agregarCompetencia("Java");
        trabajador1.agregarCompetencia("SQL");
        trabajador1.agregarCompetencia("Git");

        Trabajador trabajador2 = new Trabajador(
            "T002",
            "María González",
            "maria@email.com",
            "956789012",
            30,
            "Femenino",
            "Ingeniero Informático",
            6
        );

        trabajador2.agregarCompetencia("Java");
        trabajador2.agregarCompetencia("Python");
        trabajador2.agregarCompetencia("SQL");
        trabajador2.agregarCompetencia("Git");

        Trabajador trabajador3 = new Trabajador(
            "T003",
            "Carlos Soto",
            "carlos@email.com",
            "967890123",
            25,
            "Masculino",
            "Diseñador Gráfico",
            2
        );

        trabajador3.agregarCompetencia("Photoshop");
        trabajador3.agregarCompetencia("Illustrator");

        OfertaLaboral oferta1 = new OfertaLaboral(
            "O001",
            "Desarrollador Java",
            "Desarrollo de aplicaciones empresariales",
            1200000,
            "Híbrido",
            "Ingeniero Informático"
        );

        oferta1.agregarRequisito("Java");
        oferta1.agregarRequisito("SQL");
        oferta1.agregarRequisito("Git");

        OfertaLaboral oferta2 = new OfertaLaboral(
            "O002",
            "Desarrollador Backend",
            "Desarrollo de servicios y sistemas",
            1300000,
            "Remoto",
            "Ingeniero Informático"
        );

        oferta2.agregarRequisito("Java");
        oferta2.agregarRequisito("SQL");
        oferta2.agregarRequisito("Python");

        // =========================
        // CARGAR DATOS
        // =========================

        try
        {
            sistema.cargarDatos();
            System.out.println("Datos cargados correctamente.");
        }
        catch (IOException e)
        {
            System.out.println("No se pudieron cargar los datos.");
        }

        // =========================
        // AGREGAR DATOS INICIALES
        // SOLO SI EL SISTEMA ESTA VACIO
        // =========================

        if (!sistema.hayDatos())
        {
            System.out.println("Sistema vacío. Agregando datos iniciales.");

            try
            {
                sistema.agregarEmpresa(empresa1);
                sistema.agregarEmpresa(empresa2);
                sistema.agregarEmpresa(empresa3);

                sistema.agregarTrabajador(trabajador1);
                sistema.agregarTrabajador(trabajador2);
                sistema.agregarTrabajador(trabajador3);

                sistema.agregarOfertaEmpresa("E001", oferta1);
                sistema.agregarOfertaEmpresa("E002", oferta2);
            }
            catch (EmpresaExistente e)
            {
                System.out.println(e.getMessage());
            }
            catch (TrabajadorExistente e)
            {
                System.out.println(e.getMessage());
            }

            System.out.println("Datos iniciales agregados.");
        }
        else
        {
            System.out.println("Ya existen datos. No se agregan datos iniciales.");
        }

        // =========================
        // SELECCIONAR MODO DE USO
        // =========================

        System.out.println("SISTEMA BOLSA DE TRABAJO INICIO");
        System.out.println("1. USAR CONSOLA");
        System.out.println("2. USAR MODO VENTANA");

        int opcion = lector.leerEntero(
            "Elija una opción",
            1,
            2
        );

        if (opcion == 1)
        {
            MenuAcceso menu = new MenuAcceso(sistema, lector);
            menu.iniciar();

            try
            {
                sistema.guardarDatos();
                System.out.println("Datos guardados correctamente.");
            }
            catch (IOException e)
            {
                System.out.println("No se pudieron guardar los datos.");
            }
        }
        else
        {
            VentanaGeneral ventana = new VentanaGeneral(sistema);
            ventana.setVisible(true);
        }
    }
}