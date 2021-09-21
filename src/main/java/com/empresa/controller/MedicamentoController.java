package com.empresa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.empresa.entity.Medicamento;
import com.empresa.service.MedicamentoService;
import com.empresa.util.Constantes;

@RestController
@RequestMapping("/rest/medicamento")
@CrossOrigin(origins = "http://localhost:4200")
public class MedicamentoController {

	@Autowired
	MedicamentoService servicio;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Medicamento>> listaMedicamento(){
		List<Medicamento> temp = servicio.listado();
		return ResponseEntity.ok(temp);
	}
	
	@PostMapping()
	@ResponseBody
	public ResponseEntity<Map<String,Object>> guardarMedicamento(@RequestBody Medicamento obj){
		Map<String, Object> tempOut = new HashMap<>();
		try {
			Medicamento medicinaOut = servicio.guardar(obj);
			if (medicinaOut == null) {
				tempOut.put("message", Constantes.MENSAJE_REG_ERROR);
			}else {
				tempOut.put("message", Constantes.MENSAJE_REG_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			tempOut.put("message", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(tempOut);
	}
}
