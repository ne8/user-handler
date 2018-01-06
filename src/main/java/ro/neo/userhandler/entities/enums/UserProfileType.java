package ro.neo.userhandler.entities.enums;

/**
 * Created by neop on 1/14/17.
 */
public enum UserProfileType {

    USER("USER"),
    DBA("DBA"),
    ADMIN("ADMIN");

    String userProfileType;

    private UserProfileType(final String userProfileType) {
        this.userProfileType = userProfileType;
    }

    public String getUserProfileType() {
        return this.userProfileType;
    }

}
