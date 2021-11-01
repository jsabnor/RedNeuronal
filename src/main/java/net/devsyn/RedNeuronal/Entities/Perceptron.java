package net.devsyn.RedNeuronal.Entities;

import java.util.Arrays;
import java.util.Random;

/**
 * Clase que define un Perceptron
 * Los pesos y el umbral estan comprendidos entre 0 y 1
 * @author Josema
 * @version1.0
 */
public class Perceptron {
    //ATRIBUTOS
    private Integer numEntradas;
    private Double[] entradas;
    private Double[] pesos;
    private Double umbral;
    private Integer numSalidas;
    private Double[] salidas;
    private boolean isEntrada;

    //CONSTRUCTORES

    /**
     * Constructor con el numero de entradas, salidas y si es entrada de datos(capa 0)
     * @param numEntradas numero de entrada del perceptron
     * @param numSalidas numero de salidas del perceptron
     * @param isEntrada es entrada de datos
     */
    public Perceptron(Integer numEntradas, Integer numSalidas, boolean isEntrada) {
        this.numEntradas = numEntradas;
        this.numSalidas = numSalidas;
        this.isEntrada = isEntrada;
        this.entradas=new Double[numEntradas];
        this.pesos=new Double[numEntradas];
        this.salidas=new Double[numSalidas];
        //Si es una entrada los pesos se ponen a 1 y el umbral a 0
        if(this.isEntrada==true){
            for(int i=0;i<pesos.length;i++){
                pesos[i]=Double.valueOf(1);
            }
            this.umbral= Double.valueOf(0);
        }
        //Generamos los pesos aleatorios
        this.calcularPesosRandom();
    }


    //METODOS

    /**
     * Metodo que calcula la salida
     * @param entradas array con las entradas
     * @param pesos array con los pesos
     * @return salida calculada conl la funcion de activacion
     */
    public Double calculoSalidas(Double[] entradas,Double[] pesos){
        Double resultado=Double.valueOf(0);
        Double sigmoide;
        for(int i=0; i<entradas.length;i++){
          resultado+=entradas[i]*pesos[i];
        }
        resultado+=this.umbral;
        System.out.println("Resultado:"+ resultado);
        sigmoide=calculaSigmoide(resultado);
        System.out.println("Sigmoide resultado:"+sigmoide);
        return sigmoide;
    }

    /**
     * Metodo que asigna el valor a las salidas
     */
    public void asignarSalidas(){
        for(int i=0;i<this.salidas.length;i++){
            this.salidas[i]=calculoSalidas(this.entradas, this.pesos);
            System.out.println(this.salidas[i]);
        }
    }

    /**
     * Metodo que genera un double random entre un minimo y un maximo
     * @param min numero mínimo
     * @param max numero máximo
     * @return random
     */
    public double randomDouble(int min, int max){
        double random;
        Random r=new Random();
        random=((double)(min+(max-min)))*r.nextDouble();
        return random;
    }

    /**
     * Función de activacion Sigmoide
     * @param salida salida obtenida antes de la funcion de activacion
     * @return funcion sigmoide de la salida
     */
    public double calculaSigmoide(double salida)
    {
        return (1/(1+Math.exp(-salida)));
    }

    /**
     * Metodo que calcula pesos aleatorios para las entradas
     */
    public void calcularPesosRandom(){
        for(int i=0;i<this.pesos.length;i++) {
            pesos[i] = randomDouble(0, 1);
        }
    }

    @Override
    public String toString() {
        return "Perceptron{" +
                "numEntradas=" + numEntradas +
                ", entradas=" + Arrays.toString(entradas) +
                ", pesos=" + Arrays.toString(pesos) +
                ", umbral=" + umbral +
                ", numSalidas=" + numSalidas +
                ", salidas=" + Arrays.toString(salidas) +
                ", isEntrada=" + isEntrada +
                '}';
    }

    //GETTER Y SETTER


    public Integer getNumEntradas() {
        return numEntradas;
    }

    public void setNumEntradas(Integer numEntradas) {
        this.numEntradas = numEntradas;
    }

    public Double[] getEntradas() {
        return entradas;
    }

    public void setEntradas(Double[] entradas) {
        this.entradas = entradas;
    }

    public Double[] getPesos() {
        return pesos;
    }

    public void setPesos(Double[] pesos) {
        this.pesos = pesos;
    }

    public Double getUmbral() {
        return umbral;
    }

    public void setUmbral(Double umbral) {
        this.umbral = umbral;
    }

    public Integer getNumSalidas() {
        return numSalidas;
    }

    public void setNumSalidas(Integer numSalidas) {
        this.numSalidas = numSalidas;
    }

    public Double[] getSalidas() {
        return salidas;
    }

    public void setSalidas(Double[] salidas) {
        this.salidas = salidas;
    }

    public boolean isEntrada() {
        return isEntrada;
    }

    public void setEntrada(boolean entrada) {
        isEntrada = entrada;
    }
}
