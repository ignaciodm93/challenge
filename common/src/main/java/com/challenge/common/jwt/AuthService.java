package com.challenge.common.jwt;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.challenge.common.models.AuthResponse;
import com.challenge.common.models.LoginRequest;
import com.challenge.common.models.RegisterRequest;
import com.challenge.common.models.User;
import com.challenge.common.repository.UserRepository;

import reactor.core.publisher.Mono;

@Service
public class AuthService {

	private static final String INVALID_CREDENTIALS = "invalid credentials";
	private final UserRepository userRepository;
	private final JwtService jwtService;
	private final PasswordEncoder passwordEncoder;

	public AuthService(UserRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.jwtService = jwtService;
		this.passwordEncoder = passwordEncoder;
	}

	public Mono<AuthResponse> login(LoginRequest req) {
		return userRepository.findByUsername(req.getUsername())
				.filter(user -> passwordEncoder.matches(req.getPassword(), user.getPassword()))
				.map(user -> new AuthResponse(jwtService.generateToken(user)))
				.switchIfEmpty(Mono.error(new RuntimeException(INVALID_CREDENTIALS)));
	}

	public Mono<AuthResponse> register(RegisterRequest req) {
		User user = new User(req.getUsername(), req.getLastname(), req.getLastname(), req.getCountry(),
				passwordEncoder.encode(req.getPassword()), req.getRole());
		return userRepository.save(user).map(savedUser -> new AuthResponse(jwtService.generateToken(savedUser)));
	}

}
