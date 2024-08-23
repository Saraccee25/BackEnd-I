package com.dh.Clase15_SpringMVC.controller;

import com.dh.Clase15_SpringMVC.modelo.Paciente;
import com.dh.Clase15_SpringMVC.servicio.IPacienteServicio;
import com.dh.Clase15_SpringMVC.servicio.impl.PacienteServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping("/paciente")
public class PacienteController {
    private IPacienteServicio pacienteServicio;

    @Autowired
    public PacienteController(IPacienteServicio pacienteServicio) {
        this.pacienteServicio = pacienteServicio;
    }

    @GetMapping("/id")
    public String buscarPacientePorId(Model model, @RequestParam Integer id) {
        Paciente paciente = pacienteServicio.buscarPorId(id);
        model.addAttribute("nombre", paciente.getNombre());
        model.addAttribute("apellido", paciente.getApellido());
        return "buscarPaciente";
    }
}

