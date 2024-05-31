package com.leekiye.mybatis.dao;

import com.leekiye.mybatis.dto.MemberDto;
import com.leekiye.mybatis.mybatis.MybatisConnectionFactory;
import org.apache.ibatis.session.SqlSession;

public class MemberDao {
    // html (front) ---> controller(프론트에서 넘어온 데이터 처리) ---> DAO 메서드 호출
    // --> DAO 에서 DB에 CRUD(MYBATIS / JPA) 하고 결과값 들고오기
    public int insertMember(MemberDto memberDto) {
        int result = 0;
        SqlSession sqlSession = MybatisConnectionFactory.getSqlSession(true);
        result = sqlSession.insert("insertMember", memberDto);

        sqlSession.close();
        return result;
    }

    public int idCheck(String userID) {
        int result = 0;
        SqlSession sqlSession = MybatisConnectionFactory.getSqlSession(true);
        result = sqlSession.selectOne("idCheck", userID); // 1,0

        sqlSession.close();
        return result;
    }

    public MemberDto loginMember(MemberDto memberDto) {
        MemberDto loginMemberDto = null;
        SqlSession sqlSession = MybatisConnectionFactory.getSqlSession(true);
        loginMemberDto = sqlSession.selectOne("loginMember", memberDto);

        sqlSession.close();
        return loginMemberDto;
    }

    public MemberDto infoMember(String userID) {
        MemberDto infoMemberDto = null;
        SqlSession sqlSession = MybatisConnectionFactory.getSqlSession(true);
        infoMemberDto = sqlSession.selectOne("infoMember", userID);

        sqlSession.close();
        return infoMemberDto;
    }


}
