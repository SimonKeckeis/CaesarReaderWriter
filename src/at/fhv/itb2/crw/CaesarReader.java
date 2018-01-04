package at.fhv.itb2.crw;

import java.io.*;

/**
 * Class to read from an input file based on the Caesar cipher.
 * @author ske2577
 * <p>Created on: 1.6.17</p>
 * @version 1
 *
 */
public class CaesarReader extends Reader{
	Reader _r = null;
	int _shift;
	CaesarOperation _op;
	
	public CaesarReader(Reader r, int shift,  CaesarOperation op) {
		_r = r;
		_shift = shift;
		_op = op;
	}

	@Override
	public void close() throws IOException {
		_r.close();
		_r = null;
	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		int size = _r.read(cbuf, off, len);
		CaesarCoder cc = new CaesarCoder(_shift, cbuf);
		
		if(size == -1){
			return -1;
		}
		
		if(_op == CaesarOperation.DECODE){	
			cbuf = cc.decode();
		}else{
			cbuf = cc.encode();
		}
		
		return size;
	}
}
