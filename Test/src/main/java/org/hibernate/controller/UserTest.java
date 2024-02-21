package org.hibernate.controller;

import java.util.List;
import java.util.Scanner;

import com.hibernate.dao.TestDao;
import com.hibernate.dto.User;

public class UserTest {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter 1 :Save the Record");
		System.out.println("Enter 2:Update the record");
		System.out.println("enter 3:fetch the record using id");
		System.out.println("enter 4 : fetch all the record");
		System.out.println("enter 5 : for delete the record");
		System.out.println("enter your choice");
		int key=sc.nextInt();
		TestDao dao=new TestDao();
		
		switch(key) {
		case 1:{
		System.out.println("Enter your name,phone,password");
		String name=sc.next();
		long phone=sc.nextLong();
		String password=sc.next();
		User u=new User();
		u.setName(name);
		u.setPhone(phone);
		u.setPassword(password);
		if(u!=null) {
			dao.saveUser(u);
			System.out.println("Record is inserted");
		}else {
			System.out.println("record is not inserted");
		}
		break;
		}
		case 2:{
			System.out.println("enter your id to update");
			int id=sc.nextInt();
			System.out.println("Enter your name,phone,password");
			String name=sc.next();
			long phone=sc.nextLong();
			String password=sc.next();
			User u=new User();
			u.setName(name);
			u.setPhone(phone);
			u.setPassword(password);
			dao.updateUser(u);
			System.out.println("your record is updated");
			break;
		}
		case 3:{
			System.out.println("enter the id you need to fetch");
			int id=sc.nextInt();
			User u =dao.getById(id);
			if(u!=null) {
				System.out.println("ID:    "+u.getId());
				System.out.println("Name:     "+u.getName());
				System.out.println("Phone:    "+u.getPhone());
				System.out.println("Pssword:   "+u.getPassword());
				
			}
			else {
				System.err.println("enter valid id");
			}
			break;
			
		}
		case 4:{
			List<User> list=dao.getAllUser();
			if(list.size()>0) {
				for(User u:list){
					System.out.println("ID    "+u.getId());
					System.out.println("Name:   "+u.getName());
					System.out.println("Phone:    "+u.getPhone());
					System.out.println("Password  "+u.getPassword());
					
				}
			}
			else {
				System.err.println("cant fetch all the record");
			}
			break;
			
		}
		case 5:{
			System.out.println("Enter your id to delete");
			int id =sc.nextInt();
			boolean res=dao.deleteUser(id);
			if(res==true) {
				System.out.println("Record deleted successfully");
			}
			else {
				System.out.println("enter valid id");
			}
			break;
		}
		default:
			break;
		}
	}
}
