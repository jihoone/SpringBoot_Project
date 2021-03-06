package com.example.study.controller.api;

import com.example.study.ifs.CrudInterface;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.UserApiRequest;
import com.example.study.model.network.respnse.UserApiResponse;
import com.example.study.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResponse> {


    @Autowired
    private UserApiLogicService userApiLogicService;

//    @Override
//    @PatchMapping("")
//    public Header create() {
//        return null;
//    }

    @Override
    @PostMapping("")
    public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> request) {
        log.info("{}",request);
        return userApiLogicService.create(request);
    }

//    @Override
//    @GetMapping("{id}")
//    public Header read(@PathVariable(name = "id")Long id) {
//        return null;
//    }

//    @Override
//    @PatchMapping("")
//    public Header<UserApiResponse> create(Header<UserApiRequest> request) {
//        return null;
//    }

    @Override
    @GetMapping("{id}")
    public Header<UserApiResponse> read(@PathVariable(name = "id")Long id) {
        return null;
    }

//    @Override
//    @PutMapping("")
//    public Header<UserApiResponse> update(Header<UserApiRequest> request) {
//        return null;
//    }

//    @Override
//    @PutMapping("")
//    public Header update() {
//        return null;
//    }

    @Override
    @PutMapping("")
    public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> request) {
        return null;
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        return null;
    }

//    public Header create(){
//
//    }
//
//    public Header read(){
//
//    }


}
