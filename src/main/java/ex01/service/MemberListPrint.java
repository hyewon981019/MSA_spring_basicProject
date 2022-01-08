package ex01.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import ex01.dao.MemberDao;
import ex01.vo.Member;

@Component("listPrint")
public class MemberListPrint {
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	@Qualifier("printer")
	private MemberPrint print;
	
	// 생성자를 이용해서 의존객체를 주입
//	public MemberListPrint(MemberDao memberDao, MemberPrint print) {
//		this.memberDao = memberDao;
//		this.print = print;
//	}
	
	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
		members.forEach(m -> print.print(m));
	}


}
