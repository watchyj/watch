<div align="center">
<img src="https://user-images.githubusercontent.com/86641712/150141160-fe74de5d-2c47-45e1-87b9-5d132f508eba.png">
</div>
  
### 와치테이블 소개
>**음식을 사랑하고 효율을 중시하는 한국사람들! <br>
"맛집 앞에서 끝도 없는 웨이팅도 불사하지만 조금 더 효율적인 방법으로 맛집 탐방을 할 순 없을까?!"** <br><br>
가고싶은 가게의 상황을 미리 알 수 있으면 어떨까요? 와치테이블은 말 그대로 보이는 테이블이란 뜻으로 내가 가고자 하는 매장의 혼잡도를 보여줍니다. <br>
***
### 와치테이블 실행 설명
#### 메인화면

메인화면의 지도에서 현재 내 위치를 중심으로 서비스를 이용중인 가게에 핀이 꽂힙니다. 이 핀은 초록색, 파란색 그리고 붉은색으로 세가지 색깔이며 매장의 혼잡도를 직관적으로 볼 수 있습니다. (초록색: 여유, 파란색: 보통, 붉은색: 혼잡 또는 만석)<br>
#### 상세페이지
가게 상세페이지에서 실시간으로 매장의 혼잡도를 볼 수 있습니다. 또한 일반회원들은 만석인 식당에 대기등록을 할 수 있고, 대기현황과 작성한 리뷰는 내정보에서 확인 할 수 있으며 언제든 수정이 가능합니다. <br>
#### 일반회원
1. 로그인,회원가입<br>
제이쿼리로 유효성 검사를 합니다.
2. 내정보 수정 <br>
내 정보 수정이 가능합니다.
3. 내정보 페이지 <br>
대기 등록한 가게, 리뷰 남긴 가게, 찜한 가게 리스트를 볼 수 있습니다.
4. 대기 등록 수정 <br>
가게 대기중 인원 수정이 가능합니다.
#### 사업자 회원
1. 로그인, 회원가입<br>
제이쿼리로 유효성 검사를 하며 카카오 우편번호 API를 활용하여 주소검색을 할 수 있습니다. 또한 ajax를 이용하여 이미지 업로드가 가능합니다.
2. 내 가게 대기현황 <br>
사업자 회원은 내 가게정보에서 대기현황을 볼 수 있습니다. POS시스템과 연결하여 테이블에 주문이 들어오면 혼잡도가 올라가고, 결제가 완료되면 혼잡도가 내려갑니다.

***
### 사용한 언어와 프레임워크
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=SpringBoot&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-%23005C0F.svg?style=for-the-badge&logo=Thymeleaf&logoColor=white)
![jQuery](https://img.shields.io/badge/jquery-%230769AD.svg?style=for-the-badge&logo=jquery&logoColor=white)
![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E)
![Bootstrap](https://img.shields.io/badge/bootstrap-%23563D7C.svg?style=for-the-badge&logo=bootstrap&logoColor=white)
![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)

### 함께한 사람들
**Ginaben** - 전반적인 화면 구현, 전체 페이지간 연결 흐름 설정, 리뷰 등록/수정/삭제/회원별 리스트, 대기 등록/수정/취소/회원별 리스트 <br>
**yoonjeongoh** - 전반적인 테이블 연관관계 설정, 회원별 회원가입, 로그인, 회원가입시 이미지파일 업로드, 업로드한 파일 상세페이지에 나타내기, 우편번호API, 소셜 회원가입, Security, POS시스템 구현, 회원가입 유효성검사 <br>
**sjjkk1996** - 지도API, 메인화면 지도에 혼잡도 구현, 상세페이지 혼잡도 차트 구현, POS시스템 구현<br>
**YoungDDon** - 회원가입 유효성검사, POS시스템 구현<br>

팀 와치테이블은 2021년 Java기반 풀스택 개발자 과정을 수료하였습니다.
