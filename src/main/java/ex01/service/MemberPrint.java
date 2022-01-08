package ex01.service;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

import ex01.vo.Member;

public class MemberPrint {
	
	private String createdFrom = "";
	
	//명시적 의존주입
	public MemberPrint(String createdFrom)
	{
		this.createdFrom = createdFrom;
	}
	
	private DateTimeFormatter dateTimeFormatter;
	
	//생성자로 필드 초기화
	public MemberPrint()
	{
		dateTimeFormatter =DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"); 
		//dateTimeFormatter 객체에 지정된 날짜출력형식
	}
	
	// 멤버 객체의 내용을 형식에 맞춰서 출력
		public void print(Member member) {
			
			if(dateTimeFormatter == null)
			{
				System.out.printf("[%s] 회원정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n", 
						createdFrom, member.getId(), member.getEmail(), member.getName(), member.getRegistDate());
			}
			
			else
			{
				System.out.printf("[%s] 회원정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n", 
						createdFrom, member.getId(), member.getEmail(), member.getName(), 
						dateTimeFormatter.format(member.getRegistDate()));	
				//회원가입을 했다면 내가 지정한 날짜형식으로 출력
			}
					
		}
		
		@Autowired
		public void setDateFormatter(@Nullable DateTimeFormatter dateTimeFormatter)
		{
			//원래라면 DateTimeFormatter 타입의 빈객체를 끌어와 여기다 자동주입해줘야 하는데
			//빈으로 등록되어있지 않으니 오류남 
			this.dateTimeFormatter = dateTimeFormatter;
		}

}
