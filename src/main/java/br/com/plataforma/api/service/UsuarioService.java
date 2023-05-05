package br.com.plataforma.api.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataforma.api.model.Usuario;
import br.com.plataforma.api.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public List<Usuario> buscarTodosUsuario(){
		return usuarioRepository.findAll();
	}
	
	@Transactional
	public Usuario salvarNovoUsuario(Usuario usuario) {
		Boolean emailEmUso = usuarioRepository.findByEmail(usuario.getEmail())
				.stream()
				.anyMatch(usuarioExistente -> !usuarioExistente.equals(usuario));
		if(emailEmUso) {
			throw new RuntimeException("Já existe um usuario cadastrado com esse E-mail");
		}
		return usuarioRepository.save(usuario);
	}
}
