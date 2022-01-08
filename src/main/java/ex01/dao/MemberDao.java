package ex01.dao;

import java.util.Map;

import org.springframework.stereotype.Component;

import ex01.vo.Member;

import java.util.HashMap;
import java.util.Collection;

@Component
public class MemberDao {
	
	private Map<String, Member> map = new HashMap<>(); //이메일을 키로 설정
	
	private long nextId = 0;//아이디 자동 카운트
	
	public Member selectByEmail(String email)
	{
		//파라미터로 전달된 이메일과 일치하는 회원을 조회해서 반환
		return map.get(email);
	}
	
	public void insert(Member member) {
		nextId ++;
		member.setId(nextId);
		map.put(member.getEmail(), member); //파라미터로 전달된 회원 정보를 가지고 map에 회원 저장
		
	}
	
	public Collection<Member> selectAll() {
		return map.values();//모든 회원 반환
	}
	
	public void update(Member member)
	{
		map.put(member.getEmail(), member);
	}

}
