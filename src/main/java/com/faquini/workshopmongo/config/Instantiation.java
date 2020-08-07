package com.faquini.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.faquini.workshopmongo.domain.Post;
import com.faquini.workshopmongo.domain.User;
import com.faquini.workshopmongo.dto.AuthorDTO;
import com.faquini.workshopmongo.dto.CommentDTO;
import com.faquini.workshopmongo.repositoty.PostRepository;
import com.faquini.workshopmongo.repositoty.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
				
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, bob, alex));
		
		Post post1 = new Post(null, sdf.parse("06/08/2020"), "Bom Dia", "Dia amanheceu ensolarado", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("07/08/2020"), "Bom Dia", "Dia amanheceu ensolarado de novo", new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Tenha um bom dia", sdf.parse("06/08/2020"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Bom para ir a praia", sdf.parse("06/08/2020"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Mais um belo dia", sdf.parse("07/08/2020"), new AuthorDTO(alex));
		
		post1.setComments(Arrays.asList(c1, c2));
		post2.setComments(Arrays.asList(c3));
				
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.setPosts(Arrays.asList(post1, post2));
		userRepository.save(maria);
		
		
	}

}
