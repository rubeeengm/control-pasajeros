package ado;

import ado.Pasajero;
import ado.Pasajeros;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;
import java.util.Scanner;

public class Principal{
    private static Pasajeros lista = null;
    private static boolean cambios;
    private static Scanner teclado = new Scanner(System.in);
    private static float total = 0;
 
    public static void main(String[] args) throws IOException{
        leer();
        operaciones();
        escribir();
    }
 
    public static void leer() throws IOException{
        ObjectInputStream ois = null;
        
        try{
            File fichero = new File("ado.txt");
            
            if (!fichero.exists()){
                lista = new Pasajeros();
                System.out.println("Archivo Nuevo");
            } 
            
            else {
                ois = new ObjectInputStream(new FileInputStream("ado.txt"));
                lista = (Pasajeros) ois.readObject();
                System.out.println("Ya existe");
            }
        }
        
        catch(ClassNotFoundException e){
            System.out.println("Error: " + e.toString());
        }
        
        catch (IOException e){
            System.out.println("Error: " + e.toString());
        }
        
        finally{
            try{
                if(ois != null){
                    ois.close();
                }
            }
            
            catch (IOException e){
                
            }
        }
    }
 
    public static void operaciones() {
        int opc;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
 
        int posi = -1;
        int id = 0;
        String nombre;
        String apellido;
        String sexoTemporal;
        char sexo;
        int edad = 0;
        String destino = null;
        float costoViaje = 0;
        int numViaje;
        boolean eliminado = false;
        boolean error;
        boolean salir = false;
        Random md = new Random();
 
        try{
            do{
                System.out.println("\nREGISTRO DE PASAJEROS DE ADO\n");
                System.out.println("1. Agregar Pasajeros");
                System.out.println("2. Eliminar Pasajeros");
                System.out.println("3. Ver registro de pasajeros");
                System.out.println("4. Ver lista de destinos");
                System.out.println("5. Ganancias actuales");
                System.out.println("6. Salir");
                
                do{
                    System.out.print("\nIngrese la opcion deseada: ");
                    opc = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
                    
                    if(opc > 0 && opc <7){
                        salir = true;
                    }
                    
                    else{
                        System.out.println("Opcion ingresada erronea, verificala por favor");
                    }
                }while(salir == false);
                    
                switch (opc){
                    //AGREGAR PASAJEROS
                    case 1:
                        //VALIDA EL ID
                        do{
                            error = false;
                            
                            try{
                                System.out.print("\nIngresa un ID para identificarte: ");
                                id = Integer.parseInt(br.readLine());
                            }
                        
                            catch(NumberFormatException ne){
                                System.out.println("Error*** valor incorrecto" + " (Solo numeros)");
                                error = true;
                            }
                        }while(error);

                        System.out.print("Nombres: ");
                        nombre = br.readLine();
                        System.out.print("Apellidos: ");
                        apellido = br.readLine();
                        
                        salir = false;
                        
                        do{
                            System.out.print("Sexo (H/M): ");
                            sexoTemporal = br.readLine();
                            sexo = sexoTemporal.charAt(0);
                            
                            if(sexo == 'H' || sexo == 'h' || sexo == 'M' || sexo == 'm'){
                                salir = true;
                            }
                            
                            else{
                                System.out.println("Opcion ingresada erronea, verificala por favor");
                            }
                        }while(salir == false);
                        
                        //VALIDA LA EDAD
                        do{
                            error = false;
                            
                            try{
                                System.out.print("Edad: ");
                                edad = Integer.parseInt(br.readLine());
                            } 
                            
                            catch(NumberFormatException ne){
                                System.out.println("Error*****" + " (Solo Numeros)");
                                error = true;
                            }
                        }while(error);

                            
                             
                        boolean salirOpc = false;
                            
                        do{ 
                            System.out.print("Desea ver la lista de destinos disponibles (S/N): ");
                            String resp = br.readLine();
                            char resp1 = resp.charAt(0);
                            
                            if(resp1 == 's' || resp1 == 'S'){
                                imprimirDestino();
                            }
                                
                            System.out.print("Clave de Destino: ");
                            int destino1 = Integer.parseInt(br.readLine());
                                
                            switch(destino1){
                                case 101:
                                    destino = "Veracruz";
                                    costoViaje = 50;
                                    salirOpc = true;
                                break;
                                        
                                case 202:
                                    destino = "Xalapa";
                                    costoViaje = 170;
                                    salirOpc = true;
                                break;
                                        
                                case 303:
                                    destino = "Cordoba";
                                    costoViaje = 200;
                                    salirOpc = true;
                                break;
                                        
                                case 404:
                                    destino = "Coatzacoalcos";
                                    costoViaje = 500;
                                    salirOpc = true;
                                break;
                                    
                                case 505:
                                    destino = "Papantla";
                                    costoViaje = 350;
                                    salirOpc = true;
                                break;
                                        
                                case 606:
                                    destino = "Poza Rica";
                                    costoViaje = 300;
                                    salirOpc = true;
                                break;
                                    
                                case 707:
                                    destino = "Catemaco";
                                    costoViaje = 200;
                                    salirOpc = true;
                                break;
                                        
                                case 808:
                                    destino = "Tuxpan";
                                    costoViaje = 200;
                                    salirOpc = true;
                                break;
                                        
                                case 909:
                                    destino = "Orizaba";
                                    costoViaje = 300;
                                    salirOpc = true;
                                break;
                                        
                                case 110:
                                    destino = "Cardel";
                                    costoViaje = 100;
                                    salirOpc = true;
                                break;
                                        
                                default:
                                    System.out.println("Opcion ingresada erronea, verificala por favor");
                                break;
                            }
                        }while(salirOpc == false);
                        
                        numViaje = (int) (md.nextDouble()*10000+1000);
 
                        lista.agregar(new Pasajero(id,nombre,apellido,sexo,edad,destino,costoViaje,numViaje));
                        cambios = true;
                        calcGanancias(costoViaje);
                    break;
                        
                    //ELIMINAR PASAJEROS
                    case 2:
                        do{
                            error = false;
                            
                            try{
                                System.out.print("\nIngrese el ID del pasajero que desea borrar: ");
                                id = Integer.parseInt(br.readLine());
                            } 
                            
                            catch (NumberFormatException ne){
                                System.out.println("\nError***" + " (Solo Numeros)");
                                error = true;
                            }
                        }while(error);
                        
                        eliminado = lista.eliminar(id);
                        
                        if(eliminado){
                            System.out.println("\nRegistro eliminado con exito!");
                            cambios = true;
                        } 
                        
                        else{
                            if(lista.longitud() != 0){
                                System.out.println("\nNo se Encuentra");
                            } 
                            
                            else{
                                System.out.println("\nArchivo vacio");
                            }
                        }
                    break;
                        
                    //VER REGISTROS
                    case 3: 
                        do{
                            error = false;
                            
                            try{
                                System.out.print("\nIngrese el ID que desea ver: ");
                                id = Integer.parseInt(br.readLine());
                            }
                        
                            catch(NumberFormatException ne){
                                System.out.println("Error*****" + " (Solo Numeros)");
                            error = true;
                            }
                        }while(error);
                        
                        posi = lista.buscar(id);
                        
                        if(posi == -1){
                            if (lista.longitud() != 0){
                                System.out.println("\nNo se Encuentra");
                            } 
                            
                            else{
                                System.out.println("\nArchivo vacio");
                            }
                        } 
                        
                        else{
                            lista.elemento(posi).imprimir();
                        }
                    break;
                    
                    case 4:
                        imprimirDestino();
                    break;
                        
                    case 5:
                        System.out.println("\nLas Ganancias de los movimientos realizados este dia son: $"+calcGanancias(0));
                    break;
                        
                    case 6:
                        System.out.println("BYE!");
                    break;
                        
                }
            }while (opc != 6);
        } 
        
        catch(IOException e){
            
        }
    }

    public static void escribir(){
        ObjectOutputStream ous = null;
 
        try{
            if(cambios){
                ous = new ObjectOutputStream(new FileOutputStream("ado.txt"));
                ous.writeObject(lista);
            }
            
            lista = null;
        }
        
        catch (IOException e){
            System.out.println("Error: " + e.toString());
        }
        
        finally{
            try{
                if(ous != null){
                    ous.close();
                }
            }
            
            catch (IOException e){
                
            }
        }
    }
    
    public static void imprimirDestino(){
        System.out.println("");
        System.out.println("CLAVE       DESTINO         PRECIO");
        System.out.println("101---------VERACRUZ--------$50");
        System.out.println("202---------XALAPA----------$170");
        System.out.println("303---------CORDOBA---------$200");
        System.out.println("404---------COATZACOALCOS---$500");
        System.out.println("505---------PAPANTLA--------$350");
        System.out.println("606---------POZA RICA-------$300");
        System.out.println("707---------CATEMACO--------$200");
        System.out.println("808---------TUXPAN----------$200");
        System.out.println("909---------ORIZABA---------$300");
        System.out.println("110---------CARDEL----------$100");
        System.out.println("");
    }
    
    public static float calcGanancias(float monto){
        return total = total + monto;
    }
}