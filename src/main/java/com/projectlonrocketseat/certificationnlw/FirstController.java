package com.projectlonrocketseat.certificationnlw;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Tudo que é retornado nessa RestController, nesta classe, será um API REST
@RestController
// Usa-se RequestMapping - Path da página
@RequestMapping("/firstcontroller")
public class FirstController {

    // Esses @alguma coisa são anotations que guiam o comportamento da aplicação
    // que por baixo dos panos são controllers
    @GetMapping("/returnfirstcontroller")
    public Usuario returnFirstController(){

        var usuario = new Usuario("Daniele", 34);
        return usuario;
    }

    @PostMapping("/thatsthepost")
    public String FirstPost()
    {return "That's THE BEST POST EVER.";}

    record Usuario(String nome, int idade){}


}
