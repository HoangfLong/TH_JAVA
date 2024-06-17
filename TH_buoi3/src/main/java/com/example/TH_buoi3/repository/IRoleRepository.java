package com.example.TH_buoi3.repository;

import com.example.TH_buoi3.entity.Role;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {

    //@Query định nghĩa các truy vấn
    @Query("SELECT r.id FROM Role r WHERE r.name = ?1")
    Long getRoleIdByName(String roleName);
}
