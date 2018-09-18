package com.test.xml;

import java.io.File;
import java.io.FileWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.test.xml.Students;

@XmlRootElement(name="testfan")
public class Person {
	
	private String name;
	private int age;
	
	public Person() {
		
	}
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	@XmlElement(name="testname")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void  eat() {
		System.out.println("大米");
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	public static void main(String[] args) {

        JAXBContext context;
		try {
			context = JAXBContext.newInstance(Person.class);
		//获得Marshaller对象
	        Marshaller marshaller = context.createMarshaller();
	        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	        //定义值
	        Person person  = new Person();
	        person.setName("张三");
	        person.setAge(18);
	        
	        String path = System.getProperty("user.dir")+File.separator+"data"+File.separator+"person.xml";
	        FileWriter writer=new FileWriter(new File(path));
	        //输出到文件
	        marshaller.marshal(person, writer);
	        //打印到控制台
	        marshaller.marshal(person, System.out);
	        
		/*	  String path = System.getProperty("user.dir")+File.separator+"data"+File.separator+"person.xml";
			   context = JAXBContext.newInstance(Person.class);
		        Unmarshaller unmarshaller = context.createUnmarshaller();
		        File file = new File(path);
		        Person person = (Person) unmarshaller.unmarshal(file);
		        System.out.println(person);*/
		} catch (Exception e) {
			e.printStackTrace();
		}
        
	}
}
