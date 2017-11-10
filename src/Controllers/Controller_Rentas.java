/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Model_Rentas;
import Views.View_Rentas;

/**
 *
 * @author Mike
 */
public class Controller_Rentas {
    
    Model_Rentas model_Rentas;
    View_Rentas view_Rentas;
    
    public Controller_Rentas(Model_Rentas model_Rentas, View_Rentas view_Rentas){
        this.model_Rentas = model_Rentas;
        this.view_Rentas = view_Rentas;
        this.view_Rentas.jb_anterior.addActionListener(e -> jb_anterior_click());
        this.view_Rentas.jb_siguiente.addActionListener(e -> jb_siguiente_click());
        this.view_Rentas.jb_ultimo.addActionListener(e -> jb_ultimo_click());
        this.view_Rentas.jb_primero.addActionListener(e -> jb_primero_click());
        this.view_Rentas.jb_nuevo.addActionListener(e -> jb_nuevo_click());
        this.view_Rentas.jb_editar.addActionListener(e -> jb_editar_click());
        this.view_Rentas.jb_guardar.addActionListener(e -> jb_guardar_click());
        this.view_Rentas.jb_borrar.addActionListener(e -> jb_borrar_click());
        initView();              
    }
    
    public void getValores(){
        view_Rentas.jtf_id_renta.setText("" + model_Rentas.getId_renta());
        view_Rentas.jtf_id_cliente.setText("" + model_Rentas.getId_cliente());
        view_Rentas.jtf_id_pelicula.setText("" + model_Rentas.getId_pelicula());
        view_Rentas.jtf_formato.setText("" + model_Rentas.getFormato());
        view_Rentas.jtf_costo_por_dia.setText("" + model_Rentas.getCosto_dia());
        view_Rentas.jtf_dias.setText("" + model_Rentas.getDias());
        view_Rentas.jtf_total_renta.setText("" + model_Rentas.getTotal_renta());        
    }
    
    public void setValores(){
        model_Rentas.setId_renta(Integer.parseInt(view_Rentas.jtf_id_renta.getText()));
        model_Rentas.setId_cliente(Integer.parseInt(view_Rentas.jtf_id_cliente.getText()));
        model_Rentas.setId_pelicula(Integer.parseInt(view_Rentas.jtf_id_pelicula.getText()));
        model_Rentas.setFormato(view_Rentas.jtf_formato.getText());
        model_Rentas.setCosto_dia(Integer.parseInt(view_Rentas.jtf_costo_por_dia.getText()));
        model_Rentas.setDias(Integer.parseInt(view_Rentas.jtf_dias.getText()));
        model_Rentas.setTotal_renta(Integer.parseInt(view_Rentas.jtf_total_renta.getText()));        
    }
    private void jb_anterior_click() {        
        model_Rentas.moverAnterior();
        getValores();
    }

    private void jb_ultimo_click() {        
        model_Rentas.moverUltimo();
        getValores();
    }

    private void jb_siguiente_click() {        
        model_Rentas.moverSiguiente();
        getValores();        
    }

    private void jb_primero_click() {        
        model_Rentas.moverPrimero();
        getValores();
    }

    private void jb_nuevo_click() {
        view_Rentas.jtf_id_renta.setEditable(false);
        int id = Integer.parseInt(view_Rentas.jtf_id_renta.getText());
        id += 1;
        view_Rentas.jtf_formato.setText("");
        view_Rentas.jtf_costo_por_dia.setText("");
        view_Rentas.jtf_dias.setText("");
        view_Rentas.jtf_total_renta.setText("");        
    }

    private void jb_editar_click() {
        setValores();
        model_Rentas.Actualizar(model_Rentas.getId_renta(),model_Rentas.getId_cliente(),
        model_Rentas.getId_pelicula(),model_Rentas.getFormato(),
        model_Rentas.getCosto_dia(), model_Rentas.getDias(),
        model_Rentas.getTotal_renta());
        getValores();
    }

    private void jb_guardar_click() {
        setValores();
        model_Rentas.Insertar(model_Rentas.getId_renta(),model_Rentas.getId_cliente(),model_Rentas.getFormato(),
        model_Rentas.getCosto_dia(), model_Rentas.getDias(),model_Rentas.getTotal_renta());
        getValores();
    }

    private void jb_borrar_click() {
        setValores();
        model_Rentas.Borrar(model_Rentas.getId_renta());
        getValores();
    }
    
    private void initView(){
        model_Rentas.Conectar();        
        view_Rentas.setVisible(true);
        model_Rentas.moverPrimero();
        getValores();
    }
}
