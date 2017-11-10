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
public class Model_Clientes {
    
    private Connection conexion;
    private Statement st; 
    private ResultSet rs;
    private PreparedStatement ps;
    private String sql;
    
    private int id_cliente;
    private String nombre;
    private String telefono;
    private String email;
    private String direccion;    

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    private void llenarTodos() {
        try{
            sql = "SELECT * FROM clientes;";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error","Error 107",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void Insertar(String nombre, String telefono, String email, String direccion){
        try{
            sql = "Insert into clientes(nombre, telefono, email, direccion) values (?,?,?,?);";
            ps = conexion.prepareStatement(sql);
            ps.setString(1,nombre);
            ps.setString(2,telefono);
            ps.setString(3,email);
            ps.setString(4,direccion);            
            ps.executeUpdate();
            llenarTodos();
            moverPrimero();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error","Error 108",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void Borrar(int id_cliente){
        try{
            sql = "DELETE FROM clientes WHERE id_cliente = ?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, id_cliente);
            ps.executeUpdate();
            llenarTodos();
            moverPrimero();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error","Error 109",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void Actualizar(int id_cliente,String nombre, String telefono, String email, String direccion){
        try{
            sql = "UPDATE clientes SET nombre = ?,"
                    + " telefono = ?, email = ?,"
                    + " direccion = ? WHERE id_cliente = ? ;";            
            ps = conexion.prepareStatement(sql);
            ps.setInt(5, id_cliente);
            ps.setString(1, nombre);
            ps.setString(2,telefono);
            ps.setString(3,email);
            ps.setString(4,direccion);            
            ps.executeUpdate();
            llenarTodos();
            moverPrimero();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error",""+e.getMessage(),JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void llenarValores(){
        try{
            setId_cliente(rs.getInt("id_cliente"));
            setNombre(rs.getString("nombre"));
            setTelefono(rs.getString("telefono"));
            setEmail(rs.getString("email"));
            setDireccion(rs.getString("direccion"));            
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
    
}
