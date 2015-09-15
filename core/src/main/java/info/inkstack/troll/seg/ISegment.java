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
import java.util.List;

/**
 * 分词接口。将输入的文本分词。
 * 
 * @author Halo9Pan
 *
 */
public interface ISegment {

	/**
	 * 将输入的文本内容分词，确保输入的字符编码为UTF-8
	 * 
	 * @param content
	 * @return
	 */
	List<String> segWords(String content);

	/**
	 * 将文件的内容分词，确保输入的文本流编码为UTF-8
	 * 
	 * @param reader
	 * @return
	 */
	List<String> segWords(File file) throws FileNotFoundException;

}
