package com.joe.pruebas.main;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws UnknownHostException {
        final Clock clock = new NanoClock();
        System.out.printf("Calling the hostname resolution method...%n");
        final Instant startTime = Instant.now(clock);
        InetAddress addr = InetAddress.getLocalHost();
        String hostName = addr.getHostName();
        String ip = addr.toString();
        final Instant endTime = Instant.now(clock);
        System.out.printf("Method called, hostname %s | ip %s, elapsed time: %d (ms)%n", hostName, ip
                , TimeUnit.NANOSECONDS.toMillis(Duration.between(startTime, endTime).toNanos()));
    }
}
