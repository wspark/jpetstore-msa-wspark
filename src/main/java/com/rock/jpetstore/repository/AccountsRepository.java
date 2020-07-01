package com.rock.jpetstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.rock.jpetstore.domain.Accounts; 

@RepositoryRestResource(exported = false) 
public interface AccountsRepository extends JpaRepository<Accounts, String> { 
	Accounts findByUserid(String userid);
}
