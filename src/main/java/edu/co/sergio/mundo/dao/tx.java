package edu.co.sergio.mundo.dao;
import java.lang.reflect.Field;
import edu.co.sergio.mundo.vo.User;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class tx<T> {
    
    private Connection conexion;
    
    public tx() throws URISyntaxException {
        Conexion2 db = Conexion2.getConexion();
        this.conexion = db.getConnection();
    }
    
    public void insert(T t) throws IllegalArgumentException, IllegalAccessException {
        /*String usuario.getNombre();
        usuario.getApellido();
        usuario.getCorreo();
        usuario.getTelefono();
         */
        Field[] field = t.getClass().getDeclaredFields();

        String statement = "";
        String statement2 = "";
        String statement3 = "";
        String statement4 = "";

        for (int i = 0; i < field.length; i++) {
            field[i].getName();
            System.out.println("Parametro " + (i + 1) + " " + field[i].getName());
            System.out.println("GET: " + field[i].get(t));
            System.out.println(t.getClass().getSimpleName());
        }
        System.out.println("-----------------------------------------------------------");
        statement = "insert into " + t.getClass().getSimpleName() + "(";

        for (int j = 0; j < field.length; j++) {
            if (j == field.length - 1) {
                statement2 = statement2 + field[j].getName() + ") ";
                break;
            } else {
                statement2 = statement2 + field[j].getName() + ",";
            }
        }

        statement3 = "values (";

        for (int j = 0; j < field.length; j++) {

            if (j == field.length - 1) {
                statement4 = statement4 + "'" + field[j].get(t) + "');";
                break;
            } else {
                statement4 = statement4 + "'" + field[j].get(t) + "',";
            }
        }
        String full = statement + statement2 + statement3 + statement4;
        System.out.println(full);
        System.out.println("     ");
        
        Statement stat;
        try {
            stat = this.conexion.createStatement();
            //Ejecuto
            stat.executeQuery(full);

            System.out.println("La Conexion es correcta, se agrego el usuario...");

        } catch (SQLException e) {
            System.out.println("Error de conexion");
            e.printStackTrace();
        }

    }
    //-------------------------------------------------------------------------------------------

    public ArrayList Select() {

        Connection connection = null;
        try {
            connection = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(ServiciosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        String query = "select * from Users";
        ArrayList Users = new ArrayList();

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Users.add(rs.getInt(1));
                Users.add(rs.getInt(3));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServiciosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Users;
    }

    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, URISyntaxException {

        tx<User> TX = new tx();
        String nombre = "Carlos";
        String apellido = "Correa";
        String correo = "tato";
        String telefono = "12345";

        User usuario = new User();

        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setTelefono(telefono);
        usuario.setCorreo(correo);

        TX.insert(usuario);

    }
}
