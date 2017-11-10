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
public class Model_Rentas {
    
    private Connection conexion;
    private Statement st; 
    private ResultSet rs;
    private PreparedStatement ps;
    private String sql;
    
    private int id_renta;
    private int id_cliente;
    private int id_pelicula;
    private String formato;
    private int costo_dia;
    private int dias;
    private int total_renta;    

    public int getId_renta() {
        return id_renta;
    }

    public void setId_renta(int id_renta) {
        this.id_renta = id_renta;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public int getCosto_dia() {
        return costo_dia;
    }

    public void setCosto_dia(int costo_dia) {
        this.costo_dia = costo_dia;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public int getTotal_renta() {
        return total_renta;
    }

    public void setTotal_renta(int total_renta) {
        this.total_renta = total_renta;
    }

    
    

    
    public  void Conectar(){
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/cine_mvc","root", "1405");
            st = conexion.createStatement();             
            llenarTodos();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "No esta conectada correctamente la base de datos","Error de conexion",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void llenarValores(){
        try{
            setId_renta(rs.getInt("id_rentas"));
            setId_cliente(rs.getInt("id_cliente"));
            setId_pelicula(rs.getInt("id_pelicula"));            
            setFormato(rs.getString("formato"));
            setCosto_dia(rs.getInt("costo_dia"));
            setDias(rs.getInt("dias"));
            setTotal_renta(rs.getInt("total_renta"));
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
            sql = "SELECT * FROM rentas;";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error","Error 107",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void Insertar(int id_cliente, int id_pelicula, String formato, int costo_dia, int dias, int total_renta){
        try{
            sql = "Insert into rentas (id_cliente, id_pelicula,formato,costo_dia,dias,total_renta) values (?,?,?,?,?,?);";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1,id_cliente);
            ps.setInt(2,id_pelicula);            
            ps.setString(3,formato);
            ps.setInt(4,costo_dia);
            ps.setInt(5,dias);
            ps.setInt(6,total_renta);
            ps.executeUpdate();
            llenarTodos();
            moverPrimero();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error","Error 108",JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }
    }
    public void Borrar(int id_rentas){
        try{
            sql = "DELETE FROM rentas WHERE id_rentas = ?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, id_rentas);
            ps.executeUpdate();
            llenarTodos();
            moverPrimero();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error","Error 109",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void Actualizar(int id_rentas, int id_cliente, int id_pelicula, String formato,int costo_dia, int dias, int total_renta){
        try{
            sql = "UPDATE rentas SET id_cliente = ?, id_pelicula, formato = ?,"
                    + " costo_dia = ?, dias= ?, total_renta = ? WHERE"
                    + " id_rentas = ? ;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(5, id_rentas);
            ps.setInt(1, id_cliente);
            ps.setInt(2, id_pelicula);
            ps.setString(3, formato);
            ps.setInt(4,costo_dia);
            ps.setInt(5,dias);
            ps.setInt(6,total_renta);
            ps.executeUpdate();
            llenarTodos();
            moverPrimero();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error","Error 109",JOptionPane.ERROR_MESSAGE);
        }
    }   
}
