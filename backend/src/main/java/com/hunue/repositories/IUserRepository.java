package com.hunue.repositories;

import com.hunue.entities.User;
import org.springframework.data.repository.CrudRepository;

//                                   ... extends JpaRepository<User, Long> {
public interface IUserRepository extends CrudRepository<User, Long>{

}
