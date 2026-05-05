/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bbdd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/*****/
/* BBDD*/
/* JBDC: Librerias necesarias para trabajar con BBDD*/
/* (Java Data Base Conectivity) API estandard de conexion a las BBDD*/
/* Metodos mas comunes para interacion con BBDD*/
/* 1. DriverManager.getConnection()-> obtener una conexion a la BBDD*/
/* 2. connection.createStatement() -> crear Statement para ejecutar sql*/
/* 3. statement.executQuery() -> para los SELECT (retorna un result set)*/
/*    statement.executeUpdate() -> para los CREATE, INSERT, UPDATE, DELETE*/
/* 4. resultSet.next() -> recorrer fila a fila el resultado de las SQL*/
/* 5. connection.close() -> cerrar la conexion a la BBDD (SUPER IMPORTANTE)*/



public class BBDD {

   
    // Datos de la conexion a la bbdd
    // URL de conexion a la BBDD
    private static final String URL = "jdbc:mysql://localhost:3306/escola";
    
    //USUARIO de conexion a la BBDD
    private static final String USER = "root";
            
    // PASSWORD de conexion a la BBDD
    private static final String PASSWORD = "";
    
    /*CONEXION A LA BBDD*/
    /* Abrir y cerrar la conexion a la BBDD*/
    private static Connection obtenirConexio() throws SQLException{
        
           //Sirver para buscar el Driver de conexion mas adecuado a la BBDD
           return DriverManager.getConnection(URL, USER, PASSWORD);
    };
    
    /*Crear tabla en BBDD*/
    
    private static void crearTaula(){
        
        //SQL para crear la tabla de "alumnes"
        String sql = "CREATE TABLE IF NOT EXISTS alumnes ("
                + " id INT AUTO_INCREMENT PRIMARY KEY,"
                + " nom VARCHAR(100) NOT NULL, "
                + " email VARCHAR(100) NOT NULL,"
                + " edad INT "
                +")";
        // Seimpre la ejecucion de los SQL dentro de los try-catch para el control 
        //de errores
        try(Connection conn = obtenirConexio();
                Statement stmt = conn.createStatement()){
        
            stmt.executeUpdate(sql);
            System.out.println("Taula creada correctamante.");
        }catch(SQLException e){
            System.out.println("Error en crear la tabla: "+ e.getMessage());
        }
        
    }
    
    /*INSERTAT DATOS A LA TABLA alumnes*/
    private static void insertarAlumno(){
    
        // Statemen vs PreparedStatement
        // Statement: se utiliza cuando no hay valores que "escapar", es decir
        // que no se le pasa ningun valor a la SQL (peligroso SQL injection)
        // PreparedStatement: el que se tiene que utilizar cuando se le pasan
        // parametros a la SQL
        // SIEMPRE UTILIZAR EL preparedStatement CUANDO HAY DATOS DEL USUARIO
    
        String sql = "INSERT INTO alumnes (nom, email, edad) VALUES (?, ?, ?)";
    
        try(Connection conn = obtenirConexio();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
        
            // Alumne 1
            pstmt.setString(1, "Pepita"); //? Numero 1  -> nom
            pstmt.setString(2, "pepita@gmail.com"); // ? numero 2 -> email
            pstmt.setInt(3, 23); // ? numero 3 -> edat
            pstmt.executeUpdate();
            
             // Alumne 2
            pstmt.setString(1, "Jesus"); //? Numero 1  -> nom
            pstmt.setString(2, "jesus@gmail.com"); // ? numero 2 -> email
            pstmt.setInt(3, 21); // ? numero 3 -> edat
            pstmt.executeUpdate();
            
             // Alumne 3
            pstmt.setString(1, "Manolo"); //? Numero 1  -> nom
            pstmt.setString(2, "manolo@gmail.com"); // ? numero 2 -> email
            pstmt.setInt(3, 33); // ? numero 3 -> edat
            
            //Ejecutar SQL
            pstmt.executeUpdate();
            
            System.out.println("3 Alumnos añadidos correctamante");
            
        }catch(SQLException e){
            System.out.println("Error al insertat:"+ e.getMessage());
        }
    
    }
    
    
    /* SELECT*/
    private static void consultarAlumnos(){
        
        String sql = "SELECT id, nom,  email , edad FROM alumnes ORDER BY id";
        
        try(Connection conn = obtenirConexio();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)){
        
            System.out.println("\n------LISTA ALUMNOS ------- \n");
            
            // rs.next() -> avanza y recorre los registros del ResultSet
            // mientras haya registros
            while(rs.next()){
                
                // Leemos cada columna del ResultSet
                int id = rs.getInt("id"); //index rs.getInt(0)
                String nom = rs.getString("nom");
                String email = rs.getString("email");
                int edad = rs.getInt("edad");
                
                
                System.out.println(id + " | " + nom + " | " +email+ " | " +edad+ " | ");
            }
        }catch(SQLException e){
            System.out.println("Errorconsultando la tabla: "+ e.getMessage());
        }
    }
    
    
    /* UPDATE: modificar tabla alumnes*/
    private static void actualizarAlumnos(){
        
        String sql = "UPDATE alumnes SET edad = ? WHERE nom = ?";
        
         try(Connection conn = obtenirConexio();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
        
         pstmt.setInt(1, 21); //La edad que queremos modificar
         pstmt.setString(2, "Manolo");
        
         int filaAfectadas = pstmt.executeUpdate();
             System.out.println("UPDATE: " +filaAfectadas+ " filas modificadas");
                 
        }catch(SQLException e){
            System.out.println("Erroren el update: "+ e.getMessage());
        }
    }
    
    /* DELETE: eliminar algun  alumno*/
    
    private static void eliminarAlumnos(){
    
        String sql = "DELETE FROM alumnes WHERE nom = ?";
        
        try(Connection conn = obtenirConexio();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
        
         
              
            pstmt.setString(1, "Pepita");
            
            int filaAfectadas = pstmt.executeUpdate();
             System.out.println("DELETE: " +filaAfectadas+ " filas modificadas");
             
        }catch(SQLException e){
            System.out.println("Erroren al eliminar: "+ e.getMessage());
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
        
        crearTaula();
        insertarAlumno();
        consultarAlumnos();
        actualizarAlumnos();
        consultarAlumnos();
        eliminarAlumnos();
        consultarAlumnos();
    }
    
}
