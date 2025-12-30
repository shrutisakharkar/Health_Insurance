package com.crud.util;


import com.crud.entity.Admin;
import org.springframework.stereotype.Component;

@Component
public class SuperAdminNotifier {

    public void notifyNewAdmin(Admin admin) {
        System.out.println("[SuperAdminNotifier] New admin registration awaiting approval: " + admin.getEmail());
    }
}
 