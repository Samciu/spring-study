package mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MybatisUserBalanceDao {

	@Select("Select * from UserBalance")
	public List<UserBalance> getUserBalanceList();

}
