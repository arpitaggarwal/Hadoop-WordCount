package com.test;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public class WordCountMapper extends MapReduceBase implements
		Mapper<LongWritable, Text, Text, IntWritable> {

	// hadoop supported data types
	private final static IntWritable one = new IntWritable(1);
	private Text word = new Text();

	// map method that performs the tokenizer job and framing the initial key
	// value pairs

	// The first and second parameter refers to the Data type of the input Key
	// and Value to the mapper.
	// The third parameter is the output collector which does the job of taking
	// the output data either from the mapper or reducer, with the output
	// collector we need to specify the Data Types of the output Key and Value
	// from the mapper.
	// The fourth parameter, the reporter is used to report the task status
	// internally in Hadoop environment to avoid time outs.
	@Override
	public void map(LongWritable key, Text value,
			OutputCollector<Text, IntWritable> output, Reporter reporter)
			throws IOException {
		// taking one line at a time and tokenizing the same
		String line = value.toString();
		StringTokenizer tokenizer = new StringTokenizer(line);
		System.out
				.println("printing tokenizer : ********************************************** : "
						+ tokenizer);

		// iterating through all the words available in that line and forming
		// the key value pair
		while (tokenizer.hasMoreTokens()) {
			word.set(tokenizer.nextToken());
			// sending to output collector which inturn passes the same to
			// reducer
			output.collect(word, one);
		}
	}
}
