package com.funtl.oauth2.resources.service;

import com.funtl.oauth2.resources.domain.TbContent;

import java.util.List;

/**
 * @author : Hens
 * @date : 2019/9/13 15:13
 */
public interface TbContentServcie {

    List<TbContent> selectAll();
}
