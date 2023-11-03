package pe.edu.continental.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.continental.demo.models.Persona;

@Controller
// Ruta
@RequestMapping("/personas")
public class AppController {
    List<Persona> listaPersonas = new ArrayList<Persona>();

    @GetMapping("/inicio")
    public String index(Model model) {
        model.addAttribute("miNombre", model);
        return "personas/inicio";
    }

    @GetMapping("/lista")
    public String listaPersonas(Model model) {
        List<Persona> listaPersonas = new ArrayList<Persona>();
        listaPersonas.add(new Persona(1, "Juan", "Caballo"));
        listaPersonas.add(new Persona(2, "Keria", "de el t1"));
        listaPersonas.add(new Persona(3, "Faker", "El rey arruinado"));
        model.addAttribute("listaPersonas", listaPersonas);
        return "personas/lista";
    }

    // Subruta dinámica
    @GetMapping("/persona/{id}")
    public String detallePersona(@PathVariable Integer id, Model model) {
        listaPersonas.add(new Persona(1, "Juan", "Caballo"));
        listaPersonas.add(new Persona(2, "Keria", "de el t1"));
        listaPersonas.add(new Persona(3, "Faker", "El rey arruinado"));
        Persona persona = listaPersonas.get(id - 1);
        persona.getId();
        persona.getNombre();
        persona.getApellido();
        model.addAttribute("id", persona.getId());
        model.addAttribute("nombre", persona.getNombre());
        model.addAttribute("apellido", persona.getApellido());
        return "personas/detalle";
    }

}
