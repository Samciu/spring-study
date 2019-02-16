package jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import java.util.List;

/**
 * Created by yanfa on 2016/10/27.
 */
@Repository
public class JdbcTemplateUserBalanceDao implements UserBalanceDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<UserBalance> getUserBalanceList() {
        return this.jdbcTemplate.query("SELECT * FROM UserBalance",new RowMapper<UserBalance>() {
			public UserBalance mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserBalance userBalance = new UserBalance();
                userBalance.setUserId(rs.getLong("userId"));
                userBalance.setBalance(rs.getDouble("balance"));
                return userBalance;
			}
		});
    }

    public void addMoney(Long userId, double count){
        this.jdbcTemplate.update("UPDATE UserBalance SET balance=balance+? WHERE userId=?",count,userId);
    }

    public void subMoney(Long userId,double count){
        this.jdbcTemplate.update("UPDATE UserBalance SET balance=balance-? WHERE userId=?",count,userId);
    }
}