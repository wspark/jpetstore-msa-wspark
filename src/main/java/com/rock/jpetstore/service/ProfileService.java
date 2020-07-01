package com.rock.jpetstore.service;

import com.rock.jpetstore.domain.Profile; 
import com.rock.jpetstore.repository.ProfileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;
 
    public Profile getProfileById(String userid){
        return profileRepository.findByUserid(userid);
    }
    public void deleteProfile(String userid){
        profileRepository.deleteById(userid);
    }
    public void updateSignon(Profile profile){
    	profileRepository.save(profile);
    }
}