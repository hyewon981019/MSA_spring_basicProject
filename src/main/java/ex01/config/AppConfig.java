package ex01.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"ex01"})
@Import({AppConf1.class, AppConf2.class}) //새로운 설정파일이 추가되면 여기만 수정 
public class AppConfig {

	
}
