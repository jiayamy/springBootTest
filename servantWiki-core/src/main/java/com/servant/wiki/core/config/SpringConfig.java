package com.servant.wiki.core.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring")
public class SpringConfig {
	
	private Profiles profiles;
	
	public Profiles getProfiles() {
		return profiles;
	}

	public void setProfiles(Profiles profiles) {
		this.profiles = profiles;
	}

	public static class Profiles {
		
		private String active;

		public String getActive() {
			return active;
		}

		public void setActive(String active) {
			this.active = active;
		}
		
		
	}
}
