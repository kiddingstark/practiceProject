package com.ahong.PO;

public class TRole {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_role.ROLE_ID
     *
     * @mbg.generated Wed May 13 09:41:07 CST 2020
     */
    private String roleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_role.ROLE_NAME
     *
     * @mbg.generated Wed May 13 09:41:07 CST 2020
     */
    private String roleName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_role.ROLE_ID
     *
     * @return the value of t_role.ROLE_ID
     *
     * @mbg.generated Wed May 13 09:41:07 CST 2020
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_role.ROLE_ID
     *
     * @param roleId the value for t_role.ROLE_ID
     *
     * @mbg.generated Wed May 13 09:41:07 CST 2020
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_role.ROLE_NAME
     *
     * @return the value of t_role.ROLE_NAME
     *
     * @mbg.generated Wed May 13 09:41:07 CST 2020
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_role.ROLE_NAME
     *
     * @param roleName the value for t_role.ROLE_NAME
     *
     * @mbg.generated Wed May 13 09:41:07 CST 2020
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }
}