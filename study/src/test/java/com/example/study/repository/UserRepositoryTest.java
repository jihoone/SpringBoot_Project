package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import com.example.study.model.entity.User;
import org.junit.jupiter.api.Test;

import org.testng.Assert;
//import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends StudyApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        User user = new User();

        user.setAccount("TestUser03");
        user.setEmail("TestUser03@gmail.com");
        user.setPhoneNumber("010-1111-3333");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("TestUser3");

        User newUser = userRepository.save(user);
        System.out.println("new User : " + newUser);

    }

    @Test
    @Transactional
    public void read(){

//        Optional<User> user = userRepository.findById(2L);
//
//        user.ifPresent(selectUser->{
//            System.out.println("user : " + selectUser);
//            System.out.println("email : " +selectUser.getEmail());
//        });

        Optional<User> user = userRepository.findById(5L);

        user.ifPresent(selectUser ->{
            selectUser.getOrderDetailList().stream().forEach(detail -> {

                Item item = detail.getItem();

                System.out.println(item);
            });
        });
    }

    @Test
    public void update(){
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser ->{
            selectUser.setAccount("pppp");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);
        });
    }

//    @Test
//    public void delete(){
//        Optional<User> user = userRepository.findById(2L);
//
//        user.ifPresent(selectUser ->{
//            userRepository.delete(selectUser);
//        });
//
//        Optional<User> deleteUser = userRepository.findById(2L);
//
//        if(deleteUser.isPresent()){
//            System.out.println("데이터 존재 : " + deleteUser.get());
//        }
//        else{
//            System.out.println("데이터 삭제 데이터 없음");
//        }
//    }

    @Test
    public void delete(){
        Optional<User> user = userRepository.findById(2L);

        Assert.assertTrue(user.isPresent());

        user.ifPresent(selectUser ->{
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(2L);

        Assert.assertFalse(deleteUser.isPresent());
    }

}
