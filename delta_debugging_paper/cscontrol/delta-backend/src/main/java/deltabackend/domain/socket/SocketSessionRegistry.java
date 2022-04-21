package deltabackend.domain.socket;

import org.springframework.util.Assert;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class SocketSessionRegistry{
    private final ConcurrentMap<String, Set<String>> user_sId = new ConcurrentHashMap();
    private final Object lock = new Object();

    public SocketSessionRegistry() {
    }

    public Set<String> getSessionIds(String user) {
        Set set = (Set)this.user_sId.get(user);
        return set != null?set: Collections.emptySet();
    }

    public ConcurrentMap<String, Set<String>> getAllSessionIds() {
        return this.user_sId;
    }

    public void registerSessionId(String user, String sessionId) {
        Assert.notNull(user, "User must not be null");
        Assert.notNull(sessionId, "Session ID must not be null");
        Object var3 = this.lock;
        synchronized(this.lock) {
            Object set = (Set)this.user_sId.get(user);
            if(set == null) {
                set = new CopyOnWriteArraySet();
                this.user_sId.put(user, (Set<String>) set);
            }
            ((Set)set).add(sessionId);
        }
    }

    public void unregisterSessionId(String userName, String sessionId) {
        Assert.notNull(userName, "User Name must not be null");
        Assert.notNull(sessionId, "Session ID must not be null");
        Object var3 = this.lock;
        synchronized(this.lock) {
            Set set = (Set)this.user_sId.get(userName);
            if(set != null && set.remove(sessionId) && set.isEmpty()) {
                this.user_sId.remove(userName);
            }

        }
    }
}
