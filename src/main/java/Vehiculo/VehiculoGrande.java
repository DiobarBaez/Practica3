
package Vehiculo;

import java.awt.Color;
import java.awt.Graphics;

public class VehiculoGrande extends Vehiculo{
    private int posx;
    private int posy;
    private int size;

  /******CONSTRUCTOR******/ 
    
    public VehiculoGrande(String tamaño, String servicio, String prioridad, Color color ){
      super(tamaño,servicio,prioridad,color);
      posx=0;
      posy=0;
      size=50;
    }

  /******SETTERS AND GETTERS******/
    
    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    /******METODO PARA DIBUJAR OBJETO******/
    
    @Override
    public void dibujar(Graphics g) {
        g.setColor(color);
        g.fillOval(posx, posy,50,50);
        g.setColor(Color.BLACK);
        g.drawOval(posx, posy,50,50);
    }
}
