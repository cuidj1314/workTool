import com.work.sha256.Pbkdf2Sha256;

import java.io.IOException;
public class TestCode {
    public static void main(String[] args) throws IOException {
        //获取密文（密码加盐）
        String salt = Pbkdf2Sha256.encode("123456");
        System.out.println("salt===" + salt);
        boolean verification = Pbkdf2Sha256.verification("123456", salt);
        System.out.println(verification);
        /** * Python生成的密码和密文 * admin123456 * PBKDF2&SHA256$2000$SzNgPdzz$50f22e207abec8e837bce97642a46f965f19d992217d7df9be496700b286345d * PBKDF2&SHA256$2000$VzmO4yOZ$71891148cfbdd9103aaa511d20dc52431c8947ce4a00d89708231ec76053f6f3 * PBKDF2&SHA256$2000$3xuRb8AR$6bff0310fd35c88572633b00d36e9039fef3e68c6e37b14204958946e8738e93 */
        String oldPassword7 = "PBKDF2&SHA256$2000$SzNgPdzz$50f22e207abec8e837bce97642a46f965f19d992217d7df9be496700b286345d";
        String oldPassword8 = "PBKDF2&SHA256$2000$VzmO4yOZ$71891148cfbdd9103aaa511d20dc52431c8947ce4a00d89708231ec76053f6f3";
        String oldPassword9 = "PBKDF2&SHA256$2000$3xuRb8AR$6bff0310fd35c88572633b00d36e9039fef3e68c6e37b14204958946e8738e93";
        boolean verification7 = Pbkdf2Sha256.verification("admin123456", oldPassword7);
        boolean verification8 = Pbkdf2Sha256.verification("admin123456", oldPassword8);
        boolean verification9 = Pbkdf2Sha256.verification("admin123456", oldPassword9);
        System.out.println(verification7);
        System.out.println(verification8);
        System.out.println(verification9);
    }
}