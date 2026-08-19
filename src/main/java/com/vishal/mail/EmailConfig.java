package com.vishal.mail;

import static com.vishal.constants.FrameworkConstants.REPORT_TITLE;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Data for Sending email after execution
 * Environment variables are loaded from .env file if present
 */
public class EmailConfig {

    private static final Map<String, String> ENV_VALUES = loadEnvFile();

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

    private static Map<String, String> loadEnvFile() {
        Map<String, String> values = new HashMap<>();
        File envFile = new File(System.getProperty("user.dir"), ".env");

        if (!envFile.exists()) {
            return values;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(envFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String trimmed = line.trim();
                if (trimmed.isEmpty() || trimmed.startsWith("#") || !trimmed.contains("=")) {
                    continue;
                }

                String[] parts = trimmed.split("=", 2);
                String key = parts[0].trim();
                String value = parts[1].trim();

                if ((value.startsWith("\"") && value.endsWith("\"")) ||
                        (value.startsWith("'") && value.endsWith("'"))) {
                    value = value.substring(1, value.length() - 1);
                }

                values.put(key, value);
            }
        } catch (IOException ignored) {
            // Ignore invalid .env content and fall back to system environment/defaults
        }

        return values;
    }

    /**
     * Get environment variable value with fallback to default
     */
    private static String getEnv(String key, String defaultValue) {
        String value = ENV_VALUES.get(key);
        if (value != null && !value.isBlank()) {
            return value;
        }

        value = System.getenv(key);
        if (value != null && !value.isBlank()) {
            return value;
        }

        return defaultValue;
    }

    /**
     * Convert comma-separated email string to array
     */
    private static String[] getEmailArray(String emails) {
        return emails.split(",\\s*");
    }
}