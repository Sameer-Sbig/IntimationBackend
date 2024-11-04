package com.sbigeneral.PINS.Utill;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

@Service
public class LoginAttemptService {
	private final int MAX_ATTEMPT = 3;
    private final long LOCK_TIME_DURATION = TimeUnit.MINUTES.toMillis(30);
    private ConcurrentHashMap<String, LoginAttempt> attemptsCache = new ConcurrentHashMap<>();

    public void loginSucceeded(String key) {
        attemptsCache.remove(key);
    }

    public void loginFailed(String key) {
        LoginAttempt attempt = attemptsCache.get(key);
        if (attempt == null) {
            attempt = new LoginAttempt();
            attemptsCache.put(key, attempt);
        }
        attempt.incrementAttempts();
    }

    public boolean isBlocked(String key) {
        LoginAttempt attempt = attemptsCache.get(key);
        if (attempt != null && attempt.getAttempts() >= MAX_ATTEMPT) {
            if (System.currentTimeMillis() - attempt.getLastModified() < LOCK_TIME_DURATION) {
                return true;
            } else {
                attemptsCache.remove(key);
                return false;
            }
        }
        return false;
    }

    private static class LoginAttempt {
        private int attempts;
        private long lastModified;

        public LoginAttempt() {
            this.attempts = 1;
            this.lastModified = System.currentTimeMillis();
        }

        public void incrementAttempts() {
            this.attempts++;
            this.lastModified = System.currentTimeMillis();
        }

        public int getAttempts() {
            return attempts;
        }

        public long getLastModified() {
            return lastModified;
        }
    }
}