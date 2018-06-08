package org.yunpeng.tryspringboot.storage;

public interface UserInterface {
    /**
     * Creates a new user.
     *
     * @param name is the name of the new user.
     * @param age is the age of the new user.
     */
    void create(String name, Integer age);

    /**
     * Deletes a user according to the name.
     *
     * @param name is the name of the user being deleted.
     */
    void deleteByName(String name);

    /**
     *
     * @return the number of users.
     */
    Integer getNumOfUsers();

    /**
     * Deletes all users.
     */
    void deleteAllUsers();
}
