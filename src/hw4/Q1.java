/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw4;


import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

/**
 *
 * @author 985892
 */
public class Q1 {

    public static void main(String[] args) throws Exception {
        System.out.println(Q1.pos("./data/Aug03.csv"));
    }

    public static String pos(String filename) throws Exception {
        // model file
        MaxentTagger tagger = new MaxentTagger("./lib/english-bidirectional-distsim.tagger");

        // file to convert to pos
        List<List<HasWord>> sentences = MaxentTagger.tokenizeText(
                new BufferedReader(new FileReader(filename)));

        StringBuilder sb = new StringBuilder();
        sentences.stream().map((sentence) -> tagger.tagSentence(sentence))
                .forEach((tSentence) -> {
                    tSentence.stream().filter((tw) -> !(!(tw.tag().startsWith("NN")
                            || tw.tag().startsWith("VB")
                            || tw.tag().startsWith("JJ"))))
                            .forEach((tw) -> {
                                sb.append(tw.word()).append(",").append(tw.tag()).append("\n");
                            });
                });
        return sb.toString();
    }

}
