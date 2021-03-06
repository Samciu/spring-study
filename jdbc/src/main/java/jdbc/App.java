/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package jdbc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            // get mapper
            JdbcTemplateUserBalanceDao dao = ctx.getBean("jdbcTemplateUserBalanceDao", JdbcTemplateUserBalanceDao.class);
            // get service
            TransferMoneyService transferBalanceService = ctx.getBean("transferMoneyService",
                    TransferMoneyService.class);
            transferBalanceService.setUserBalanceDao(dao);
            // log 一下
            transferBalanceService.logUserBalanceList();

            try {
                transferBalanceService.transferMoney(Long.valueOf(5), Long.valueOf(1), 101);
            } catch (Exception e) {
                System.out.println(e.toString());
            }

            // 再log 一下
            transferBalanceService.logUserBalanceList();
        };
    }
}
