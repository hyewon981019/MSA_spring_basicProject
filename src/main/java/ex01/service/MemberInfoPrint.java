package ex01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import ex01.dao.MemberDao;
import ex01.vo.Member;

@Component("infoPrint")
public class MemberInfoPrint {
	
	private MemberDao memberDao;
	private MemberPrint print;
	
	//setter로 의존 객체 주입 하는 방식 
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Autowired
	@Qualifier("printer")
	public void setMemberPrint(MemberPrint print) {
		this.print = print;
	}
	
	public void printMemberInfo(String email) {
		Member member = memberDao.selectByEmail(email);
		if (member == null) {
			System.out.println("일치하는 데이터가 없습니다.");
			return;
		}
		print.print(member);
	}


}
