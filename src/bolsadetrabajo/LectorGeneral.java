package bolsadetrabajo;
import java.util.Scanner;
public class LectorGeneral {
    private Scanner lector;
    public LectorGeneral(Scanner scanner) {
        this.lector = scanner;
    }

    public int leerEntero(String texto, int min, int max){
        while(true){
            System.out.print(texto);

            try{
                int entero = Integer.parseInt(lector.nextLine());
                if(entero >= min && entero <= max) 
                    return entero;
                else
                    System.out.println("Por favor ingrese un valor entero tipo int mayor o igual a " + min + "y menor o igual a " + max);

            }
            catch(NumberFormatException e){
                System.out.println("Por favor ingrese un valor numérico int");
            }

        }
    }

    public int leerEntero(String texto, int min){
        while(true){
            System.out.print(texto);

            try{
                int entero = Integer.parseInt(lector.nextLine());
                if(entero >= min) 
                    return entero;
                else
                    System.out.println("Por favor ingrese un valor entero tipo int mayor o igual a " + min);

            }catch(NumberFormatException e){
                System.out.println("Por favor ingrese un valor numérico int");
            }

        }
    }
    public String leerString(String texto){
        System.out.print(texto);
        return lector.nextLine();
    }
}