package com.soonpan.ldap;

import java.util.Set;

/**
 * @author spock
 */
public class Main {
    public static void main(String[] args) throws Exception {
        LdapConfiguration ldapConfiguration = new LdapConfiguration()
                .bindDn("cn=admin,dc=planetexpress,dc=com")
                .bindDNPwd("GoodNewsEveryone")
                .server("localhost")
                .port(10389);

        LdapRolesProvider ldapRolesProvider = new LdapRolesProvider("dc=planetexpress,dc=com", ldapConfiguration);

        Set<String> userRoles = ldapRolesProvider.getUserRoles("fry");

        System.out.println(userRoles);
    }
}
