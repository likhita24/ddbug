package apiserver.async;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration  
@EnableAsync  
public class ExecutorConfig {  
  
    /** Set the ThreadPoolExecutor's core pool size. */  
    private int cps = 10;  
    /** Set the ThreadPoolExecutor's maximum pool size. */  
    private int mps = 200;  
    /** Set the capacity for the ThreadPoolExecutor's BlockingQueue. */  
    private int qc = 10;  
  
    @Bean  
    public Executor mySimpleAsync() {  
        ThreadPoolTaskExecutor er = new ThreadPoolTaskExecutor();  
        er.setCorePoolSize(cps);  
        er.setMaxPoolSize(mps);  
        er.setQueueCapacity(qc);  
        er.setThreadNamePrefix("MySimpleExecutor-");  
        er.initialize();  
        return er;  
    }  
      
    @Bean  
    public Executor myAsync() {  
        ThreadPoolTaskExecutor er = new ThreadPoolTaskExecutor();  
        er.setCorePoolSize(cps);  
        er.setMaxPoolSize(mps);  
        er.setQueueCapacity(qc);  
        er.setThreadNamePrefix("MyExecutor-");  

        er.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());  
        er.initialize();  
        return er;  
    }  
}  