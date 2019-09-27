/**
 * 
 */
package com.adaivskenan.jvm;

/**
 * @author adaivskenan
 *
 */
public class LocalvariablesTest {

	public static int b = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LocalvariablesTest test = new LocalvariablesTest();
		 test.testLocal();//局部变量比静态变量效率高，下面三个方法都没什么实质的速度提升
//		 test.testT();
//		 test.testT1();
//		test.testT2();
	}

	public void testLocal() {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 2000000000; i++) {
			b++;
		}
		int a = 0;// local variables has better performance
		long midleTime = System.currentTimeMillis();
		System.out.println(b);
		System.out.println(midleTime - startTime);
		for (int i = 0; i < 2000000000; i++) {
			a++;
		}
		System.out.println(a);
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - midleTime);
	}

	public T t = new T();

	public void testT() {
		T tl = new T();
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 2000000000; i++) {
			t.setV(t.getV() + 1);
		}
		System.out.println(t.getV());
		long midleTime = System.currentTimeMillis();
		System.out.println(midleTime - startTime);
		for (int i = 0; i < 2000000000; i++) {
			tl.setV(tl.getV() + 1);
		}
		System.out.println(tl.getV());
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - midleTime);
		// the best way,has the best performace
		int v = tl.getV();
		for (int i = 0; i < 2000000000; i++) {
			v++;
		}
		tl.setV(v);
		System.out.println(System.currentTimeMillis() - endTime);
	}

	public void testT1() {
		t.setV(0);

		final T tCopy = t;
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 2000000000; i++) {
			tCopy.setV(tCopy.getV() + 1);
		}
		t.setV(0);
		long midleTime = System.currentTimeMillis();
		System.out.println(midleTime - startTime);

		for (int i = 0; i < 2000000000; i++) {
			t.setV(t.getV() + 1);
		}
		t.setV(0);
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - midleTime);
	}

	class T {
		private int v;

		public int getV() {
			return v;
		}

		public void setV(int v) {
			this.v = v;
		}

	}

	class FT {
		private T t;

		public T getT() {
			return t;
		}

		public void setT(T t) {
			this.t = t;
		}
	}

	class FFT {
		private FT ft;

		public FT getFt() {
			return ft;
		}

		public void setFt(FT ft) {
			this.ft = ft;
		}

	}

	public void testT2() {
		FFT fft = new FFT();
		FT ft = new FT();
		T t = new T();
		ft.setT(t);
		fft.setFt(ft);

		long startTime = System.currentTimeMillis();
		for (int j = 0; j < 100; j++) {
			for (int i = 0; i < 2000000000; i++) {
				fft.getFt().getT().setV(fft.getFt().getT().getV() + 1);
			}
		}
		long midleTime = System.currentTimeMillis();
		System.out.println(midleTime - startTime);
		T t1 = fft.getFt().getT();
		for (int j = 0; j < 100; j++) {
			for (int i = 0; i < 2000000000; i++) {
				t1.setV(t1.getV() + 1);
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - midleTime);
	}

}
