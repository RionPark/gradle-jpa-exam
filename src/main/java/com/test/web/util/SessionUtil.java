package com.test.web.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.test.web.entity.HiberInfo;

public class SessionUtil {

	private static SessionFactory ssf;
	private static StandardServiceRegistry reg;
	
	public static SessionFactory getSSF() {
		if(ssf==null) {
			StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder();
			
			ssrb = ssrb.configure();
			
			reg = ssrb.build();
			
			MetadataSources ms = new MetadataSources(reg);
			Metadata meta = ms.getMetadataBuilder().build();
			ssf = meta.getSessionFactoryBuilder().build();
		}
		return ssf;
	}
	public static Session getSession() {
		return getSSF().openSession();
	}
	
	public static void main(String[] args) {
		Session ss = getSession();
		ss.beginTransaction();
		HiberInfo hi = ss.get(HiberInfo.class, 2);
		System.out.println(hi);
	}
}
