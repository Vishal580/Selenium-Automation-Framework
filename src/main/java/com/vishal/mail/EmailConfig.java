package com.vishal.mail;

import io.github.cdimascio.dotenv.Dotenv;
import static com.vishal.constants.FrameworkConstants.REPORT_TITLE;

/**
 * Data for Sending email after execution
 * Environment variables are loaded from .env file
 */
public class EmailConfig {

    private static final Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

    //Remember to create an app password (App Password) for Gmail before sending
    //If you use Hosting's email, it's normal
    //Enable Override Report and Send mail in config file => src/test/resources/config/config.properties
    //OVERRIDE_REPORTS=yes
    //send_email_to_users=yes

    public static final String SERVER = getEnv("EMAIL_SERVER", "smtp.gmail.com");
    public static final String PORT = getEnv("EMAIL_PORT", "587");

    public static final String FROM = getEnv("EMAIL_FROM", "");
    public static final String PASSWORD = getEnv("EMAIL_PASSWORD", "");

    public static final String[] TO = getEmailArray(getEnv("EMAIL_TO", ""));
    public static final String SUBJECT = REPORT_TITLE;

    /**
     * Get environment variable value with fallback to default
     */
    private static String getEnv(String key, String defaultValue) {
        String value = dotenv.get(key);
        return value != null && !value.isEmpty() ? value : System.getenv(key) != null ? System.getenv(key) : defaultValue;
    }

    /**
     * Convert comma-separated email string to array
     */
    private static String[] getEmailArray(String emails) {
        return emails.split(",\\s*");
    }
}