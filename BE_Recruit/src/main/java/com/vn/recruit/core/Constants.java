package com.vn.recruit.core;

/**
 * Application constants.
 */
public final class Constants {

    private Constants() {
    }

    public static final class Role{
        public static final String ADMIN = "ROLE_ADMIN";
        public static final String JE = "ROLE_JE";
        public static final String USER = "ROLE_USER";
    }
    public static final class OTP{
        public static final Long EXPIRED_TIME = 15 * 60 * 1000L;
    }

    public static final class Status{
        public static final String PENDING = "pending";
        public static final String APPROVED = "approved";
    }

    public static final class TypeJob{
        public static final String FEATURED = "FEATURED";
        public static final String  NEWEST= "NEWEST";
    }

    // Regex for acceptable logins
    public static final String LOGIN_REGEX = "^(?>[a-zA-Z0-9!$&*+=?^_`{|}~.-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*)|(?>[_.@A-Za-z0-9-]+)$";

//    public static final String SYSTEM = "system";
//    public static final String DEFAULT_LANGUAGE = "vi";
//    public static final Locale DEFAULT_LOCALE = Locale.forLanguageTag(DEFAULT_LANGUAGE);
//    public static final String API_KEY_JWT = "JWT";


    public static final class Api {

//        public static class Tag {
//            public static final String AUTHENTICATION = "Authentication";
//            public static final String DASHBOARD = "Dashboard";
//            public static final String PROFILE_SETTINGS = "Profile Settings";
//            public static final String ROLE_MANAGEMENT = "Role Management";
//            public static final String CALENDAR_MANAGEMENT = "Calendar Management";
//            public static final String NOTIFICATION = "Notification";
//        }

        public static class Path {
            public static final String PREFIX = "/api";

            public static final String PUBLIC = PREFIX + "/public";
            public static final String ADMIN = PREFIX + "/admin";
            public static final String AUTH = PREFIX + "/auth";
//            public static final String ACCOUNT = PREFIX + "/account";
//            public static final String ON_BOARDING = PUBLIC + "/on-boarding";

            public static class Auth {
                public static final String LOGIN = "/login";
                public static final String REFRESH_TOKEN = "/refresh-token";
                public static final String CHECK_PHONE_NUMBER = "/check-phone-number";
                public static final String OTP = "/otp";
                public static final String OTP_REQUEST = OTP + "/request";
                public static final String OTP_VERIFY = OTP + "/verify";
            }

            public static class Account {
                public static final String REGISTER = "/register";
                public static final String CHANGE_PASSWORD = "/change-password";
                public static final String RESET_PASSWORD = "/reset-password";
                public static final String RESET_PASSWORD_INIT = RESET_PASSWORD + "/init";
                public static final String RESET_PASSWORD_FINISH = RESET_PASSWORD + "/finish";
            }

            public static class Admin {
                public static final String AUTH = ADMIN + "/auth";
            }
        }
    }
    public static class ValidationMessage {
        public static final String FIELD_IS_REQUIRED = "validation.mustNotBeNull";

        public static final String INVALID_PHONE_NUMBER = "validation.invalidPhoneNumber";
        public static final String INVALID_OTP = "validation.invalidOTP";
        public static final String INVALID_PASSWORD = "validation.invalidPassword";
        public static final String INVALID_USER_NAME = "validation.invalidUserName";
        public static final String INVALID_FIRST_NAME = "validation.invalidFirstName";
        public static final String INVALID_LAST_NAME = "validation.invalidLastName";
        public static final String INVALID_COUNTRY_CODE = "validation.invalidCountryCode";
        public static final String EXPIRED_OTP = "validation.expiredOTP";
        public static final String INVALID_DATE = "validation.invalidDate";
        public static final String UNVERIFIED_PHONE_NUMBER = "validation.unverifiedPhoneNumber";

        public static final String NOT_FOUND_RECEIVER = "validation.notFoundReceiver";
        public static final String NOT_FOUND_USER = "validation.notFoundUser";
        public static final String NOT_ACTIVATED_USER = "validation.notActivatedUser";
        public static final String NOT_FOUND_PET = "validation.notFoundPet";
        public static final String NOT_FOUND_NOTIFICATION = "validation.notFoundNotification";
        public static final String NOT_FOUND_TRACKER = "validation.notFoundTracker";
        public static final String CURRENT_PASSWORD_INVALID = "validation.invalidCurrentPassword";
        public static final String NOT_FOUND_BREED = "validation.notFoundBreed";
        public static final String NOT_FOUND_SAFE_ZONE = "validation.notFoundSafeZone";

        public static final String EXISTS_USER = "validation.existsUser";
        public static final String NOT_EXISTS_IMEI = "validation.notExistingImei";
        public static final String TOO_MANY_TIMES_GET_OTP = "validation.tooManyTimesGetOTP";
        public static final String TOO_SHORT_DURATION_BETWEEN_OTP_REQUESTS = "validation.tooShortDurationBetweenOtpRequests";

        public static final String INVALID_MIN_VALUE = "validation.invalidMinValue";
        public static final String INVALID_MAX_VALUE = "validation.invalidMaxValue";
        public static final String INVALID_SIZE_VALUE = "validation.invalidSizeValue";
        public static final String NOT_CONTAIN_WHITE_SPACE = "validation.notContainWhiteSpace";

        public static final String FEATURED = "FEATURED";

        public static final String NEWEST = "NEWEST";

    }

}