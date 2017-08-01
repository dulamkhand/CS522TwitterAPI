/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw6;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.util.Tool;

/**
 *
 * @author 985892
 */
public class WordCount extends Configured implements Tool {

    @Override
    public int run(String[] strings) throws Exception {
        if(strings.length < 2) {
            System.out.println("input & output are required");
            return -1;
        }
        JobConf conf = new JobConf(WordCount.class);
        File
    }
    
}
