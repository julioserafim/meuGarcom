package com.projeto.ufc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.ufc.dao.GarcomDao;
import com.projeto.ufc.model.Garcom;

@Transactional
@Controller
public class GarcomController {
	
	@Autowired
	private GarcomDao garcomDao;
	
	@RequestMapping("/inserirGarcomFormulario")
	public String inserirGarcomFormulario(){
		return "página de cadastro garçom";
	}
	
	@RequestMapping("/inserirGarcom")
	public ModelAndView inserirGarcom(@Valid Garcom garcom, BindingResult result){
		
		ModelAndView mv = new ModelAndView("página de cadastro garçom");
		garcomDao.save(garcom);
		mv.addObject("mensagem", "Garçom cadastrado com sucesso");
		return mv;
	}
	
	@RequestMapping("/apagarGarcom")
	public ModelAndView apagarGarcom(@RequestParam(value = "garcom") Long codigoGarcom){
		ModelAndView mv = new ModelAndView("GarcomApagadoSucesso");
		garcomDao.delete(codigoGarcom);
		return mv;
	}
	
	@RequestMapping("/listarGarcons")
	public ModelAndView listarGarcons(@Valid Garcom garcom, BindingResult result){
		List<Garcom> todosGarcons = garcomDao.findAll();
		ModelAndView mv = new ModelAndView("ListarGarcons");
		mv.addObject("garcos", todosGarcons);
		return mv;
		
	}
	
}
