package com.digitalhouse.odontologia.controller;

import com.digitalhouse.odontologia.domain.Odontologo;
import com.digitalhouse.odontologia.services.impl.OdontologoServiceImpl;
import com.digitalhouse.odontologia.services.IOdontologoService;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/odontologo")
public class OdontologoController {
    private static final Logger LOGGER = Logger.getLogger(OdontologoController.class);

    private IOdontologoService iOdontologoServiceImpl;

    public OdontologoController() {

        this.iOdontologoServiceImpl = new OdontologoServiceImpl();
    }

    @GetMapping("/id")
    public String buscarOdontologoPorId(Model model, @RequestParam Integer id){
        LOGGER.info("buscarOdontologoPorId en OdontologoController");
        Odontologo odontologo = iOdontologoServiceImpl.buscarPorId(id);

        if (odontologo == null) {
            model.addAttribute("error", "Odontólogo no encontrado");
            return "errorPage";
        }

        model.addAttribute("Nombre", odontologo.getNombre());
        model.addAttribute("Apellido", odontologo.getApellido());
        return "buscarOdontologo";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(iOdontologoServiceImpl.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Odontologo> guardar(@RequestBody Odontologo odontologo) {
        return ResponseEntity.ok(iOdontologoServiceImpl.guardar(odontologo));
    }




}
