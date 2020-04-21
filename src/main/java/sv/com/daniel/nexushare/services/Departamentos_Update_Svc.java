package sv.com.daniel.nexushare.services;

import org.springframework.stereotype.Service;

import sv.com.daniel.nexushare.dtos.Response_Dto;
import sv.com.daniel.nexushare.entities.Departamento;
import sv.com.daniel.nexushare.interfaces.IResponseDto;
import sv.com.daniel.nexushare.interfaces.IService_OI;
import sv.com.daniel.nexushare.repositories.Departamento_Rep;

@Service("updateSvc")
public class Departamentos_Update_Svc implements IService_OI<IResponseDto<Object>, Departamento> {
	
	private Departamento_Rep repo;
	
	public Departamentos_Update_Svc(Departamento_Rep repo) {
		this.repo = repo;
	}

	@Override
	public IResponseDto<Object> process(Departamento dep) {
		try {
			repo.save(dep);
			return new Response_Dto<>("200");
		} catch (Exception e) {
			// TODO: handle exception
			return new Response_Dto<>("500", null, "Departamento process error");
		}
		
	}
	
}
