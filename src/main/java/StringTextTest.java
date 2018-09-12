public class StringTextTest {
    public static void main(String[] args) {

        String message= "\n" +
                "Здравствуйте, Tim!\n" +
                "Измените свой пароль, и мы поможем Вам исправить ситуацию.\n" +
                "\n" +
                "Чтобы изменить пароль в LinkedIn, нажмите здесь или вставьте в адресную строку браузера следующую ссылку:\n" +
                "\n" +
                "https://www.linkedin.com/e/v2?e=bakhzj-jlz69ivc-mt&lipi=urn%3Ali%3Apage%3Aemail_security_password_reset_checkpoint%3BJOcIiUMzStKlphc%2B9i%2Fzvw%3D%3D&a=checkpoint-password-reset&midToken=AQFHrt1Nczn9UQ&tracking=eml-jav-saved-job&ek=security_password_reset_checkpoint&encryptedEmail=AgFEB7ILE7P_TgAAAWXN8Am2PcGqu1bof-DCUFapyqSChekLQFfVWqnJgqAR_t5B_d50k40&requestSubmissionId=AgF7Lq1hwCo5EQAAAWXN8AnBmagwExG2mb7NGWFn6A1qYps1EJzISnmWOGA7XXRfYpQREibQ4NOBIB4NjDpBswz9sUOo8KxTZtuvLpqu5J8&oneTimeToken=4503183077995850539&_sig=34x63Jw3FvQoo1\n" +
                "\n" +
                "Срок действия этой ссылки истечёт через 24 часа, поэтому воспользуйтесь ею прямо сейчас.\n" +
                "\n" +
                "Благодарим за использование LinkedIn,\n" +
                "\n" +
                "коллектив компании LinkedIn";

        messageSearchResetLink(message);

    }

    private static void messageSearchResetLink(String message) {
        String correctLink;
        String correctLinkStartPoint;
        String correctLinkEndPoint;

        int startPoint = message.indexOf("Чтобы изменить пароль в LinkedIn, нажмите")+105;
        System.out.println(startPoint);
        System.out.println(" ");
        correctLinkStartPoint = message.substring(startPoint, (message.length()-startPoint));
        System.out.println(" ");
        System.out.println("Start point: "+correctLinkStartPoint);

        int endPoint = correctLinkStartPoint.indexOf("style=");
        correctLinkEndPoint = message.substring(startPoint, endPoint);
        System.out.println("End point "+endPoint);
        System.out.println(" ");
        correctLink = correctLinkEndPoint;
        System.out.println("Correct link: "+correctLink);
    }
}


