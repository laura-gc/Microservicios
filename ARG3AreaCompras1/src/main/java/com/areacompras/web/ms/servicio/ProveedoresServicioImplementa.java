package com.areacompras.web.ms.servicio;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.areacompras.web.ms.modelo.Proveedores;
import com.areacompras.web.ms.repositorio.ProveedoresRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProveedoresServicioImplementa implements ProveedoresServicio{

//	private static final ProveedoresRepositorio ProveedoresRepositorio = null;
//	@Autowired
//	private final ProveedoresRepositorio proveedoresRepositorio=ProveedoresRepositorio;
	
	private final ProveedoresRepositorio proveedoresRepositorio;
	
	@Override
	public List<Proveedores> BuscarTodosProveedores() {
		return proveedoresRepositorio.findAll();
	}

	@Override
	public Proveedores BuscarPorIdProveedor(int idProveedor) {
		return proveedoresRepositorio.findById(idProveedor).orElse(null);
	}

	@Override
	public Proveedores crearProveedor(Proveedores proveedores) {
		proveedores.setFechaRegistro(new Date());
		return proveedoresRepositorio.save(proveedores);
	}

	@Override
	public Proveedores editarProveedor(Proveedores proveedores) {
		Proveedores proveedoresDB=BuscarPorIdProveedor(proveedores.getIdProveedor());
		if (null == proveedoresDB) {
			return null;
		}
		proveedoresDB.setRuc(proveedores.getRuc());
		proveedoresDB.setRazonSocial(proveedores.getRazonSocial());
		proveedoresDB.setTelefono(proveedores.getTelefono());
		proveedoresDB.setCorreo(proveedores.getCorreo());
		proveedoresDB.setDireccion(proveedores.getDireccion());
		//proveedoresDB.setFechaRegistro(proveedores.getFechaRegistro());
		return proveedoresRepositorio.save(proveedoresDB);
	}

	@Override
	public void eliminarProveedor(int idProveedor) {		
		proveedoresRepositorio.deleteById(idProveedor);
	}

}
