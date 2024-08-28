package com.dh.Clase15_SpringMVC.service.impl;

import com.dh.Clase15_SpringMVC.dao.IDAO;
import com.dh.Clase15_SpringMVC.dao.impl.ImplementacionTurnoList;
import com.dh.Clase15_SpringMVC.entity.Turno;
import com.dh.Clase15_SpringMVC.service.ITurnoServicio;

import java.util.List;

public class TurnoServicioImpl implements ITurnoServicio {

    private IDAO<Turno> iDao;

    public TurnoServicioImpl () {
        this.iDao = new ImplementacionTurnoList();
    }

    @Override
    public Turno guardar(Turno turno) {
        return iDao.guardar(turno);
    }

    @Override
    public Turno buscarPorId(Integer id) {
        return iDao.consultarPorId(id);
    }

    @Override
    public List<Turno> listarTodos() {
        return iDao.listarTodos();
    }
}