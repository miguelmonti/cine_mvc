/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Model_Principal;
import Views.View_Principal;
import Views.View_Clientes;
import Views.View_Peliculas;
import Views.View_Rentas;
/**
 *
 * @author Mike
 */
public class Controller_Principal {
    
    Model_Principal model_Principal;
    View_Principal view_Principal;
    View_Clientes view_Clientes;
    View_Peliculas view_Peliculas;
    View_Rentas view_Rentas;
    
    public Controller_Principal(Model_Principal model_Principal, View_Principal view_Principal, 
        View_Clientes view_Clientes, View_Peliculas view_Peliculas, View_Rentas view_Rentas) {
        this.model_Principal = model_Principal;
        this.view_Principal = view_Principal;
        this.view_Clientes = view_Clientes;    
        this.view_Peliculas = view_Peliculas;
        this.view_Rentas = view_Rentas;
        view_Principal.jmi_clientes.addActionListener(e->jmi_clientes_click());
        view_Principal.jmi_peliculas.addActionListener(e ->jmi_peliculas_click());
        view_Principal.jmi_rentas.addActionListener(e ->jmi_rentas_click());
        initView();
    }

    private void jmi_clientes_click() {
        this.view_Principal.setContentPane(view_Clientes);
        this.view_Principal.revalidate();
        this.view_Principal.repaint();
    }
    private void jmi_peliculas_click(){
        this.view_Principal.setContentPane(view_Peliculas);
        this.view_Principal.revalidate();
        this.view_Principal.repaint();
    }
     private void jmi_rentas_click() {
        this.view_Principal.setContentPane(view_Rentas);
        this.view_Principal.revalidate();
        this.view_Principal.repaint();
    }
    
     private void initView(){
        this.view_Principal.setTitle("Peliculas");
        this.view_Principal.setLocationRelativeTo(null);
        this.view_Principal.setVisible(true);
    }
   
    
}
