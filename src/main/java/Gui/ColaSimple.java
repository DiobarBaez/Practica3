
package Gui;

package colas;

public class Simple<T>{
    private T[] arreglo;
    private int maximo;
    private int inicio, fin;
    
    
    public Simple(){
     arreglo=(T[]) new Object[5];
     maximo=5;
     inicio=-1;
     fin=-1;
    }
    
    public Simple(int maximo){
     arreglo=(T[]) new Object[maximo];
     this.maximo=maximo;
     inicio=-1;
     fin=-1;
    }
    
    public boolean vacio(){
      boolean c=false;
      if(inicio<0 && fin<0){
        c=true;
        return c;
      }
      return c;
    }
    
    public boolean lleno(){
      boolean c=false;
      if(fin==maximo-1){
        c=true;
        return c;
      }
      return c;
    }
    
    
    public void agregarACola(T x){
     if(lleno()){
      System.out.println("La fila esta llena.No se agrego el ultimo elemento.");
     }else{
      if(inicio==-1 && fin==-1){
        inicio++; fin++;
        arreglo[inicio]=x;
      }else{
        fin++;
        arreglo[fin]=x;
      }
      System.out.println("Se ha agregado exitosamente el elemento.");
     }
    }
    
    public T extraerDeCola(){
      T valor = null;
      if(vacio()){
        System.out.println("La cola esta vacia.");
      }else{
       if(inicio==fin){
         valor = arreglo[inicio];
         System.out.println("El elemento extraido es: "+arreglo[inicio]);
         inicio=-1; fin=-1;
         return valor;
       }else{
          valor = arreglo[inicio];
          System.out.println("El elemento extraido es: "+arreglo[inicio]);
          inicio++;
          return valor;
        }
      }
      return valor;
    }
    
    public void mostrarCola(){
     if(vacio()){
      System.out.println("La cola esta vacia.");
     }else{
      System.out.println("Elementos de la cola.");
      int i=inicio;
      do{
       System.out.print("\t"+arreglo[i]);
       i++;
      }while(i<=fin);
     }
    }
    

}

