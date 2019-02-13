package mybatis;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferMoneyService {

    UserBalanceDao userBalanceDao;

    public void setUserBalanceDao(UserBalanceDao userBalanceDao) {
        this.userBalanceDao = userBalanceDao;
    }

    @Transactional
    public void transferMoney(Long srcUserId, Long targetUserId, double count){
        System.out.println("Class TransferBalanceService Method transferMoney");
        this.userBalanceDao.subMoney(srcUserId,count);
        // throwException();
        this.userBalanceDao.addMoney(targetUserId,count);
    }

    public List<UserBalance> getUserBalanceList(){
        return this.userBalanceDao.getUserBalanceList();
    }

    public void logUserBalanceList() {
        System.out.println("the userBalanceList:");
        List<UserBalance> userBalanceList = getUserBalanceList();
        for (UserBalance userBalance : userBalanceList) {
            System.out.println(userBalance);
        }
    }

    private void throwException() {
        throw new RuntimeException("Throw Exception");
    }
}