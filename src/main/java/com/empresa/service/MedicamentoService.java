package com.empresa.service;

import java.util.List;
import com.empresa.entity.Medicamento;

public interface MedicamentoService {
	
	public abstract List<Medicamento> listado();
	public abstract Medicamento guardar(Medicamento obj);
}
