package com.rock.jpetstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.rock.jpetstore.domain.Signon; 

@RepositoryRestResource(exported = false) 
public interface SignonRepository extends JpaRepository<Signon, String> { 
	Signon findByUsername(String userid);
}
