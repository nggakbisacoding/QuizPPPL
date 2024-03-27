import org.example.BankAccount;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BankAccountTest {

    public ArrayList<BankAccount> ATM;

    @BeforeAll
    public void initialization() {
        ATM = new ArrayList<>();
    }

    @BeforeEach
    public void init() {
        BankAccount b1 = new BankAccount("SNB34342D", 100000);
        BankAccount b2 = new BankAccount("SNEK342D2", 500000);
        ATM.add(b1);
        ATM.add(b2);
    }

    @Test
    @Order(1)
    public void AccountNumberTest() {
        Assertions.assertEquals(ATM.getFirst().getAccountNumber(), "SNB34342D");
        Assertions.assertEquals(ATM.get(1).getAccountNumber(), "SNEK342D2");
    }

    @Test
    @Order(2)
    public void getBalanceTest() {
        Assertions.assertNotEquals(ATM.getFirst().getBalance(), 15000, "Tidak valid!");
        Assertions.assertEquals(ATM.get(1).getBalance(), 500000);
    }

    @Test
    @Order(3)
    public void depositTest() {
        ATM.getFirst().deposit(1000);
        Assertions.assertEquals(ATM.getFirst().getBalance(), 101000);
        ATM.get(1).deposit(5);
        Assertions.assertEquals(ATM.get(1).getBalance(),500005);
    }

    @Test
    @Order(4)
    public void withdrawTest() {
        ATM.getFirst().withdraw(100000);
        Assertions.assertEquals(ATM.getFirst().getBalance(), 0);
        ATM.get(1).withdraw(1);
        Assertions.assertNotEquals(ATM.get(1).getBalance(), 500000);
    }

    @Test
    @Order(5)
    public void transferFundsTest() {
        ATM.getFirst().transferFunds(ATM.get(1), 10000);
        Assertions.assertEquals(ATM.getFirst().getBalance(), 90000);
        Assertions.assertEquals(ATM.get(1).getBalance(), 510000);
    }

    @AfterEach
    public void clean() {
        ATM.clear();
    }

    @AfterAll
    public void destroy() {
        ATM.clear();
    }
}
