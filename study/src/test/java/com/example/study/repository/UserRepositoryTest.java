package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import com.example.study.model.entity.User;
import org.junit.jupiter.api.Test;

import org.testng.Assert;
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
//        User user = new User();
//
//        user.setAccount("TestUser04");
//        user.setEmail("TestUser04@gmail.com");
//        user.setPhoneNumber("010-1111-4444");
//        user.setCreatedAt(LocalDateTime.now());
//        user.setCreatedBy("TestUser4");
//
//        User newUser = userRepository.save(user);
//        System.out.println("new User : " + newUser);

        String account = "Test01";
        String password = "Test01";
        String status = "REGISTERED";
        String email = "Test01@gmail.com";
        String phoneNumber = "010-1111-2222";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        user.setCreatedAt(createdAt);
        user.setCreatedBy(createdBy);

        User newUser = userRepository.save(user);
        Assert.assertNotNull(newUser);

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

//        Optional<User> user = userRepository.findById(5L);

//        Optional<User> user = userRepository.findByAccount("TestUser03");
//
//        user.ifPresent(selectUser ->{
//            selectUser.getOrderDetailList().stream().forEach(detail -> {
//
//                Item item = detail.getItem();
//
//                System.out.println(item);
//            });
//        });

        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");
        Assert.assertNotNull(user);
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
        Optional<User> user = userRepository.findById(4L);

        Assert.assertTrue(user.isPresent());

        user.ifPresent(selectUser ->{
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(4L);

        Assert.assertFalse(deleteUser.isPresent());
    }

}
