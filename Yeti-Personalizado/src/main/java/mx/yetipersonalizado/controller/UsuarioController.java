package mx.yetipersonalizado.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import mx.yetipersonalizado.model.ChangePassword;
import mx.yetipersonalizado.model.Usuario;
import mx.yetipersonalizado.service.UsuarioService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path="/usuario/")
//@CrossOrigin(origins="http://127.0.0.1:5501")
public class UsuarioController {
	private final UsuarioService usuarioService;
	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	} // constructor
	
	@GetMapping
	public List<Usuario> getAllUsers(){
		return usuarioService.getAllUsuarios();
	} // getAllUsers
	
	@GetMapping (path="{UsuId}")
	public Usuario getUser(@PathVariable("UsuId") Long id) {
		return usuarioService.getUsuario(id);
	} // getUser
	
	@DeleteMapping (path="{UsuId}")
	public Usuario deleteUser(@PathVariable("UsuId") Long id) {
		return usuarioService.deleteUsuario(id);
	} // deleteUser
	
	@PostMapping
	public Usuario addUser(@RequestBody Usuario usuario) {
		return usuarioService.addUsuario(usuario);
	} // addUser
	
	@PutMapping (path="{UsuId}")
	public Usuario updateUser(@PathVariable("UsuId") Long id,
			@RequestBody ChangePassword changePassword){
		return usuarioService.updateUsuario(id, changePassword);
	} // updateUser 
} // class UsuarioController
