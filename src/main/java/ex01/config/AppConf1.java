package ex01.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ex01.dao.MemberDao;
import ex01.service.ChangePasswordService;
import ex01.service.MemberInfoPrint;
import ex01.service.MemberPrint;

@Configuration
@ComponentScan(basePackages = {"ex01"})
public class AppConf1 {
//	@Bean
//	public MemberDao memberDao() {
//		return new MemberDao();
//	}
	
	@Bean
	@Qualifier("printer")
	public MemberPrint memberPrint1() {
		return new MemberPrint("memberPrint1");
	}
	
	@Bean
	public MemberPrint memberPrint2() {
		return new MemberPrint("memberPrint2");
	}
	@Bean
	public MemberInfoPrint memberInfoPrint() {
		MemberInfoPrint mip = new MemberInfoPrint();
		mip.setMemberPrint(memberPrint2());	
		return mip;
	}


}
