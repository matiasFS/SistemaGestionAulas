package com.sistema.GestionAulas.PedidoParaFinalOCurso.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.GestionAulas.PedidoParaFinalOCurso.Entity.Curso;
import com.sistema.GestionAulas.PedidoParaFinalOCurso.Entity.Final;
import com.sistema.GestionAulas.PedidoParaFinalOCurso.Service.NotaPedidoService;
import com.sistema.GestionAulas.Universidad.Service.MateriaService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PedidoController {

    @Autowired
    @Qualifier("notaPedidoService")
    public NotaPedidoService pedidoService;

    @Autowired
    @Qualifier("materiaService")
    public MateriaService materiaService;

    @PostMapping("/final")
    public ResponseEntity<Final> createPedidoFinal(@RequestBody PedidoFinalRequest pedidoFinalRequest) {
        return ResponseEntity.ok(pedidoService.saveFinal(pedidoFinalRequest));
    }

    
    @PostMapping("/curso")
    public ResponseEntity<Curso> createPedidoCurso(@RequestBody PedidoCursoRequest pedidoCursoRequest) {
        return ResponseEntity.ok(pedidoService.saveCurso(pedidoCursoRequest));
    }
/*
    @Secured("ROLE_ASISTENTE")
    @PostMapping("/pedidoenviadocurso")
    public ModelAndView pedidoCursoEnviado(@Valid @ModelAttribute Curso cursoPedido, RedirectAttributes attributes) {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.REDIRECT_HOME);
        pedidoService.insertOrUpdateCurso(cursoPedido);

        attributes.addFlashAttribute("success", "Pedido enviado con exito");

        return mAV;
    }

    @Secured({ "ROLE_ADMIN_GENERAL", "ROLE_ASISTENTE" })
    @GetMapping("/listaPedidos")
    public ModelAndView listarPedidos() {

        ModelAndView mAV = new ModelAndView(ViewRouteHelper.PEDIDOSLISTAR);

        List<Final> final1 = pedidoService.getAll();
        List<Curso> curso = pedidoService.getAll1();
        List<Final> final3 = new ArrayList<>();
        List<Curso> curso3 = new ArrayList<>();
        for (Final final2 : final1) {
            if (final2.getEspacio() == null) {
                final2.setEspacio(new Espacio());
                final2.getEspacio().setAula(new Aula());
                final2.getEspacio().getAula().setEdificio(new Edificio());
                final3.add(final2);
            } else {
                final3.add(final2);
            }
        }
        for (Curso curso2 : curso) {
            if (curso2.getEspacio() == null) {
                curso2.setEspacio(new Espacio());
                curso2.getEspacio().setAula(new Aula());
                curso2.getEspacio().getAula().setEdificio(new Edificio());
                curso3.add(curso2);
            } else {
                curso3.add(curso2);
            }
        }

        mAV.addObject("final1", final1);
        mAV.addObject("curso", curso);

        return mAV;

    }

    @Secured({"ROLE_ADMIN_GENERAL","ROLE_ASISTENTE"})
    @GetMapping("/deleteFinal/{id}")
    public String eliminarFinal(@PathVariable("id") Long idPedido, RedirectAttributes attribute) {

        Final final1 = null;
        if (idPedido > 0) {
            final1 = pedidoService.buscarPorID(idPedido);
            if (final1 == null) {
                attribute.addFlashAttribute("error", "*ERROR* el pedido solicitado no existe");
                return ViewRouteHelper.REDIRECT_PEDIDO;
            }else{
                pedidoService.eliminarFinal(idPedido);

            }
        }else{
            attribute.addFlashAttribute("error", "*ERROR* el pedido solicitado no existe");
            return ViewRouteHelper.REDIRECT_PEDIDO;

        }
        
       
        attribute.addFlashAttribute("warning", "Pedido eliminado con Exito!");

        return ViewRouteHelper.REDIRECT_PEDIDO;
    }

    @Secured({"ROLE_ADMIN_GENERAL","ROLE_ASISTENTE"})
    @GetMapping("/deleteCurso/{id}")
    public String eliminarCurso(@PathVariable("id") Long idPedido, RedirectAttributes attribute){
        Curso curso1 = null;
        if (idPedido > 0) {
            curso1 = pedidoService.buscarPorIDCurso(idPedido);
            if (curso1 == null) {
                System.out.println("hola");
                attribute.addFlashAttribute("error", "*ERROR* el pedido solicitado no existe");
                return ViewRouteHelper.REDIRECT_PEDIDO;
            }else{
                pedidoService.eliminarCurso(idPedido);
            }
        }else{
            attribute.addFlashAttribute("error", "*ERROR* el pedido solicitado no existe");
            return ViewRouteHelper.REDIRECT_PEDIDO;

        }
       
        attribute.addFlashAttribute("warning", "Pedido eliminado con Exito!");

        return ViewRouteHelper.REDIRECT_PEDIDO;
    }*/
}

