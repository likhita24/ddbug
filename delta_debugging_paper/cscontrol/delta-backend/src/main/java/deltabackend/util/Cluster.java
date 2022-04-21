package deltabackend.util;

public class Cluster {
    private String name;
    private String IP_mas;
    private String user;
    private String pwd;
    private String token;
    private String apis;

    public Cluster(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMasterIp() {
        return IP_mas;
    }

    public void setMasterIp(String IP_mas) {
        this.IP_mas = IP_mas;
    }

    public String getUsername() {
        return user;
    }

    public void setUsername(String user) {
        this.user = user;
    }

    public String getPasswd() {
        return pwd;
    }

    public void setPasswd(String pwd) {
        this.pwd = pwd;
    }

    public String getApiServer() {
        return apis;
    }

    public void setApiServer(String apis) {
        this.apis = apis;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
