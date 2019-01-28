package com.rmi.remotingclient;

import java.rmi.Naming;
import java.util.List;

import com.rmi.RmiConstant;
import com.rmi.model.PersonEntity;
import com.rmi.service.PersonService;

public class RmiClient {
	public static void main(String[] args) {
		try {
			// 调用远程对象，注意RMI路径与接口必须与服务器配置一致
			// 重点从远程对象取的服务，而不是自己new了一个 new PersonServiceImpl()，rmi比rpc 更像一个面向对象编程。
			// rmi只是注重服务。
			PersonService personService = (PersonService) Naming.lookup(RmiConstant.RMI_URL);
			List<PersonEntity> personList = personService.GetList();
			for (PersonEntity person : personList) {
				System.out.println("ID:" + person.getId() + " Age:" + person.getAge() + " Name:" + person.getName());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	/**
	 * 2017-02-09 程序执行结果
	 * ID:0 Age:25 Name:Leslie
	 * ID:1 Age:25 Name:Rose
	 */
}
