package com.projectcommerce.dscommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectcommerce.dscommerce.entities.User;
import com.projectcommerce.dscommerce.services.exceptions.ForbiddenException;

@Service
public class AuthService {
    
    @Autowired
    private UserService userService;

    public void validadeSelfOrAdmin(Long userId){
        User me = userService.authenticated();
        if(!me.hasRole("ROLE_ADMIN") && !me.getId().equals(userId)){
            throw new ForbiddenException("Acess Denied");
        }
    }

}
