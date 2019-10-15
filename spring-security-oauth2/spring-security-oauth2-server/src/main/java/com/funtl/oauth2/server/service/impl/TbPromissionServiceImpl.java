package com.funtl.oauth2.server.service.impl;

import com.funtl.oauth2.server.domain.TbPermission;
import com.funtl.oauth2.server.mapper.TbPermissionMapper;
import com.funtl.oauth2.server.service.TbPromissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : Hens
 * @date : 2019/9/13 14:00
 */
@Service
public class TbPromissionServiceImpl implements TbPromissionService {
    @Resource
    private TbPermissionMapper tbPermissionMapper;

    @Override
    public List<TbPermission> selectByUserId(Long userId) {
        return tbPermissionMapper.selectByUserId(userId);
    }
}
