package com.funtl.oauth2.resources.controller;

import com.funtl.oauth2.resources.domain.TbContent;
import com.funtl.oauth2.resources.dto.ResponseResult;
import com.funtl.oauth2.resources.service.TbContentServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : Hens
 * @date : 2019/9/13 15:13
 */

@RestController
public class TbContentController {
    @Autowired
    private TbContentServcie tbContentServcie;

    @GetMapping("/view")
    public ResponseResult<List<TbContent>> list() {
        return new ResponseResult<List<TbContent>>(Integer.valueOf(HttpStatus.OK.value()), HttpStatus.OK.toString(), tbContentServcie.selectAll());
    }
}
