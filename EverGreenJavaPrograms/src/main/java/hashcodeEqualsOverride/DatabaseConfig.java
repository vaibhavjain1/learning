package hashcodeEqualsOverride;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class DatabaseConfig {
    private String tomcatName;
    private String tomcatPort;
    private Object dbType;
    private String hostName;
    private String hostPort;
    private String alias;
    private String databaseName;
    private boolean logincredentialsUsed;
    private String dbUser;
    private String dbPassword;
    private boolean ssl;
    private boolean oracleSn;
    private String dataFileLocation;
    private String logFileLocation;
    private String dataFileName;
    private String logFileName;
    private String tablespaceTables;
    private String tablespaceIndicies;
    private List<String> tablespaces;
    private boolean forMigration;
    private boolean overrideOdbcDriver;
    private String odbcDriver;
    private String sqlAuthenticationDomain;
    private String dbDomain;

    private boolean repoUseOracleClientNetService;
    private String repoOracleClientDatabase;
    private String repoOracleClientServer;

    public DatabaseConfig() {
    }

    public DatabaseConfig(DatabaseConfig other) {
        this.dbType = other.dbType;
        this.hostName = other.hostName;
        this.hostPort = other.hostPort;
        this.databaseName = other.databaseName;
        this.logincredentialsUsed = other.logincredentialsUsed;
        this.dbDomain = other.dbDomain;
        this.dbUser = other.dbUser;
        this.dbPassword = other.dbPassword;
        this.ssl = other.ssl;
        this.oracleSn = other.oracleSn;
        this.dataFileLocation = other.dataFileLocation;
        this.logFileLocation = other.logFileLocation;
        this.dataFileName = other.dataFileName;
        this.logFileName = other.logFileName;
        this.tablespaceTables = other.tablespaceTables;
        this.tablespaceIndicies = other.tablespaceIndicies;
        this.sqlAuthenticationDomain = other.sqlAuthenticationDomain;
    }

    public List<String> getTablespaces() {
        return tablespaces;
    }

    public void setTablespaces(List<String> tablespaces) {
        this.tablespaces = tablespaces;
    }

    public String getTomcatName() {
        return tomcatName;
    }

    public void setTomcatName(String tomcatName) {
        this.tomcatName = tomcatName;
    }

    public String getTomcatPort() {
        return tomcatPort;
    }

    public void setTomcatPort(String tomcatPort) {
        this.tomcatPort = tomcatPort;
    }

    public String getTablespaceTables() {
        return tablespaceTables;
    }

    public void setTablespaceTables(String tablespaceTables) {
        this.tablespaceTables = tablespaceTables;
    }

    public String getTablespaceIndicies() {
        return tablespaceIndicies;
    }

    public void setTablespaceIndicies(String tablespaceIndicies) {
        this.tablespaceIndicies = tablespaceIndicies;
    }

    public DatabaseConfig copy() {
        return new DatabaseConfig(this);
    }

    public DatabaseConfig withDatabaseName(String databaseName) {
        this.databaseName = databaseName;
        return this;
    }

    public boolean isOracleSn() {
        return oracleSn;
    }

    public void setOracleSn(boolean oracleSn) {
        this.oracleSn = oracleSn;
    }

    public boolean isSsl() {
        return ssl;
    }

	public void setSsl(boolean ssl) {
        this.ssl = ssl;
    }

    public boolean isForMigration() {
        return forMigration;
    }

    public void setForMigration(boolean forMigration) {
        this.forMigration = forMigration;
    }

    public String getDataFileLocation() {
        return dataFileLocation;
    }

    public void setDataFileLocation(String dataFileLocation) {
        this.dataFileLocation = dataFileLocation;
    }

    public String getLogFileLocation() {
        return logFileLocation;
    }

    public void setLogFileLocation(String logFileLocation) {
        this.logFileLocation = logFileLocation;
    }

    public String getDataFileName() {
        return dataFileName;
    }

    public void setDataFileName(String dataFileName) {
        this.dataFileName = dataFileName;
    }

    public String getLogFileName() {
        return logFileName;
    }

    public void setLogFileName(String logFileName) {
        this.logFileName = logFileName;
    }

    public String getsqlAuthenticationDomain() {
		return sqlAuthenticationDomain;
	}

	public void setsqlAuthenticationDomain(String sqlAuthenticationDomain) {
		this.sqlAuthenticationDomain = sqlAuthenticationDomain;
	}

	/**
     * Check properties values for equality in null- or empty-string tolerant manner
     * Prefer this, if you would like to check, if two configs are reference same DB
     */
    public boolean isSameDb(DatabaseConfig that) {
        if (!equalsTrimmed(databaseName, that.databaseName))
            return false;
        if (!equalsTrimmed(dbPassword, that.dbPassword))
            return false;
        if (dbType != that.dbType)
            return false;
        if (!equalsTrimmed(dbDomain, that.dbDomain))
            return false;
        if (!equalsTrimmed(dbUser, that.dbUser))
            return false;
        if (!equalsTrimmed(hostName, that.hostName))
            return false;
        if (!equalsTrimmed(hostPort, that.hostPort))
            return false;
        if (!equalsTrimmed(dataFileLocation, that.dataFileLocation))
            return false;
        if (!equalsTrimmed(logFileLocation, that.logFileLocation))
            return false;
        if (!equalsTrimmed(dataFileName, that.dataFileName))
            return false;
        if (!equalsTrimmed(logFileName, that.logFileName))
            return false;
        if (!equalsTrimmed(tablespaceTables, that.tablespaceTables))
            return false;
        if (!equalsTrimmed(tablespaceIndicies, that.tablespaceIndicies))
            return false;
        if(!equalsTrimmed(sqlAuthenticationDomain, that.sqlAuthenticationDomain))
        	return false;

        return ssl == that.isSsl() && oracleSn == that.isOracleSn();
    }

    /**
     * @return true, if both Strings equals, after triming to empty (see {@link StringUtils#trimToEmpty}).
     */
    private boolean equalsTrimmed(String s1, String s2) {
        return StringUtils.equals(StringUtils.trimToEmpty(s1), StringUtils.trimToEmpty(s2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DatabaseConfig that = (DatabaseConfig) o;

        if (databaseName != null ? !databaseName.equals(that.databaseName) : that.databaseName != null) return false;
        if (dbPassword != null ? !dbPassword.equals(that.dbPassword) : that.dbPassword != null) return false;
        if (dbType != that.dbType) return false;
        if (dbDomain != null ? !dbDomain.equals(that.dbDomain) : that.dbDomain != null) return false;
        if (dbUser != null ? !dbUser.equals(that.dbUser) : that.dbUser != null) return false;
        if (hostName != null ? !hostName.equals(that.hostName) : that.hostName != null) return false;
        if (hostPort != null ? !hostPort.equals(that.hostPort) : that.hostPort != null) return false;
        if (dataFileLocation != null ? !dataFileLocation.equals(that.dataFileLocation) : that.dataFileLocation != null)
            return false;
        if (logFileLocation != null ? !logFileLocation.equals(that.logFileLocation) : that.logFileLocation != null)
            return false;
        if (dataFileName != null ? !dataFileName.equals(that.dataFileName) : that.dataFileName != null) return false;
        if (logFileName != null ? !logFileName.equals(that.logFileName) : that.logFileName != null) return false;
        if (tablespaceTables != null ? !tablespaceTables.equals(that.tablespaceTables) : that.tablespaceTables != null)
            return false;
        if (tablespaceIndicies != null ? !tablespaceIndicies.equals(that.tablespaceIndicies) : that.tablespaceIndicies != null)
            return false;
        if (overrideOdbcDriver!=that.overrideOdbcDriver) return false;
        if (sqlAuthenticationDomain != null ? !sqlAuthenticationDomain.equals(that.sqlAuthenticationDomain) : that.sqlAuthenticationDomain != null)
            return false;
        if ( overrideOdbcDriver && odbcDriver != null ? !odbcDriver.equals(that.odbcDriver) : that.odbcDriver != null) return false;
        return ssl == that.isSsl() && oracleSn == that.isOracleSn();
    }

    @Override
    public int hashCode() {
        int result = dbType != null ? dbType.hashCode() : 0;
        result = 31 * result + (hostName != null ? hostName.hashCode() : 0);
        result = 31 * result + (hostPort != null ? hostPort.hashCode() : 0);
        result = 31 * result + (databaseName != null ? databaseName.hashCode() : 0);
        result = 31 * result + (dbDomain != null ? dbDomain.hashCode() : 0);
        result = 31 * result + (dbUser != null ? dbUser.hashCode() : 0);
        result = 31 * result + (dbPassword != null ? dbPassword.hashCode() : 0);
        result = 31 * result + Boolean.valueOf(ssl).hashCode();
        result = 31 * result + Boolean.valueOf(oracleSn).hashCode();
        result = 31 * result + (dataFileLocation != null ? dataFileLocation.hashCode() : 0);
        result = 31 * result + (logFileLocation != null ? logFileLocation.hashCode() : 0);
        result = 31 * result + (dataFileName != null ? dataFileName.hashCode() : 0);
        result = 31 * result + (logFileName != null ? logFileName.hashCode() : 0);
        result = 31 * result + (tablespaceTables != null ? tablespaceTables.hashCode() : 0);
        result = 31 * result + (tablespaceIndicies != null ? tablespaceIndicies.hashCode() : 0);
        result = 31 * result + (sqlAuthenticationDomain != null ? sqlAuthenticationDomain.hashCode() : 0);
        return result;
    }

    public Object getDbType() {

        return dbType;
    }

    public void setDbType(Object dbType) {
        this.dbType = dbType;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        if (StringUtils.isNotBlank(hostName)) {
            this.hostName = hostName.trim();
        } else {
            this.hostName = hostName;
        }
    }

    public String getHostPort() {
        return hostPort;
    }

    public void setHostPort(String hostPort) {
        this.hostPort = hostPort;
    }

    public String getAlias()
	{
		return alias;
	}

	public void setAlias(String alias)
	{
		this.alias = alias;
	}

	public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public boolean isLogincredentialsUsed()
    {
        return logincredentialsUsed;
    }

    public void setLogincredentialsUsed( boolean logincredentialsUsed )
    {
        this.logincredentialsUsed = logincredentialsUsed;
    }

    public String getDbDomain() {
        return dbDomain;
    }

    public void setDbDomain(String dbDomain) {
        this.dbDomain = dbDomain;
    }
    
    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public DatabaseConfig withUserName(String dbUser) {
        this.dbUser = dbUser;
        return this;
    }

    public boolean isRepoUseOracleClientNetService() {
        return repoUseOracleClientNetService;
    }

    public void setRepoUseOracleClientNetService(boolean repoUseOracleClientNetService) {
        this.repoUseOracleClientNetService = repoUseOracleClientNetService;
    }

    public String getRepoOracleClientDatabase() {
        return repoOracleClientDatabase;
    }

    public void setRepoOracleClientDatabase(String repoOracleClientDatabase) {
        this.repoOracleClientDatabase = repoOracleClientDatabase;
    }

    public String getRepoOracleClientServer() {
        return repoOracleClientServer;
    }

    public void setRepoOracleClientServer(String repoOracleClientServer) {
        this.repoOracleClientServer = repoOracleClientServer;
    }
	
	public boolean isOverrideOdbcDriver() {
			return overrideOdbcDriver;
	}

	public void setOverrideOdbcDriver(boolean overrideOdbcDriver) {
			this.overrideOdbcDriver = overrideOdbcDriver;
	}
    
    public String getOdbcDriver() {
		return odbcDriver;
	}

	public void setOdbcDriver(String odbcDriver) {
		this.odbcDriver = odbcDriver;
	}
}
