import java.util.ArrayList;
import java.util.Scanner;

public class FuncionesCandidato {
    static ArrayList<Candidato> lista= new ArrayList<Candidato>();

    public static void crearCandidato(String[] args) throws Exception{
        
        boolean salir = true; 
        while(salir){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingresa el nombre: ");
            String nombreWhile = scanner.nextLine();
            
            System.out.println("ingrese la Identificación: ");
            String identificacion = scanner.nextLine();
            Ciudades ciudades[] = Ciudades.values();

            System.out.println("Estas son las ciudades: ");            
            for(Integer i=1; i <= ciudades.length ; i++){
                if (((i+1)%4)==0){
                System.out.print(i.toString() + ". " + ciudades[i-1] + "  \n" );
            }else {
                System.out.print(i.toString() + ". " + ciudades[i-1] + "       " );
            }
            }
            System.out.println();

            int variableswitch3;
            Ciudades ciudad = null; 
            do{
                System.out.println("ingrese el número de su ciudad de origen: ");
                variableswitch3 = scanner.nextInt();
                
                switch(variableswitch3){
                    case 1: ciudad = Ciudades.Cali;break;
                    case 2: ciudad = Ciudades.Buenaventura;break;
                    case 3: ciudad = Ciudades.Palmira;break;
                    case 4: ciudad = Ciudades.Tulua;break;
                    case 5: ciudad = Ciudades.Jamundi;break;
                    case 6: ciudad = Ciudades.Cartago;break;
                    case 7: ciudad = Ciudades.Zarzal;break;
                    case 8: ciudad = Ciudades.Candelaria;break;
                    case 9: ciudad = Ciudades.Pradera;break;
                    case 10: ciudad = Ciudades.Ginebra;break;
                    case 11: ciudad = Ciudades.Cerrito;break;
                    case 12: ciudad = Ciudades.Roldanillo;break;
                    case 13: ciudad = Ciudades.Launion;break;
                    case 14: ciudad = Ciudades.Sevilla;break;
                    case 15: ciudad = Ciudades.Buga;break;
                    case 16: ciudad = Ciudades.Guacari;break;
                    case 17: ciudad = Ciudades.Rozo;break;
                    case 18: ciudad = Ciudades.Caicedonia;break;
                    case 19: ciudad = Ciudades.Yumbo;break;
                    case 20: ciudad = Ciudades.Florida;break;
                    case 21: ciudad = Ciudades.Dagua;break;
                    default: System.out.println("Digite algo válido");
                }
            }while(variableswitch3 < 1 || variableswitch3 >21 );  
            
            Boolean posicion = false;
            Partido PartidoCan = null;
            int posi;

            do {
                System.out.println("ingrese 0 si es de derecha o 1 si es de Izquierda: ");
                posi = scanner.nextInt();
                if(posi == 0){
                posicion = true; /* se le asigna true cuando el candidato es de derecha */
                int variableswitch;
                do {
                    System.out.println("Estos son los partidos de derecha: ");
                    System.out.println("1. "+Partido.Conservador);
                    System.out.println("2. "+Partido.Centro_democratico);
                    System.out.println("3. "+Partido.Partido_cambio_radical);

                    variableswitch = scanner.nextInt(); 
                    switch(variableswitch){
                    case 1: PartidoCan = Partido.Conservador;break;
                    case 2: PartidoCan = Partido.Centro_democratico;break;
                    case 3: PartidoCan = Partido.Partido_cambio_radical;break;
                    default: System.out.println("Digíte un dato válido");break;
                    }
                
                } while (variableswitch < 1 || variableswitch > 3 );
                }         
                else if(posi == 1){
                    posicion = false; /* se le asigna false cuando el candidato es de izquierda */
                    int variableswitch2;
                    do {
                        System.out.println("Estos son los partidos de izquierda: ");
                        System.out.println("1. "+Partido.Liberal);
                        System.out.println("2. "+Partido.Alianza_verde);
                        variableswitch2 = scanner.nextInt();
                        
                        switch(variableswitch2){
                        case 1: PartidoCan = Partido.Liberal;break;
                        case 2: PartidoCan = Partido.Alianza_verde;break;
                        default: System.out.println("Digíte un dato válido");break;
                    }
                    } while (variableswitch2 < 1 || variableswitch2 > 2);
                    
                }else System.out.println("Dígite un numero válido");
                
            } while (posi > 1 || posi < 0);
            
            System.out.println("ingrese sus propuestas de campaña: ");
            scanner.nextLine();
            String propuestas = scanner.nextLine();
        
            Candidato candidato = new Candidato(nombreWhile, identificacion, ciudad , posicion, PartidoCan, propuestas);
            lista.add(candidato);
            System.out.println("si desea salir, ingrese 0: ");
            int continuar = scanner.nextInt();

            if(continuar==0)
                salir = false;
        }
    }
    public static void mostrarC(ArrayList<Candidato> lista2){
        lista2.forEach((i) ->{
            System.out.println("------------------------------------------------------------");
            System.out.println(i.getNombre());            
            System.out.println(i.getIdentificacion());            
            System.out.println(i.getCiudad_origen());            
            System.out.println(i.isDerecha());            
            System.out.println(i.getPartido_politico());            
            System.out.println(i.getPropuestas()); 
            System.out.println("\n");           
        });
    }
    public static void eliminarC(Scanner opc){
        System.out.println("Digite el nombre del candidato: ");
            String candidatoE = opc.nextLine();
            int posicion = 0;
            for(int i=0; i<FuncionesCandidato.lista.size(); i++){
                if(candidatoE.equals(FuncionesCandidato.lista.get(i).getNombre())){
                posicion = 1;
                }
            }
            if(posicion>0){
                FuncionesCandidato.lista.remove(posicion);
                System.out.println("El candidato se ha eliminado correctamente. ");
            }else{
                System.out.println("El candidato no fue encontrado. ");
            }
            

    }
}

