package sv.com.daniel.nexushare.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sv.com.daniel.nexushare.entities.Departamento;
import sv.com.daniel.nexushare.interfaces.IResponseDto;
import sv.com.daniel.nexushare.interfaces.IService_O;
import sv.com.daniel.nexushare.interfaces.IService_OI;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Departamentos_Ctrl {

	private IService_OI<IResponseDto<Object>, Integer> serviceDel;
	private IService_O<IResponseDto<List<Departamento>>> serviceGet;
	@Qualifier("updateSvc")
	private IService_OI<IResponseDto<Object>, Departamento> servicePut;
	@Qualifier("saveSvc")
	private IService_OI<IResponseDto<Object>, Departamento> servicePost;
	
	@Autowired
	public Departamentos_Ctrl(
			@Qualifier("saveSvc") IService_OI<IResponseDto<Object>, Departamento> servicePost,
			@Qualifier("updateSvc") IService_OI<IResponseDto<Object>, Departamento> servicePut,
			IService_O <IResponseDto<List<Departamento>>> serviceGet,
			IService_OI<IResponseDto<Object>, Integer> serviceDel) {
		this.servicePost = servicePost;
		this.serviceGet = serviceGet;
		this.serviceDel = serviceDel;
		this.servicePut = servicePut;
	}

	@GetMapping(value = "/dep")
	public IResponseDto<List<Departamento>> getDeps(){
		return serviceGet.process();
	}
	
	@PostMapping(value = "/dep")
	public IResponseDto<Object> saveDep (@RequestBody Departamento dep) {
		return servicePost.process(dep);
	}
	
	@DeleteMapping(value = "/dep/{id}")
	public IResponseDto<Object> delDep (@PathVariable Integer id) {
		return serviceDel.process(id);
	}
	
	@PutMapping(value = "/dep")
	public IResponseDto<Object> updDep (@RequestBody Departamento dep) {
		return servicePut.process(dep);
	}
	

}