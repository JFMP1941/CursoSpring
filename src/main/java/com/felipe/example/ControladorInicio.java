/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.felipe.example;

import com.felipe.example.domain.Persona;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Felipe
 */
//con esta anotacion se vuelve un controlador
//de tipo rest pero con mvc
@Controller
@Slf4j
public class ControladorInicio {
//usamos la variable value para traer el valor desde el archivo 
//applicattion.properties    
    @Value("${index.saludo}")
    private String saludo;
//nos ayuda a mapear el inicio de la aplicacion, de modo tal que cuando entramos a 
//localhost:8080 nos trae la pagina que le indiquemos en el return    
    @GetMapping("/")

    public String Inicio(Model model) {
        var mensaje = "Hola mundo con thymeleaf";
        log.info("Ejecutando controlador de tipo spring MVC");
        
        //creando nuestra primera instancia del objetos persona
        var persona = new Persona();
        persona.setNombre("Juan felipe");
        persona.setApellido("Martin Puerto");
        persona.setEmail("felipemarpu@gmail.com");
        persona.setTelefono("3108784358");
        
        var persona2 = new Persona();
        persona2.setNombre("Yesica Carolina ");
        persona2.setApellido("Solano Layton");
        persona2.setEmail("yesolano@gmail.com");
        persona2.setTelefono("3155018345");
       
        //Esta es una forma de adicionar los objetos persona a un arraylist
        /* List <Persona> personas = new ArrayList<>();
        personas.add(persona);
        personas.add(persona2);*/
                
        //Esta es otra forma de adicionar los objetos persona a un arraylist
        var personas = Arrays.asList(persona, persona2);//agregamos personas, deberian aparecer listadas en la pagina de index
        //var personas = new ArrayList();//no agregamos personas deberia aparecer lista de personas vacia
        model.addAttribute("personas",personas); 
        
        
        //envio de el mapeo clave,valor del atributo
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludo", saludo);
        //envio la clave que va ser como se va a identificar el objeto en el index y envio el objeto persona
        model.addAttribute("persona",persona);
        return "index";
    }

}
