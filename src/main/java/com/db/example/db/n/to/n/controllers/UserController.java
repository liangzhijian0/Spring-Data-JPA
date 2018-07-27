package com.db.example.db.n.to.n.controllers;

import com.db.example.db.n.to.n.entities.User;
import com.db.example.db.n.to.n.repositories.GroupRepository;
import com.db.example.db.n.to.n.repositories.UserRepository;
import com.db.example.db.one.to.one.dto.KlassDTO;
import com.db.example.db.one.to.one.entities.Klass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    GroupRepository groupRepository;

    @Autowired
    UserRepository userRepository;

    @Transactional
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public User createKlass(@RequestBody User user) {
//        user.getGroupList().stream().forEach(group -> group.setUserList());
        return userRepository.save(user);
    }

}
