package com.soonpan.ldap;


import java.io.Serializable;

/**
 * @author spock
 */
public class LdapConfiguration implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * The file on classpath that this configuration can be loaded from.
     */
    public static final transient String FILENAME = "ldap-healthcheck-config.json";

    private String server;
    private Integer port;
    private String bindDn;
    private String bindDNPwd;
    private Boolean useSSL = false;
    private String trustStore;
    private String trustStorePassword;
    private Integer poolSize = 5;
    private Integer poolMaxConnectionAgeMS = 15000; // re-estabilish connection in the pool after that time
    private Integer connectionTimeoutMS = 3000; // time to wait to estabilish connection
    private Integer responseTimeoutMS = 3000; // time to wait until receiving response from ldap
    private boolean debug = false;
    private boolean keepAlive = true;

    public LdapConfiguration server(String server) {
        this.server = server;
        return this;
    }

    public LdapConfiguration port(Integer port) {
        this.port = port;
        return this;
    }

    public LdapConfiguration bindDn(String bindDn) {
        this.bindDn = bindDn;
        return this;
    }

    public LdapConfiguration bindDNPwd(String bindDNPwd) {
        this.bindDNPwd = bindDNPwd;
        return this;
    }

    public LdapConfiguration useSSL(Boolean useSSL) {
        this.useSSL = useSSL;
        return this;
    }

    public LdapConfiguration trustStore(String trustStore) {
        this.trustStore = trustStore;
        return this;
    }

    public LdapConfiguration trustStorePassword(String trustStorePassword) {
        this.trustStorePassword = trustStorePassword;
        return this;
    }

    public LdapConfiguration poolSize(Integer poolSize) {
        this.poolSize = poolSize;
        return this;
    }

    public String getServer() {
        return server;
    }

    public Integer getPort() {
        return port;
    }

    public String getBindDn() {
        return bindDn;
    }

    public String getBindDNPwd() {
        return bindDNPwd;
    }

    public Boolean getUseSSL() {
        return useSSL;
    }

    public String getTrustStore() {
        return trustStore;
    }

    public String getTrustStorePassword() {
        return trustStorePassword;
    }

    public Integer getPoolSize() {
        return poolSize;
    }

    public Integer getConnectionTimeoutMS() {
        return connectionTimeoutMS;
    }

    public LdapConfiguration connectionTimeoutMS(Integer connectionTimeoutMS) {
        this.connectionTimeoutMS = connectionTimeoutMS;
        return this;
    }

    public Integer getResponseTimeoutMS() {
        return responseTimeoutMS;
    }

    public LdapConfiguration responseTimeoutMS(Integer responseTimeoutMS) {
        this.responseTimeoutMS = responseTimeoutMS;
        return this;
    }

    public boolean isDebug() {
        return debug;
    }

    public LdapConfiguration debug(boolean debug) {
        this.debug = debug;
        return this;
    }

    public boolean isKeepAlive() {
        return keepAlive;
    }

    public LdapConfiguration keepAlive(boolean keepAlive) {
        this.keepAlive = keepAlive;
        return this;
    }

    public Integer getPoolMaxConnectionAgeMS() {
        return poolMaxConnectionAgeMS;
    }

    public LdapConfiguration poolMaxConnectionAgeMS(Integer poolMaxConnectionAgeMS) {
        this.poolMaxConnectionAgeMS = poolMaxConnectionAgeMS;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LdapConfiguration [server=");
        builder.append(server);
        builder.append(", port=");
        builder.append(port);
        builder.append(", bindDn=");
        builder.append(bindDn);
        builder.append(", bindDNPwd=");
        builder.append(bindDNPwd);
        builder.append(", useSSL=");
        builder.append(useSSL);
        builder.append(", trustStore=");
        builder.append(trustStore);
        builder.append(", trustStorePassword=");
        builder.append(trustStorePassword);
        builder.append(", poolSize=");
        builder.append(poolSize);
        builder.append(", poolMaxConnectionAgeMS=");
        builder.append(poolMaxConnectionAgeMS);
        builder.append(", connectionTimeoutMS=");
        builder.append(connectionTimeoutMS);
        builder.append(", responseTimeoutMS=");
        builder.append(responseTimeoutMS);
        builder.append(", debug=");
        builder.append(debug);
        builder.append(", keepAlive=");
        builder.append(keepAlive);
        builder.append("]");
        return builder.toString();
    }
}
