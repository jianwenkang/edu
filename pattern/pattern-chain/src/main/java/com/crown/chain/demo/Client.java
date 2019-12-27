package com.crown.chain.demo;

/**
 * @ClassName Client
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/5/10
 * @Time 18:18
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        Client client = new Client();
        MainHandler mainHandler = new MainHandler();
        if(false){
            TypeHandler typeHandler = new TypeHandler();
            client.addNextHandler(mainHandler,typeHandler);
        }
        if(true){
            GroupHandler groupHandler = new GroupHandler();
            client.addNextHandler(mainHandler,groupHandler);
        }
        mainHandler.handleRequest();
    }

    private void addNextHandler(Handler handler, Handler nextHandler) {
        if(handler.nextHandler == null){
            handler.setNextHandler(nextHandler);
        }else {
            addNextHandler(handler.getNextHandler(),nextHandler);
        }

    }
}
