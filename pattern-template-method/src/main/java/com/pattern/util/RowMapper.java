package com.pattern.util;

import java.sql.ResultSet;

/**
 * Created by Administrator on 2018/11/27 0027.
 */
public interface RowMapper<T> {

    public T mapRow(ResultSet rs, int rowNum ) throws Exception;
}
