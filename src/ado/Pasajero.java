package ado;

public class Pasajero implements java.io.Serializable {
    private int id;
    private String nombre;
    private String apellido;
    private char sexo;
    private int edad;
    private String destino;
    private int numViaje;
    private float costoViaje;

    public Pasajero() {
        super();
    }

    public Pasajero(int id, String nombre, String apellido, char sexo, int edad, String destino, float costoViaje, int numViaje) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.edad = edad;
        this.destino = destino;
        this.costoViaje = costoViaje;
        this.numViaje = numViaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public float getCostoViaje() {
        return costoViaje;
    }

    public void setCostoViaje(float costoViaje) {
        this.costoViaje = costoViaje;
    }

    public int getNumViaje() {
        return numViaje;
    }

    public void setNumViaje(int numViaje) {
        this.numViaje = numViaje;
    }
    
    public void imprimir(){
        System.out.println();
        System.out.println("Nombre:          "+getNombre()+" "+getApellido());
        System.out.println("ID:              "+getId());
        System.out.println("Sexo:            "+getSexo());
        System.out.println("Edad:            "+getEdad());
        System.out.println("Destino:         "+getDestino());
        System.out.println("Costo de viaje:  $"+getCostoViaje());
        System.out.println("Numero de viaje: "+getNumViaje());
        System.out.println("");
    }
}