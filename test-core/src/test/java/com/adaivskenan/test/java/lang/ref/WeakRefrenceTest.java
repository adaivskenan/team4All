/**
 * 
 */
package com.adaivskenan.test.java.lang.ref;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author adaivskenan
 *
 */
public class WeakRefrenceTest {

	public static ReferenceQueue<WeakRefrenceTest> weakQueue;

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		Reference<? extends WeakRefrenceTest> obj = null;
		try {
			obj = weakQueue.remove();
		} catch (java.lang.InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("finalize--" + obj);
		if (obj != null) {
			System.out.println("Object for WeakReference is " + obj.get());
		}
		System.out.println("MyObject's finalie called"); // GC will call this finalize method
	}
	
	@Override
	public String toString() {
	
		return "I am WeakReferenceTest Object";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WeakRefrenceTest obj = new WeakRefrenceTest();// FinalReference
		weakQueue = new ReferenceQueue<>();
		// init WeakReference
		WeakReference<WeakRefrenceTest> weakReference = new WeakReference<>(obj, weakQueue);
		System.out.println(obj);
		
		obj = null;// delete the final reference , if the jvm want to clear this object , the
					// method of finalize() will be called
		System.gc(); // force gc
		System.out.println(obj);
		// gc will remove the weak reference
		System.out.println("After GC:Weak Get= " + weakReference.get());
		System.out.println("allocate a huge memory");

		// `Exception in thread "main" java.lang.OutOfMemoryError: Requested array size
		// exceeds VM limit
		// the biggest size of array,is Integer.MAX_VALUE-2. if the requested array size
		// bigger than that ,JVM will throw anOutOfMemoryError
		// the size of 1 integer number == 8 byte
		// 1024*1024*1024=2^30 1GB
		// there are apply for around 8GB memory
		int [] b = null;
		try {
			b= new int[Integer.MAX_VALUE - 2];// allocate a huge memory to enforce gc
		} catch (Exception e) {
			// e.printStackTrace();
		} finally {
			System.out.println("b[]: " + b);
			System.out.println("After new byte[]:Weak Get= " + weakReference.get());
			System.out.println(obj);
		}

	}

}
