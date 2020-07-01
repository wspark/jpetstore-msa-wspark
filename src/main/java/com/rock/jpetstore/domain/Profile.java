package com.rock.jpetstore.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="profile")
public class Profile {
	
	@Id
	private String userid;
	private String langpref;
	private String favcategory;
	private Boolean mylistopt;
	private Boolean banneropt;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getLangpref() {
		return langpref;
	}
	public void setLangpref(String langpref) {
		this.langpref = langpref;
	}
	public String getFavcategory() {
		return favcategory;
	}
	public void setFavcategory(String favcategory) {
		this.favcategory = favcategory;
	}
	public Boolean getMylistopt() {
		return mylistopt;
	}
	public void setMylistopt(Boolean mylistopt) {
		this.mylistopt = mylistopt;
	}
	public Boolean getBanneropt() {
		return banneropt;
	}
	public void setBanneropt(Boolean banneropt) {
		this.banneropt = banneropt;
	}
	
	@Override
	public String toString() {
		return "Profile [userid=" + userid + ", langpref=" + langpref + ", favcategory=" + favcategory + ", mylistopt="
				+ mylistopt + ", banneropt=" + banneropt + "]";
	}	
}
