package com.Service;

import com.pojo.PageInfo;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface Service {
    List selAll() throws NamingException, SQLException;

    PageInfo page(int pageNum, int pageSize) throws IOException;
}
