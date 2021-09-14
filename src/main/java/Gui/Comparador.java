
package Gui;

import Vehiculo.Vehiculo;
import java.util.Comparator;

public class Comparador implements Comparator<Vehiculo>{

    @Override
    public int compare(Vehiculo a, Vehiculo b){
      if(a.getPrioridad().equalsIgnoreCase("si") && b.getPrioridad().equalsIgnoreCase("si")){
        if(a.getNumerocliente()<b.getNumerocliente()){
          return -1;
        }else{
          return 1;
        }
      }else{
        if(a.getPrioridad().equalsIgnoreCase("no") && b.getPrioridad().equalsIgnoreCase("no")){
          if(a.getNumerocliente()<b.getNumerocliente()){
            return -1;
          }else{
            return 1;
          }
        }else{
          if(a.getPrioridad().equalsIgnoreCase("si") &&  b.getPrioridad().equalsIgnoreCase("no")){
             return 1;
          }else{
             if(a.getPrioridad().equalsIgnoreCase("no") &&  b.getPrioridad().equalsIgnoreCase("si")){
               return -1;
             }else{
               return 1;
             }
          }
        }
      }
    }
}

