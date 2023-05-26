package br.com.plataforma.api.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import br.com.plataforma.api.repository.UsuarioRepository;



@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter{

	
	@Autowired
	private AutenticacaoService autenticacaoService;
	@Autowired
	private TokenService tonkenService;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
	
		return super.authenticationManager();
	}
	
	
	//Configuracao de autenticação. controle de acesso login
	@Override
	protected void configure (AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	//Configuraçao de autorização. acesso a url 
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/h2-console/**").permitAll()
		.antMatchers(HttpMethod.POST, "/login").permitAll()
		.antMatchers(HttpMethod.POST, "/usuarios/*").permitAll()
		
		.anyRequest().authenticated()
		.and().csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().addFilterBefore(new AutenticacaoViaTokenFilter(tonkenService, usuarioRepository), UsernamePasswordAuthenticationFilter.class);
	}
	
	//Configuração de resursos estaticos. js, css, imagens e etc.
	@Override
	public void configure(WebSecurity web) throws Exception{
		 web.ignoring().antMatchers("/**.html", "/v2/api-docs", "/webjars/**","/configuration/**", "/swagger-resources/**");
		web.ignoring().antMatchers("/h2-console/**");

	}

}

