package com.rock.jpetstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.rock.jpetstore.domain.Profile; 

@RepositoryRestResource(exported = false) 
public interface ProfileRepository extends JpaRepository<Profile, String> { 
	Profile findByUserid(String userid);
}
