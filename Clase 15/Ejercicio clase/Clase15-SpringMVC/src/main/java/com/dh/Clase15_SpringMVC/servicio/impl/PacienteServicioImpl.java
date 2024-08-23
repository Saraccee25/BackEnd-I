package com.dh.Clase15_SpringMVC.servicio.impl;

import com.dh.Clase15_SpringMVC.dao.IDAO;
import com.dh.Clase15_SpringMVC.dao.impl.ImplementacionPaciente;
import com.dh.Clase15_SpringMVC.modelo.Paciente;
import com.dh.Clase15_SpringMVC.servicio.IPacienteServicio;

import java.util.List;

public class PacienteServicioImpl implements IPacienteServicio {
    private IDAO<Paciente> pacienteIDAO;

    public PacienteServicioImpl() {
        this.pacienteIDAO = new ImplementacionPaciente();
    }

    @Override
    public Paciente guardar(Paciente paciente) {
        return pacienteIDAO.guardar(paciente);
    }

    @Override
    public Paciente buscarPorId(Integer id) {
        return pacienteIDAO.consultarPorId(id);
    }

    @Override
    public void eliminar(Integer id) {
        pacienteIDAO.eliminarPorId(id);
    }

    @Override
    public void actualizar(Paciente paciente) {
        pacienteIDAO.actualizar(paciente);
    }

    @Override
    public List<Paciente> listarTodos() {
        return pacienteIDAO.listarTodos();
    }

}
