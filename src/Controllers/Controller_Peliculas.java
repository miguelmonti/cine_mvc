/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Model_Peliculas;
import Views.View_Peliculas;

/**
 *
 * @author Mike
 */
public class Controller_Peliculas {
    
    Model_Peliculas model_Peliculas;
    View_Peliculas view_Peliculas;
    
    public Controller_Peliculas(Model_Peliculas model_Peliculas, View_Peliculas view_Peliculas){
        this.model_Peliculas = model_Peliculas;
        this.view_Peliculas = view_Peliculas;
        this.view_Peliculas.jb_anterior.addActionListener(e -> jb_anterior_click());
        this.view_Peliculas.jb_siguiente.addActionListener(e -> jb_siguiente_click());
        this.view_Peliculas.jb_ultimo.addActionListener(e -> jb_ultimo_click());
        this.view_Peliculas.jb_primero.addActionListener(e -> jb_primero_click());
        this.view_Peliculas.jb_nuevo.addActionListener(e -> jb_nuevo_click());
        this.view_Peliculas.jb_editar.addActionListener(e -> jb_editar_click());
        this.view_Peliculas.jb_guardar.addActionListener(e -> jb_guardar_click());
        this.view_Peliculas.jb_borrar.addActionListener(e -> jb_borrar_click());
        initView();              
    }
    
    public void getValores(){
        view_Peliculas.jtf_id_pelicula.setText("" + model_Peliculas.getId_pelicula());
        view_Peliculas.jtf_nombre.setText("" + model_Peliculas.getNombre());
        view_Peliculas.jtf_formato.setText("" + model_Peliculas.getFormato());
        view_Peliculas.jtf_duracion.setText("" + model_Peliculas.getDuracion_min());
        view_Peliculas.jtf_descripcion.setText("" + model_Peliculas.getDescripcion());        
    }
    
    public void setValores(){
        model_Peliculas.setId_pelicula(Integer.parseInt(view_Peliculas.jtf_id_pelicula.getText()));
        model_Peliculas.setNombre(view_Peliculas.jtf_nombre.getText());
        model_Peliculas.setFormato(view_Peliculas.jtf_formato.getText());
        model_Peliculas.setDuracion_min(view_Peliculas.jtf_duracion.getText());
        model_Peliculas.setDescripcion(view_Peliculas.jtf_descripcion.getText());        
    }
    private void jb_anterior_click() {        
        model_Peliculas.moverAnterior();
        getValores();
    }

    private void jb_ultimo_click() {        
        model_Peliculas.moverUltimo();
        getValores();
    }

    private void jb_siguiente_click() {        
        model_Peliculas.moverSiguiente();
        getValores();        
    }

    private void jb_primero_click() {        
        model_Peliculas.moverPrimero();
        getValores();
    }

    private void jb_nuevo_click() {
        view_Peliculas.jtf_id_pelicula.setEditable(false);
        int id = Integer.parseInt(view_Peliculas.jtf_id_pelicula.getText());
        id += 1;
        view_Peliculas.jtf_nombre.setText("");
        view_Peliculas.jtf_formato.setText("");
        view_Peliculas.jtf_duracion.setText("");
        view_Peliculas.jtf_descripcion.setText("");        
    }

    private void jb_editar_click() {
        setValores();
        model_Peliculas.Actualizar(model_Peliculas.getId_pelicula(),model_Peliculas.getNombre(),
        model_Peliculas.getFormato(), model_Peliculas.getDuracion_min(),
        model_Peliculas.getDescripcion());
        getValores();
    }

    private void jb_guardar_click() {
        setValores();
        model_Peliculas.Insertar(model_Peliculas.getNombre(), model_Peliculas.getFormato(),
        model_Peliculas.getDuracion_min(),model_Peliculas.getDescripcion());
        getValores();
    }

    private void jb_borrar_click() {
        setValores();
        model_Peliculas.Borrar(model_Peliculas.getId_pelicula());
        getValores();
    }
    
    private void initView(){
        model_Peliculas.Conectar();        
        view_Peliculas.setVisible(true);
        model_Peliculas.moverPrimero();
        getValores();
    }
}
