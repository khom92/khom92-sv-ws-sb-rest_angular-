package sv.com.daniel.nexushare.services;

import java.util.List;

import org.springframework.stereotype.Service;

import sv.com.daniel.nexushare.dtos.Response_Dto;
import sv.com.daniel.nexushare.entities.Departamento;
import sv.com.daniel.nexushare.interfaces.IResponseDto;
import sv.com.daniel.nexushare.interfaces.IService_O;
import sv.com.daniel.nexushare.repositories.Departamento_Rep;

@Service
public class Departamentos_Get_Svc implements IService_O<IResponseDto<List<Departamento>>> {
	
	private Departamento_Rep repo;
	
	public Departamentos_Get_Svc(Departamento_Rep repo) {
		this.repo = repo;
	}

	@Override
	public IResponseDto<List<Departamento>> process() {
		try {
			List<Departamento> responseDepList = (List<Departamento>)repo.findAll();
			return new Response_Dto<>("200", responseDepList);
		} catch (Exception e) {
			// TODO: handle exception
			return new Response_Dto<>("500", null, "Departamento process error");
		}
		
	}
	
}
