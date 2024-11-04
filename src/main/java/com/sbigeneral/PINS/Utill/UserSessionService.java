package com.sbigeneral.PINS.Utill;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service
public class UserSessionService {
    // Map to store active sessions for each user ID
    private final Map<String, SessionInfo> activeSessions = new ConcurrentHashMap<>();

    // Scheduled executor for periodic session expiration check
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    public UserSessionService() {
        // Schedule the session expiration check task to run every minute
        executorService.scheduleAtFixedRate(this::checkSessionExpiration, 0, 1, TimeUnit.MINUTES);
    }

    // Method to login user and start session
    public synchronized void login(String username, HttpSession session) {
        // Get the previous session information if exists
        SessionInfo previousSession = activeSessions.get(username);
       
        // If there's a previous session and it's not expired, invalidate it
        if (previousSession != null && !previousSession.isExpired(System.currentTimeMillis())) {
            previousSession.invalidate();
        }
       
        // Add the new session
        activeSessions.put(username, new SessionInfo(session));
    }

    // Method to logout user and end session
    public synchronized void logout(String userId) {
        activeSessions.remove(userId);
    }

    // Method to check if user is already logged in
    public synchronized boolean isUserAlreadyLoggedIn(String username) {
        SessionInfo sessionInfo = activeSessions.get(username);
        return sessionInfo != null && !sessionInfo.isExpired(System.currentTimeMillis());
    }

    // Method to check for session expiration and logout users
    private synchronized void checkSessionExpiration() {
        long currentTime = System.currentTimeMillis();
        activeSessions.entrySet().removeIf(entry -> entry.getValue().isExpired(currentTime));
    }

    // Inner class to hold session information
    private static class SessionInfo {
        private final HttpSession session;
        private final long expirationTime;

        public SessionInfo(HttpSession session) {
            this.session = session;
            this.expirationTime = System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(2); // 2 minutes timeout
        }

        public boolean isExpired(long currentTime) {
            return currentTime > expirationTime;
        }

        public void invalidate() {
            session.invalidate();
        }
    }
}