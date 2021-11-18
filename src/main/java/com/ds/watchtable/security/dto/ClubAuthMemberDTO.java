package com.ds.watchtable.security.dto;

import com.ds.watchtable.dto.MemberDTO;
import com.ds.watchtable.entity.Member;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

@Log4j2
@Getter
@Setter
@ToString
public class ClubAuthMemberDTO extends User implements OAuth2User {
  private String memberId;
  private String password;
  private String name;
  private boolean fromSocial;
  private Member member;
  //구글로부터 받아오는 정보 id, picture 등
  private Map<String, Object> attr;


  public ClubAuthMemberDTO(String username, String password, boolean fromSocial,
                           Collection<? extends GrantedAuthority> authorities,
                           Map<String, Object> attr) {
    this(username, password, fromSocial, authorities);
    this.attr = attr;
  }

  public ClubAuthMemberDTO(String username, String password,
                           boolean fromSocial,
                           Collection<? extends GrantedAuthority> authorities) {
    super(username, password, authorities);
    this.memberId = username;
    this.password = password;
    this.fromSocial = fromSocial;
  }

  @Override
  public Map<String, Object> getAttributes() {
    return this.attr;
  }
}
