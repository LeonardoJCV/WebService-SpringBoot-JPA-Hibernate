package com.leonardojcv.springboot.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.leonardojcv.springboot.entities.Category;
import com.leonardojcv.springboot.entities.Order;
import com.leonardojcv.springboot.entities.User;
import com.leonardojcv.springboot.entities.enums.OrderStatus;
import com.leonardojcv.springboot.repositories.CategoryRepository;
import com.leonardojcv.springboot.repositories.OrderRepository;
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
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	//Método de implementação do CommandLineRunner para rodar assim que a aplicação for iniciada.
	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Electronics"); 
		Category cat2 = new Category(null, "Books"); 
		Category cat3 = new Category(null, "Computers");
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		//no Terceiro parametro, o usuario entra no construtor e faz a associação entre objetos
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.WAITING_PAYMENT, u1); 
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.PAID, u2); 
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT,u1); 
		
		//Método para salvar as instancias em forma de lista no banco de dados
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
	}
	
}
