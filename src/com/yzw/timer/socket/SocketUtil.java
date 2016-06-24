/*
 * This file is part of the QuickServer library 
 * Copyright (C) QuickServer.org
 *
 * Use, modification, copying and distribution of this software is subject to
 * the terms and conditions of the GNU Lesser General Public License. 
 * You should have received a copy of the GNU LGP License along with this 
 * library; if not, you can download a copy from <http://www.quickserver.org/>.
 *
 * For questions, suggestions, bug-reports, enhancement-requests etc.
 * visit http://www.quickserver.org
 *
 */

package com.yzw.timer.socket;

import java.io.*;
import java.net.*;
import java.util.logging.*;
/**
 * Blocking Client socket.
 * @author Akshathkumar Shetty
 * @since 1.4.7
 */
public class SocketUtil {
	private static final Logger logger = Logger.getLogger(SocketUtil.class.getName());
	private static String charset = "ISO-8859-1";
	private static boolean debug = false;
	
	public static boolean isDebug() {
		return debug;
	}

	public static void setDebug(boolean aDebug) {
		debug = aDebug;
	}

	private String host = "localhost";
	private int port = 0;	

	private Socket socket;
	private OutputStream out;
	private BufferedOutputStream b_out;
	private ObjectOutputStream o_out;

	private InputStream in;
	private BufferedInputStream b_in;
	private BufferedReader br;
	private ObjectInputStream o_in;

	public void setCharset(String c) {
		charset = c;
	}
	public String getCharset() {
		return charset;
	}	

	public void connect(String host, int port) throws Exception {
		this.host = host;
		this.port = port;

		if(isDebug()) logger.finest("Connecting to "+host+":"+port);
		

		socket = new Socket(host, port);

		in = socket.getInputStream();
		out = socket.getOutputStream();
		if(isDebug()) logger.fine("Connected");
	}

	public boolean isConnected() {
		if(socket==null) return false;
		return socket.isConnected();
	}

	public void close() throws IOException {
		if(isDebug()) logger.fine("Closing");
		
		if(out!=null) {
			if(isDebug()) logger.finest("Closing output streams");
			try {
				out.flush();
			} catch(IOException ioe) {
				logger.finest("Flushing output streams failed: "+ioe);
			}
			/*
			if(socket!=null && isSecure()==false) {
				socket.shutdownOutput();
			}
			 */

			try {
				if(o_out != null) {
					o_out.close();
				}
			} catch(IOException ioe) {
				logger.finest("o_out stream close failed: "+ioe);
			}

			try {
				if(b_out != null) {
					b_out.close();
				}
			} catch(IOException ioe) {
				logger.finest("b_out stream close failed: "+ioe);
			}

			try {
				out.close();
			} catch(IOException ioe) {
				logger.finest("out stream close failed: "+ioe);
			}
		}

		if(in!=null) {
			if(isDebug()) logger.finest("Closing input streams");

			if(o_in != null) {
				try {
					o_in.close();
				} catch(IOException ioe) {
					logger.finest("o_in stream close failed: "+ioe);
				}
			} 
			if(b_in != null) {
				try {
					b_in.close();
				} catch(IOException ioe) {
					logger.finest("b_in stream close failed: "+ioe);
				}
			}	
			if(br != null) {
				try {
					br.close();
				} catch(IOException ioe) {
					logger.finest("b_in stream close failed: "+ioe);
				}
			}
			try {
				in.close();
			} catch(IOException ioe) {
				logger.finest("in stream close failed: "+ioe);
			}
		}

		if(socket!=null) {
			socket.close();
			socket = null;
		}
	}
	
	public void sendByte(int data) throws IOException {
		if(isDebug()) logger.fine("Sending byte");
		checkBufferedOutputStream();
		b_out.write(data);
		b_out.flush();
	}

	public void sendBytes(byte[] data) throws IOException {
		if(isDebug()) logger.fine("Sending bytes: "+data.length);
		checkBufferedOutputStream();
		b_out.write(data);
		b_out.flush();
	}

	public void sendBytes(String data, String _charset) throws IOException {
		if(isDebug()) logger.fine("Sending: "+data);
		checkBufferedOutputStream();
		if(_charset==null) _charset = charset;
		byte d[] = data.getBytes(_charset);
		b_out.write(d, 0 , d.length);
		b_out.flush();
	}

	public void sendLine(String data, String _charset) throws IOException {
		if(isDebug()) logger.fine("Sending: "+data);
		checkBufferedOutputStream();
		if(_charset==null) _charset = charset;
		byte d[] = data.getBytes(_charset);
		b_out.write(d, 0 , d.length);
		d = "\r\n".getBytes(_charset);
		b_out.write(d, 0 , d.length);
		b_out.flush();
	}

	public void sendObject(Object data) throws IOException {
		checkObjectOutputStream();
		o_out.writeObject(data);
		o_out.flush();
	}
	
	public int readByte() throws IOException {
		checkBufferedInputStream();
		return b_in.read();
	}

	public byte[] readBytes() throws IOException {
		checkBufferedInputStream();
		return readInputStream(b_in);
	}

	public String readBytes(String _charset) throws IOException {
		byte data[] = readBytes();
		if(data==null) return null;
		if(_charset==null) _charset = charset;
		return new String(data, _charset);
	}

	public String readLine() throws IOException {
		checkBufferedReader();
		return br.readLine();
	}

	public Object readObject() throws IOException, ClassNotFoundException {
		checkObjectInputStream();
		return o_in.readObject();
	}

	public Socket getSocket() {
		return socket;
	}

	private void checkObjectOutputStream() throws IOException {
		if(o_out==null) {
			b_out = null;
			o_out = new ObjectOutputStream(out);
			o_out.flush();
		}
	}
	private void checkBufferedOutputStream() throws IOException {
		if(b_out==null) {
			o_out = null;
			b_out = new BufferedOutputStream(out);
		}
	}

	private void checkBufferedInputStream() throws IOException {
		if(b_in==null) {
			br = null;
			o_in = null;
			b_in = new BufferedInputStream(in);
		}
	}
	private void checkBufferedReader() throws IOException {
		if(br==null) {
			b_in = null;
			o_in = null;
			br = new BufferedReader(new InputStreamReader(in, charset));
		}
	}
	private void checkObjectInputStream() throws IOException {
		if(o_in==null) {
			b_in = null;
			br = null;
			o_in = new ObjectInputStream(in);
		}
	}

	public static byte[] readInputStream(InputStream _in) throws IOException {
		byte data[] = null;
		if(_in==null)
			throw new IOException("InputStream can't be null!");
		
		int s = _in.read();
		if(s==-1) {
			return null; //Connection lost
		}
		int alength = _in.available();
		if(alength > 0) {
			data = new byte[alength+1];	
			data[0] = (byte) s;
			int len = _in.read(data, 1, alength);
			if(len < alength) {
				data = copyOf(data, len+1);
			}
		} else {
			data = new byte[1];
			data[0] = (byte) s;
		}
		return data;
	}
	
	private static byte[] copyOf(byte data[], int len) {
		byte newdate[] = new byte[len];
		System.arraycopy(data, 0, newdate, 0, len);
		return newdate;
	}
	

}
