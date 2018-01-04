package at.fhv.itb2.crw;

import java.io.*;

/**
 * Class to write to an output file based on the Caesar cipher.
 * @author ske2577
 * <p>Created on: 1.6.17</p>
 * @version 1
 *
 */
public class CaesarWriter extends Writer{
	Writer _w = null;
	int _shift;
	CaesarOperation _op;
	
	
	public CaesarWriter(Writer w, int shift, CaesarOperation op) {
		_w = w;
		_shift = Math.abs(shift);;
		_op = op;
	}

	@Override
	public void close() throws IOException {
		_w.close();
	}

	@Override
	public void flush() throws IOException {
		_w.flush();
		
	}

	@Override
	public void write(char[] cbuf, int off, int size) throws IOException {
		CaesarCoder cc = new CaesarCoder(_shift, cbuf);
		
		if(_op == CaesarOperation.ENCODE){
			cbuf = cc.encode();
		}else{
			cbuf = cc.decode();
		}

		_w.write(cbuf);
	}
}
