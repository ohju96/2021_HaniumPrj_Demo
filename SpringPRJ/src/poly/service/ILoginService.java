package poly.service;

import poly.dto.ProjectsDTO;

public interface ILoginService {

   // 로그인을 위해 아이디와 비밀번호가 일치하는지 확인하기
   int Loginpage(ProjectsDTO mDTO) throws Exception;
   
}