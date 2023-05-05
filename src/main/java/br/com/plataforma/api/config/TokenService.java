package br.com.plataforma.api.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.plataforma.api.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	@Value("${jwt.expiration}")
	private String expiration;
	
	@Value("${jwt.secret}")
	private String secret;
	

	public String gerarToken(Authentication authentication) {
	

			
		Usuario logado = (Usuario) authentication.getPrincipal();
		Date hoje = new Date();
	
		Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));


		
		return Jwts.builder()
				.setIssuer("API do projeto Guarani")
				.setSubject(logado.getId_usuario().toString())
				.setIssuedAt(hoje)
				.setExpiration(dataExpiracao)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();


	}


	
	//valida se o token é valido
	public boolean isTokenValido(String token) {
		
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		
		}
	}


	//pega o id do usuario correspondente ao token
	public Long getIdUsuario(String token) {
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return Long.parseLong(claims.getSubject());
	}
	

	

}