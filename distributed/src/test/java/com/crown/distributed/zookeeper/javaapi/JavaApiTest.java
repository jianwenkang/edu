package com.crown.distributed.zookeeper.javaapi;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;

/**
 * Created by Crown on 2019/2/15.
 */
public class JavaApiTest {
    @Test
    public void CreateSessionDemo() throws Exception {
        Watcher watcher = new MyWatcher();
        ZooKeeper zooKeeper = new ZooKeeper("", 1, watcher);
    }
}
class MyWatcher implements Watcher{
    @Override
    public void process(WatchedEvent watchedEvent) {

    }
}
