package com.u4.chan.photoapp.api.users.data;

import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<UserEntity, Long> {
    // added findByEmail method because of loadUserByUsername method inside UsersServiceImpl
    UserEntity findByEmail(String email);
}
