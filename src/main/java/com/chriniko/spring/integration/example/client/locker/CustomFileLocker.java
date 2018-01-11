package com.chriniko.spring.integration.example.client.locker;

import org.springframework.integration.file.locking.AbstractFileLockerFilter;

import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CustomFileLocker extends AbstractFileLockerFilter {

    private static final String INBOUND = "inbound";

    private final ConcurrentHashMap<File, Lock> locksDb;

    public CustomFileLocker() {
        locksDb = new ConcurrentHashMap<>();
    }

    @Override
    public boolean lock(File fileToLock) {

        Lock lock = locksDb.get(fileToLock);
        if (lock == null) {
            locksDb.put(fileToLock, new ReentrantLock(true));
        }

        lock = locksDb.get(fileToLock);
        lock.lock();

        return true;
    }

    @Override
    public boolean isLockable(File file) {
        return file.getAbsolutePath().contains(INBOUND);
    }

    @Override
    public void unlock(File fileToUnlock) {
        Lock lock = locksDb.get(fileToUnlock);
        lock.unlock();
    }
}
