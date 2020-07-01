package com.rock.jpetstore.controller;
  
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.RestController;
 
import com.rock.jpetstore.domain.Signon;
import com.rock.jpetstore.service.SignonService;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity; 

@RestController
public class SignonController {

    @Autowired
    private SignonService signonService;
   
    @RequestMapping(value = "/signon/{userid}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<Object> get(@PathVariable String userid) throws Exception{

    	HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Retry-After", "3600");
        
    	Signon signon = signonService.getSignonById(userid);
    	
        if (signon == null) { 
        	//return new ResponseEntity<>("{}", headers, HttpStatus.OK);
        	return new ResponseEntity<>(null, headers, HttpStatus.NOT_FOUND); 
        } else {
        	return new ResponseEntity<>(signon, headers, HttpStatus.OK);  
        }
    }

    @RequestMapping(value = "/signon/{userid}", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<Map<Object, Object>> update(@PathVariable String userid, @RequestBody Signon signon) {

    	HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Retry-After", "3600");
        
		Map<Object, Object> map = new HashMap<>();
		
		try {  
			System.out.println(signon);
			
			signonService.updateSignon(signon);
			
			map.put("result", "OK");  
		}catch(Exception e){
			map.put("result", "NOK");   
	    	return new ResponseEntity<>(map, headers, HttpStatus.BAD_REQUEST);  
		}
		
    	return new ResponseEntity<>(map, headers, HttpStatus.CREATED);  
	} 
}
