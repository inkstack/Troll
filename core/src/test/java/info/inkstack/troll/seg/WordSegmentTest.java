/**
 * The MIT License (MIT)
 * 
 * Copyright (c) 2015 panhao
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

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * @author panhao
 *
 */
public class WordSegmentTest {

	private ISegment segment;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.segment = new WordSegment();
	}

	/**
	 * Test method for {@link info.inkstack.troll.seg.WordSegment#segWords(java.lang.String)}.
	 */
	@Test
	public void testSegWordsString() {
		List<String> words = this.segment.segWords("心有多远，路就有多远。");
		words.stream().forEach(System.out::println);
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link info.inkstack.troll.seg.WordSegment#segWords(java.io.File)}.
	 */
	@Test
	public void testSegWordsFile() {
		fail("Not yet implemented");
	}

}
