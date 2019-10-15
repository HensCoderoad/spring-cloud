package com.funtl.oauth2.server.service;

import com.funtl.oauth2.server.domain.TbUser;

/**
 * @author : Hens
 * @date : 2019/9/13 13:49
 */
public interface TbUserService {

    public TbUser getByUsername(String username);
}
