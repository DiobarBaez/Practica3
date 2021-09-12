
package Gui;

import Vehiculo.Vehiculo;
import Vehiculo.VehiculoGrande;
import Vehiculo.VehiculoMediano;
import Vehiculo.VehiculoPequeño;
import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Control extends JPanel{
    
    private PriorityQueue<Vehiculo> colaCarril;
    private PriorityQueue<Vehiculo> colaSecado;
    private PriorityQueue<Vehiculo> colaLavado;
    private PriorityQueue<Vehiculo>[] colaAspirado;
    
    public Control(){
      colaCarril= new PriorityQueue<Vehiculo>();
      colaSecado= new PriorityQueue<Vehiculo>();
      colaLavado= new PriorityQueue<Vehiculo>();
      colaAspirado=new PriorityQueue[4];
    }    


    /******METODO PARA DIBUJAR LOS VEHICULOS******/
    
    private void dibujarFigura(Vehiculo vehiculo, Graphics g){
        Class clase = vehiculo.getClass();
        if(clase == VehiculoMediano.class ||
                clase == VehiculoPequeño.class ||
                clase == VehiculoGrande.class){
            vehiculo.dibujar(g);
        }
    }
    
    
    /******METODOS PARA INGRESAR VEHICULO A CARRIL******/
    
    public void crearVehiculo(String tamaño, String servicio, String prioridad, Color color, Graphics g){
      Vehiculo vehiculo;
      if(tamaño.equalsIgnoreCase("pequeño")){
        vehiculo=new VehiculoPequeño(tamaño, servicio,prioridad,color);
        if(agregarCarril(vehiculo)){
          dibujarFigura(vehiculo, g);
        }
      }else{
        if(tamaño.equalsIgnoreCase("mediano")){
          vehiculo=new VehiculoMediano(tamaño, servicio,prioridad,color);
          agregarCarril(vehiculo);
          if(agregarCarril(vehiculo)){
            dibujarFigura(vehiculo, g);
          }
        }else{
          vehiculo=new VehiculoGrande(tamaño, servicio,prioridad,color);
          if(agregarCarril(vehiculo)){
           dibujarFigura(vehiculo, g);
          }
        }
      }
    }
    
    public boolean agregarCarril(Vehiculo vehiculo){
      if(colaCarril.size()<10){
        colaCarril.add(vehiculo);
        JOptionPane.showMessageDialog(null,"Se proceso el servicio.");
        return true;
      }else{
          JOptionPane.showMessageDialog(null,"La fila de espera esta llena.");
          return false;
      }
    }
    
    
    
}
