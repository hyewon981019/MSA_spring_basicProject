package ex01;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ex01.config.AppConf1;
import ex01.config.AppConfig;
import ex01.exception.DuplicateMemberException;
import ex01.exception.MemberNotFoundException;
import ex01.exception.WrongIdPasswordException;
import ex01.service.ChangePasswordService;
import ex01.service.MemberInfoPrint;
import ex01.service.MemberListPrint;
import ex01.service.MemberRegisterService;
import ex01.service.VersionPrinter;
import ex01.vo.RegistRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MainForSpring {
	
	 private static ApplicationContext ctx = null; //컨테이너 

	public static void main(String[] args) throws IOException {
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    	
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	while(true) {
    		System.out.println("명령어를 입력하세요. (new: 등록 | chage: 변경 | list: 목록출력 | info: 회원정보 | version: 버전정보 | exit: 종료");
    		String command = reader.readLine();
    		if (command.equalsIgnoreCase("exit")) {
    			System.out.println("프로그램 종료");
    			break;
    		}
    		
    		if (command.startsWith("new ")) {
    			// new email name password confirmpassword
    			doRegist(command.split(" "));
    		} else if (command.startsWith("change ")) {
    			// change email oldpassword newpassword
    			doChangePassword(command.split(" "));
    		} else if (command.equalsIgnoreCase("list")) {
    			doPrintList();
    		} else if (command.startsWith("info ")) {
    			// info email
    			doPrintInfo(command.split(" "));
    		}  else if (command.equals("version")) {
    			doVersion();
    		}     

    	}
	}
	
	private static void doVersion() {
//		VersionPrinter versionPrinter = new VersionPrinter();
//		versionPrinter.print();
		VersionPrinter versionPrinter = ctx.getBean("versionPrinter", VersionPrinter.class);
		versionPrinter.print();
	}

	
	private static void doPrintInfo(String[] args) {
		if (args.length != 2) {
			System.out.println("info email");
			return;
		}
		
		MemberInfoPrint mip = ctx.getBean("memberInfoPrint", MemberInfoPrint.class);
		mip.printMemberInfo(args[1]);
	}


	
	private static void doPrintList() {
		MemberListPrint mlp = ctx.getBean("memberListPrint", MemberListPrint.class);
		mlp.printAll();		
	}

	
	private static void doChangePassword(String[] args) {
		// change email oldpassword newpassword
		if (args.length != 4) {
			System.out.println("change email oldpassword newpassword");
			return;
		}
		
		// ChangePasswordService cps = new ChangePasswordService(dao);
		// ChangePasswordService cps = asm.getChangePasswordService();
		ChangePasswordService cps = ctx.getBean("changePwdSvc", ChangePasswordService.class);
		try {
			cps.changePassword(args[1], args[2], args[3]);
			System.out.println("정상적으로 패스워드를 변경했습니다.");
		} catch (MemberNotFoundException e) {
			System.out.println("일치하는 회원 정보가 존재하지 않습니다.");
		} catch (WrongIdPasswordException e) {
			System.out.println("이메일과 패스워드가 일치하지 않습니다.");
		}
	}
	
	private static void doRegist(String[] args) {
		// new email name password confirmpassword
		if (args.length != 5) {
			System.out.println("new email name password confirmpassword");
			return;
		}
		
		
		// MemberRegisterService mrs = new MemberRegisterService(dao);
		// MemberRegisterService mrs = asm.getMemberRegisterService();
		MemberRegisterService mrs = ctx.getBean("memberRegSvc", MemberRegisterService.class);
		RegistRequest request = new RegistRequest();
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
