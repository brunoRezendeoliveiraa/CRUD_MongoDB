package com.cadastro.cadastroUsuarios.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cadastro.cadastroUsuarios.domain.User;

public interface UserRepository extends MongoRepository<User, String> {
}
