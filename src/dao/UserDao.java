package dao;

public interface UserDao {
	/**
	 * @return true: login success ; false: fail to login
	 * */
	boolean login(String userName, String password);
}
