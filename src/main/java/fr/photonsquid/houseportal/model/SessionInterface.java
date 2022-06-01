package fr.photonsquid.houseportal.model;

public interface SessionInterface {

    /**
     * create a session
     * 
     * @param uid user id
     * @return bearer
     */
    String createSession(int uid);

    /**
     * remove session
     * 
     * @param sessionId
     */
    void destroySession(String bearer);

    /**
     * check if a session is still valid
     * 
     * @return the user Id (int > 0) if session is valid, -1 otherwise
     * @param bearer
     */
    int checkSession(String bearer);
}
