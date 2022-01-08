package ex01.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ex01.exception.DuplicateMemberException;
import ex01.exception.MemberNotFoundException;
import ex01.exception.WrongIdPasswordException;
import ex01.service.ChangePasswordService;
import ex01.service.MemberRegisterService;
import ex01.vo.RegistRequest;

import java.io.*;

public class Main{
	
//	static MemberDao dao = new MemberDao(); //저장소를 실행 클래스에서 생성
	static Assembler asm = new Assembler();
	

	public static void main(String[] args) throws IOException{
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		while(true)
		{
			System.out.println("명령어를 입력하세요. (new : 등록 | change : 변경 | exit : 종료)");
			String command = reader.readLine();
			
			if(command.equalsIgnoreCase("exit"))
			{
				System.out.println("프로그램 종료");
				break;
			}
			
			if (command.startsWith("new ")) {
    			// new email name password confirmpassword
    			doRegist(command.split(" "));
    		} else if (command.startsWith("change ")) {
    			// change email oldpassword newpassword
    			doChangePassword(command.split(" "));
    		}
		}
	

	}
	
	private static void doChangePassword(String[] args)
	{
		if(args.length !=4) //인자가 4개가 아니면
		{
			System.out.println("change email oldpassword newpassword");
			return;
		}
		
		//ChangePasswordService cps = new ChangePasswordService(dao);//서비스 객체 생성, DI
		ChangePasswordService cps = asm.getChangePasswordService();
		
		try {
			cps.changePassword(args[1], args[2], args[3]);
			System.out.println("정상적으로 패스워드 변경");
		} catch (MemberNotFoundException e) {
			System.out.println("일치하는 회원정보가 조회되지 않음");
		} catch (WrongIdPasswordException e) {
			System.out.println("이메일과 패스워드가 일치되지 않음");
		}
	}
	
	private static void doRegist(String[] args)
	{
		if(args.length !=5)
		{
			System.out.println("new email name password confirmpassword");
			return;
			
		}
		
		MemberRegisterService mrs = asm.getMemberRegisterService();
		
		
		RegistRequest request = new RegistRequest(); //요청객체 
		
		request.setEmail(args[1]);
		request.setName(args[2]);
		request.setPassword(args[3]);
		request.setConfirmPassword(args[4]);
		try {
			mrs.regist(request);
			System.out.println("정상적으로 등록되었습니다.");
		} catch (DuplicateMemberException e) {
			System.out.println("이미 등록된 사용자입니다.");
		}

	}

}
