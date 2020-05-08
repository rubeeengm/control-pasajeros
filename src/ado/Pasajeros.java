package ado;

import java.io.Serializable;

public class Pasajeros implements Serializable {
    private Pasajero[] pasajeros;
    private int tamaño;
 	
    public Pasajeros(){
        tamaño = 0;
        pasajeros = inicializar(tamaño);
    }
 
    private Pasajero[] inicializar(int nElementos){
        try{
            return new Pasajero[nElementos];
        }catch (OutOfMemoryError e){
            System.out.println(e.toString());
            return pasajeros;
        }
    }
    
    public Pasajero elemento(int i){
        if(i >= 0 && i < tamaño){
            return pasajeros[i];	
        } 
        
        else{
            System.out.println("No hay elementos en esa posicion");
            return null;
        }
    }
 
    public int longitud(){
        return pasajeros.length;
    }
 
    public void agregar(Pasajero unEmpleado){
        Pasajero[] copiaDeLista;
        copiaDeLista = pasajeros;
        tamaño = copiaDeLista.length;
        pasajeros = inicializar(tamaño + 1);
        
        for(int i = 0; i < tamaño; i++){
            pasajeros[i] = copiaDeLista[i];
        }
        
        pasajeros[tamaño] = unEmpleado;
        tamaño++;
    }
 
    public boolean eliminar(int cod){
        Pasajero[] copiaDeLista;
        int posi = buscar(cod);
        
        if(posi != -1){
            pasajeros[posi] = null;
            copiaDeLista = pasajeros;
            
            if(copiaDeLista.length != 0){
                tamaño = copiaDeLista.length;
                pasajeros = inicializar(tamaño - 1);
                
                for(int i = 0; i < tamaño; i++){
                    if(copiaDeLista[i] != null){
                        pasajeros[i] = copiaDeLista[i];
                    }
                }
                
                tamaño--;
                return true;
            }
        }
        return false;
    }
 
    public int buscar(int id) {
        int posi = -1;
        
        for (int i = 0; i < tamaño; i++) {
            if (pasajeros[i].getId() == id) {
                posi = i;
            }
        }
        return posi;
    }
}