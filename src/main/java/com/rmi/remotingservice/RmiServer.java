
package com.rmi.remotingservice;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import com.rmi.PersonServiceImpl;
import com.rmi.RmiConstant;
import com.rmi.service.PersonService;

public class RmiServer {

	public static void main(String[] args) {
		try {
			PersonService personServiceImp = new PersonServiceImpl();
			// 注册通讯端口
			LocateRegistry.createRegistry(6600);
			// 注册通讯路径
			Naming.rebind(RmiConstant.RMI_URL, personServiceImp);
			System.out.println("Service Start!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}