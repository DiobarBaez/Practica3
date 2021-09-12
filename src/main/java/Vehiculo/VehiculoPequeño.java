
package Vehiculo;

import java.awt.Color;
import java.awt.Graphics;

public class VehiculoPequeño extends Vehiculo{
    private int posx;
    private int posy;
    private int size;
    
    /******CONSTRUCTOR DE CLASE******/
    
    public VehiculoPequeño(String tamaño, String servicio, String prioridad, Color color ){
      super(tamaño,servicio,prioridad,color);
      posx=200;
      posy=200;
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
    
    /******METODO PARA DIBUJAR LOS OBJETOS******/
    
    @Override
    public void dibujar(Graphics g) {
        g.setColor(color);
        g.fillRect(posx, posy, 50, 100);
        g.setColor(Color.BLACK);
        g.drawRect(posx, posy, 50, 100);
    }
    
}
