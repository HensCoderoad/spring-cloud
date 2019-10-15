package com.funtl.oauth2.resources.service.impl;

import com.funtl.oauth2.resources.domain.TbContent;
import com.funtl.oauth2.resources.mapper.TbContentMapper;
import com.funtl.oauth2.resources.service.TbContentServcie;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : Hens
 * @date : 2019/9/13 15:14
 */
@Service
public class TbContentServiceImpl implements TbContentServcie {
    @Resource
    private TbContentMapper tbContentMapper;

    @Override
    public List<TbContent> selectAll() {
        return tbContentMapper.selectByExample(null);
    }
}
