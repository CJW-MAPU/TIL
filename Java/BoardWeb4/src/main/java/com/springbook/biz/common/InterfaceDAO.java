package com.springbook.biz.common;

import java.util.List;

public interface InterfaceDAO {
    public Object insert(String queryId, Object params);

    public Object update(String queryId, Object params);

    public Object delete(String queryId, Object params);

    public Object selectOne(String queryId);

    public Object selectOneParam(String queryId, Object params);

    public List selectList(String queryId);

    public List selectListParam(String queryId, Object params);
}
