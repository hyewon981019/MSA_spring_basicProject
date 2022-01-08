package ex01.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;

import ex01.dao.MemberDao;
import ex01.service.ChangePasswordService;
import ex01.service.MemberInfoPrint;
import ex01.service.MemberListPrint;
import ex01.service.MemberPrint;
import ex01.service.MemberRegisterService;
import ex01.service.VersionPrinter;

@Configuration
@ComponentScan(basePackages = {"ex01"})
public class AppConf2 {
	// 스프링 빈에 의존하는 다른 빈을 자동으로 주입하고 싶을 때 사용
//		@Autowired
//		private MemberDao memberDao;
//		
//		@Autowired
//		private MemberPrint memberPrint;

		@Bean
		public MemberRegisterService memberRegSvc() {
//			return new MemberRegisterService(memberDao);
			return new MemberRegisterService();
		}

		@Bean
		public ChangePasswordService changePwdSvc() {
//			ChangePasswordService pwdSvc = new ChangePasswordService();
//			return pwdSvc;
			//한줄로 줄이기
			return new ChangePasswordService();
		}

		@Bean
		public MemberListPrint memberListPrint() {
			//return new MemberListPrint(memberDao, memberPrint);
			return new MemberListPrint();
		}

		

		@Bean
		public VersionPrinter versionPrinter() {
			VersionPrinter versionPrinter = new VersionPrinter();
			versionPrinter.setMajorVersion(1);
			versionPrinter.setMinorVersion(0);
			return versionPrinter;
		}


}
