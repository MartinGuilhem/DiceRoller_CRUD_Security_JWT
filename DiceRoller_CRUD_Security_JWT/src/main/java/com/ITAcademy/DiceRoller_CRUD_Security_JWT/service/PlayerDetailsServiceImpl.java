package com.ITAcademy.DiceRoller_CRUD_Security_JWT.service;

import static java.util.Collections.emptyList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ITAcademy.DiceRoller_CRUD_Security_JWT.dto.Player;
import com.ITAcademy.DiceRoller_CRUD_Security_JWT.repository.IPlayerRepository;


@Service
public class PlayerDetailsServiceImpl implements UserDetailsService {

	private IPlayerRepository iPlayerRepository;

	public PlayerDetailsServiceImpl(IPlayerRepository iPlayerRepository) {
		this.iPlayerRepository = iPlayerRepository;
	}
	
//	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		Player player = iPlayerRepository.findByName(name);
		if (player == null) {
			throw new UsernameNotFoundException(name);
		}
		return new User(player.getName(), player.getPassword(), emptyList());
	}
	
}
