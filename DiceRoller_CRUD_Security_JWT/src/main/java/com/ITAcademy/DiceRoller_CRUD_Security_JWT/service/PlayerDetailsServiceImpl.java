package com.ITAcademy.DiceRoller_CRUD_Security_JWT.service;

import static java.util.Collections.emptyList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ITAcademy.DiceRoller_CRUD_Security_JWT.dao.IPlayerDAO;
import com.ITAcademy.DiceRoller_CRUD_Security_JWT.dto.Player;


public class PlayerDetailsServiceImpl implements UserDetailsService {

	private IPlayerDAO iPlayerDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Player usuario = iPlayerDAO.findByUsername(username);
		if (usuario == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(usuario.getName(), usuario.getPassword(), emptyList());
	}
	
}
