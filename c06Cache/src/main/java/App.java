import com.java1234.service.BankService;
import com.java1234.service.impl.BankServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) throws InterruptedException {
        /**
         * 无cache测试
         */
       /* ApplicationContext ac = new ClassPathXmlApplicationContext("01noCache.xml");
        BankService bankService = (BankService) ac.getBean("bankService");
        for (int i = 1; i <= 10; i++) {
            bankService.transferAccountsNoCache(5, 1, 2);
        }*/

        /**
         * 有cache测试，1注解式
         */
        /*ApplicationContext ac = new ClassPathXmlApplicationContext("02annotationCache.xml");
        BankService bankService = (BankService) ac.getBean("bankService");
        bankService.transferAccounts(500, 1, 2);
        System.out.println("----------------");
        bankService.transferAccounts(500, 1, 2);
        System.out.println("----------------");
        bankService.transferAccounts(500, 1, 2);
        System.out.println("----------------");*/

        /**
         * 有cache测试，2xml式
         */
        ApplicationContext ac = new ClassPathXmlApplicationContext("03xmlCache.xml");
        BankService bankService = (BankService) ac.getBean("bankService");
        bankService.transferAccounts(500, 1, 2);
        System.out.println("----------------");
        bankService.transferAccounts(500, 1, 2);
        System.out.println("----------------");
        bankService.transferAccounts(500, 1, 2);
        System.out.println("----------------");

    }
}
