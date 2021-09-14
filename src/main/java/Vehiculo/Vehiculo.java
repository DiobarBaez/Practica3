package Vehiculo;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Vehiculo {
   protected String tamaño;
   protected String servicio;
   protected String prioridad;
   protected Color color;
   protected int tiempo;
   protected int numerocliente;

  /******CONSTRUCTORES*******/
  
  public Vehiculo(String tamaño, String servicio, String prioridad, Color color) {
	 this.tamaño=tamaño;
	 this.servicio=servicio;
	 this.prioridad=prioridad;
         this.color=color;
         tiempo=0;
  }
  
  /******SETTERS AND GETTERS******/

  
  public String getTamaño() {
	 return tamaño;
  }

  public void setTamaño(String tamaño) {
	this.tamaño = tamaño;
  }

  public String getServicio() {
	return servicio;
  }

  public void setServicio(String servicio) {
	this.servicio = servicio;
  }

  public String getPrioridad() {
	return prioridad;
  }

  public void setPrioridad(String prioridad) {
	this.prioridad = prioridad;
  }  
  
  public Color getColor() {
        return color;
  }

  public void setColor(Color color) {
        this.color = color;
  }  
  
  public int getTiempo() {
        return tiempo;
  }

  public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
  }
  
  public int getNumerocliente() {
       return numerocliente;
  }

  public void setNumerocliente(int Numerocliente) {
      this.numerocliente = Numerocliente;
  }
  
  /******METODO ABSTRACTO PARA DIBUJAR FIGURA
     * @param g*/
  public abstract void dibujar(Graphics g);  

}


