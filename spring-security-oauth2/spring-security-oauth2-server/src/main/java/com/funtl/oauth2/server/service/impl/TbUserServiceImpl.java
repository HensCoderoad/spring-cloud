package com.funtl.oauth2.server.service.impl;

import com.funtl.oauth2.server.domain.TbUser;
import com.funtl.oauth2.server.domain.TbUserExample;
import com.funtl.oauth2.server.mapper.TbUserMapper;
import com.funtl.oauth2.server.service.TbUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : Hens
 * @date : 2019/9/13 13:50
 */
@Service
public class TbUserServiceImpl implements TbUserService {
    @Resource
    private TbUserMapper tbUserMapper;

    @Override
    public TbUser getByUsername(String username) {
        TbUserExample tbUserExample = new TbUserExample();
        tbUserExample.createCriteria().andUsernameEqualTo(username);
        TbUser tbUser = tbUserMapper.selectByExample(tbUserExample).get(0);
        return tbUser;
    }
}
