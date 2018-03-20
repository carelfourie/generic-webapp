package genericwebapp.event;

import org.springframework.context.ApplicationEvent;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SystemMemoryEvent extends ApplicationEvent {

    private long usedMemoryMb, freeMemoryMb, totalMemoryMb, maxMemoryMb;

    public SystemMemoryEvent(Object source) {
        super(source);

        final long mb = 1024 * 1024;
        Runtime runtime = Runtime.getRuntime();
        usedMemoryMb = (runtime.totalMemory() - runtime.freeMemory()) / mb;
        freeMemoryMb = runtime.freeMemory() / mb;
        totalMemoryMb = runtime.totalMemory() / mb;
        maxMemoryMb = runtime.maxMemory() / mb;
    }

    public long getUsedMemoryMb() {
        return usedMemoryMb;
    }

    public long getFreeMemoryMb() {
        return freeMemoryMb;
    }

    public long getTotalMemoryMb() {
        return totalMemoryMb;
    }

    public long getMaxMemoryMb() {
        return maxMemoryMb;
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        }
        catch (JsonProcessingException e) {
            return e.toString();
        }
    }
}
