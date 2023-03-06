package com.soonpan.ldap;

import java.util.Hashtable;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

/**
 * @author spock
 */
public class GetUsersFromLdapGroup {
    static String ldapSearchBase = "dc=planetexpress,dc=com";
    private static DirContext ctx = null;

    private static DirContext getActiveDirectoryContext() throws Exception {

        final Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        properties.put(Context.PROVIDER_URL, "ldap://localhost:10389");
        properties.put(Context.SECURITY_AUTHENTICATION, "simple");
        properties.put(Context.SECURITY_PRINCIPAL, "cn=admin,dc=planetexpress,dc=com");
        properties.put(Context.SECURITY_CREDENTIALS, "GoodNewsEveryone");
        return new InitialDirContext(properties);

    }

    public void getGroupUsers(String searchBase, String searchFilter, String returnedAttrs[], int maxResults) {
        Hashtable userEntries = null;
        String member = "";
        try {
            SearchControls searchCtls = new SearchControls();
            searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            searchCtls.setReturningAttributes(returnedAttrs);
            ctx = getActiveDirectoryContext();
            try {
                System.out.println("Search Base: " + searchBase);
                System.out.println("Search Filter: " + searchFilter);
                NamingEnumeration users = ctx.search(searchBase, searchFilter, searchCtls);
                if (users.hasMoreElements() == false) {
                    System.out.println("Not find any object with this filter " + searchFilter + " and searchBase " + searchBase);
                }

                int k = 0;
                String attValue = "";
                userEntries = new Hashtable();
                while (users.hasMoreElements()) {
                    if (k >= maxResults) {
                        break;
                    }
                    SearchResult sr = (SearchResult) users.next();
                    Attributes attrs = sr.getAttributes();
                    if (attrs.size() == 0) {
                        System.out.println("Could not find attribute " + returnedAttrs[0] + " for this object.");
                    } else {

                        try {
                            for (NamingEnumeration ae = attrs.getAll(); ae.hasMore(); ) {
                                Attribute attr = (Attribute) ae.next();
                                String id = attr.getID();
                                for (NamingEnumeration e = attr.getAll(); e.hasMore(); ) {
                                    attValue = (String) e.next();
                                    if (id.equalsIgnoreCase("member")) {
                                        member = attValue;
                                        System.out.println("member :" + member);
                                    } else {
                                        System.out.println("empty");
                                    }
                                }
                            }
                        } catch (NamingException e) {
                            System.out.println("Problem listing membership:" + e);
                        }
                    }
                    k++;
                }
            } catch (NamingException e) {
                System.out.println("Problem searching directory: " + e);
            }
            ctx.close();
            ctx = null;
        } catch (Exception namEx) {
            System.out.println("Exception while fetching the users from LDAP::" + namEx);
        }

    }

    public static void main(String args[]) throws Exception {
        GetUsersFromLdapGroup gug = new GetUsersFromLdapGroup();
        String[] returnedAttrs = {"cn", "member"};
        String searchFilter = "uid=fry";
        gug.getGroupUsers(ldapSearchBase, searchFilter, returnedAttrs, Integer.parseInt("2000"));
    }
}