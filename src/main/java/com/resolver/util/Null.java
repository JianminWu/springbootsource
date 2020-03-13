package com.resolver.util;

import java.io.Serializable;

public class Null implements Serializable {
	private static final long serialVersionUID = 1l;
	public static Null INSTANCE = new Null();
	
	private Null() {
		
	}
	
	private Object readResolve() {
		return INSTANCE;
	}
}
