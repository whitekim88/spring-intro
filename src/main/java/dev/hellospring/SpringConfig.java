package dev.hellospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.hellospring.aop.TimeTraceAop;
import dev.hellospring.repository.MemberRepository;
import dev.hellospring.service.MemberService;

@Configuration
public class SpringConfig {

  private final MemberRepository memberRepository;

  @Autowired
  public SpringConfig(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  // 직접 스프링 빈 주입
  @Bean
  public MemberService memberService() {
    return new MemberService(memberRepository);
  }

  //  @Bean
  //  public MemberRepository memberRepository() {
  //    return new MemoryMemberRepository();
  //    return new JdbcMemberRepository(dataSource);
  //    return new JdbcTemplateMemberRepository(dataSource);
  //    return new JpaMemberRepository(em);
  //  }
}
