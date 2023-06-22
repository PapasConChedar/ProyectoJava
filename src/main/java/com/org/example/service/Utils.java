package com.org.example.service;

import com.org.example.clases.Cliente;
import com.org.example.clases.Empleado;

import javax.swing.*;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    private static final String PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                    "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static Boolean validEmail(String email) {
        Matcher matcher = Pattern.compile(PATTERN).matcher(email);
        return matcher.matches();
    }

    public static Boolean validPassword(String password) {
        return password.length() >= 8;
    }

    public static Boolean verificarDatos(String email, String password) {
        return validEmail(email) && validPassword(password);
    }
    public static void borrarFilaDeTabla(JTable tabla, int fila){
        try {
            ((javax.swing.table.DefaultTableModel) tabla.getModel()).removeRow(fila);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al borrar la fila.");
        }
    }

    /**
     * Devuelve 1 si es cliente, 2 si es empleado y 0 si no existe
     * @param email
     * @param pass
     * @return
     */
    public static Integer verificarEntidad(String email, String pass) {
        Optional<Cliente> cliente = new GestionImpleCliente().encontrarCliente(email, pass);
        Optional<Empleado> empleado = new GestionImpleEmpleado().encontrarEmpleado(email, pass);
        Integer response;
        if (cliente.isPresent()) {
            response = 1;
        } else if (empleado.isPresent()) {
            response = 2;
        } else {
            response = 0;
        }
        return response;
    }
}
