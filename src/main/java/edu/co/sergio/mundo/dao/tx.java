package edu.co.sergio.mundo.dao;

import java.lang.reflect.Field;
import edu.co.sergio.mundo.vo.User;

public class tx {

    public void peticionSQL(User usuario) throws IllegalArgumentException, IllegalAccessException {
        /*String usuario.getNombre();
        usuario.getApellido();
        usuario.getCorreo();
        usuario.getTelefono();
         */
        Field[] field = usuario.getClass().getDeclaredFields();

        String statement = "";
        String statement2 = "";
        String statement3 = "";
        String statement4 = "";

        for (int i = 0; i < field.length; i++) {
            field[i].getName();
            System.out.println("Parametro " + (i + 1) + " " + field[i].getName());
            System.out.println("GET: " + field[i].get(usuario));
            System.out.println(usuario.getClass().getSimpleName());
        }
        System.out.println("-----------------------------------------------------------");
        statement = "insert into " + usuario.getClass().getSimpleName() + " (";

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
                statement4 = statement4 + "'" + field[j].get(usuario) + "');";
                break;
            } else {
                statement4 = statement4 + "'" + field[j].get(usuario) + "',";
            }
        }
        String full = statement + statement2 + statement3 + statement4;
        System.out.println(full);
    }

    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {

        tx TX = new tx();
        String nombre = "Carlos";
        String apellido = "Correa";
        String correo = "tato";
        String telefono = "12345";

        User usuario = new User();

        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setTelefono(telefono);
        usuario.setCorreo(correo);

        TX.peticionSQL(usuario);

    }
}
