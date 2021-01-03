package com.springbook.biz.common;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AbstractDAO implements InterfaceDAO{
    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public Object insert(String queryId, Object params) {
        return sqlSession.insert(queryId, params);
    }

    @Override
    public Object update(String queryId, Object params) {
        return sqlSession.update(queryId, params);
    }

    @Override
    public Object delete(String queryId, Object params) {
        return sqlSession.delete(queryId, params);
    }

    @Override
    public Object selectOne(String queryId) {
        return sqlSession.selectOne(queryId);
    }

    @Override
    public Object selectOneParam(String queryId, Object params) {
        return sqlSession.selectOne(queryId, params);
    }

    @Override
    @SuppressWarnings("rawtypes")
    public List selectList(String queryId) {
        return sqlSession.selectList(queryId);
    }

    @Override
    @SuppressWarnings("rawtypes")
    public List selectListParam(String queryId, Object params) {
        return sqlSession.selectList(queryId, params);
    }
}
