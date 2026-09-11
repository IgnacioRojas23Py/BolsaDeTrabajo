package bolsadetrabajo;

import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class PersistenciaCSV {
    public static void registrarTrabajadoresCSV(ArrayList<Trabajador> trabajadores, String rutaArchivo)throws IOException{
       BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo));
       for(Trabajador trabajador : trabajadores){
           String infoTrabajador = trabajador.getIdentificador()+ ";" + trabajador.getNombre() + ";" + trabajador.getCorreo() + ";" + trabajador.getTelefono() + ";" + trabajador.getEdad() + ";" + trabajador.getSexo() + ";" + trabajador.getProfesion() + ";" + trabajador.getAnyosExperiencia();
       
            ArrayList<String> competencias = trabajador.getCompetencias();
            String infoCompetencias = "";

            for(int i = 0; i < competencias.size(); i++){
                infoCompetencias = infoCompetencias + competencias.get(i);
                if(i < competencias.size() - 1){
                    infoCompetencias = infoCompetencias + "|";
                }
         
            }
            infoTrabajador += ";" + infoCompetencias;
            writer.write(infoTrabajador);
            writer.newLine();
        }
       writer.close();
    }
    public static ArrayList<Trabajador> cargarTrabajadoresCSV(String rutaArchivo) throws IOException{
        ArrayList<Trabajador> listaTrabajadores = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));
        
        String linea;
        while(true){
            linea = reader.readLine();
            if(linea == null) break;
            
            String datos[] = linea.split(";", -1);
            
            String identificador = datos[0];
            String nombre = datos[1];
            String correo = datos[2];
            String telefono = datos[3];
            int edad = Integer.parseInt(datos[4]);
            String sexo = datos[5];
            String profesion = datos[6];
            int anyosExperiencia = Integer.parseInt(datos[7]);
            String competencias = datos[8];
            
            Trabajador trabajador = new Trabajador(identificador, nombre, correo, telefono, edad, sexo, profesion, anyosExperiencia);

            if (!competencias.isEmpty())
            {
                String listaCompetencias[] = competencias.split("\\|");

                for(String competencia : listaCompetencias)
                {
                    trabajador.agregarCompetencia(competencia);
                }
            }
            listaTrabajadores.add(trabajador);
        }
        
        reader.close();
        return listaTrabajadores;
    }
    public static void registrarEmpresasCSV(ArrayList<Empresa> empresas, String rutaArchivo)throws IOException{
       BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo));
       for(Empresa empresa : empresas){
           String infoEmpresa = empresa.getIdentificador()+ ";" + empresa.getNombre() + ";" + empresa.getCorreo() + ";" + empresa.getTelefono() + ";" + empresa.getSector() + ";" + empresa.getDireccion() + ";" + empresa.getSitioWeb() + ";" + empresa.getDescripcionEmpresa();

            writer.write(infoEmpresa);
            writer.newLine();
        }
       writer.close();
    }
    public static ArrayList<Empresa> cargarEmpresasCSV(String rutaArchivo) throws IOException{
        ArrayList<Empresa> listaEmpresas = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));
        
        String linea;
        while(true){
            linea = reader.readLine();
            if(linea == null) break;
            
            String datos[] = linea.split(";", -1);
            
            String identificador = datos[0];
            String nombre = datos[1];
            String correo = datos[2];
            String telefono = datos[3];
            String sector = datos[4];
            String direccion = datos[5];
            String sitioWeb = datos[6];
            String descripcion = datos[7];
            
            Empresa empresa = new Empresa(identificador, nombre, correo, telefono, sector, direccion, sitioWeb, descripcion);
            listaEmpresas.add(empresa);
        } 
        reader.close();
        return listaEmpresas;
    }
    public static void registrarOfertasCSV(ArrayList<Empresa> empresas, String rutaArchivo) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo));

        for(Empresa empresa : empresas){
            for(OfertaLaboral oferta : empresa.getOfertas()){
                String infoOferta = oferta.getId() + ";" + empresa.getIdentificador() + ";" + oferta.getCargo() + ";" + oferta.getDescripcion() + ";" + oferta.getSalario() + ";" + oferta.getModalidad() + ";" + oferta.getProfesionRequerida();

                ArrayList<String> requisitos = oferta.getRequisitos();
                String infoRequisitos = "";

                for(int i = 0; i < requisitos.size(); i++){
                    infoRequisitos = infoRequisitos + requisitos.get(i);
                    if(i < requisitos.size() - 1){
                        infoRequisitos = infoRequisitos + "|";
                    }
                }

                infoOferta += ";" + infoRequisitos;
                writer.write(infoOferta);
                writer.newLine();
            }
        }
        writer.close();
    }
        public static void cargarOfertasCSV(SistemaBolsaDeTrabajo sistema, String rutaArchivo) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));

        String linea;
        while(true){
            linea = reader.readLine();
            if(linea == null) break;

            String datos[] = linea.split(";", -1);

            String idOferta = datos[0];
            String idEmpresa = datos[1];
            String cargo = datos[2];
            String descripcion = datos[3];
            int salario = Integer.parseInt(datos[4]);
            String modalidad = datos[5];
            String profesionRequerida = datos[6];
            String requisitos = datos[7];

            OfertaLaboral oferta = new OfertaLaboral(idOferta, cargo, descripcion, salario, modalidad, profesionRequerida);

            if (!requisitos.isEmpty())
            {
                String listaRequisitos[] = requisitos.split("\\|");

                for(String requisito : listaRequisitos)
                {
                    oferta.agregarRequisito(requisito);
                }
            }

            sistema.agregarOfertaEmpresa(idEmpresa, oferta);
        }

        reader.close();
    }
}
