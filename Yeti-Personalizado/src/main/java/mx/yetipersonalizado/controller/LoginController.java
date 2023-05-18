package mx.yetipersonalizado.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import mx.yetipersonalizado.config.JwtFilter;
import mx.yetipersonalizado.model.Token;
import mx.yetipersonalizado.model.Usuario;
import mx.yetipersonalizado.service.UsuarioService;

@RestController
@RequestMapping(path = "/login/")
//@CrossOrigin(origins="http://127.0.0.1:5501")
public class LoginController {
	private final UsuarioService usuarioService;
	
	@Autowired	
	public LoginController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;				 
	}//constructor

	@PostMapping    
	public Token loginUsuario(@RequestBody Usuario usuario) throws ServletException {
		if (usuarioService.validateUsuario(usuario)) { 
			return new Token(generateToken(usuario.getMail()));
		}//if validateUsuario
		throw new ServletException("Nombre de usuario o contraseña incorrectos");
	}//loginUsuario
	
	private String generateToken(String username) { 
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR, 10); 
		return Jwts.builder().setSubject(username).claim("role", "user")
		.setIssuedAt(new Date()).setExpiration(calendar.getTime())
		.signWith(SignatureAlgorithm.HS256, JwtFilter.secret)
		.compact();
	}//generateToken
}//class loginController

