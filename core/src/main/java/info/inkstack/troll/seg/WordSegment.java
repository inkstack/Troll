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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Halo9Pan
 *
 */
public class WordSegment implements ISegment {

	private static Logger logger = LoggerFactory.getLogger(WordSegment.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see info.inkstack.troll.seg.ISegment#segWords(java.lang.String)
	 */
	public List<String> segWords(String content) {
		if (content == null) {
			return null;
		}
		List<Word> words = WordSegmenter.seg(content);
		List<String> list = words.stream().map(w -> w.getText()).collect(Collectors.toList());
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see info.inkstack.troll.seg.ISegment#segWords(java.io.File)
	 */
	public List<String> segWords(File file) {
		List<String> words = null;
		try {
			File output = File.createTempFile("segment", ".word"); //$NON-NLS-1$ //$NON-NLS-2$
			WordSegmenter.seg(file, output);
			try (BufferedReader reader = new BufferedReader(new FileReader(output))) {
	            return reader.lines().findFirst()
	                    .map(line -> Arrays.asList(line.split(" "))) //$NON-NLS-1$
	                    .get();
	        } catch (IOException e) {
	        	logger.warn("Can't read the output file.", e);
	        }
		} catch (IOException e) {
			logger.warn("Can't create temporaty file.", e);
		} catch (Exception e) {
			logger.warn("Exception when segging words.", e);
		}
		return words;
	}

}
