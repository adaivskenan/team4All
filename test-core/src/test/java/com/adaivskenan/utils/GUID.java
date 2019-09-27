package com.adaivskenan.utils;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.security.MessageDigest;
import java.security.PrivilegedAction;
import java.security.SecureRandom;
import java.util.Comparator;

import sun.misc.Unsafe;

/**
 * GUID
 * 
 * @author gaojingxin
 * 
 */
@SuppressWarnings("restriction")
public final class GUID extends Object implements Serializable,
		Comparable<GUID> {
	public final static Comparator<GUID> comparator = new Comparator<GUID>() {
		public int compare(GUID o1, GUID o2) {
			return o1.compareTo(o2);
		}
	};

	/**
	 * 判断是否相同
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof GUID) {
			GUID one = (GUID) obj;
			return this.leastSigBits == one.leastSigBits
					&& this.mostSigBits == one.mostSigBits;
		}
		return false;
	}

	public boolean isEmpty() {
		return this.leastSigBits == 0L && this.mostSigBits == 0L;
	}

	/**
	 * 判断是否相同
	 */
	public boolean equals(GUID id) {
		return (id == this)
				|| (id != null && this.leastSigBits == id.leastSigBits && this.mostSigBits == id.mostSigBits);
	}

	public byte[] toBytes() {
		return this.toBytes(null);
	}

	public byte[] toBytes(byte[] bytes) {
		if (bytes == null || bytes.length != 16) {
			bytes = new byte[16];
		}
		long sb = this.leastSigBits;
		for (int i = 15; i >= 8; i--) {
			bytes[i] = (byte) sb;
			sb >>>= 8;
		}
		sb = this.mostSigBits;
		for (int i = 7; i >= 0; i--) {
			bytes[i] = (byte) sb;
			sb >>>= 8;
		}
		return bytes;
	}

	public void toBytes(final byte[] buf, final int off) {
		if (buf == null) {
			throw new NullPointerException("buf");
		}
		final int blen = buf.length;
		if (off < 0 || off > blen) {
			throw new IndexOutOfBoundsException("buf's length: " + blen
					+ ", off: " + off);
		}
		if (blen - off < 16) {
			throw new BufferUnderflowException();
		}

		long sb = this.leastSigBits;
		for (int i = off + 15; i >= off + 8; i--) {
			buf[i] = (byte) sb;
			sb >>>= 8;
		}
		sb = this.mostSigBits;
		for (int i = off + 7; i >= off; i--) {
			buf[i] = (byte) sb;
			sb >>>= 8;
		}
	}

	/**
	 * 判断是否相同
	 */
	public static boolean equals(GUID id1, GUID id2) {
		if (id1 == id2) {
			return true;
		}
		return id1 != null && id2 != null
				&& id1.leastSigBits == id2.leastSigBits
				&& id1.mostSigBits == id2.mostSigBits;
	}

	/**
	 * 返回hashCode
	 */
	@Override
	public final int hashCode() {
		return (int) ((this.mostSigBits >>> 32) ^ this.mostSigBits
				^ (this.leastSigBits >>> 32) ^ this.leastSigBits);
	}

	public final int compareTo(GUID val) {
		long d = (this.mostSigBits >>> 1) - (val.mostSigBits >>> 1);
		if (d > 0) {
			return 1;
		}
		if (d < 0) {
			return -1;
		}
		d = (this.mostSigBits & 1l) - (val.mostSigBits & 1l);
		if (d > 0) {
			return 1;
		}
		if (d < 0) {
			return -1;
		}
		d = (this.leastSigBits >>> 1) - (val.leastSigBits >>> 1);
		if (d > 0) {
			return 1;
		}
		if (d < 0) {
			return -1;
		}
		d = (this.leastSigBits & 1l) - (val.leastSigBits & 1l);
		if (d > 0) {
			return 1;
		}
		if (d < 0) {
			return -1;
		}
		return 0;
	}

	/**
	 * 高位64位
	 */
	private final long mostSigBits;

	/**
	 * 高位64位
	 */
	public final long getMostSigBits() {
		return this.mostSigBits;
	}

	/**
	 * 低位64位
	 */
	private final long leastSigBits;

	/**
	 * 低位64位
	 */
	public final long getLeastSigBits() {
		return this.leastSigBits;
	}

	@Override
	public final String toString() {
		return this.toString(false, true);
	}

	private final static int h2b_A_10 = 'A' - 10;
	private final static int h2b_a_10 = 'a' - 10;

	private static int parseChar(String s, int offset)
			throws  StringIndexOutOfBoundsException {
		char c = s.charAt(offset);
		if (c < '0') {
		} else if (c <= '9') {
			return c - '0';
		} else if (c < 'A') {
		} else if (c <= 'F') {
			return c - h2b_A_10;
		} else if (c < 'a') {
		} else if (c <= 'f') {
			return c - h2b_a_10;
		}
		throw new IllegalArgumentException("在偏移量" + offset + "处出现无效的十六进制字符'" + c
				+ "'");
	}

	private static void byteToHex(char[] hex, int index, byte b,
			boolean upperCase) {
		int h = b >>> 4 & 0xF;
		if (upperCase) {
			hex[index] = (char) (h > 9 ? h + h2b_A_10 : h + '0');
			h = b & 0xF;
			hex[index + 1] = (char) (h > 9 ? h + h2b_A_10 : h + '0');
		} else {
			hex[index] = (char) (h > 9 ? h + h2b_a_10 : h + '0');
			h = b & 0xF;
			hex[index + 1] = (char) (h > 9 ? h + h2b_a_10 : h + '0');
		}
	}

	private static void appendTo(Appendable hex, long l, boolean upperCase)
			throws IOException {
		int b = (int) (l >>> 56);
		int h = (b >>> 4) & 0xF;
		if (upperCase) {
			hex.append((char) (h > 9 ? h + h2b_A_10 : h + '0'));
			h = b & 0xF;
			hex.append((char) (h > 9 ? h + h2b_A_10 : h + '0'));
		} else {
			hex.append((char) (h > 9 ? h + h2b_a_10 : h + '0'));
			h = b & 0xF;
			hex.append((char) (h > 9 ? h + h2b_a_10 : h + '0'));
		}
	}

	public final String toString(boolean withPrefix, boolean upperCase) {
		int j = withPrefix ? 34 : 32;
		char[] hex = new char[j];
		if (withPrefix) {
			hex[0] = '0';
			hex[1] = upperCase ? 'X' : 'x';
		}
		long sb = this.leastSigBits;
		j -= 2;
		byteToHex(hex, j, (byte) sb, upperCase);
		j -= 2;
		sb >>>= 8;
		byteToHex(hex, j, (byte) sb, upperCase);
		j -= 2;
		sb >>>= 8;
		byteToHex(hex, j, (byte) sb, upperCase);
		j -= 2;
		sb >>>= 8;
		byteToHex(hex, j, (byte) sb, upperCase);
		j -= 2;
		sb >>>= 8;
		byteToHex(hex, j, (byte) sb, upperCase);
		j -= 2;
		sb >>>= 8;
		byteToHex(hex, j, (byte) sb, upperCase);
		j -= 2;
		sb >>>= 8;
		byteToHex(hex, j, (byte) sb, upperCase);
		j -= 2;
		sb >>>= 8;
		byteToHex(hex, j, (byte) sb, upperCase);
		j -= 2;
		sb = this.mostSigBits;
		byteToHex(hex, j, (byte) sb, upperCase);
		j -= 2;
		sb >>>= 8;
		byteToHex(hex, j, (byte) sb, upperCase);
		j -= 2;
		sb >>>= 8;
		byteToHex(hex, j, (byte) sb, upperCase);
		j -= 2;
		sb >>>= 8;
		byteToHex(hex, j, (byte) sb, upperCase);
		j -= 2;
		sb >>>= 8;
		byteToHex(hex, j, (byte) sb, upperCase);
		j -= 2;
		sb >>>= 8;
		byteToHex(hex, j, (byte) sb, upperCase);
		j -= 2;
		sb >>>= 8;
		byteToHex(hex, j, (byte) sb, upperCase);
		j -= 2;
		sb >>>= 8;
		byteToHex(hex, j, (byte) sb, upperCase);
		return UnsafeString.fastString(hex);
	}

	public final void appendTo(Appendable hex) {
		this.appendTo(hex, false, true);
	}

	public final void appendTo(Appendable hex, boolean withPrefix,
			boolean upperCase) {
		if (hex == null) {
			throw new NullPointerException("hex is null");
		}
		try {
			if (withPrefix) {
				hex.append('0');
				hex.append(upperCase ? 'X' : 'x');
			}
			long sb = this.mostSigBits;
			appendTo(hex, sb, upperCase);
			sb <<= 8;
			appendTo(hex, sb, upperCase);
			sb <<= 8;
			appendTo(hex, sb, upperCase);
			sb <<= 8;
			appendTo(hex, sb, upperCase);
			sb <<= 8;
			appendTo(hex, sb, upperCase);
			sb <<= 8;
			appendTo(hex, sb, upperCase);
			sb <<= 8;
			appendTo(hex, sb, upperCase);
			sb <<= 8;
			appendTo(hex, sb, upperCase);
			sb = this.leastSigBits;
			appendTo(hex, sb, upperCase);
			sb <<= 8;
			appendTo(hex, sb, upperCase);
			sb <<= 8;
			appendTo(hex, sb, upperCase);
			sb <<= 8;
			appendTo(hex, sb, upperCase);
			sb <<= 8;
			appendTo(hex, sb, upperCase);
			sb <<= 8;
			appendTo(hex, sb, upperCase);
			sb <<= 8;
			appendTo(hex, sb, upperCase);
			sb <<= 8;
			appendTo(hex, sb, upperCase);
		} catch (Throwable e) {
			UnsafeString.unsafe.throwException(e);
		}
	}

	/**
	 * 空ID
	 */
	public static final GUID emptyID = new GUID(0, 0);
	/**
	 * 最小ID
	 */
	public static final GUID minID = emptyID;
	/**
	 * 最大ID
	 */
	public static final GUID maxID = new GUID(-1L, -1L);

	/**
	 * 根据两个long创建ID
	 * 
	 * @param mostSigBits
	 *            高位
	 * @param leastSigBits
	 *            地位
	 * @return 返回ID
	 */
	public static GUID valueOf(final long mostSigBits, final long leastSigBits) {
		if (mostSigBits == 0 && leastSigBits == 0) {
			return emptyID;
		}
		return new GUID(mostSigBits, leastSigBits);
	}

	/**
	 * 根据byte数组创建ID
	 * 
	 * @param bytes
	 *            二进制值
	 * @return 返回ID
	 */
	public static GUID valueOf(byte[] bytes) {
		if (bytes == null) {
			return null;
		}
		int length = bytes.length;
		if (length == 0) {
			return emptyID;
		}
		int c = length > 8 ? 8 : length;
		int index = 0;
		long msb = bytes[index++] & 0xff;
		while (index < c) {
			msb = (msb << 8) | (bytes[index++] & 0xff);
		}
		long lsb;
		if (index < length) {
			lsb = bytes[index++] & 0xff;
			while (index < length) {
				lsb = (lsb << 8) | (bytes[index++] & 0xff);
			}
		} else {
			lsb = 0;
		}
		if (msb == 0 && lsb == 0) {
			return emptyID;
		}
		return new GUID(msb, lsb);
	}

	/**
	 * 解析指定的字节缓冲区中从指定位置开始的16个字节，根据其值创建GUID实例。
	 * 
	 * 对于<code>GUID.emptyID</code>，不会创建新实例。
	 * 
	 * @param buf
	 *            字节缓冲区
	 * @param off
	 *            解析的开始位置
	 * @return 解析出的GUID实例
	 * @throws NullPointerException
	 *             指定的缓冲区为空（<code>null</code>）
	 * @throws IndexOutOfBoundsException
	 *             指定的开始偏移位置越界
	 * @throws BufferUnderflowException
	 *             指定的缓冲区中从指定的开始位置之后的数据不足以创建GUID实例
	 */
	public static GUID valueOf(final byte[] buf, int off) {
		if (buf == null) {
			throw new NullPointerException("buf");
		}
		final int blen = buf.length;
		if (off < 0 || off > blen) {
			throw new IndexOutOfBoundsException("buf's length: " + blen
					+ ", off: " + off);
		}
		if (blen - off < 16) {
			throw new BufferUnderflowException();
		}

		int end = off + 8;
		long msb = buf[off++] & 0xff;
		while (off < end) {
			msb = (msb << 8) | (buf[off++] & 0xff);
		}
		end = off + 8;
		long lsb = buf[off++] & 0xff;
		while (off < end) {
			lsb = (lsb << 8) | (buf[off++] & 0xff);
		}
		if (msb == 0 && lsb == 0) {
			return emptyID;
		}
		return new GUID(msb, lsb);
	}

	private static class MD5Digest {
		private static Charset UTF8 = Charset.forName("UTF-8");
		private final MessageDigest md5;
		private final CharsetEncoder encoder;

		final GUID digest(CharSequence message) {
			if (message == null) {
				throw new IllegalArgumentException("message is null");
			}
			if (message.length() == 0) {
				return GUID.emptyID;
			}
			final ByteBuffer bb;
			try {
				bb = this.encoder.encode(CharBuffer.wrap(message));
			} catch (CharacterCodingException e) {
				UnsafeString.unsafe.throwException(e);
				return null;// 永远不会到这里
			}
			this.md5.update(bb);
			return GUID.valueOf(this.md5.digest());
		}

		final byte[] digestTo16Bytes(CharSequence message) {
			if (message == null) {
				throw new IllegalArgumentException("message is null");
			}
			if (message.length() == 0) {
				return new byte[16];
			}
			final ByteBuffer bb;
			try {
				bb = this.encoder.encode(CharBuffer.wrap(message));
			} catch (CharacterCodingException e) {
				UnsafeString.unsafe.throwException(e);
				return null;// 永远不会到这里
			}
			this.md5.update(bb);
			return this.md5.digest();
		}

		final long digestToLong(CharSequence message) {
			if (message == null) {
				throw new IllegalArgumentException("message is null");
			}
			if (message.length() == 0) {
				return 0;
			}
			try {
				this.md5.update(this.encoder.encode(CharBuffer.wrap(message)));
			} catch (CharacterCodingException e) {
				UnsafeString.unsafe.throwException(e);
				return 0;
			}
			final byte[] buf = this.md5.digest();
			long msb = buf[0] & 0xff;
			for (int i = 1; i < 8; i++) {
				msb = (msb << 8) | (buf[i] & 0xff);

			}
			return msb;
		}

		MD5Digest() {
			MessageDigest md5;
			try {
				md5 = MessageDigest.getInstance("MD5");
			} catch (Throwable e) {
				UnsafeString.unsafe.throwException(e);
				md5 = null;
			}
			this.md5 = md5;
			this.encoder = UTF8.newEncoder();
			this.encoder.onMalformedInput(CodingErrorAction.IGNORE);
			this.encoder.onUnmappableCharacter(CodingErrorAction.IGNORE);
		}
	}
	
	private static class SHA256Digest {
		private static Charset UTF8 = Charset.forName("UTF-8");
		private final MessageDigest sha256;
		private final CharsetEncoder encoder;

		final GUID digest(CharSequence message) {
			if (message == null) {
				throw new IllegalArgumentException("message is null");
			}
			if (message.length() == 0) {
				return GUID.emptyID;
			}
			final ByteBuffer bb;
			try {
				bb = this.encoder.encode(CharBuffer.wrap(message));
			} catch (CharacterCodingException e) {
				UnsafeString.unsafe.throwException(e);
				return null;// 永远不会到这里
			}
			this.sha256.update(bb);
			return GUID.valueOf(this.sha256.digest());
		}

		final byte[] digestTo16Bytes(CharSequence message) {
			if (message == null) {
				throw new IllegalArgumentException("message is null");
			}
			if (message.length() == 0) {
				return new byte[16];
			}
			final ByteBuffer bb;
			try {
				bb = this.encoder.encode(CharBuffer.wrap(message));
			} catch (CharacterCodingException e) {
				UnsafeString.unsafe.throwException(e);
				return null;// 永远不会到这里
			}
			this.sha256.update(bb);
			return this.sha256.digest();
		}

		final long digestToLong(CharSequence message) {
			if (message == null) {
				throw new IllegalArgumentException("message is null");
			}
			if (message.length() == 0) {
				return 0;
			}
			try {
				this.sha256.update(this.encoder.encode(CharBuffer.wrap(message)));
			} catch (CharacterCodingException e) {
				UnsafeString.unsafe.throwException(e);
				return 0;
			}
			final byte[] buf = this.sha256.digest();
			long msb = buf[0] & 0xff;
			for (int i = 1; i < 8; i++) {
				msb = (msb << 8) | (buf[i] & 0xff);

			}
			return msb;
		}

		SHA256Digest() {
			MessageDigest sha256;
			try {
				sha256 = MessageDigest.getInstance("SHA-256");
			} catch (Throwable e) {
				UnsafeString.unsafe.throwException(e);
				sha256 = null;
			}
			this.sha256 = sha256;
			this.encoder = UTF8.newEncoder();
			this.encoder.onMalformedInput(CodingErrorAction.IGNORE);
			this.encoder.onUnmappableCharacter(CodingErrorAction.IGNORE);
		}
	}
	
	private static ThreadLocal<MD5Digest> md5s = new ThreadLocal<MD5Digest>() {
		@Override
		protected MD5Digest initialValue() {
			return new MD5Digest();
		};
	};
	
	private static ThreadLocal<SHA256Digest> sha256 = new ThreadLocal<SHA256Digest>() {
		@Override
		protected SHA256Digest initialValue() {
			return new SHA256Digest();
		};
	};
	
	/**
	 * 根据文本采用UTF8编码，采用MD5算法散列得到GUID
	 * 
	 * @param message
	 *            为null时抛出异常，""时返回GUID.EMPTY
	 * @return
	 */
	public static GUID MD5Of(CharSequence message) {
		return md5s.get().digest(message);
	}

	public static GUID MD5Of(String message) {
		return md5s.get().digest(message);
	}

	public static long mostSigBitsMD5Of(CharSequence message) {
		return md5s.get().digestToLong(message);
	}

	public static byte[] MD5BytesOf(CharSequence message) {
		return md5s.get().digestTo16Bytes(message);
	}
	
	/**
	 * 根据文本采用UTF8编码，采用SHA256算法散列得到GUID
	 * 
	 * @param message
	 *            为null时抛出异常，""时返回GUID.EMPTY
	 * @return
	 */
	public static GUID SHA256Of(CharSequence message) {
		return sha256.get().digest(message);
	}

	public static GUID SHA256Of(String message) {
		return sha256.get().digest(message);
	}

	public static long mostSigBitsSHA256Of(CharSequence message) {
		return sha256.get().digestToLong(message);
	}

	public static byte[] SHA256BytesOf(CharSequence message) {
		return sha256.get().digestTo16Bytes(message);
	}
	
	private static long hexToLong(String str, int start) {
		long temp = parseChar(str, start++);
		temp = temp << 4 | parseChar(str, start++);
		temp = temp << 4 | parseChar(str, start++);
		temp = temp << 4 | parseChar(str, start++);
		temp = temp << 4 | parseChar(str, start++);
		temp = temp << 4 | parseChar(str, start++);
		temp = temp << 4 | parseChar(str, start++);
		temp = temp << 4 | parseChar(str, start++);
		temp = temp << 4 | parseChar(str, start++);
		temp = temp << 4 | parseChar(str, start++);
		temp = temp << 4 | parseChar(str, start++);
		temp = temp << 4 | parseChar(str, start++);
		temp = temp << 4 | parseChar(str, start++);
		temp = temp << 4 | parseChar(str, start++);
		temp = temp << 4 | parseChar(str, start++);
		return temp << 4 | parseChar(str, start++);
	}

	private static GUID tryParse(String str, boolean throwException) {
		if (str == null) {
			return null;
		}
		int strl = str.length();
		if (strl == 32) {
			try {
				return valueOf(hexToLong(str, 0), hexToLong(str, 16));
			} catch (IllegalArgumentException e) {
				if (throwException) {
					throw e;
				}
			}
		}
		if (throwException) {
			throw new IllegalArgumentException("GUID文本格式错误:" + str);
		}
		return null;
	}

	/**
	 * 返回GUID如果无效则返回null
	 */
	public static GUID tryValueOf(String str) {
		return tryParse(str, false);
	}

	/**
	 * 返回GUID如果无效则返返回异常
	 */
	public static GUID valueOf(String str) {
		return tryParse(str, true);
	}

	private final static byte[] bytes16 = new byte[16];
	private final static byte[] bytes8 = new byte[8];

	/**
	 * 生成随机的ID
	 * 
	 * @return 返回随机ID对象
	 */
	public static GUID randomID() {
		long msb, lsb;
		synchronized (numberGenerator) {
			numberGenerator.nextBytes(bytes16);
			msb = bytes16[0] & 0xff;
			for (int i = 1; i < 8; i++) {
				msb = (msb << 8) | (bytes16[i] & 0xff);
			}
			lsb = bytes16[8] & 0xff;
			for (int i = 9; i < 16; i++) {
				lsb = (lsb << 8) | (bytes16[i] & 0xff);
			}
		}
		return new GUID(msb, lsb);

	}

	public static long randomLong() {
		synchronized (numberGenerator) {
			numberGenerator.nextBytes(bytes8);
			long msb = bytes8[0] & 0xff;
			for (int i = 1; i < 8; i++) {
				msb = (msb << 8) | (bytes8[i] & 0xff);
			}
			return msb;
		}
	}

	// //////////////////////////////////////////////////////////////////////////
	// ////////////////////
	// //////////////////以下是内部方法/////////////////////////////////////////////////
	// ////////////////
	// //////////////////////////////////////////////////////////////////////////
	// ////////////////////
	private static final long serialVersionUID = 2686938417664634277L;
	private static final SecureRandom numberGenerator = new SecureRandom();

	/**
	 * 构造函数
	 * 
	 * @param mostSigBits
	 * @param leastSigBits
	 */
	private GUID(long mostSigBits, long leastSigBits) {
		this.mostSigBits = mostSigBits;
		this.leastSigBits = leastSigBits;
	}

	/*
	 * Added by LRJ. Mar 6th, 2008.
	 * 
	 * 保持 emptyID 的唯一性。
	 */
	private Object readResolve() {
		if (this.leastSigBits == 0 || this.mostSigBits == 0) {
			return GUID.emptyID;
		} else {
			return this;
		}
	}

	private static class UnsafeString {
		static final Unsafe unsafe = getUnsafe();

		// static final long stringValueOffset = tryGetFieldOffset(String.class,
		// "value");
		// static final long stringCountOffset = tryGetFieldOffset(String.class,
		// "count");

		// static final long ILLEGAL_OFFSET = -1;

		private static Unsafe getUnsafe() {
			Unsafe us;
			try {
				final Field f = Unsafe.class.getDeclaredField("theUnsafe");
				java.security.AccessController
						.doPrivileged(new PrivilegedAction<Object>() {
							public Object run() {
								f.setAccessible(true);
								return null;
							}
						});
				us = (Unsafe) f.get(null);
			} catch (Throwable e) {
				us = null;
			}
			return us;
		}

		// private static long tryGetFieldOffset(Class<?> clazz, String
		// fieldName) {
		// if (unsafe != null) {
		// try {
		// return unsafe.objectFieldOffset(clazz
		// .getDeclaredField(fieldName));
		// } catch (Throwable e) {
		// return ILLEGAL_OFFSET;
		// }
		// }
		// return ILLEGAL_OFFSET;
		// }

		// private static boolean 绝对不可以移除或置该变量为final = false;

		static String fastString(char[] chars) {
			int charCount = chars.length;
			if (charCount == 0) {
				return "";
			}
			return new String(chars);
			// if (stringCountOffset != ILLEGAL_OFFSET
			// && stringValueOffset != ILLEGAL_OFFSET) {
			// String s = "绝对不可以改该字符串".substring(0, 0);
			// unsafe.putInt(s, stringCountOffset, charCount);
			// unsafe.putObject(s, stringValueOffset, chars);
			// if (绝对不可以移除或置该变量为final) {
			// 绝对不可以移除或置该变量为final = false;
			// }
			// return s;
			// } else {
			// throw new IllegalAccessError();
			// }
		}
	}
}