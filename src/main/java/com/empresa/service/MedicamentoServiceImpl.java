package com.empresa.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.empresa.entity.Medicamento;
import com.empresa.repository.MedicamentoRepository;

@Service
public class MedicamentoServiceImpl implements MedicamentoService {

	@Autowired
	private MedicamentoRepository servicio;
	
	@Override
	public List<Medicamento> listado() {
		return servicio.findAll();
	}

	@Override
	public Medicamento guardar(Medicamento obj) {
		return servicio.save(obj);
	}

}
