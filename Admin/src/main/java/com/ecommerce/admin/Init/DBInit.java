package com.ecommerce.admin.Init;

import com.ecommerce.library.service.Impl.AdminServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {

    private final AdminServiceImpl adminService;

    public DBInit(AdminServiceImpl adminService) {
        this.adminService = adminService;
    }

    @Override
    public void run(String... args) throws Exception {
        adminService.initRoles();
    }
}
