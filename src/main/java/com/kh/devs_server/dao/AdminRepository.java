package com.kh.devs_server.dao;

import com.kh.devs_server.entity.Admin;
import com.kh.devs_server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository  extends JpaRepository<Admin, Long> {

    List<Admin> findByAdminEmailAndPassword(String adminEmail, String password);
}
