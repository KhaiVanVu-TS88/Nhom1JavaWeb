package hung.user;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class AutoDeleteScheduler implements ServletContextListener{
	private ScheduledExecutorService scheduler;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        scheduler = Executors.newSingleThreadScheduledExecutor();
        
    
        scheduler.scheduleAtFixedRate(() -> {
            userImpl user = new userImpl();
            int count = user.deleteUsersOlderThan60Days();
            System.out.println("Tự động xóa " + count + " người dùng quá hạn.");
        }, 0, 1, TimeUnit.DAYS);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        scheduler.shutdownNow();
    }
}
