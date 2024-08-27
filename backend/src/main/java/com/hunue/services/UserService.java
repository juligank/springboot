package com.hunue.services;

import com.hunue.entities.User;
import com.hunue.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

    //add
    @CacheEvict(cacheNames = "users", allEntries = true)
    public void add(User user){
        userRepository.save(user);
    }

    //delete
    @Caching(evict = {@CacheEvict (cacheNames = "user", key = "#id"), @CacheEvict(cacheNames = "users", allEntries = true ) })
    public void delete(Long id){
        userRepository.deleteById(id);
    }

    //update
    @Caching(evict = {@CacheEvict(cacheNames = "user", key ="#id"), @CacheEvict(cacheNames = "users", allEntries = true)})
    public void update(Long id, User user){
        User userToUpdate = userRepository.findById(id).get();
        userToUpdate.setName(user.getName());
        userToUpdate.setLastname(user.getLastname());
        userToUpdate.setNombreEnlazado(user.getNombreEnlazado());
        userRepository.save(userToUpdate);
    }

    //getall




    //@CacheEvict(cacheNames = "users")
 //   @Cacheable(cacheNames = "getAll",value = "cache1M")
    @Cacheable(value = "cache1M")
    public List<User> getAll(){
        waitTest();
        return (List<User>) userRepository.findAll();
    }

    //gertById
    //@Cacheable(cacheNames = "getById", key ="#id",value = "cache3M")
    @Cacheable(value = "cache1M", key = "#id")
    public User getById(Long id){
        waitTest();
        return userRepository.findById(id).get();
    }

    private void waitTest(){
        try{
            System.out.println("wait");
            Thread.sleep(2000);
            System.out.println("wait ended");

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
