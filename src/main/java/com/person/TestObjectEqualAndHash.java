package com.person;

import java.util.Collection;
import java.util.HashSet;

import org.junit.Test;

/**
 *  Object.class关于hashcode的注释<br>
     * 1.As much as is reasonably practical, the hashCode method defined by
     * class {@code Object} does return distinct integers for distinct
     * objects. (This is typically implemented by converting the internal
     * address of the object into an integer, but this implementation
     * technique is not required by the
     * Java&trade; programming language.)
     * 
     * It is <em>not</em> required that if two objects are unequal
     *     according to the {@link java.lang.Object#equals(java.lang.Object)}
     *     method, then calling the {@code hashCode} method on each of the
     *     two objects must produce distinct integer results.  However, the
     *     programmer should be aware that producing distinct integer results
     *     for unequal objects may improve the performance of hash tables.
 */
/**
 * 
 * @author lakala-shawn
 *
 */
public class TestObjectEqualAndHash {
	// object对象中的 public boolean equals(Object obj)，对于任何非空引用值 x 和 y，当且仅当 x 和 y
	// 引用同一个对象时，此方法才返回 true；
	// 注意：当此方法被重写时，通常有必要重写 hashCode 方法，以维护 hashCode
	// 方法的常规协定，该协定声明相等对象必须具有相等的哈希码。如下：
	// (1)当obj1.equals(obj2)为true时，obj1.hashCode() == obj2.hashCode()必须为true
	// (2)当obj1.hashCode() == obj2.hashCode()为false时，obj1.equals(obj2)必须为false

	@Test
	public void testObjEqualOverriteButHashCodeNot() {
		//Student 重写了equals方法<br>
		Student stu = new Student("01Name", "01");
		Student stuBak = new Student("01Name", "01");
		if (stu == stuBak) {
			System.out.println("stu == stuBak");
		}
		if (stu.equals(stuBak)) {
			System.out.println("stu.equals(stuBak)");
		}
		
		System.out.println("stu.hashCode()=" + stu.hashCode() + ",stuBak.hashCode()=" + stuBak.hashCode());
		/**
		 * 2016年12月09日 输出<br>
		 * stu.equals(stuBak)
		 * stu.hashCode()=114935352,stuBak.hashCode()=2110121908  //注意两个hashCode 是不一样的<br>
		 */
	}

	/**
	 * Whenever it is invoked on the same object more than once during
     *     an execution of a Java application, the {@code hashCode} method
     *     must consistently return the same integer, provided no information
     *     used in {@code equals} comparisons on the object is modified.
     *     This integer need not remain consistent from one execution of an
     *     application to another execution of the same application.
	 */
	/**
	 * 注意 testHashSet和testObjEqualOverride输出的hashCode是一样的<br>
	 * 意思就是操作系统启动之后内存堆分配好了之后，hashCode多次执行结果是一样的<br>
	 */
	@Test
	public void testHashSet() {
		Student n1 = new Student("01Name", "01");
		Student n2 = new Student("01Name", "01");

		Collection c = new HashSet();
		c.add(n1);
		c.add(n2);
		System.out.println("n1.equals(n2)==" + n1.equals(n2));
		System.out.println("------------");
		System.out.println("n1.hashcode=" + n1.hashCode());
		System.out.println("n2.hashcode=" + n2.hashCode());
		System.out.println("collection=" + c);

		/**
		 * 测试结果：没有重写hashcode 一个collection里面存放了两个相同值得对象,建"collection="<br>
		 * n1.equals(n2)==true
		 *------------
		 *n1.hashcode=114935352
		 *n2.hashcode=2110121908
		 *collection=[com.person.Student@6d9c638, com.person.Student@7dc5e7b4] 
		 //一个collection存放了两个相同值对象，地址不一样，这个是有问题的。 所以effective java中说了重写了equals必须重写hashCode<br>
		  * 当重写equals时必须重写hashCode（Item9）<br>
		 */
	}
	@Test
	public void testStudentWithHashCode()
	{
		StudentWithHashCode n1 = new StudentWithHashCode("01Name", "01");
		StudentWithHashCode n2 = new StudentWithHashCode("01Name", "01");

		Collection c = new HashSet();
		c.add(n1);
		c.add(n2);
		System.out.println("n1.equals(n2)==" + n1.equals(n2));
		System.out.println("------------");
		System.out.println("n1.hashcode=" + n1.hashCode());
		System.out.println("n2.hashcode=" + n2.hashCode());
		System.out.println(c);
		
		/**
		 * n1.equals(n2)==true
------------
n1.hashcode=1537
n2.hashcode=1537
[com.person.StudentWithHashCode@601] //2016年12月09日测试过，必须hashCode 和equals两个都重写才会hashset才会只有一个对象
		 */
	}

}

class StudentWithHashCode {
	String name;
	String id;

	StudentWithHashCode(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	@Override
	public int hashCode()
	{
		return id.hashCode();
	}
	
	/**
	 * 请注意： 重写equals方法后最好重写hashCode方法，否则两个等价对象可能得到不同的hashCode,这在集合框架中使用可能产生严重后果
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof StudentWithHashCode)) {
			return false;
		}
		final StudentWithHashCode s = (StudentWithHashCode) obj;
		if (s.name.equals(this.name) && s.id.equals(this.id)) {
			return true;
		}
		return false;
	}

}

class Student {
	String name;
	String id;

	Student(String name, String id) {
		this.name = name;
		this.id = id;
	}

	/**
	 * 请注意： 重写equals方法后最好重写hashCode方法，否则两个等价对象可能得到不同的hashCode,这在集合框架中使用可能产生严重后果
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Student)) {
			return false;
		}
		final Student s = (Student) obj;
		if (s.name.equals(this.name) && s.id.equals(this.id)) {
			return true;
		}
		return false;
	}

}
