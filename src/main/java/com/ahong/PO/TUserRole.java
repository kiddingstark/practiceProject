package com.ahong.PO;

public class TUserRole {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_role.USER_ID
     *
     * @mbg.generated Wed May 13 09:41:07 CST 2020
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_role.ROLE_ID
     *
     * @mbg.generated Wed May 13 09:41:07 CST 2020
     */
    private String roleId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_role.USER_ID
     *
     * @return the value of t_user_role.USER_ID
     *
     * @mbg.generated Wed May 13 09:41:07 CST 2020
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_role.USER_ID
     *
     * @param userId the value for t_user_role.USER_ID
     *
     * @mbg.generated Wed May 13 09:41:07 CST 2020
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_role.ROLE_ID
     *
     * @return the value of t_user_role.ROLE_ID
     *
     * @mbg.generated Wed May 13 09:41:07 CST 2020
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_role.ROLE_ID
     *
     * @param roleId the value for t_user_role.ROLE_ID
     *
     * @mbg.generated Wed May 13 09:41:07 CST 2020
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }
}