package com.danram.login.service.login;

import com.danram.login.dto.response.login.OauthLoginResponseDto;
import com.danram.login.service.oauth.NaverOauth;
import com.danram.login.service.oauth.SocialLoginType;
import com.danram.login.service.oauth.SocialOauth;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OAuthService {

    private final List<SocialOauth> socialOauthList;
    private final HttpServletResponse response;

    public void request(SocialLoginType socialLoginType) {
        SocialOauth socialOauth = this.findSocialOauthByType(socialLoginType);
        String redirectURL = socialOauth.getOauthRedirectURL();

        try {
            response.sendRedirect(redirectURL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public OauthLoginResponseDto getLoginResponseDto(SocialLoginType socialLoginType, String code) {
        SocialOauth socialOauth = this.findSocialOauthByType(socialLoginType);

        if (socialOauth instanceof NaverOauth) {
            String accessToken = socialOauth.getAccessToken(code);
            String profileJson = ((NaverOauth) socialOauth).getUserProfile(accessToken);
            return socialOauth.getLoginResponseDto(profileJson);
        } else {
            String idToken = socialOauth.getAccessToken(code);
            return socialOauth.getLoginResponseDto(idToken);
        }
    }

    private SocialOauth findSocialOauthByType(SocialLoginType socialLoginType) {
        return socialOauthList.stream()
                .filter(x -> x.type() == socialLoginType)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("알 수 없는 SocialLoginType 입니다."));
    }
}