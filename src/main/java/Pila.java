/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dzlan
 */
public class Pila {

    public int getContNodo() {
        return ContNodo;
    }

    public Nodo getCabeza() {
        return Cabeza;
    }
    
    private int ContNodo = 0; 
    
    private Nodo Cabeza;
    
    
    public void Push (Nodo N){
   
        ContNodo++; 
       if (Cabeza==null){
           Cabeza= N;
       }else {
           N.setAbajo(Cabeza);
           Cabeza.setArriba(N);
           
           Cabeza = N;
       }
        
    }
    
    public void Pop(){
        
        
        if(ContNodo > 0){
            ContNodo--; 
            
            Cabeza = Cabeza.getAbajo();
        }
        
    }
    
    
    public String Peek(){
        return Cabeza.getDato();
        
    }
    
    
    
}
