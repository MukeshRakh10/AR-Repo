package in.mk.ar.yml;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "ar")
@Data
public class ArModuleYmlProperties {
	private Map<String,String> messages = new HashMap<String,String>();

}
