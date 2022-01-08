package ex01.example;

import org.springframework.beans.factory.annotation.Autowired;

import ex01.dao.MemberDao;
import ex01.service.ChangePasswordService;
import ex01.service.MemberRegisterService;

public class Assembler {

	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberRegisterService memberRegisterService;
	@Autowired
	private ChangePasswordService changePasswordSerivce;
	
//	public Assembler() {
//		memberDao = new MemberDao();
//		memberRegisterService = new MemberRegisterService(memberDao);
//		changePasswordSerivce = new ChangePasswordService(memberDao);
//	}
//	
	public MemberRegisterService getMemberRegisterService() {
		return this.memberRegisterService;
	}
	
	public ChangePasswordService getChangePasswordService() {
		return this.changePasswordSerivce;
	}
}
