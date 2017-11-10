/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Mike
 */
public class Model_Peliculas {
    private int id_pelicula;
    private String nombre;
    private String formato;
    private String duracion_min;
    private String descripcion;
    
    private Connection conexion;
    private Statement st; 
    private ResultSet rs;
    private PreparedStatement ps;
    private String sql;

    public int getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getDuracion_min() {
        return duracion_min;
    }

    public void setDuracion_min(String duracion_min) {
        this.duracion_min = duracion_min;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }      
    
    public  void Conectar(){
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/cine_mvc","root", "1405");
            st = conexion.createStatement();             
            llenarTodos();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error","Error 101",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void llenarValores(){
        try{
            setId_pelicula(rs.getInt("id_pelicula"));
            setNombre(rs.getString("nombre"));
            setFormato(rs.getString("formato"));
            setDuracion_min(rs.getString("duracion_min"));
            setDescripcion(rs.getString("descripcion"));
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error","Error 102",JOptionPane.ERROR_MESSAGE);            
        }
    }
    
    public void moverPrimero(){
        try{
            if(rs.isFirst() == false){
                rs.first();
                llenarValores();
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error","Error 103",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void moverUltimo(){
        try{
            if(rs.isLast() == false){
                rs.last();
                llenarValores();
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error","Error 104",JOptionPane.ERROR_MESSAGE);
        }
    }        
    
    public void moverSiguiente(){
        try{
            if(rs.isLast() == false){
                rs.next();
                llenarValores();
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error","Error 105",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void moverAnterior(){
        try{
            if(rs.isFirst() == false){
                rs.previous();
                llenarValores();
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error","Error 106",JOptionPane.ERROR_MESSAGE);
        }
    }    
    
    public void llenarTodos(){
        try{
            sql = "SELECT * FROM peliculas;";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error","Error 107",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void Insertar(String nombre,String formato,String duracion_min, String descripcion){
        try{
            sql = "Insert into peliculas (nombre,formato,duracion_min,descripcion) values (?,?,?,?);";
            ps = conexion.prepareStatement(sql);
            ps.setString(1,nombre);
            ps.setString(2,formato);
            ps.setString(3,duracion_min);
            ps.setString(4,descripcion);
            ps.executeUpdate();
            llenarTodos();
            moverPrimero();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error","Error 108",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void Borrar(int id_pelicula){
        try{
            sql = "DELETE FROM peliculas WHERE id_pelicula = ?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, id_pelicula);
            ps.executeUpdate();
            llenarTodos();
            moverPrimero();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error","Error 109",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void Actualizar(int id_pelicula, String nombre, String formato, String duracion_min, String descripcion){
        try{
            sql = "UPDATE pelicula SET nombre = ?,"
                    + " formato = ?, duracion_min = ?, descripcion = ? WHERE"
                    + " id_pelicula = ? ;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(5, id_pelicula);
            ps.setString(1, nombre);
            ps.setString(2,formato);
            ps.setString(3,duracion_min);
            ps.setString(4,descripcion);
            ps.executeUpdate();
            llenarTodos();
            moverPrimero();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error","Error 109",JOptionPane.ERROR_MESSAGE);
        }
    }
}
