/**
 * The MIT License (MIT)
 * 
 * Copyright (c) 2015 Halo9Pan
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package info.inkstack.troll.seg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chenlb.mmseg4j.Dictionary;
import com.chenlb.mmseg4j.MMSeg;
import com.chenlb.mmseg4j.Seg;
import com.chenlb.mmseg4j.Word;

/**
 * 基于com.chenlb.mmseg4j的分词实现
 *
 * @author Halo9Pan
 *
 */
public abstract class MMSegSegment implements ISegment {

	private static Logger logger = LoggerFactory.getLogger(MMSegSegment.class);

	protected Dictionary dict;

	public MMSegSegment() {
		this.dict = Dictionary.getInstance();
	}

	/**
	 * 返回com.chenlb.mmseg4j不同的分词实现
	 * 
	 * @return
	 */
	protected abstract Seg initializeSeg();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iqiyi.lego.tags.seg.ISegment#segWords(java.lang.String)
	 */
	public List<String> segWords(String content) {
		Reader reader = new StringReader(content);
		List<String> list = this.segWords(reader);
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see info.inkstack.troll.seg.ISegment#segWords(java.io.File)
	 */
	public List<String> segWords(File file) throws FileNotFoundException {
		Reader reader = new FileReader(file);
		List<String> list = this.segWords(reader);
		return list;
	}

	private List<String> segWords(Reader reader) {
		List<String> list = new ArrayList<String>();
		Seg seg = this.initializeSeg(); // 取得不同的分词具体算法
		MMSeg mmSeg = new MMSeg(reader, seg);
		Word word = null;
		try {
			while ((word = mmSeg.next()) != null) {
				String w = word.getString();
				list.add(w);
			}
		} catch (IOException e) {
			logger.warn("Exception when segging words.", e);
		}
		return list;
	}

}
