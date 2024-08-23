package com.digitalhouse.odontologia.dao.impl;

import com.digitalhouse.odontologia.dao.BD;
import com.digitalhouse.odontologia.domain.Domicilio;
import org.apache.log4j.Logger;
import com.digitalhouse.odontologia.domain.Paciente;
import com.digitalhouse.odontologia.dao.IDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDaoH2 implements IDAO<Paciente> {

    private static final Logger LOGGER = Logger.getLogger(PacienteDaoH2.class);
    DomicilioDaoH2 implementacionDomicilio = new DomicilioDaoH2();

    @Override
    public Paciente guardar(Paciente paciente) {
        LOGGER.info("Comenzamos a persistir un paciente");
        Connection connection = null;

        try {
            implementacionDomicilio.guardar(paciente.getDomicilio());
            connection = BD.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO PACIENTES (" +
                            "NOMBRE, APELLIDO, DNI, FECHA_ALTA, DOMICILIO_ID) VALUES " +
                            "(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS
            );

            preparedStatement.setString(1, paciente.getNombre());
            preparedStatement.setString(2, paciente.getApellido());
            preparedStatement.setString(4, paciente.getDni());
            preparedStatement.setDate(5, Date.valueOf(paciente.getFechaAlta()));
            preparedStatement.setInt(5,paciente.getDomicilio().getId());

            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();

            while (rs.next()) {
                paciente.setId(rs.getInt(1));
                LOGGER.info("paciente guardado: " + paciente.getNombre() + " " + paciente.getApellido());
            }

        }  catch (Exception e) {
            LOGGER.error("Error al guardar paciente", e);
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("Error al cerrar la conexión", ex);
            }
        }
        LOGGER.info("Guardamos el paciente con nombre " + paciente.getNombre());
        return paciente;
    }

    @Override
    public List<Paciente> listar() {
        LOGGER.info("Comenzamos a listar los pacientes");
        Connection connection = null;

        List<Paciente> pacienteList = new ArrayList<>();
        Paciente paciente = null;

        try {
            connection = BD.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM PACIENTES"
            );

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                Domicilio domicilio = implementacionDomicilio.consultarPorId(rs.getInt(6));
                paciente = new Paciente(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getDate(5).toLocalDate(), domicilio);

                pacienteList.add(paciente);

                LOGGER.info("Paciente encontrado: ID = " + paciente.getId() +
                        ", Apellido = " + paciente.getApellido() +
                        ", Nombre = " + paciente.getNombre() +
                        ", Domicilio = " + paciente.getDomicilio() +
                        ", DNI = " + paciente.getDni() +
                        ", Fecha de alta = " + paciente.getFechaAlta()
                );
            }

            if (pacienteList.isEmpty()) {
                LOGGER.info("No se encontró ningún paciente.");
            } else {
                LOGGER.info("Se listaron " + pacienteList.size() + " pacientes.");
            }

        } catch (Exception e) {
            LOGGER.error("Error al listar los pacientes", e);
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("Error al cerrar la conexión", ex);
            }
        }

        return pacienteList;
    }

    @Override
    public Paciente consultarPorId(Integer id) {
        Connection connection = null;
        Paciente paciente = null;
        try {
            connection = BD.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM PACIENTES WHERE ID=?"
            );

            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                Domicilio domicilio = implementacionDomicilio.consultarPorId(rs.getInt(6));

                paciente = new Paciente(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getDate(5).toLocalDate(), domicilio);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void eliminarPorId(Integer id) {
        Connection connection = null;

        try {





        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Paciente actualizar(Paciente paciente) {
        Connection connection = null;

        try {
            connection = BD.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE PACIENTES SET NOMBRE=?, APELLIDO=?, DOMICILIO=?," +
                            "DNI=?, FECHA_ALTA=? WHERE ID=?"
            );

            preparedStatement.setString(1,paciente.getNombre());
            preparedStatement.setString(2,paciente.getApellido());
            preparedStatement.setInt(3, paciente.getDomicilio().getId());
            preparedStatement.setString(4, paciente.getDni());
            preparedStatement.setDate(5, Date.valueOf(paciente.getFechaAlta()));
            preparedStatement.setInt(6, paciente.getId());

            preparedStatement.execute();

            System.out.println("Este es el nuevo nombre del paciente" + paciente.getNombre());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return paciente;
    }
}
