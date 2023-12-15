package com.danram.user.service.member;

import com.danram.user.domain.Authority;
import com.danram.user.domain.Member;
import com.danram.user.dto.request.login.OauthLoginRequestDto;
import com.danram.user.dto.request.member.MemberEditRequestDto;
import com.danram.user.dto.response.member.MemberAdminResponseDto;
import com.danram.user.dto.request.token.TokenReissueResponseDto;
import com.danram.user.dto.response.login.LoginResponseDto;
import com.danram.user.dto.response.member.MemberInfoResponseDto;
import com.danram.user.dto.response.member.MemberResponseDto;
import com.danram.user.dto.response.token.TokenResponseDto;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    public List<Member> findAll();
    public Optional<Member> checkDuplicatedEmail(String email);
    public LoginResponseDto signUp(OauthLoginRequestDto dto);
    public LoginResponseDto signIn(Member member);
    public List<Authority> getAuthorities();
    public String verifyMember();
    public MemberAdminResponseDto getMemberInfo(String memberId);
    public List<MemberAdminResponseDto> getMembers();
    public MemberResponseDto getInfo();
    public MemberInfoResponseDto editInfo(MemberEditRequestDto memberEditRequestDto, String upload);
    public void signOut();
    public TokenResponseDto reissueAccessToken();
}
