package com.leisure.connectionpool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * @author gonglei
 * @date 2020/4/10 14:28
 */
public class ConnectionDriver {
	static class ConnectionHandler implements InvocationHandler{
		public Object invoke(Object proxy, Method method,Object[] args)throws Throwable{
			if(method.getName().equals("commit")){
				TimeUnit.MILLISECONDS.sleep(100);
			}
			return null;
		}
	}

	//创建一个Connection的代理
	public static final Connection createConnection(){
		return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(),
				new Class<?>[]{Connection.class},new ConnectionHandler());
	}
}
