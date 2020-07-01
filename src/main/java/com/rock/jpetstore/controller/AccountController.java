package com.rock.jpetstore.controller;
 
import java.util.HashMap;
import java.util.List;
import java.util.Map;
  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.RestController;

import com.rock.jpetstore.domain.Account;
import com.rock.jpetstore.domain.Accounts;
import com.rock.jpetstore.service.AccountService;
import com.rock.jpetstore.service.ProfileService;
import com.rock.jpetstore.service.SignonService;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity; 

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private ProfileService profileService;
    @Autowired
    private SignonService signonService;
 
    //@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/accounts/all", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<Object> all() throws Exception{
    	
    	HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Retry-After", "3600");
        
    	List<Accounts> accounts = accountService.getAll(); 
    	
        if (accounts == null) { 
        	return new ResponseEntity<>(null, headers, HttpStatus.NOT_FOUND); 
        } else {
        	return new ResponseEntity<>(accounts, headers, HttpStatus.OK);  
        }
    }
    
    //@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/accounts", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<Object> list() throws Exception{
    	
    	HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Retry-After", "3600");
        
    	List<Account> account = accountService.getAccountList(); 
    	
        if (account == null) { 
        	return new ResponseEntity<>(null, headers, HttpStatus.NOT_FOUND); 
        } else {
        	return new ResponseEntity<>(account, headers, HttpStatus.OK);  
        }
    }

    @RequestMapping(value = "/accounts/{userid}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<Object>  get(@PathVariable String userid) throws Exception{
    	
    	HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Retry-After", "3600");
        
    	Account account = accountService.getAccountById(userid);    	  
        
        if (account == null) {
        	//return new ResponseEntity<>("{}", headers, HttpStatus.OK);
        	return new ResponseEntity<>(null, headers, HttpStatus.NOT_FOUND);        	 
        } else {
        	return new ResponseEntity<>(account, headers, HttpStatus.OK);  
        }
    }
     
	@RequestMapping(value = "/accounts/{userid}", method = RequestMethod.DELETE)
	public ResponseEntity<Map<Object, Object>> delete(@PathVariable String userid) {

    	HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Retry-After", "3600");
        
		Map<Object, Object> map = new HashMap<>();
		
		try {
			accountService.deleteAccount(userid);
			//profileService.deleteProfile(userid);
			//signonService.deleteSignon(userid); 

			map.put("result", "OK");  
		}catch(Exception e){
			map.put("result", "NOK");   
		}

    	return new ResponseEntity<>(map, headers, HttpStatus.ACCEPTED);  
	}
    

    @RequestMapping(value = "/accounts", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<Map<Object, Object>> insert(@RequestBody Accounts accounts) {

    	HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Retry-After", "3600");
        
		Map<Object, Object> map = new HashMap<>();
		
		try {  
			System.out.println(accounts);
			
			accountService.insertAccount(accounts);
			
			map.put("result", "OK");  
		}catch(Exception e){
			map.put("result", "NOK");   
	    	return new ResponseEntity<>(map, headers, HttpStatus.BAD_REQUEST);  
		}
		
    	return new ResponseEntity<>(map, headers, HttpStatus.CREATED);  
	}

    @RequestMapping(value = "/accounts/{userid}", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<Map<Object, Object>> update(@PathVariable String userid, @RequestBody Accounts accounts) {

    	HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Retry-After", "3600");
        
		Map<Object, Object> map = new HashMap<>();
		
		try {  
			System.out.println(accounts);
			
			accountService.insertAccount(accounts);
			
			map.put("result", "OK");  
		}catch(Exception e){
			map.put("result", "NOK");   
	    	return new ResponseEntity<>(map, headers, HttpStatus.BAD_REQUEST);  
		}
		
    	return new ResponseEntity<>(map, headers, HttpStatus.CREATED);  
	}
}
