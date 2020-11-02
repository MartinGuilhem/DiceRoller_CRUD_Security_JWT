package com.ITAcademy.DiceRoller_CRUD_Security_JWT.service;

import static java.util.Collections.emptyList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ITAcademy.DiceRoller_CRUD_Security_JWT.dao.IPlayerDAO;
import com.ITAcademy.DiceRoller_CRUD_Security_JWT.dto.Player;


@Service
public class PlayerDetailsServiceImpl implements UserDetailsService {

	private IPlayerDAO iPlayerDAO;

	public PlayerDetailsServiceImpl(IPlayerDAO iPlayerDAO) {
		this.iPlayerDAO = iPlayerDAO;
	}
	
//	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		Player player = iPlayerDAO.findByName(name);
		if (player == null) {
			throw new UsernameNotFoundException(name);
		}
		return new User(player.getName(), player.getPassword(), emptyList());
	}
	
}
