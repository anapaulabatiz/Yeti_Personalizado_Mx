package mx.yetipersonalizado.service;

import java.util.List;
import mx.yetipersonalizado.model.Producto;
import mx.yetipersonalizado.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
	private final ProductoRepository productoRepository;
	
	@Autowired
	public ProductoService(ProductoRepository productoRepository) {
		this.productoRepository= productoRepository;
		
	} // constructor
	
	public List<Producto> getAllProductos(){
		return productoRepository.findAll();
	} // getAllProductos

	public Producto getProducto(Integer id) {
		return productoRepository.findById(id).orElseThrow(
				()-> new IllegalArgumentException("El producto con id "+ id + " no existe"));
	} // getProducto

	public Producto deleteProducto(Integer id) {
		Producto tmpProd = null;
		if (productoRepository.existsById(id)) {
			tmpProd=productoRepository.findById(id).get();
			productoRepository.deleteById(id);
		}//if 
		return tmpProd;
	} // deleteProducto

	public Producto addProducto(Producto producto) {
		return productoRepository.save(producto);
	} // addProducto

	public Producto updateProducto(Integer id, String nombre, String descripcion, String imagen, Integer categoria, Integer precio) {
		Producto tmpProd = null;
		if (productoRepository.existsById(id)) {
			tmpProd= productoRepository.findById(id).get();
			if (nombre!=null)tmpProd.setNombre(nombre);
			if (descripcion !=null)tmpProd.setDescripcion(descripcion);
			if (imagen !=null)tmpProd.setImagen(imagen);
			if (categoria !=null)tmpProd.setCategoria(categoria);
			if (precio !=null)tmpProd.setPrecio(precio.intValue());
			productoRepository.save(tmpProd);
		}else {
			System.out.println("Update - El producto con id " + id + " no existe");
		}// else
		return tmpProd;
	} //updateProducto
	
} // class ProductoService