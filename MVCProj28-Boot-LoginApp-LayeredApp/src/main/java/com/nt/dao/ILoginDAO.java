package com.nt.dao;

import com.nt.bo.UserBO;

public interface ILoginDAO {

	public String authenticateUser(UserBO bo);
	public int insert(UserBO bo);
}
