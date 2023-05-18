package mx.yetipersonalizado.controller;

import java.util.List;

import mx.yetipersonalizado.model.Producto;
import mx.yetipersonalizado.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path="/producto/")
//@CrossOrigin(origins="http://127.0.0.1:5501")
public class ProductoController {
	private final ProductoService productoService;
	@Autowired
	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	} // constructor
	
	@GetMapping
	public List<Producto> getAllProducts(){
		return productoService.getAllProductos();
	} // getAllProducts
	
	@GetMapping (path="{ProdId}")
	public Producto getProduct(@PathVariable("ProdId") Integer id) {
		return productoService.getProducto(id);
	} // getProduct
	
	@DeleteMapping (path="{ProdId}")
	public Producto deleteProduct(@PathVariable("ProdId") Integer id) {
		return productoService.deleteProducto(id);
	} // deleteProduct
	
	@PostMapping
	public Producto addProduct(@RequestBody Producto producto) {
		return productoService.addProducto(producto);
	} // addProducto
	
	@PutMapping (path="{ProdId}")
	public Producto updateProduct(@PathVariable("ProdId") Integer id,
			@RequestParam(required = false) String nombre,
			@RequestParam(required = false)String descripcion,
			@RequestParam(required = false)String imagen,
			@RequestParam(required = false)Integer categoria,
			@RequestParam(required = false)Integer precio) {
		return productoService.updateProducto(id, nombre, descripcion, imagen, categoria, precio);
	} // updateProduct
} // class YetiPersonalizadoController
