package com.pattern.dao;

import com.pattern.entity.Member;
import com.pattern.template.JDBCTemplate;
import com.pattern.util.RowMapper;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by Administrator on 2018/11/27 0027.
 */
public class MemberDao  {


    private JDBCTemplate jdbcTemplate = new JDBCTemplate() ;


    public List<Object> query() throws Exception {
        String sql = "select * from t_member ";
        return jdbcTemplate.executeQuery(sql, new RowMapper<Member>() {
            @Override
            public Member mapRow(ResultSet resultSet, int rowNum) throws Exception {
                Member member = new Member();
                member.setUsername(resultSet.getString("username"));
                member.setPassword(resultSet.getString("password"));
                member.setNickname(resultSet.getString("nickname"));
                return member;
            }
        },null);
    }
}
