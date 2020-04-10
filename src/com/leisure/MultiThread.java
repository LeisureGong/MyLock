package com.leisure;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author gonglei
 * @date 2020/4/10 10:15
 */
public class MultiThread {
	public static void main(String... args){
		//获取Java线程管理MXBean
		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);
		//遍历线程信息，仅打印线程IDD和线程名称信息
		for(ThreadInfo threadInfo : threadInfos){
			System.out.println("[" + threadInfo.getThreadId() + "]" + threadInfo.getThreadName());
		}
	}
}
