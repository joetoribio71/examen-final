/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exam.exam.controller;

import com.exam.exam.entity.Pedido;
import com.exam.exam.service.PedidoService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Noodlexz.CD
 */
@Controller
@RequestMapping("/ped")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/all")
    public String listarPed(Model model) {
        model.addAttribute("pedidos", pedidoService.readAll());
        return "/Ped/listarPed";
    }

    @PostMapping("/add")
    public String savePed(@Valid @ModelAttribute Pedido ped, BindingResult result, Model model, RedirectAttributes attributes) {
        pedidoService.create(ped);
        //model.addAttribute("pedidos", pedidoService.readAll());
        return "redirect:/ped/all";
    }

    @GetMapping("/form")
    public String createPed(Model model) {
        model.addAttribute("titulo", "Registrar Pedido");
        model.addAttribute("pedidos", new Pedido());
        return "/Ped/formPed";
    }

    @GetMapping("/del/{id}")
    public String deletePed(Model model, @PathVariable("id") Integer idped) {
        pedidoService.delete(idped);
        return "redirect:/ped/all";
    }//PUT,PATCH,GET;DELETE,POST

    @GetMapping("/edit/{id}")
    public String editPed(Model model, @PathVariable("id") Integer idped) {
        Pedido pedidos = pedidoService.read(idped);
        model.addAttribute("titulo", "Modificar Pedido");
        model.addAttribute("pedidos", pedidos);
        return "/Ped/formPed";
    }

    @PostMapping("/{id}")
    public String readPed(Model model, @PathVariable("id") Integer idped) {
        model.addAttribute("ped", pedidoService.read(idped));
        return "redirect:/ped";
    }
}
