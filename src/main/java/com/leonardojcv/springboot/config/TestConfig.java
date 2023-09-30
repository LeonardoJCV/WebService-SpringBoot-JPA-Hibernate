package com.leonardojcv.springboot.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.leonardojcv.springboot.entities.User;
import com.leonardojcv.springboot.repositories.UserRepository;

//Anotação @configuration indica ao Spring que trata-se de uma classe de configuração
//Anotação @Profile indica ao spring que trata-se de uma classe de configuração especifica para o perfil de teste
//Classe para database seeding (popular o banco de dados)

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	//Anotação @Autowired associa uma instancia de UserReposiroy, para injeção de dependencia.
	@Autowired
	private UserRepository userRepository;

	//Método de implementação do CommandLineRunner para rodar assim que a aplicação for iniciada.
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		//Método para salvar as instancias em forma de lista no banco de dados
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
	
}
