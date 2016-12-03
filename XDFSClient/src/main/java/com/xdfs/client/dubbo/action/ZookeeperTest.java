package com.xdfs.client.dubbo.action;

import org.apache.zookeeper.*;

import java.io.IOException;

/**
 * Created by xyy on 16-9-4.
 */
public class ZookeeperTest {

    final public static String IP = "127.0.0.1";
    final public static String CLIENTPORT = "2181";
    final public static int CONNECTION_TIMEOUT = 2000;

    public static void main(String[] args) throws InterruptedException, KeeperException {
        ZooKeeper zk = null;
        try {
            //??zookeeper????????????????????????Watcher
            zk = new ZooKeeper(IP + ":" + CLIENTPORT, CONNECTION_TIMEOUT, new Watcher() {

                @Override
                public void process(WatchedEvent watchedEvent) {

                    System.out.println("???" + watchedEvent.getType() + "????");
                }
            });
            //??????????
            zk.create("/xyy", "testData".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            //????????????
            zk.create("/xyy/testChildPath1", "testChildData1".getBytes(),
                      ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            //???/xyy????????
            System.out.println("/xyy"+"=="+new String(zk.getData("/xyy", true, null)));
            //???/xyy/testChildPath1???????
            System.out.println("/xyy/testChildPath1"+"=="+new String(zk.getData("/xyy/testChildPath1", true, null), "utf-8"));
            //???/xyy/testChildPath1???????
            zk.setData("/xyy/testChildPath1", "????testChildData1".getBytes("utf-8"), -1);
            //???/xyy/testChildPath1???????
            System.out.println("/xyy/testChildPath1"+"=="+new String(zk.getData("/xyy/testChildPath1", true, null), "utf-8"));
            //????????????
            zk.create("/xyy/testChildPath2", "testChildDataTwo".getBytes(),
                      ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            //???/xyy/testChildPath2???????
            System.out.println("/xyy/testChildPath2"+"=="+new String(zk.getData("/xyy/testChildPath2", true, null)));
            // ??????????
            zk.delete("/xyy/testChildPath2", -1);
            zk.delete("/xyy/testChildPath1", -1);
            // ??????????
            zk.delete("/xyy", -1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        } finally {
//
//            zk.delete("/xyy/testChildPath2", -1);
//            zk.delete("/xyy/testChildPath1", -1);
//            // ??????????
//            zk.delete("/xyy", -1);
            if(zk != null) {
                //???????
                zk.close();
            }
        }
    }
}
