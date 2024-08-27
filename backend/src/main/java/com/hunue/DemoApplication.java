package com.hunue;

import com.hunue.entities.ResidentialUnit;
import com.hunue.entities.User;
import com.hunue.repositories.IResidentialUnitRepository;
import com.hunue.repositories.IUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.util.List;


@SpringBootApplication
@EnableCaching
public class DemoApplication /*implements CommandLineRunner */{

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
	//private IUserRepository repository;
	@Autowired
	private IResidentialUnitRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/*
	@Override
	public void run(String... args) throws Exception {

		/*List<User> users = (List<User>) repository.findAll();
		users.stream().forEach(user -> {
			System.out.println(user);
		});*/

		//List<ResidentialUnit> residentialUnitList = (List<ResidentialUnit>) repository.findAll();
		//List<ResidentialUnit> residentialUnitList = (List<ResidentialUnit>) repository.findByName("27404");

	/*
	    long startTime = System.currentTimeMillis();
		List<ResidentialUnit> residentialUnitList = (List<ResidentialUnit>) repository.buscarToditos();
		long endTime = System.currentTimeMillis();
		log.info("Consulta tardo: {} ms", endTime - startTime);
		residentialUnitList.stream().forEach(residentialUnit -> {
			System.out.println("hola "+residentialUnit);
		});



	}*/
}



