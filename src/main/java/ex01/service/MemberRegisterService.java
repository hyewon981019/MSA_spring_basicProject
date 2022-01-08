package ex01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ex01.dao.MemberDao;
import ex01.exception.DuplicateMemberException;
import ex01.vo.Member;
import ex01.vo.RegistRequest;

@Component
public class MemberRegisterService {
	
//	 private MemberDao memberDao = new MemberDao(); //저장 및 관리하는 저장소 생성, 의존객체다
	@Autowired
	private MemberDao memberDao;
	
//	public MemberRegisterService(MemberDao memberDao)
//	{
//		this.memberDao = memberDao; //바로 생성하지 말고 외부주입 받아라
//	}
	 
	 public Long regist(RegistRequest req) throws DuplicateMemberException
	 {
		 Member member = memberDao.selectByEmail(req.getEmail());
		 //요청한 메일을 조회
		 
		 if(member!=null) //이미 그런 메일을 사용하는 사용자가 있으면
			 throw new DuplicateMemberException("이메일 중복" + req.getEmail());
		 
		 Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName());
		 //요청에서 온 파라미터로 새 객체 생성
		 
		 memberDao.insert(newMember); //새 멤버를 저장소에 저장, 인서트 실행하면 자동으로 아이디 넣어짐
		 return newMember.getId(); //해당 아이디 리턴
		 
		 
	 }
	 
	 
}
