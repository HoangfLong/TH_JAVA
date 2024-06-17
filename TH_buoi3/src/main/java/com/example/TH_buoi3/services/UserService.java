package com.example.TH_buoi3.services;

import com.example.TH_buoi3.entity.User;
import com.example.TH_buoi3.repository.IRoleRepository;
import com.example.TH_buoi3.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    //
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRoleRepository roleRepository;

    public void save(User user) {
        userRepository.save(user);

        //định nghĩa trong các đối tượng userRepository và
        //roleRepository để thêm một quyền cho một người dùng trong hệ thống.
        Long userId = userRepository.getUserIdByUserName(user.getUsername());
        Long roleId = roleRepository.getRoleIdByName("USER");
        if(roleId != 0 && userId != 0) {
            userRepository.addRoleToUser(userId, roleId);
        }
    }
}
