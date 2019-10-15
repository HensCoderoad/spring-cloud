package com.funtl.oauth2.server.config.service;

import com.funtl.oauth2.server.domain.TbPermission;
import com.funtl.oauth2.server.domain.TbUser;
import com.funtl.oauth2.server.service.TbPromissionService;
import com.funtl.oauth2.server.service.TbUserService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 认证和授权
 *
 * @author : Hens
 * @date : 2019/9/13 14:02
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private TbUserService userService;
    @Autowired
    private TbPromissionService tbPromissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TbUser byUsername = userService.getByUsername(username);
        List<GrantedAuthority> grantedAuthorityList = Lists.newArrayList();
        if (byUsername != null) {
            List<TbPermission> tbPermissions = tbPromissionService.selectByUserId(byUsername.getId());
            tbPermissions.forEach(tbPermission -> {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(tbPermission.getEnname());
                grantedAuthorityList.add(grantedAuthority);
            });
        }
        return new User(byUsername.getUsername(), byUsername.getPassword(), grantedAuthorityList);
    }
}
