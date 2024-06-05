package Bai4;

import java.time.Clock;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);

        // Thread 1: Múi giờ Anh
        executorService.scheduleAtFixedRate(() -> {
        	System.out.println("Thread1 created");
            printTime(ZoneId.of("Europe/London"), "London Time:");
        }, 0, 1, TimeUnit.SECONDS);

        // Thread 2: Múi giờ Việt Nam
        executorService.scheduleAtFixedRate(() -> {
        	System.out.println("Thread2 created");
            printTime(ZoneId.of("Asia/Ho_Chi_Minh"), "Vietnam Time:");
        }, 0, 1, TimeUnit.SECONDS);

        // Thread 3: Múi giờ Mỹ
        executorService.scheduleAtFixedRate(() -> {
        	System.out.println("Thread3 created");
            printTime(ZoneId.of("America/New_York"), "US Time:");
        }, 0, 1, TimeUnit.SECONDS);

        // Keep the program running   interrupted
        while (!Thread.interrupted()) {
            Thread.sleep(1000); // Sleep for 1 second
        }

        executorService.shutdown(); // Shutdown the thread pool when interrupted
    }

    private static void printTime(ZoneId zoneId, String prefix) {
    	long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < 1000) {
            // Do nothing, wait for at least 1 second
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String timeString = formatter.format(Clock.system(zoneId).instant());
        System.out.println(prefix + " " + timeString);
    }
}
