package mybatis;

import java.util.List;

public interface UserBalanceDao {

    public List<UserBalance> getUserBalanceList();

	public void subMoney(Long srcUserId, double count);

	public void addMoney(Long targetUserId, double count);
}