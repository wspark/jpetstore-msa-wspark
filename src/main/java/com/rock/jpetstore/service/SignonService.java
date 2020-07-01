package com.rock.jpetstore.service;
 
import com.rock.jpetstore.domain.Signon;
import com.rock.jpetstore.repository.SignonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SignonService {
    @Autowired
    private SignonRepository signonRepository;
 
    public Signon getSignonById(String userid){
        return signonRepository.findByUsername(userid);
    }

    public void deleteSignon(String userid){
        signonRepository.deleteById(userid);
    }

    public void updateSignon(Signon signon){
        signonRepository.save(signon);
    }
}