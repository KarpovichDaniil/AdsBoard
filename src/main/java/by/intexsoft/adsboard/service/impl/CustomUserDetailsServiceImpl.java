package by.intexsoft.adsboard.service.impl;

import by.intexsoft.adsboard.model.CustomUserDetails;
import by.intexsoft.adsboard.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * ������������� ��������� ���������� �� ����������� ������������ �������
 * ������� ������������ ��� ������������������ �����
 */
@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsersService userService;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		return new CustomUserDetails(userService.findByUserName(userName));
	}
}
