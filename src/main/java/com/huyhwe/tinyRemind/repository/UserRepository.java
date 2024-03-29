package com.huyhwe.tinyRemind.repository;

import com.huyhwe.tinyRemind.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {
}
