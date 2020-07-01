package com.rock.jpetstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.rock.jpetstore.domain.Account; 

@RepositoryRestResource(exported = false) 
public interface AccountRepository extends JpaRepository<Account, String> { 
	Account findByUserid(String userid);
}
