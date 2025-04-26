package com.khlebnikovevgeniy.securitycrudapi.init;

import static java.util.Arrays.asList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.khlebnikovevgeniy.securitycrudapi.model.Role;
import com.khlebnikovevgeniy.securitycrudapi.repository.RoleRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ApplicationStartRunner implements CommandLineRunner {
	private final RoleRepository roleRepository;

	@Override
	public void run(String... args) throws Exception {
		Role roleUser = new Role(1L, "123", "ROLE_USER");
		Role roleAdmin = new Role(2L, "456", "ROLE_ADMIN");
		roleRepository.saveAll(asList(roleUser, roleAdmin));
	}

}
