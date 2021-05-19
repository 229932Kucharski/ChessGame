import org.junit.Assert;
import org.junit.Test;
import player.password.PasswordHashing;

public class PasswordHashingTest {

    @Test
    public void passwordHashing() {
        byte[] pass1 = PasswordHashing.hashPassword("haslo1234@#");
        byte[] pass2 = PasswordHashing.hashPassword("haslo1234@#");
        byte[] pass3 = PasswordHashing.hashPassword("haslo1134@#");
        Assert.assertArrayEquals(pass1, pass2);
        Assert.assertNotEquals(pass1, pass3);
    }

}
