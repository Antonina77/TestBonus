import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {
    @Test
    void shouldCalculateRegistredAndUnderLimit() {
        BonusService service = new BonusService();
        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateRegistredAndOverLimit() {
        BonusService service = new BonusService();
        long amount = 10000060;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }


    @Test
    void shouldCalculateUnregistredAndUnderLimit() {
        BonusService service = new BonusService();
        long amount = 100060;
        boolean registered = false;
        long expected = 10;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateUnregistredAndOverLimit() {
        BonusService service = new BonusService();
        long amount = 100000060;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
}
