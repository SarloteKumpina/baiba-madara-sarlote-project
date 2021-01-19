package com.accenture.bootcamp.onlinestore.project.cookies;

import javax.servlet.http.Cookie;

public class CookieUtils {

        public static final int COOKIE_DEFAULT_MAX_AGE_SECONDS = 60 * 60 * 24 * 30;
        public static final String COOKIE_DOMAIN = "localhost";

        public static Cookie createCookie(String name, String value) {
            Cookie cookie = new Cookie(name, value);
            cookie.setMaxAge(COOKIE_DEFAULT_MAX_AGE_SECONDS);
            cookie.setDomain(COOKIE_DOMAIN);
            cookie.setPath("/");
            return cookie;
        }
}
