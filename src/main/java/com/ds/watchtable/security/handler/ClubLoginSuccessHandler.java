package com.ds.watchtable.security.handler;

import com.ds.watchtable.security.dto.ClubAuthMemberDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Log4j2
public class ClubLoginSuccessHandler implements AuthenticationSuccessHandler {

  private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
  private PasswordEncoder passwordEncoder;

  public ClubLoginSuccessHandler(PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request,
        HttpServletResponse response, Authentication authentication)
          throws IOException, ServletException {

    log.info("----------------------------------------------");
    log.info("onAuthenticationSuccess ");

    ClubAuthMemberDTO authMember = (ClubAuthMemberDTO) authentication.getPrincipal();

    boolean fromSocial = authMember.isFromSocial();
    log.info("Need Modify Member?" + fromSocial);
    boolean passwordResult = passwordEncoder.matches("1", authMember.getPassword());

    List<String> roleList = new ArrayList<>();
//    authMember.getAuthorities().forEach(grantedAuthority -> {
//      roleList.add(grantedAuthority.getAuthority());
//    });
    authMember.getAuthorities().forEach(new Consumer<GrantedAuthority>() {
      @Override
      public void accept(GrantedAuthority grantedAuthority) {
        roleList.add(grantedAuthority.getAuthority());
      }
    });
    log.info("getAuthorities: " + roleList);
    String sendUrl = "";
    if (roleList.contains("ROLE_USER") && fromSocial && passwordResult) sendUrl = "/";
    if (roleList.contains("ROLE_MANAGER")) sendUrl = "/member/managemyinfo";
    if (roleList.contains("ROLE_ADMIN")) sendUrl = "/admin";
    if (roleList.contains("ROLE_SOCIAL") && fromSocial && passwordResult) sendUrl = "/join/socialJoin";
    log.info("sendUrl: "+sendUrl);
    redirectStrategy.sendRedirect(request, response, sendUrl);
  }
}
