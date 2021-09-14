
package Gui;

import Vehiculo.Vehiculo;
import Vehiculo.VehiculoGrande;
import Vehiculo.VehiculoMediano;
import Vehiculo.VehiculoPequeño;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Control extends JPanel{
    private PriorityQueue<Vehiculo> colaCarril;
    private PriorityQueue<Vehiculo> colaSecado;
    private PriorityQueue<Vehiculo> colaLavado;
    private PriorityQueue<Vehiculo>[] colaAspirado;
    private Comparador comparador;
    private int contadorCliente;
    
    public Control(){
      comparador=new Comparador();
      colaCarril= new PriorityQueue<Vehiculo>(10, (Comparator<? super Vehiculo>) comparador);
      colaSecado= new PriorityQueue<Vehiculo>();
      colaLavado= new PriorityQueue<Vehiculo>();
      colaAspirado=new PriorityQueue[4];
    }    

    /******Metodo de creacion de Vehiculo******/
    
    public Vehiculo crearVehiculo(String tamaño, String servicio, String prioridad, Color color){
      if(tamaño.equalsIgnoreCase("pequeño")){
        VehiculoPequeño vehiculo=new VehiculoPequeño(tamaño, servicio,prioridad,color, colaCarril.size());
        agregarCarril(vehiculo);
        return vehiculo;
      }else{
        if(tamaño.equalsIgnoreCase("mediano")){
          VehiculoMediano vehiculo=new VehiculoMediano(tamaño, servicio,prioridad,color, colaCarril.size());;
          agregarCarril(vehiculo);
          return vehiculo;
        }else{
          VehiculoGrande vehiculo=new VehiculoGrande(tamaño, servicio,prioridad,color,colaCarril.size());
          agregarCarril(vehiculo);
          return vehiculo;
        }
      }
    }
    
    
    /*Metodo para agregar Vehiculo a colaCarril.*/
    public void agregarCarril(Vehiculo vehiculo){
      if(colaCarril.size()<10){
        colaCarril.add(vehiculo);
        vehiculo.setNumerocliente(contadorCliente);
        contadorCliente++;
        JOptionPane.showMessageDialog(null,"Se proceso el servicio.");
      }else{
          JOptionPane.showMessageDialog(null,"La fila de espera esta llena.");
      }
    }
    
    public void dibujarVehiculo(PriorityQueue<Vehiculo> cola){
      if(!cola.isEmpty()){
        PriorityQueue<Vehiculo> aux;
        aux=cola;
        while(!cola.isEmpty()){
          dibujarVehiculo(aux.poll());
        }
      }
    }
    
    //*Mover vehiculo de carril a lavado, regresa un true si se proceso el moviemiento.
    public boolean moverLavado(Vehiculo vehiculo){
     if(colaLavado.size()<3){
       colaLavado.add(vehiculo);
       return true;
     }else return false;
    }
    
    /*Metodo para obtener el aspirado con menor autos.*/
    public int aspiradoDisp(){
      int ubicacion=0; int numeroMenor=5;
      for(int i=0;i<colaAspirado.length;i++){
        if(colaAspirado[i].size()<numeroMenor){
          numeroMenor=colaAspirado[i].size();
          ubicacion=i;
        }
      }
      return ubicacion;
    }
    
    /*Metodo para agregar vehiculo al respectivo servicio selecionado.*/
    public boolean irServicio(Vehiculo vehiculo){
      if(vehiculo.getServicio().equalsIgnoreCase("aspirado")){
        if(colaAspirado[aspiradoDisp()].size()<4){
          colaAspirado[aspiradoDisp()].add(vehiculo);
          return true;
        }else return false;
      }else{
        if(colaSecado.size()<5){
          colaSecado.add(vehiculo);
          return true;
        }else return false;
      }
    }
    
    /******Metodo para dibujar los vehiculo.******/
    
    private void dibujarVehiculo(Vehiculo vehiculo){
        Graphics g=getGraphics();
        Class clase = vehiculo.getClass();
        if(clase == VehiculoMediano.class ||
                clase == VehiculoPequeño.class ||
                clase == VehiculoGrande.class){
            vehiculo.dibujar(g);    
        }
    }
    


    /******SETTERS Y GETTERS******/
    public PriorityQueue<Vehiculo> getColaCarril() {
        return colaCarril;
    }

    public PriorityQueue<Vehiculo> getColaSecado() {
        return colaSecado;
    }

    public PriorityQueue<Vehiculo> getColaLavado() {
        return colaLavado;
    }

    public PriorityQueue<Vehiculo>[] getColaAspirado() {
        return colaAspirado;
    }
}
