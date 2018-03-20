package genericwebapp.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import genericwebapp.event.SystemMemoryEvent;

@Component
public final class TaskScheduler {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    // 30 min
    //@Scheduled(fixedDelay = 1800000)
    @Scheduled(fixedDelay = 10000)
    public void runtime() {
        System.gc();
        applicationEventPublisher.publishEvent(new SystemMemoryEvent(this));
    }
}
