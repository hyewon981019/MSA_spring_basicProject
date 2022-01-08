package ex01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ex01.dao.MemberDao;
import ex01.exception.MemberNotFoundException;
import ex01.exception.WrongIdPasswordException;
import ex01.vo.Member;

@Component
public class ChangePasswordService {
	
	@Autowired
	private MemberDao memberDao; //메모리 공간만 할당, 실제로 객체는 아직 x
	
	//생성자를 통해 의존 주입
//	public ChangePasswordService(MemberDao memberDao) {
//		this.memberDao = memberDao;
//	}
//	// setter 메서드를 통해서 의존객체를 주입
//	public void setMemberDao(MemberDao memberDao) {
//		this.memberDao = memberDao;
//	}
	
	
	
	// 패스워드 변경
	public void changePassword(String email, String oldPw, String newPw) throws MemberNotFoundException, WrongIdPasswordException {
		Member member = memberDao.selectByEmail(email); //멤버를 이메일로 찾음
		if (member == null) {
			throw new MemberNotFoundException();
		}
			
		member.changePassword(oldPw, newPw);
			
		memberDao.update(member);//업데이트된 멤버객체를 dao에 반영 	
	}



}
