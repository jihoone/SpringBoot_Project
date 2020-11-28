package com.example.study.ifs;

import com.example.study.model.network.Header;
import com.example.study.model.network.request.UserApiRequest;
import com.example.study.model.network.respnse.UserApiResponse;

public interface CrudInterface <Req, Res>{

//    Header create();
//    Header<UserApiResponse> create(UserApiRequest request);
    Header<Res> create(Header<Req> request);

//    Header read(Long id);
    Header<Res> read(Long id);

//    Header update();
    Header<Res> update(Header<Req> request);

    Header delete(Long id);

}
