package mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MybatisUserBalanceDao extends UserBalanceDao{

	@Select("Select * from UserBalance")
	public List<UserBalance> getUserBalanceList();

	@Update("UPDATE UserBalance SET balance=balance+#{param2} WHERE userId=#{param1} ")
	public void addMoney(Long userId, double count);

	@Update("UPDATE UserBalance SET balance=balance-#{param2} WHERE userId=#{param1} ")
	public void subMoney(Long userId, double count);

}
