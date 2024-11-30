package com.crud.crud_app.repository;

import com.crud.crud_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Long> {
}
