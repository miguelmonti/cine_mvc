/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Models.*;
import Views.*;
import Controllers.*;

/**
 *
 * @author Mike
 */
public class Main {
    
    private static Model_Principal model_Principal;
    private static View_Principal view_Principal;    
    private static Controller_Principal controller_Principal;
    
    private static Model_Peliculas model_Peliculas;
    private static View_Peliculas view_Peliculas;    
    private static Controller_Peliculas controller_Peliculas;
    
    private static Model_Clientes model_Clientes;
    private static View_Clientes view_Clientes;
    private static Controller_Clientes controller_Clientes;
    
    private static Model_Rentas model_Rentas;
    private static View_Rentas view_Rentas;
    private static Controller_Rentas controller_Rentas;
    
    public static void main (String maom[]){
        
       model_Peliculas = new Model_Peliculas();
       view_Peliculas = new View_Peliculas();
       controller_Peliculas = new Controller_Peliculas(model_Peliculas, view_Peliculas);
       
       model_Clientes = new Model_Clientes();
       view_Clientes = new View_Clientes();
       controller_Clientes = new Controller_Clientes(model_Clientes, view_Clientes);
       
       model_Rentas = new Model_Rentas();
       view_Rentas = new View_Rentas();
       controller_Rentas = new Controller_Rentas(model_Rentas, view_Rentas);
       
       model_Principal = new Model_Principal();
       view_Principal = new View_Principal();
       controller_Principal = new Controller_Principal(model_Principal, view_Principal, view_Clientes, view_Peliculas, view_Rentas);
    }
}
