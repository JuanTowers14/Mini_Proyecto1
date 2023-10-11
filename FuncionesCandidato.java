import java.util.ArrayList;
import java.util.Scanner;

public class FuncionesCandidato {
    static ArrayList<Candidato> lista= new ArrayList<Candidato>();
    static int indice;
    static int validar = 0;
    static int mas_votos = 0; 
    static Candidato ganador = null;

    static void pressEnterToContinue(){ 
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press Enter key to continue...");
        try{
            System.in.read();
            scanner.nextLine();
            }
        catch(Exception e)
        {}
    }
    public static void crearCandidato(String[] args) throws Exception{
        
        boolean salir = true; 
        while(salir){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingresa el nombre: ");
            String nombreWhile = scanner.nextLine();
            System.out.print("\033c");
            
            System.out.println("Ingrese la Identificación: ");
            String identificacion = scanner.nextLine();
            Ciudades ciudades[] = Ciudades.values();
            System.out.print("\033c");

            System.out.println("Estas son las ciudades: ");  
            System.out.println("-------------------------------------------------------------------------------");          
            for(Integer i=1; i <= ciudades.length ; i++){
                if (((i+1)%4)==0){    
                    System.out.print(i.toString() + ". " + ciudades[i-1] + "\t\t\n" );
                }else {
                    System.out.print(i.toString() + ". " + ciudades[i-1] + "\t\t" );
            }
            }
            System.out.println("\n-------------------------------------------------------------------------------\n"); 

            int variableswitch3;
            Ciudades ciudad = null; 
            do{
                System.out.println("ingrese el número de su ciudad de origen: ");
                variableswitch3 = scanner.nextInt();
                System.out.print("\033c");
                
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
                    default: System.out.println("ERROR. Digite algo válido");
                }
            }while(variableswitch3 < 1 || variableswitch3 >21 );  
            
            Boolean posicion = false;
            Partido PartidoCan = null;
            int posi;

            do {
                System.out.println("ingrese 0 si es de derecha o 1 si es de Izquierda: ");
                posi = scanner.nextInt();
                System.out.print("\033c");
                if(posi == 0){
                posicion = true; /* se le asigna true cuando el candidato es de derecha */
                int variableswitch;
                do {
                    System.out.println("Estos son los partidos de derecha: ");
                    System.out.println("1. "+Partido.Conservador);
                    System.out.println("2. "+Partido.Centro_democratico);
                    System.out.println("3. "+Partido.Partido_cambio_radical);
                    variableswitch = scanner.nextInt(); 
                    System.out.print("\033c");

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
                        System.out.print("\033c");
                        
                        switch(variableswitch2){
                        case 1: PartidoCan = Partido.Liberal;break;
                        case 2: PartidoCan = Partido.Alianza_verde;break;
                        default: System.out.println("Digíte un dato válido");break;
                    }
                    } while (variableswitch2 < 1 || variableswitch2 > 2);
                    
                }else System.out.println("Dígite un numero válido");
                
            } while (posi > 1 || posi < 0);
            
            System.out.println("Ingrese sus propuestas de campaña: ");
            scanner.nextLine();
            String propuestas = scanner.nextLine();
            System.out.print("\033c");
        
            Candidato candidato = new Candidato(nombreWhile, identificacion, ciudad , posicion, PartidoCan, propuestas);
            lista.add(candidato);
            System.out.println("Si desea salir, ingrese 0: ");
            int continuar = scanner.nextInt();
            System.out.print("\033c");

            if(continuar==0)
                salir = false;
        }
    }

    public static void mostrarCandidato(ArrayList<Candidato> lista2){
        Scanner scanner = new Scanner(System.in);
        lista2.forEach((i) ->{
            String posiToF = null;
            if(i.isDerecha()==true){
                    posiToF = "Derecha";
                }
            else if(i.isDerecha()==false){
                    posiToF = "Izquierda";
                }
            System.out.println("------------------------------------------------------------");
            System.out.println(i.getNombre());            
            System.out.println(i.getIdentificacion());            
            System.out.println(i.getCiudad_origen());            
            System.out.println(posiToF);            
            System.out.println(i.getPartido_politico());            
            System.out.println(i.getPropuestas()); 
            System.out.println("\n");
            System.out.println("\n"); 
        });
    } 

    public static void buscarCandidato(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa el nombre del candidato a buscar: ");
        String buscado = scanner.nextLine();
        System.out.print("\033c");
        
        lista.forEach((i)->{
            
            if(i.getNombre().contains(buscado)){
                String posiToF = null;
                if(i.isDerecha()==true){
                    posiToF = "Derecha";
                }
                else if(i.isDerecha()==false){
                    posiToF = "Izquierda";
                }
                System.out.println("------------------------------------------------------------");
                System.out.println(i.getNombre());            
                System.out.println(i.getIdentificacion());            
                System.out.println(i.getCiudad_origen());            
                System.out.println(posiToF);            
                System.out.println(i.getPartido_politico());            
                System.out.println(i.getPropuestas()); 
                System.out.print("\n");
            }
        });
    }

    public static void actualizarCandidato(){
        Scanner scanner = new Scanner(System.in);
        
        do{     
        System.out.print("Ingresa la cédula del candidato a actualizar: ");
        String buscado = scanner.nextLine();
        System.out.print("\033c");

        lista.forEach((i)->{
            if(i.getIdentificacion().equals(buscado)){
                indice = lista.indexOf(i);
                validar = 1;
            }
        });
        if(validar!=1){
            System.out.println("Candidato no encontrado, por favor vuelva a intentar");
        }
        }while(validar != 1);
        int opc1 = 2;
        while(validar != 0 || opc1<1 || opc1>4){
        String posiToF = null;
        if(lista.get(indice).isDerecha()){
                        posiToF = "Derecha";
                    }
                else{
                        posiToF = "Izquierda";
                    } 
                System.out.println("------------------------------------------------------------");
                System.out.println("Nombre:     1.    \t"+lista.get(indice).getNombre());            
                System.out.println("Cedula:           \t"+lista.get(indice).getIdentificacion()+"\t(No permitido)");            
                System.out.println("Ciudad de origen: \t"+lista.get(indice).getCiudad_origen()+"\t(No permitido)");            
                System.out.println("Posición:   2.    \t"+posiToF);            
                System.out.println("Partido:    3.    \t"+lista.get(indice).getPartido_politico());            
                System.out.println("Propuestas: 4.    \t"+lista.get(indice).getPropuestas()); 
                System.out.println("\n");
        System.out.println("Ingrese el número del atributo a cambiar: ");
        opc1 = scanner.nextInt();
        scanner.nextLine();
        System.out.print("\033c");

        switch(opc1){
            case 1: System.out.println("Ingrese el nuevo nombre: ");          
                    String nombreA = scanner.nextLine();
                    System.out.print("\033c");

                    lista.get(indice).setNombre(nombreA);
                    break;
            case 2: if(lista.get(indice).isDerecha()==true){
                        lista.get(indice).setDerecha(false);
                        int variableswitch4;
                            do {
                                System.out.println("Su posición será cambiada a izquierda");
                                System.out.println("Estos son los partidos de izquierda: ");
                                System.out.println("1. "+Partido.Liberal);
                                System.out.println("2. "+Partido.Alianza_verde);
                                variableswitch4 = scanner.nextInt();
                                System.out.print("\033c");
                                
                                switch(variableswitch4){
                                case 1: lista.get(indice).setPartido_politico(Partido.Liberal);break;
                                case 2: lista.get(indice).setPartido_politico(Partido.Alianza_verde);break;
                                default: System.out.println("Digíte un dato válido");break;
                            }
                            }while(variableswitch4 < 1 || variableswitch4 > 2);
                    }
                    else{
                        lista.get(indice).setDerecha(true);
                        int variableswitch3;
                        do {
                            System.out.println("Su posición será cambiada a derecha");
                            System.out.println("Estos son los partidos de derecha: ");
                            System.out.println("1. "+Partido.Conservador);
                            System.out.println("2. "+Partido.Centro_democratico);
                            System.out.println("3. "+Partido.Partido_cambio_radical);

                            variableswitch3 = scanner.nextInt(); 
                            System.out.print("\033c");
                            switch(variableswitch3){
                            case 1: lista.get(indice).setPartido_politico(Partido.Conservador);break;
                            case 2: lista.get(indice).setPartido_politico(Partido.Centro_democratico);break;
                            case 3: lista.get(indice).setPartido_politico(Partido.Partido_cambio_radical);break;
                            default: System.out.println("Digíte un dato válido");break;
                            }
                        }while(variableswitch3<1 ||  variableswitch3>3);
                    }
                    System.out.println("Posición política cambiada");
                    break;
            case 3: if(lista.get(indice).isDerecha()==true){
                        int variableswitch;
                        do {
                            System.out.println("Estos son los partidos de derecha: ");
                            System.out.println("1. "+Partido.Conservador);
                            System.out.println("2. "+Partido.Centro_democratico);
                            System.out.println("3. "+Partido.Partido_cambio_radical);

                            variableswitch = scanner.nextInt(); 
                            System.out.print("\033c");
                            switch(variableswitch){
                            case 1: lista.get(indice).setPartido_politico(Partido.Conservador);break;
                            case 2: lista.get(indice).setPartido_politico(Partido.Centro_democratico);break;
                            case 3: lista.get(indice).setPartido_politico(Partido.Partido_cambio_radical);break;
                            default: System.out.println("Digíte un dato válido");break;
                            }
                        }while(variableswitch<1 ||  variableswitch>3);
                        }else{
                            int variableswitch2;
                            do {
                                System.out.println("Estos son los partidos de izquierda: ");
                                System.out.println("1. "+Partido.Liberal);
                                System.out.println("2. "+Partido.Alianza_verde);
                                variableswitch2 = scanner.nextInt();
                                System.out.print("\033c");
                                
                                switch(variableswitch2){
                                case 1: lista.get(indice).setPartido_politico(Partido.Liberal);break;
                                case 2: lista.get(indice).setPartido_politico(Partido.Alianza_verde);break;
                                default: System.out.println("Digíte un dato válido");break;
                            }
                            }while(variableswitch2 < 1 || variableswitch2 > 2);
                        }
                    break;
            case 4: System.out.println("Ingrese las nuevas propuestas: ");
                    String propuestA = scanner.nextLine();
                    System.out.print("\033c");
                    lista.get(indice).setPropuestas(propuestA);
                    break;
            default: System.out.println("Dígite algo válido: ");
                     break;
                    }
            validar = 0;
        }
                         
    }

    public static void eliminarCandidato(){
         Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa la cédula del candidato a eliminar: ");
        String buscado = scanner.nextLine();
        System.out.print("\033c");

        for(int i = 0; i < FuncionesCandidato.lista.size(); i++){
            if(FuncionesCandidato.lista.get(i).getIdentificacion().equals(buscado)){
                FuncionesCandidato.lista.remove(i);
            }
        }

    }
    public static void asignarVotos(){
        Scanner scanner = new Scanner(System.in);

        lista.forEach((i)->{
            System.out.println("Asigna la cantidad de votos para el candidato "+ i.getNombre());
            int votos = scanner.nextInt();
            i.setNumero_votos(votos);
            if(votos > mas_votos){
                ganador = i;
                mas_votos = votos;
            }
                
        });
    }
}

