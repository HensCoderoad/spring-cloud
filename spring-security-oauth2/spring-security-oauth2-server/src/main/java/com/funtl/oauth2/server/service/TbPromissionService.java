package com.funtl.oauth2.server.service;

import com.funtl.oauth2.server.domain.TbPermission;

import java.util.List;

/**
 * @author : Hens
 * @date : 2019/9/13 13:59
 */
public interface TbPromissionService {

    List<TbPermission> selectByUserId(Long userId);
}
