/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw6;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 *
 * @author 985892
 */
public class MapClass extends Mapper{
    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();
    
    //@Override
    protected void map(LongWritable key, Text value,
			Context context)
			throws IOException, InterruptedException {
		
        //Get the text and tokenize the word using space as separator.
		String line = value.toString();
		StringTokenizer st = new StringTokenizer(line," ");
		
        //For each token aka word, write a key value pair with 
        //word and 1 as value to context
		while(st.hasMoreTokens()){
			word.set(st.nextToken());
			context.write(word,one);
		}
		
	}
}
