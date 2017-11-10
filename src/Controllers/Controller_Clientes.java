/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Model_Clientes;
import Views.View_Clientes;

/**
 *
 * @author Mike
 */
public class Controller_Clientes {
    private Model_Clientes model_Clientes;
    private View_Clientes view_Clientes;
    
    public Controller_Clientes(Model_Clientes model_Clientes, View_Clientes view_Clientes){
        this.model_Clientes = model_Clientes;
        this.view_Clientes = view_Clientes;
        this.view_Clientes.jb_anterior.addActionListener(e -> jb_anterior_click());
        this.view_Clientes.jb_siguiente.addActionListener(e -> jb_siguiente_click());
        this.view_Clientes.jb_ultimo.addActionListener(e -> jb_ultimo_click());
        this.view_Clientes.jb_primero.addActionListener(e -> jb_primero_click());
        this.view_Clientes.jb_nuevo.addActionListener(e -> jb_nuevo_click());
        this.view_Clientes.jb_editar.addActionListener(e -> jb_editar_click());
        this.view_Clientes.jb_guardar.addActionListener(e -> jb_guardar_click());
        this.view_Clientes.jb_borrar.addActionListener(e -> jb_borrar_click());
        initView();
    }

    public void getValores(){
        view_Clientes.jtf_id_cliente.setText("" + model_Clientes.getId_cliente());
        view_Clientes.jtf_nombre.setText("" + model_Clientes.getNombre());
        view_Clientes.jtf_telefono.setText("" + model_Clientes.getTelefono());
        view_Clientes.jtf_email.setText("" + model_Clientes.getEmail());
        view_Clientes.jtf_direccion.setText("" + model_Clientes.getDireccion());
    }
    
    public void setValores(){
        model_Clientes.setId_cliente(Integer.parseInt(view_Clientes.jtf_id_cliente.getText()));
        model_Clientes.setNombre(view_Clientes.jtf_nombre.getText());
        model_Clientes.setTelefono(view_Clientes.jtf_telefono.getText());
        model_Clientes.setEmail(view_Clientes.jtf_email.getText());
        model_Clientes.setDireccion(view_Clientes.jtf_direccion.getText());
    }
    
    private void jb_anterior_click() {        
        model_Clientes.moverAnterior();
        getValores();
    }

    private void jb_ultimo_click() {        
        model_Clientes.moverUltimo();
        getValores();
    }

    private void jb_siguiente_click() {        
        model_Clientes.moverSiguiente();
        getValores();        
    }

    private void jb_primero_click() {        
        model_Clientes.moverPrimero();
        getValores();
    }

    private void jb_nuevo_click() { 
        view_Clientes.jtf_id_cliente.setEditable(false);
        int id = Integer.parseInt(view_Clientes.jtf_id_cliente.getText());
        id += 1;
        view_Clientes.jtf_id_cliente.setText(id+"");
        view_Clientes.jtf_nombre.setText("");
        view_Clientes.jtf_telefono.setText("");
        view_Clientes.jtf_email.setText("");
        view_Clientes.jtf_direccion.setText("");
    }

    private void jb_editar_click() {
        setValores();
        model_Clientes.Actualizar(model_Clientes.getId_cliente(),model_Clientes.getNombre(),
        model_Clientes.getTelefono(), model_Clientes.getEmail(),model_Clientes.getDireccion());
        getValores();
    }

    private void jb_guardar_click() {
        setValores();
        model_Clientes.Insertar(model_Clientes.getNombre(), model_Clientes.getTelefono(), 
        model_Clientes.getEmail(), model_Clientes.getDireccion());
        getValores();
    }

    private void jb_borrar_click() {
        setValores();
        model_Clientes.Borrar(model_Clientes.getId_cliente());
        getValores();
    }
    
    private void initView(){
        model_Clientes.Conectar();        
        view_Clientes.setVisible(true);
        model_Clientes.moverPrimero();
        getValores();
    }
}
